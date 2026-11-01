package com.dheekshith.zenlock;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ZenLockService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\"\u0010\u001c\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/dheekshith/zenlock/ZenLockService;", "Landroid/app/Service;", "()V", "checkRunnable", "com/dheekshith/zenlock/ZenLockService$checkRunnable$1", "Lcom/dheekshith/zenlock/ZenLockService$checkRunnable$1;", "consecutiveBadReads", "", "handler", "Landroid/os/Handler;", "prefs", "Lcom/dheekshith/zenlock/ZenPrefs;", "tickCount", "buildNotification", "Landroid/app/Notification;", "remainingMs", "", "checkAndEnforce", "", "createNotificationChannel", "getForegroundApp", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "flags", "startId", "Companion", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ZenLockService extends Service {
    private static final String CHANNEL_ID = "zen_lock_channel";
    private static final int NOTIF_ID = 1;
    private int consecutiveBadReads;
    private ZenPrefs prefs;
    private int tickCount;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> DEFAULT_ALLOWED = SetsKt.setOf((Object[]) new String[]{"com.miui.contacts", "com.google.android.contacts", "com.android.contacts", "com.samsung.android.app.contacts", "com.miui.messaging", "com.google.android.apps.messaging", "com.android.mms", "com.samsung.android.messaging", "com.whatsapp", "com.whatsapp.w4b", "com.miui.camera", "com.android.camera2", "com.android.camera", "com.google.android.GoogleCamera", "com.samsung.android.camera", "android", "com.android.systemui", "com.android.permissioncontroller", "com.google.android.permissioncontroller", "com.miui.permcenter", "com.miui.securitycenter", "com.android.documentsui", "com.google.android.documentsui", "com.android.intentresolver", "com.android.chooser", "com.google.android.gms", "com.google.android.inputmethod.latin", "com.touchtype.swiftkey", "com.samsung.android.honeyboard", "com.google.android.providers.media.module", "com.android.providers.media.module", "com.google.android.apps.photos", "com.miui.home", "com.android.launcher3"});
    private static final Set<String> PHONE_APP_GROUP = SetsKt.setOf((Object[]) new String[]{"com.miui.dialer", "com.google.android.dialer", "com.android.dialer", "com.samsung.android.dialer", "com.android.server.telecom", "com.android.incallui", "com.google.android.incallui", "com.miui.incallui", "com.samsung.android.incallui", "com.android.phone", "com.android.server.telecom.components"});
    private static final Set<String> SECURITY_SENSITIVE_APPS = SetsKt.setOf((Object[]) new String[]{"com.google.android.apps.nbu.paisa.user", "com.google.android.apps.walletnfcrel"});
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final ZenLockService$checkRunnable$1 checkRunnable = new Runnable() { // from class: com.dheekshith.zenlock.ZenLockService$checkRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            this.this$0.checkAndEnforce();
            this.this$0.tickCount++;
            if (this.this$0.tickCount % 60 == 0) {
                Object systemService = this.this$0.getSystemService("notification");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                NotificationManager notifManager = (NotificationManager) systemService;
                ZenLockService zenLockService = this.this$0;
                ZenPrefs zenPrefs = this.this$0.prefs;
                if (zenPrefs == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("prefs");
                    zenPrefs = null;
                }
                notifManager.notify(1, zenLockService.buildNotification(zenPrefs.getRemainingMs()));
            }
            this.this$0.handler.postDelayed(this, 500L);
        }
    };

    /* JADX INFO: compiled from: ZenLockService.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/dheekshith/zenlock/ZenLockService$Companion;", "", "()V", "CHANNEL_ID", "", "DEFAULT_ALLOWED", "", "getDEFAULT_ALLOWED", "()Ljava/util/Set;", "NOTIF_ID", "", "PHONE_APP_GROUP", "getPHONE_APP_GROUP", "SECURITY_SENSITIVE_APPS", "getSECURITY_SENSITIVE_APPS", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getDEFAULT_ALLOWED() {
            return ZenLockService.DEFAULT_ALLOWED;
        }

        public final Set<String> getPHONE_APP_GROUP() {
            return ZenLockService.PHONE_APP_GROUP;
        }

        public final Set<String> getSECURITY_SENSITIVE_APPS() {
            return ZenLockService.SECURITY_SENSITIVE_APPS;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.prefs = new ZenPrefs(this);
        createNotificationChannel();
        startForeground(1, buildNotification$default(this, 0L, 1, null));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.handler.post(this.checkRunnable);
        return 1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkAndEnforce() {
        boolean phoneGroupNeeded;
        ZenPrefs zenPrefs = this.prefs;
        ZenPrefs zenPrefs2 = null;
        if (zenPrefs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs = null;
        }
        if (!zenPrefs.isZenActive()) {
            stopSelf();
            return;
        }
        String foregroundPkg = getForegroundApp();
        if (foregroundPkg == null) {
            return;
        }
        ZenPrefs zenPrefs3 = this.prefs;
        if (zenPrefs3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
        } else {
            zenPrefs2 = zenPrefs3;
        }
        Set<String> whitelistAppsSet = zenPrefs2.getWhitelistAppsSet();
        if (whitelistAppsSet.contains(foregroundPkg) && SECURITY_SENSITIVE_APPS.contains(foregroundPkg)) {
            this.consecutiveBadReads = 0;
            return;
        }
        Set<String> $this$any$iv = whitelistAppsSet;
        if (!($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
            Iterator it = $this$any$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    String it2 = (String) element$iv;
                    if (PHONE_APP_GROUP.contains(it2)) {
                        phoneGroupNeeded = true;
                        break;
                    }
                } else {
                    phoneGroupNeeded = false;
                    break;
                }
            }
        } else {
            phoneGroupNeeded = false;
        }
        Set allowedPackages = SetsKt.plus((Set<? extends String>) SetsKt.plus(SetsKt.plus((Set) DEFAULT_ALLOWED, (Iterable) whitelistAppsSet), (Iterable) (phoneGroupNeeded ? PHONE_APP_GROUP : SetsKt.emptySet())), getPackageName());
        if (!allowedPackages.contains(foregroundPkg)) {
            this.consecutiveBadReads++;
            if (this.consecutiveBadReads >= 10) {
                Intent intent = new Intent(this, (Class<?>) ZenActivity.class);
                intent.addFlags(805306368);
                startActivity(intent);
                this.consecutiveBadReads = 0;
                return;
            }
            return;
        }
        this.consecutiveBadReads = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private final String getForegroundApp() {
        Object maxElem$iv;
        try {
            Object systemService = getSystemService("usagestats");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.usage.UsageStatsManager");
            UsageStatsManager usm = (UsageStatsManager) systemService;
            long now = System.currentTimeMillis();
            Iterable iterableQueryUsageStats = usm.queryUsageStats(0, now - ((long) PathInterpolatorCompat.MAX_NUM_POINTS), now);
            if (iterableQueryUsageStats == null) {
                return null;
            }
            Iterable $this$maxByOrNull$iv = iterableQueryUsageStats;
            Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
            if (iterator$iv.hasNext()) {
                maxElem$iv = iterator$iv.next();
                if (iterator$iv.hasNext()) {
                    UsageStats it = (UsageStats) maxElem$iv;
                    long maxValue$iv = it.getLastTimeUsed();
                    do {
                        Object e$iv = iterator$iv.next();
                        UsageStats it2 = (UsageStats) e$iv;
                        long v$iv = it2.getLastTimeUsed();
                        if (maxValue$iv < v$iv) {
                            maxElem$iv = e$iv;
                            maxValue$iv = v$iv;
                        }
                    } while (iterator$iv.hasNext());
                }
            } else {
                maxElem$iv = null;
            }
            UsageStats usageStats = (UsageStats) maxElem$iv;
            if (usageStats != null) {
                return usageStats.getPackageName();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    static /* synthetic */ Notification buildNotification$default(ZenLockService zenLockService, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return zenLockService.buildNotification(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Notification buildNotification(long remainingMs) {
        String timeText;
        if (remainingMs > 0) {
            long days = remainingMs / ((long) 86400000);
            long hours = (remainingMs / ((long) 3600000)) % ((long) 24);
            long minutes = (remainingMs / ((long) 60000)) % ((long) 60);
            if (days > 0) {
                timeText = days + "d " + hours + "h remaining";
            } else {
                timeText = hours > 0 ? hours + "h " + minutes + "m remaining" : minutes + "m remaining";
            }
        } else {
            timeText = "Zen Mode Active";
        }
        Notification notificationBuild = new NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle("🧘 ZenLock Active").setContentText(timeText).setSmallIcon(android.R.drawable.ic_lock_idle_lock).setOngoing(true).setPriority(-1).build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        return notificationBuild;
    }

    private final void createNotificationChannel() {
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "ZenLock Service", 2);
        channel.setDescription("ZenLock active session");
        channel.setShowBadge(false);
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager manager = (NotificationManager) systemService;
        manager.createNotificationChannel(channel);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacks(this.checkRunnable);
    }
}
