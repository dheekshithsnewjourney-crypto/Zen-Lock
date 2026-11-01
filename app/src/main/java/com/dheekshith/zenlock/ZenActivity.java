package com.dheekshith.zenlock;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ZenActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001bH\u0016J\u0012\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020\u001bH\u0014J\u001a\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u001bH\u0014J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020)H\u0016J\u0018\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001eH\u0002J\b\u00102\u001a\u00020\u001bH\u0002J\b\u00103\u001a\u00020\u001bH\u0002J\b\u00104\u001a\u00020\u001bH\u0002J\b\u00105\u001a\u00020\u001bH\u0002J\b\u00106\u001a\u00020\u001bH\u0002J\b\u00107\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/dheekshith/zenlock/ZenActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "appsGrid", "Landroid/widget/GridLayout;", "badgeTickCount", "", "batteryText", "Landroid/widget/TextView;", "cameraButton", "Landroid/widget/LinearLayout;", "currentTimeText", "dateFormat", "Ljava/text/SimpleDateFormat;", "dateText", "handler", "Landroid/os/Handler;", "messagesButton", "prefs", "Lcom/dheekshith/zenlock/ZenPrefs;", "timeFormat", "timerRunnable", "com/dheekshith/zenlock/ZenActivity$timerRunnable$1", "Lcom/dheekshith/zenlock/ZenActivity$timerRunnable$1;", "timerText", "whatsappButton", "applyImmersiveMode", "", "endZenMode", "getCameraPackage", "", "getMessagesPackage", "getWhatsappPackage", "launchApp", "packageName", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "onResume", "onWindowFocusChanged", "hasFocus", "setRealIcon", "imageViewId", "setupDefaultApps", "setupWhitelistApps", "updateBattery", "updateDateTime", "updateNotificationBadges", "updateTimer", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ZenActivity extends AppCompatActivity {
    private GridLayout appsGrid;
    private int badgeTickCount;
    private TextView batteryText;
    private LinearLayout cameraButton;
    private TextView currentTimeText;
    private TextView dateText;
    private LinearLayout messagesButton;
    private ZenPrefs prefs;
    private TextView timerText;
    private LinearLayout whatsappButton;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d", Locale.getDefault());
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
    private final ZenActivity$timerRunnable$1 timerRunnable = new Runnable() { // from class: com.dheekshith.zenlock.ZenActivity$timerRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            this.this$0.updateTimer();
            this.this$0.handler.postDelayed(this, 1000L);
        }
    };

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.prefs = new ZenPrefs(this);
        ZenPrefs zenPrefs = this.prefs;
        if (zenPrefs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs = null;
        }
        if (!zenPrefs.isZenActive()) {
            endZenMode();
            return;
        }
        getWindow().addFlags(6815872);
        applyImmersiveMode();
        setContentView(R.layout.activity_zen);
        View viewFindViewById = findViewById(R.id.timerText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.timerText = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.dateText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.dateText = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.currentTimeText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.currentTimeText = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.batteryText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.batteryText = (TextView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.appsGrid);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.appsGrid = (GridLayout) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.messagesButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.messagesButton = (LinearLayout) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.whatsappButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.whatsappButton = (LinearLayout) viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.cameraButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.cameraButton = (LinearLayout) viewFindViewById8;
        startLockTask();
        setupDefaultApps();
        setupWhitelistApps();
        this.handler.post(this.timerRunnable);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.dheekshith.zenlock.ZenActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i) {
                ZenActivity.onCreate$lambda$0(this.f$0, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(ZenActivity this$0, int it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.applyImmersiveMode();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        applyImmersiveMode();
        ZenPrefs zenPrefs = this.prefs;
        if (zenPrefs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs = null;
        }
        if (!zenPrefs.isZenActive()) {
            endZenMode();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            applyImmersiveMode();
        }
    }

    private final void applyImmersiveMode() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    private final void setupDefaultApps() {
        LinearLayout linearLayout = this.messagesButton;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messagesButton");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.dheekshith.zenlock.ZenActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZenActivity.setupDefaultApps$lambda$1(this.f$0, view);
            }
        });
        LinearLayout linearLayout3 = this.cameraButton;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraButton");
            linearLayout3 = null;
        }
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.dheekshith.zenlock.ZenActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZenActivity.setupDefaultApps$lambda$2(this.f$0, view);
            }
        });
        setRealIcon(R.id.messagesIcon, getMessagesPackage());
        setRealIcon(R.id.cameraIcon, getCameraPackage());
        boolean whatsappInstalled = (getPackageManager().getLaunchIntentForPackage("com.whatsapp") == null && getPackageManager().getLaunchIntentForPackage("com.whatsapp.w4b") == null) ? false : true;
        if (whatsappInstalled) {
            LinearLayout linearLayout4 = this.whatsappButton;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("whatsappButton");
                linearLayout4 = null;
            }
            linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.dheekshith.zenlock.ZenActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZenActivity.setupDefaultApps$lambda$3(this.f$0, view);
                }
            });
            LinearLayout linearLayout5 = this.whatsappButton;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("whatsappButton");
            } else {
                linearLayout2 = linearLayout5;
            }
            linearLayout2.setAlpha(1.0f);
            setRealIcon(R.id.whatsappIcon, getWhatsappPackage());
        } else {
            LinearLayout linearLayout6 = this.whatsappButton;
            if (linearLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("whatsappButton");
                linearLayout6 = null;
            }
            linearLayout6.setAlpha(0.25f);
            LinearLayout linearLayout7 = this.whatsappButton;
            if (linearLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("whatsappButton");
            } else {
                linearLayout2 = linearLayout7;
            }
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.dheekshith.zenlock.ZenActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZenActivity.setupDefaultApps$lambda$4(view);
                }
            });
        }
        updateNotificationBadges();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDefaultApps$lambda$1(ZenActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.launchApp(this$0.getMessagesPackage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDefaultApps$lambda$2(ZenActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.launchApp(this$0.getCameraPackage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDefaultApps$lambda$3(ZenActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.launchApp(this$0.getWhatsappPackage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDefaultApps$lambda$4(View it) {
    }

    private final void setRealIcon(int imageViewId, String packageName) {
        try {
            Drawable icon = getPackageManager().getApplicationIcon(packageName);
            Intrinsics.checkNotNullExpressionValue(icon, "getApplicationIcon(...)");
            ImageView imageView = (ImageView) findViewById(imageViewId);
            imageView.setImageDrawable(icon);
            imageView.setImageTintList(null);
            int sizePx = (int) (32 * getResources().getDisplayMetrics().density);
            ViewGroup.LayoutParams $this$setRealIcon_u24lambda_u245 = imageView.getLayoutParams();
            $this$setRealIcon_u24lambda_u245.width = sizePx;
            $this$setRealIcon_u24lambda_u245.height = sizePx;
            imageView.setLayoutParams($this$setRealIcon_u24lambda_u245);
        } catch (Exception e) {
        }
    }

    private final void updateNotificationBadges() {
        Map<String, Integer> unreadCounts = NotificationBadgeHelper.INSTANCE.getUnreadCounts(this);
        TextView messagesBadge = (TextView) findViewById(R.id.messagesBadge);
        Integer num = unreadCounts.get(getMessagesPackage());
        int messagesCount = num != null ? num.intValue() : 0;
        if (messagesCount > 0) {
            messagesBadge.setText(messagesCount > 99 ? "99+" : String.valueOf(messagesCount));
            messagesBadge.setVisibility(0);
        } else {
            messagesBadge.setVisibility(8);
        }
        TextView whatsappBadge = (TextView) findViewById(R.id.whatsappBadge);
        Integer num2 = unreadCounts.get("com.whatsapp");
        int iIntValue = num2 != null ? num2.intValue() : 0;
        Integer num3 = unreadCounts.get("com.whatsapp.w4b");
        int whatsappCount = iIntValue + (num3 != null ? num3.intValue() : 0);
        if (whatsappCount > 0) {
            whatsappBadge.setText(whatsappCount <= 99 ? String.valueOf(whatsappCount) : "99+");
            whatsappBadge.setVisibility(0);
        } else {
            whatsappBadge.setVisibility(8);
        }
    }

    private final void setupWhitelistApps() {
        Object element$iv;
        String it;
        PackageManager pm = getPackageManager();
        ZenPrefs zenPrefs = this.prefs;
        if (zenPrefs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs = null;
        }
        Iterable rawWhitelist = CollectionsKt.toList(zenPrefs.getWhitelistApps());
        Iterable $this$firstOrNull$iv = rawWhitelist;
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            } else {
                element$iv = it2.next();
                it = (String) element$iv;
            }
        } while (!CollectionsKt.listOf((Object[]) new String[]{"com.google.android.dialer", "com.miui.dialer", "com.android.dialer", "com.samsung.android.dialer"}).contains(it));
        final String dialerPkg = (String) element$iv;
        List displayList = new ArrayList();
        if (dialerPkg != null) {
            displayList.add("PHONE_TILE");
        }
        Iterable $this$filterNot$iv = rawWhitelist;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterNot$iv) {
            String it3 = (String) element$iv$iv;
            if (!ZenLockService.INSTANCE.getPHONE_APP_GROUP().contains(it3)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv2 : $this$forEach$iv) {
            String it4 = (String) element$iv2;
            displayList.add(it4);
        }
        GridLayout gridLayout = this.appsGrid;
        if (gridLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appsGrid");
            gridLayout = null;
        }
        gridLayout.removeAllViews();
        for (int i = 0; i < 30; i++) {
            LayoutInflater layoutInflater = getLayoutInflater();
            int i2 = R.layout.item_app_slot;
            GridLayout gridLayout2 = this.appsGrid;
            if (gridLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appsGrid");
                gridLayout2 = null;
            }
            View cell = layoutInflater.inflate(i2, (ViewGroup) gridLayout2, false);
            ImageView icon = (ImageView) cell.findViewById(R.id.slotIcon);
            TextView name = (TextView) cell.findViewById(R.id.slotName);
            TextView remove = (TextView) cell.findViewById(R.id.slotRemove);
            remove.setVisibility(8);
            if (i < displayList.size()) {
                final String pkg = (String) displayList.get(i);
                if (Intrinsics.areEqual(pkg, "PHONE_TILE")) {
                    icon.setImageResource(android.R.drawable.ic_menu_call);
                    icon.setAlpha(1.0f);
                    name.setText("Phone");
                    name.setTextColor(getColor(R.color.zen_white));
                    cell.setOnClickListener(new View.OnClickListener() { // from class: com.dheekshith.zenlock.ZenActivity$$ExternalSyntheticLambda4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ZenActivity.setupWhitelistApps$lambda$9(this.f$0, dialerPkg, view);
                        }
                    });
                } else {
                    try {
                        ApplicationInfo info = pm.getApplicationInfo(pkg, 0);
                        Intrinsics.checkNotNullExpressionValue(info, "getApplicationInfo(...)");
                        icon.setImageDrawable(pm.getApplicationIcon(info));
                        icon.setAlpha(1.0f);
                        name.setText(pm.getApplicationLabel(info).toString());
                        name.setTextColor(getColor(R.color.zen_white));
                        cell.setOnClickListener(new View.OnClickListener() { // from class: com.dheekshith.zenlock.ZenActivity$$ExternalSyntheticLambda5
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ZenActivity.setupWhitelistApps$lambda$10(this.f$0, pkg, view);
                            }
                        });
                    } catch (PackageManager.NameNotFoundException e) {
                        icon.setAlpha(0.2f);
                        name.setText("N/A");
                    }
                }
            } else {
                icon.setImageResource(android.R.drawable.ic_menu_close_clear_cancel);
                icon.setAlpha(0.1f);
                name.setText("");
            }
            GridLayout gridLayout3 = this.appsGrid;
            if (gridLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appsGrid");
                gridLayout3 = null;
            }
            gridLayout3.addView(cell);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupWhitelistApps$lambda$9(ZenActivity this$0, String $dialerPkg, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull($dialerPkg);
        this$0.launchApp($dialerPkg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupWhitelistApps$lambda$10(ZenActivity this$0, String pkg, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pkg, "$pkg");
        this$0.launchApp(pkg);
    }

    private final void launchApp(String packageName) {
        try {
            Intent normalIntent = getPackageManager().getLaunchIntentForPackage(packageName);
            if (normalIntent != null) {
                normalIntent.addFlags(268435456);
                startActivity(normalIntent, ActivityOptions.makeBasic().toBundle());
                return;
            }
            Intent $this$launchApp_u24lambda_u2411 = new Intent("android.intent.action.DIAL");
            $this$launchApp_u24lambda_u2411.addFlags(268435456);
            if ($this$launchApp_u24lambda_u2411.resolveActivity(getPackageManager()) != null) {
                startActivity($this$launchApp_u24lambda_u2411, ActivityOptions.makeBasic().toBundle());
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTimer() {
        String str;
        updateDateTime();
        ZenPrefs zenPrefs = this.prefs;
        TextView textView = null;
        if (zenPrefs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs = null;
        }
        long remaining = zenPrefs.getRemainingMs();
        if (remaining <= 0) {
            endZenMode();
            return;
        }
        long days = TimeUnit.MILLISECONDS.toDays(remaining);
        long hours = TimeUnit.MILLISECONDS.toHours(remaining) % ((long) 24);
        long j = 60;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(remaining) % j;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(remaining) % j;
        TextView textView2 = this.timerText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timerText");
        } else {
            textView = textView2;
        }
        if (days > 0) {
            str = days + "d " + hours + "h " + minutes + "m";
        } else {
            str = hours > 0 ? hours + "h " + minutes + "m " + seconds + "s" : minutes + "m " + seconds + "s";
        }
        textView.setText(str);
    }

    private final void updateDateTime() {
        Calendar now = Calendar.getInstance();
        TextView textView = this.dateText;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateText");
            textView = null;
        }
        textView.setText(this.dateFormat.format(now.getTime()));
        TextView textView3 = this.currentTimeText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentTimeText");
        } else {
            textView2 = textView3;
        }
        textView2.setText(this.timeFormat.format(now.getTime()));
        updateBattery();
        this.badgeTickCount++;
        if (this.badgeTickCount % 10 == 0) {
            updateNotificationBadges();
        }
    }

    private final void updateBattery() {
        try {
            Object systemService = getSystemService("batterymanager");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.BatteryManager");
            BatteryManager batteryManager = (BatteryManager) systemService;
            int level = batteryManager.getIntProperty(4);
            boolean isCharging = batteryManager.isCharging();
            TextView textView = this.batteryText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("batteryText");
                textView = null;
            }
            textView.setText(isCharging ? "⚡ " + level + "%" : "🔋 " + level + "%");
        } catch (Exception e) {
        }
    }

    private final void endZenMode() {
        this.handler.removeCallbacks(this.timerRunnable);
        ZenPrefs zenPrefs = this.prefs;
        if (zenPrefs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs = null;
        }
        zenPrefs.clearZenSession();
        stopService(new Intent(this, (Class<?>) ZenLockService.class));
        try {
            stopLockTask();
        } catch (Exception e) {
        }
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.addFlags(268468224);
        startActivity(intent);
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case 3:
            case 4:
            case 24:
            case 25:
            case 82:
            case 84:
            case 187:
                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacks(this.timerRunnable);
    }

    private final String getMessagesPackage() {
        Object element$iv;
        String it;
        Iterable $this$firstOrNull$iv = CollectionsKt.listOf((Object[]) new String[]{"com.miui.messaging", "com.google.android.apps.messaging", "com.android.mms"});
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it2.next();
            it = (String) element$iv;
        } while (!(getPackageManager().getLaunchIntentForPackage(it) != null));
        String str = (String) element$iv;
        return str == null ? "com.android.mms" : str;
    }

    private final String getCameraPackage() {
        Object element$iv;
        String it;
        Iterable $this$firstOrNull$iv = CollectionsKt.listOf((Object[]) new String[]{"com.miui.camera", "com.android.camera2", "com.android.camera"});
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it2.next();
            it = (String) element$iv;
        } while (!(getPackageManager().getLaunchIntentForPackage(it) != null));
        String str = (String) element$iv;
        return str == null ? "com.android.camera2" : str;
    }

    private final String getWhatsappPackage() {
        Object element$iv;
        String it;
        Iterable $this$firstOrNull$iv = CollectionsKt.listOf((Object[]) new String[]{"com.whatsapp", "com.whatsapp.w4b"});
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it2.next();
            it = (String) element$iv;
        } while (!(getPackageManager().getLaunchIntentForPackage(it) != null));
        String str = (String) element$iv;
        return str == null ? "com.whatsapp" : str;
    }
}
