package com.dheekshith.zenlock;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.Grouping;
import kotlin.collections.GroupingKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationBadgeHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/dheekshith/zenlock/ZenNotificationListener;", "Landroid/service/notification/NotificationListenerService;", "()V", "onListenerConnected", "", "onNotificationPosted", "sbn", "Landroid/service/notification/StatusBarNotification;", "onNotificationRemoved", "Companion", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ZenNotificationListener extends NotificationListenerService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile Map<String, Integer> latestCounts = MapsKt.emptyMap();

    /* JADX INFO: compiled from: NotificationBadgeHelper.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u000fR6\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/dheekshith/zenlock/ZenNotificationListener$Companion;", "", "()V", "<set-?>", "", "", "", "latestCounts", "getLatestCounts", "()Ljava/util/Map;", "recompute", "", "notifications", "", "Landroid/service/notification/StatusBarNotification;", "([Landroid/service/notification/StatusBarNotification;)V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Integer> getLatestCounts() {
            return ZenNotificationListener.latestCounts;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void recompute(final StatusBarNotification[] notifications) {
            if (notifications == null) {
                return;
            }
            ZenNotificationListener.latestCounts = GroupingKt.eachCount(new Grouping<StatusBarNotification, String>() { // from class: com.dheekshith.zenlock.ZenNotificationListener$Companion$recompute$$inlined$groupingBy$1
                @Override // kotlin.collections.Grouping
                public Iterator<StatusBarNotification> sourceIterator() {
                    return ArrayIteratorKt.iterator(notifications);
                }

                @Override // kotlin.collections.Grouping
                public String keyOf(StatusBarNotification element) {
                    StatusBarNotification it = element;
                    return it.getPackageName();
                }
            });
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerConnected() {
        super.onListenerConnected();
        INSTANCE.recompute(getActiveNotifications());
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification sbn) {
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        INSTANCE.recompute(getActiveNotifications());
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification sbn) {
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        INSTANCE.recompute(getActiveNotifications());
    }
}
