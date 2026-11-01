package com.dheekshith.zenlock;

import android.content.Context;
import android.provider.Settings;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NotificationBadgeHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/dheekshith/zenlock/NotificationBadgeHelper;", "", "()V", "getUnreadCounts", "", "", "", "context", "Landroid/content/Context;", "isNotificationAccessGranted", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NotificationBadgeHelper {
    public static final NotificationBadgeHelper INSTANCE = new NotificationBadgeHelper();

    private NotificationBadgeHelper() {
    }

    public final boolean isNotificationAccessGranted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String enabledListeners = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (enabledListeners == null) {
            return false;
        }
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        return StringsKt.contains$default((CharSequence) enabledListeners, (CharSequence) packageName, false, 2, (Object) null);
    }

    public final Map<String, Integer> getUnreadCounts(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return !isNotificationAccessGranted(context) ? MapsKt.emptyMap() : ZenNotificationListener.INSTANCE.getLatestCounts();
    }
}
