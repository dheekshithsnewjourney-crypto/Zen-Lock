package com.dheekshith.zenlock;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ZenPrefs.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u000b\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\u0006\u0010\r\u001a\u00020\u000eJ\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013J\u0006\u0010\u0016\u001a\u00020\u0011J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019J\u0006\u0010\u001a\u001a\u00020\u000bJ\u0006\u0010\u001b\u001a\u00020\u000bJ\u0006\u0010\u001c\u001a\u00020\bJ\u0014\u0010\u001d\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013J\u001c\u0010\u001f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013J\u001c\u0010 \u001a\u00020\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\u0006\u0010\"\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/dheekshith/zenlock/ZenPrefs;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "cancelDisableBrowserLockoutRequest", "", "clearZenSession", "confirmDisableBrowserLockout", "", "deletePreset", "name", "", "enableBrowserLockout", "getDisableCooldownRemainingMs", "", "getLastUsedApps", "", "getPresetApps", "getPresetNames", "getRemainingMs", "getWhitelistApps", "getWhitelistAppsSet", "", "isBrowserLockoutEnabled", "isZenActive", "requestDisableBrowserLockout", "saveLastUsedApps", "apps", "savePreset", "startZenSession", "whitelistApps", "endTimeMs", "Companion", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ZenPrefs {
    private static final String DELIMITER = "|||";
    public static final long DISABLE_COOLDOWN_MS = 86400000;
    private static final String KEY_BROWSER_LOCKOUT = "browser_lockout_enabled";
    private static final String KEY_DISABLE_REQUESTED_AT = "browser_lockout_disable_requested_at";
    private static final String KEY_END_TIME = "end_time";
    private static final String KEY_LAST_USED_APPS = "last_used_apps";
    private static final String KEY_PRESET_NAMES = "preset_names";
    private static final String KEY_PRESET_PREFIX = "preset_apps_";
    private static final String KEY_WHITELIST = "whitelist_apps";
    private static final String KEY_ZEN_ACTIVE = "zen_active";
    private final SharedPreferences prefs;

    public ZenPrefs(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context deviceContext = context.createDeviceProtectedStorageContext();
        SharedPreferences sharedPreferences = deviceContext.getSharedPreferences("zen_prefs", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "run(...)");
        this.prefs = sharedPreferences;
    }

    public final List<String> getPresetNames() {
        String string = this.prefs.getString(KEY_PRESET_NAMES, "");
        String raw = string != null ? string : "";
        if (raw.length() == 0) {
            return CollectionsKt.emptyList();
        }
        Iterable $this$filter$iv = StringsKt.split$default((CharSequence) raw, new String[]{DELIMITER}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it = (String) element$iv$iv;
            if (it.length() > 0) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public final void savePreset(String name, List<String> apps) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(apps, "apps");
        List names = CollectionsKt.toMutableList((Collection) getPresetNames());
        if (!names.contains(name)) {
            names.add(name);
            this.prefs.edit().putString(KEY_PRESET_NAMES, CollectionsKt.joinToString$default(names, DELIMITER, null, null, 0, null, null, 62, null)).apply();
        }
        this.prefs.edit().putString(KEY_PRESET_PREFIX + name, CollectionsKt.joinToString$default(apps, DELIMITER, null, null, 0, null, null, 62, null)).apply();
    }

    public final List<String> getPresetApps(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String string = this.prefs.getString(KEY_PRESET_PREFIX + name, "");
        String raw = string != null ? string : "";
        if (raw.length() == 0) {
            return CollectionsKt.emptyList();
        }
        Iterable $this$filter$iv = StringsKt.split$default((CharSequence) raw, new String[]{DELIMITER}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it = (String) element$iv$iv;
            if (it.length() > 0) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public final void deletePreset(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List names = CollectionsKt.toMutableList((Collection) getPresetNames());
        names.remove(name);
        this.prefs.edit().putString(KEY_PRESET_NAMES, CollectionsKt.joinToString$default(names, DELIMITER, null, null, 0, null, null, 62, null)).remove(KEY_PRESET_PREFIX + name).apply();
    }

    public final void saveLastUsedApps(List<String> apps) {
        Intrinsics.checkNotNullParameter(apps, "apps");
        this.prefs.edit().putString(KEY_LAST_USED_APPS, CollectionsKt.joinToString$default(apps, DELIMITER, null, null, 0, null, null, 62, null)).apply();
    }

    public final List<String> getLastUsedApps() {
        String string = this.prefs.getString(KEY_LAST_USED_APPS, "");
        String raw = string != null ? string : "";
        if (raw.length() == 0) {
            return CollectionsKt.emptyList();
        }
        Iterable $this$filter$iv = StringsKt.split$default((CharSequence) raw, new String[]{DELIMITER}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it = (String) element$iv$iv;
            if (it.length() > 0) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public final boolean isBrowserLockoutEnabled() {
        return this.prefs.getBoolean(KEY_BROWSER_LOCKOUT, false);
    }

    public final void enableBrowserLockout() {
        this.prefs.edit().putBoolean(KEY_BROWSER_LOCKOUT, true).remove(KEY_DISABLE_REQUESTED_AT).apply();
    }

    public final void requestDisableBrowserLockout() {
        this.prefs.edit().putLong(KEY_DISABLE_REQUESTED_AT, System.currentTimeMillis()).apply();
    }

    public final void cancelDisableBrowserLockoutRequest() {
        this.prefs.edit().remove(KEY_DISABLE_REQUESTED_AT).apply();
    }

    public final long getDisableCooldownRemainingMs() {
        long requestedAt = this.prefs.getLong(KEY_DISABLE_REQUESTED_AT, 0L);
        if (requestedAt == 0) {
            return -1L;
        }
        long elapsed = System.currentTimeMillis() - requestedAt;
        return RangesKt.coerceAtLeast(DISABLE_COOLDOWN_MS - elapsed, 0L);
    }

    public final boolean confirmDisableBrowserLockout() {
        long remaining = getDisableCooldownRemainingMs();
        if (remaining != 0) {
            return false;
        }
        this.prefs.edit().putBoolean(KEY_BROWSER_LOCKOUT, false).remove(KEY_DISABLE_REQUESTED_AT).apply();
        return true;
    }

    public final void startZenSession(List<String> whitelistApps, long endTimeMs) {
        Intrinsics.checkNotNullParameter(whitelistApps, "whitelistApps");
        this.prefs.edit().putBoolean(KEY_ZEN_ACTIVE, true).putLong(KEY_END_TIME, endTimeMs).putString(KEY_WHITELIST, CollectionsKt.joinToString$default(whitelistApps, DELIMITER, null, null, 0, null, null, 62, null)).apply();
    }

    public final boolean isZenActive() {
        if (!this.prefs.getBoolean(KEY_ZEN_ACTIVE, false)) {
            return false;
        }
        long endTime = this.prefs.getLong(KEY_END_TIME, 0L);
        return System.currentTimeMillis() < endTime;
    }

    public final long getRemainingMs() {
        long endTime = this.prefs.getLong(KEY_END_TIME, 0L);
        return endTime - System.currentTimeMillis();
    }

    public final List<String> getWhitelistApps() {
        String string = this.prefs.getString(KEY_WHITELIST, "");
        String raw = string != null ? string : "";
        if (raw.length() == 0) {
            return CollectionsKt.emptyList();
        }
        Iterable $this$filter$iv = StringsKt.split$default((CharSequence) raw, new String[]{DELIMITER}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it = (String) element$iv$iv;
            if (it.length() > 0) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public final Set<String> getWhitelistAppsSet() {
        return CollectionsKt.toSet(getWhitelistApps());
    }

    public final void clearZenSession() {
        this.prefs.edit().putBoolean(KEY_ZEN_ACTIVE, false).remove(KEY_END_TIME).remove(KEY_WHITELIST).apply();
    }
}
