package com.dheekshith.zenlock;

import android.app.AppOpsManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0016H\u0002J\u0012\u0010'\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\b\u0010*\u001a\u00020 H\u0014J\b\u0010+\u001a\u00020 H\u0002J\b\u0010,\u001a\u00020 H\u0002J\b\u0010-\u001a\u00020 H\u0002J\b\u0010.\u001a\u00020 H\u0002J\b\u0010/\u001a\u00020 H\u0002J\b\u00100\u001a\u00020 H\u0002J\b\u00101\u001a\u00020 H\u0002J\b\u00102\u001a\u00020 H\u0002J\b\u00103\u001a\u00020 H\u0002J\u0018\u00104\u001a\u00020 2\u0006\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u00020\u0015H\u0002J\b\u00107\u001a\u00020 H\u0002J\b\u00108\u001a\u00020 H\u0002J\u0010\u00109\u001a\u00020 2\u0006\u00106\u001a\u00020\u0015H\u0002J\b\u0010:\u001a\u00020 H\u0002J\b\u0010;\u001a\u00020 H\u0002J\b\u0010<\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R \u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00140\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/dheekshith/zenlock/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "addAppButton", "Landroid/widget/Button;", "adminComponent", "Landroid/content/ComponentName;", "adminStatusText", "Landroid/widget/TextView;", "appsGrid", "Landroid/widget/GridLayout;", "browserLockoutStatus", "browserLockoutSwitch", "Landroid/widget/Switch;", "dpm", "Landroid/app/admin/DevicePolicyManager;", "durationSlider", "Landroid/widget/SeekBar;", "durationSteps", "", "Lkotlin/Pair;", "", "", "durationValue", "notifAccessText", "prefs", "Lcom/dheekshith/zenlock/ZenPrefs;", "presetButton", "selectedApps", "", "startButton", "confirmEnableBrowserLockout", "", "handleDisableRequest", "hasUsageStatsPermission", "", "loadLastUsedAppsAsDefault", "loadPreset", "name", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "refreshAppGrid", "refreshBrowserLockoutUi", "requestAdminRights", "setupAddAppButton", "setupBrowserLockout", "setupDurationSlider", "setupPresetButton", "setupStartButton", "showAppPicker", "showFinalConfirmation", "durationText", "endTime", "showPresetMenu", "showSavePresetDialog", "startZenMode", "suspendAllInstalledBrowsers", "updateAdminStatus", "updateNotifAccessStatus", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MainActivity extends AppCompatActivity {
    private Button addAppButton;
    private ComponentName adminComponent;
    private TextView adminStatusText;
    private GridLayout appsGrid;
    private TextView browserLockoutStatus;
    private Switch browserLockoutSwitch;
    private DevicePolicyManager dpm;
    private SeekBar durationSlider;
    private final List<Pair<Long, String>> durationSteps;
    private TextView durationValue;
    private TextView notifAccessText;
    private ZenPrefs prefs;
    private Button presetButton;
    private final List<Pair<String, String>> selectedApps = new ArrayList();
    private Button startButton;

    public MainActivity() {
        List $this$durationSteps_u24lambda_u243 = CollectionsKt.createListBuilder();
        int i = 0;
        Iterable $this$forEach$iv = CollectionsKt.listOf((Object[]) new Long[]{1L, 5L, 10L, 15L, 20L, 30L, 45L});
        Iterator it = $this$forEach$iv.iterator();
        while (it.hasNext()) {
            long m = ((Number) it.next()).longValue();
            Iterable $this$forEach$iv2 = $this$forEach$iv;
            $this$durationSteps_u24lambda_u243.add(TuplesKt.to(Long.valueOf(((long) 60) * m * ((long) 1000)), m == 1 ? "1 minute" : m + " minutes"));
            $this$forEach$iv = $this$forEach$iv2;
        }
        int $i$f$forEach = 0;
        Iterator<Integer> it2 = new IntRange(1, 24).iterator();
        while (it2.hasNext()) {
            int element$iv = ((IntIterator) it2).nextInt();
            int $i$f$forEach2 = $i$f$forEach;
            long j = 60;
            $this$durationSteps_u24lambda_u243.add(TuplesKt.to(Long.valueOf(((long) element$iv) * j * j * ((long) 1000)), element$iv == 1 ? "1 hour" : element$iv + " hours"));
            $i$f$forEach = $i$f$forEach2;
        }
        Iterable $this$forEach$iv3 = new IntRange(1, 30);
        Iterator<Integer> it3 = $this$forEach$iv3.iterator();
        while (it3.hasNext()) {
            int element$iv2 = ((IntIterator) it3).nextInt();
            int i2 = i;
            Iterable $this$forEach$iv4 = $this$forEach$iv3;
            long j2 = 60;
            $this$durationSteps_u24lambda_u243.add(TuplesKt.to(Long.valueOf(((long) element$iv2) * ((long) 24) * j2 * j2 * ((long) 1000)), element$iv2 == 1 ? "1 day" : element$iv2 + " days"));
            i = i2;
            $this$forEach$iv3 = $this$forEach$iv4;
        }
        this.durationSteps = CollectionsKt.build($this$durationSteps_u24lambda_u243);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Object systemService = getSystemService("device_policy");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.admin.DevicePolicyManager");
        this.dpm = (DevicePolicyManager) systemService;
        this.adminComponent = new ComponentName(this, (Class<?>) ZenDeviceAdminReceiver.class);
        this.prefs = new ZenPrefs(this);
        ZenPrefs zenPrefs = this.prefs;
        if (zenPrefs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs = null;
        }
        if (zenPrefs.isZenActive()) {
            startActivity(new Intent(this, (Class<?>) ZenActivity.class));
            finish();
            return;
        }
        View viewFindViewById = findViewById(R.id.appsGrid);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.appsGrid = (GridLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.addAppButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.addAppButton = (Button) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.durationValue);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.durationValue = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.durationSlider);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.durationSlider = (SeekBar) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.startButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.startButton = (Button) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.adminStatusText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.adminStatusText = (TextView) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.notifAccessText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.notifAccessText = (TextView) viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.browserLockoutSwitch);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.browserLockoutSwitch = (Switch) viewFindViewById8;
        View viewFindViewById9 = findViewById(R.id.browserLockoutStatus);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.browserLockoutStatus = (TextView) viewFindViewById9;
        View viewFindViewById10 = findViewById(R.id.presetButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.presetButton = (Button) viewFindViewById10;
        setupDurationSlider();
        setupAddAppButton();
        setupStartButton();
        setupBrowserLockout();
        setupPresetButton();
        updateAdminStatus();
        loadLastUsedAppsAsDefault();
        refreshAppGrid();
    }

    private final void loadLastUsedAppsAsDefault() {
        PackageManager pm = getPackageManager();
        ZenPrefs zenPrefs = this.prefs;
        if (zenPrefs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs = null;
        }
        Iterable lastUsedApps = zenPrefs.getLastUsedApps();
        this.selectedApps.clear();
        Iterable $this$forEach$iv = lastUsedApps;
        for (Object element$iv : $this$forEach$iv) {
            String pkg = (String) element$iv;
            if (Intrinsics.areEqual(pkg, "PHONE_APP_MARKER")) {
                this.selectedApps.add(TuplesKt.to(pkg, "Phone"));
            } else {
                try {
                    ApplicationInfo info = pm.getApplicationInfo(pkg, 0);
                    Intrinsics.checkNotNullExpressionValue(info, "getApplicationInfo(...)");
                    this.selectedApps.add(TuplesKt.to(pkg, pm.getApplicationLabel(info).toString()));
                } catch (Exception e) {
                }
            }
        }
    }

    private final void setupPresetButton() {
        Button button = this.presetButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presetButton");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.setupPresetButton$lambda$5(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupPresetButton$lambda$5(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showPresetMenu();
    }

    /* JADX WARN: Type inference failed for: r6v10, types: [T, androidx.appcompat.app.AlertDialog] */
    private final void showPresetMenu() {
        ZenPrefs zenPrefs = this.prefs;
        if (zenPrefs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs = null;
        }
        Iterable presetNames = zenPrefs.getPresetNames();
        LinearLayout container = new LinearLayout(this);
        container.setOrientation(1);
        container.setPadding(32, 8, 32, 8);
        TextView saveRow = new TextView(this);
        saveRow.setText("💾  Save current list as new preset");
        saveRow.setTextSize(15.0f);
        saveRow.setTextColor(getColor(R.color.zen_accent));
        saveRow.setPadding(16, 28, 16, 28);
        container.addView(saveRow);
        if (!((Collection) presetNames).isEmpty()) {
            View divider = new View(this);
            divider.setLayoutParams(new LinearLayout.LayoutParams(-1, 2));
            divider.setBackgroundColor(getColor(R.color.zen_surface));
            container.addView(divider);
        }
        final Ref.ObjectRef dialogRef = new Ref.ObjectRef();
        Iterable $this$forEach$iv = presetNames;
        for (Object element$iv : $this$forEach$iv) {
            final String name = (String) element$iv;
            View row = getLayoutInflater().inflate(R.layout.item_preset, (ViewGroup) container, false);
            TextView nameView = (TextView) row.findViewById(R.id.presetName);
            TextView deleteBtn = (TextView) row.findViewById(R.id.presetDeleteBtn);
            nameView.setText("📋  " + name);
            nameView.setOnClickListener(new View.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda16
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.showPresetMenu$lambda$12$lambda$9(this.f$0, name, dialogRef, view);
                }
            });
            deleteBtn.setOnClickListener(new View.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.showPresetMenu$lambda$12$lambda$11(this.f$0, name, dialogRef, view);
                }
            });
            container.addView(row);
        }
        saveRow.setOnClickListener(new View.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.showPresetMenu$lambda$13(dialogRef, this, view);
            }
        });
        ScrollView $this$showPresetMenu_u24lambda_u2414 = new ScrollView(this);
        $this$showPresetMenu_u24lambda_u2414.addView(container);
        dialogRef.element = new AlertDialog.Builder(this, R.style.ZenDialog).setTitle("Preset Lists").setView($this$showPresetMenu_u24lambda_u2414).setNegativeButton("Close", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showPresetMenu$lambda$12$lambda$9(MainActivity this$0, String name, Ref.ObjectRef dialogRef, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(name, "$name");
        Intrinsics.checkNotNullParameter(dialogRef, "$dialogRef");
        this$0.loadPreset(name);
        AlertDialog alertDialog = (AlertDialog) dialogRef.element;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPresetMenu$lambda$12$lambda$11(final MainActivity this$0, final String name, final Ref.ObjectRef dialogRef, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(name, "$name");
        Intrinsics.checkNotNullParameter(dialogRef, "$dialogRef");
        new AlertDialog.Builder(this$0, R.style.ZenDialog).setTitle("Delete \"" + name + "\"?").setMessage("This preset will be removed. Your currently selected apps won't change.").setPositiveButton("Delete", new DialogInterface.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.showPresetMenu$lambda$12$lambda$11$lambda$10(this.f$0, name, dialogRef, dialogInterface, i);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showPresetMenu$lambda$12$lambda$11$lambda$10(MainActivity this$0, String name, Ref.ObjectRef dialogRef, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(name, "$name");
        Intrinsics.checkNotNullParameter(dialogRef, "$dialogRef");
        ZenPrefs zenPrefs = this$0.prefs;
        if (zenPrefs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs = null;
        }
        zenPrefs.deletePreset(name);
        AlertDialog alertDialog = (AlertDialog) dialogRef.element;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        Toast.makeText(this$0, "Deleted \"" + name + "\"", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showPresetMenu$lambda$13(Ref.ObjectRef dialogRef, MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(dialogRef, "$dialogRef");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AlertDialog alertDialog = (AlertDialog) dialogRef.element;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this$0.showSavePresetDialog();
    }

    private final void showSavePresetDialog() {
        if (this.selectedApps.isEmpty()) {
            Toast.makeText(this, "Add some apps first", 0).show();
            return;
        }
        final EditText $this$showSavePresetDialog_u24lambda_u2415 = new EditText(this);
        $this$showSavePresetDialog_u24lambda_u2415.setHint("e.g. Work, Deep Focus, Study");
        $this$showSavePresetDialog_u24lambda_u2415.setPadding(48, 32, 48, 32);
        new AlertDialog.Builder(this, R.style.ZenDialog).setTitle("Save Preset").setView($this$showSavePresetDialog_u24lambda_u2415).setPositiveButton("Save", new DialogInterface.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.showSavePresetDialog$lambda$17($this$showSavePresetDialog_u24lambda_u2415, this, dialogInterface, i);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSavePresetDialog$lambda$17(EditText input, MainActivity this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(input, "$input");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String name = StringsKt.trim((CharSequence) input.getText().toString()).toString();
        if (name.length() == 0) {
            Toast.makeText(this$0, "Enter a name", 0).show();
            return;
        }
        ZenPrefs zenPrefs = this$0.prefs;
        if (zenPrefs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs = null;
        }
        Iterable $this$map$iv = this$0.selectedApps;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Pair it = (Pair) item$iv$iv;
            destination$iv$iv.add((String) it.getFirst());
        }
        zenPrefs.savePreset(name, (List) destination$iv$iv);
        Toast.makeText(this$0, "Saved \"" + name + "\"", 0).show();
    }

    private final void loadPreset(String name) {
        StringBuilder sb;
        StringBuilder sbAppend;
        String str;
        PackageManager pm = getPackageManager();
        ZenPrefs zenPrefs = this.prefs;
        if (zenPrefs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs = null;
        }
        Iterable presetApps = zenPrefs.getPresetApps(name);
        this.selectedApps.clear();
        int skipped = 0;
        Iterable $this$forEach$iv = presetApps;
        for (Object element$iv : $this$forEach$iv) {
            String pkg = (String) element$iv;
            if (Intrinsics.areEqual(pkg, "PHONE_APP_MARKER")) {
                this.selectedApps.add(TuplesKt.to(pkg, "Phone"));
            } else {
                try {
                    ApplicationInfo info = pm.getApplicationInfo(pkg, 0);
                    Intrinsics.checkNotNullExpressionValue(info, "getApplicationInfo(...)");
                    this.selectedApps.add(TuplesKt.to(pkg, pm.getApplicationLabel(info).toString()));
                } catch (Exception e) {
                    skipped++;
                }
            }
        }
        refreshAppGrid();
        if (skipped > 0) {
            sb = new StringBuilder();
            sbAppend = sb.append("Loaded \"").append(name).append("\" (").append(skipped);
            str = " app(s) no longer installed)";
        } else {
            sb = new StringBuilder();
            sbAppend = sb.append("Loaded \"").append(name);
            str = "\"";
        }
        String msg = sbAppend.append(str).toString();
        Toast.makeText(this, msg, 0).show();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        updateAdminStatus();
        refreshBrowserLockoutUi();
    }

    private final void setupBrowserLockout() {
        refreshBrowserLockoutUi();
    }

    private final void confirmEnableBrowserLockout() {
        new AlertDialog.Builder(this, R.style.ZenDialog).setTitle("Enable Browser Lockout?").setMessage("Any browser app (Chrome, Firefox, Brave, etc — 90+ known browsers) will be instantly suspended the moment it's installed. Play Store itself stays fully usable for everything else.\n\nTo turn this off later, you'll need to wait a mandatory 24-hour cooldown after requesting it.\n\nEnable now?").setPositiveButton("Enable", new DialogInterface.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.confirmEnableBrowserLockout$lambda$19(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.confirmEnableBrowserLockout$lambda$20(this.f$0, dialogInterface, i);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda14
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                MainActivity.confirmEnableBrowserLockout$lambda$21(this.f$0, dialogInterface);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void confirmEnableBrowserLockout$lambda$19(MainActivity this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DevicePolicyManager devicePolicyManager = this$0.dpm;
        ZenPrefs zenPrefs = null;
        if (devicePolicyManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dpm");
            devicePolicyManager = null;
        }
        if (!devicePolicyManager.isDeviceOwnerApp(this$0.getPackageName())) {
            Toast.makeText(this$0, "Device Owner required first — run the ADB command", 1).show();
            this$0.refreshBrowserLockoutUi();
            return;
        }
        ZenPrefs zenPrefs2 = this$0.prefs;
        if (zenPrefs2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
        } else {
            zenPrefs = zenPrefs2;
        }
        zenPrefs.enableBrowserLockout();
        this$0.suspendAllInstalledBrowsers();
        this$0.refreshBrowserLockoutUi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void confirmEnableBrowserLockout$lambda$20(MainActivity this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.refreshBrowserLockoutUi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void confirmEnableBrowserLockout$lambda$21(MainActivity this$0, DialogInterface it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.refreshBrowserLockoutUi();
    }

    private final void suspendAllInstalledBrowsers() {
        DevicePolicyManager devicePolicyManager = this.dpm;
        ComponentName componentName = null;
        if (devicePolicyManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dpm");
            devicePolicyManager = null;
        }
        if (devicePolicyManager.isDeviceOwnerApp(getPackageName())) {
            PackageManager pm = getPackageManager();
            Iterable installedApplications = pm.getInstalledApplications(128);
            Intrinsics.checkNotNullExpressionValue(installedApplications, "getInstalledApplications(...)");
            Iterable $this$map$iv = installedApplications;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                destination$iv$iv.add(((ApplicationInfo) item$iv$iv).packageName);
            }
            Iterable $this$filter$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                String it = (String) element$iv$iv;
                BrowserBlocklist browserBlocklist = BrowserBlocklist.INSTANCE;
                Intrinsics.checkNotNull(it);
                if (browserBlocklist.isBrowser(it)) {
                    destination$iv$iv2.add(element$iv$iv);
                }
            }
            Collection installedBrowsers = (List) destination$iv$iv2;
            if (!installedBrowsers.isEmpty()) {
                try {
                    DevicePolicyManager devicePolicyManager2 = this.dpm;
                    if (devicePolicyManager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dpm");
                        devicePolicyManager2 = null;
                    }
                    ComponentName componentName2 = this.adminComponent;
                    if (componentName2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adminComponent");
                    } else {
                        componentName = componentName2;
                    }
                    Collection $this$toTypedArray$iv = installedBrowsers;
                    devicePolicyManager2.setPackagesSuspended(componentName, (String[]) $this$toTypedArray$iv.toArray(new String[0]), true);
                } catch (Exception e) {
                }
            }
        }
    }

    private final void handleDisableRequest() {
        ZenPrefs zenPrefs = this.prefs;
        ZenPrefs zenPrefs2 = null;
        if (zenPrefs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs = null;
        }
        long remaining = zenPrefs.getDisableCooldownRemainingMs();
        if (remaining == -1) {
            new AlertDialog.Builder(this, R.style.ZenDialog).setTitle("Start 24h Cooldown?").setMessage("Browser Lockout will turn off automatically 24 hours from now. This delay is intentional — it can't be rushed.\n\nStart the cooldown?").setPositiveButton("Start Cooldown", new DialogInterface.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda7
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MainActivity.handleDisableRequest$lambda$24(this.f$0, dialogInterface, i);
                }
            }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
            return;
        }
        if (remaining == 0) {
            ZenPrefs zenPrefs3 = this.prefs;
            if (zenPrefs3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
            } else {
                zenPrefs2 = zenPrefs3;
            }
            zenPrefs2.confirmDisableBrowserLockout();
            refreshBrowserLockoutUi();
            Toast.makeText(this, "Browser Lockout disabled", 0).show();
            return;
        }
        long hours = remaining / ((long) 3600000);
        long minutes = (remaining / ((long) 60000)) % ((long) 60);
        new AlertDialog.Builder(this, R.style.ZenDialog).setTitle("Cooldown Active").setMessage(hours + "h " + minutes + "m remaining before Browser Lockout can be disabled.").setPositiveButton("OK", (DialogInterface.OnClickListener) null).setNeutralButton("Cancel Cooldown Request", new DialogInterface.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.handleDisableRequest$lambda$25(this.f$0, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleDisableRequest$lambda$24(MainActivity this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZenPrefs zenPrefs = this$0.prefs;
        if (zenPrefs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs = null;
        }
        zenPrefs.requestDisableBrowserLockout();
        this$0.refreshBrowserLockoutUi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleDisableRequest$lambda$25(MainActivity this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZenPrefs zenPrefs = this$0.prefs;
        if (zenPrefs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs = null;
        }
        zenPrefs.cancelDisableBrowserLockoutRequest();
        this$0.refreshBrowserLockoutUi();
    }

    private final void refreshBrowserLockoutUi() {
        String str;
        String str2;
        Switch r0 = this.browserLockoutSwitch;
        Switch r2 = null;
        if (r0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("browserLockoutSwitch");
            r0 = null;
        }
        r0.setOnCheckedChangeListener(null);
        ZenPrefs zenPrefs = this.prefs;
        if (zenPrefs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs = null;
        }
        boolean enabled = zenPrefs.isBrowserLockoutEnabled();
        Switch r4 = this.browserLockoutSwitch;
        if (r4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("browserLockoutSwitch");
            r4 = null;
        }
        r4.setChecked(enabled);
        TextView textView = this.browserLockoutStatus;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("browserLockoutStatus");
            textView = null;
        }
        if (enabled) {
            ZenPrefs zenPrefs2 = this.prefs;
            if (zenPrefs2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
                zenPrefs2 = null;
            }
            long remaining = zenPrefs2.getDisableCooldownRemainingMs();
            if (remaining == -1) {
                str = "On — 90+ browsers auto-blocked";
            } else if (remaining == 0) {
                str = "Cooldown finished — toggle again to confirm";
            } else {
                long h = remaining / ((long) 3600000);
                long m = (remaining / ((long) 60000)) % ((long) 60);
                str = "On — disable in " + h + "h " + m + "m";
            }
            str2 = str;
        }
        textView.setText(str2);
        Switch r3 = this.browserLockoutSwitch;
        if (r3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("browserLockoutSwitch");
        } else {
            r2 = r3;
        }
        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda19
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MainActivity.refreshBrowserLockoutUi$lambda$26(this.f$0, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshBrowserLockoutUi$lambda$26(MainActivity this$0, CompoundButton compoundButton, boolean isChecked) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Switch r0 = null;
        if (isChecked) {
            ZenPrefs zenPrefs = this$0.prefs;
            if (zenPrefs == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
                zenPrefs = null;
            }
            if (!zenPrefs.isBrowserLockoutEnabled()) {
                this$0.confirmEnableBrowserLockout();
                return;
            }
        }
        if (isChecked) {
            return;
        }
        ZenPrefs zenPrefs2 = this$0.prefs;
        if (zenPrefs2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs2 = null;
        }
        if (zenPrefs2.isBrowserLockoutEnabled()) {
            Switch r3 = this$0.browserLockoutSwitch;
            if (r3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("browserLockoutSwitch");
            } else {
                r0 = r3;
            }
            r0.setChecked(true);
            this$0.handleDisableRequest();
        }
    }

    private final void updateAdminStatus() {
        DevicePolicyManager devicePolicyManager = this.dpm;
        TextView textView = null;
        if (devicePolicyManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dpm");
            devicePolicyManager = null;
        }
        boolean isDeviceOwner = devicePolicyManager.isDeviceOwnerApp(getPackageName());
        DevicePolicyManager devicePolicyManager2 = this.dpm;
        if (devicePolicyManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dpm");
            devicePolicyManager2 = null;
        }
        ComponentName componentName = this.adminComponent;
        if (componentName == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adminComponent");
            componentName = null;
        }
        boolean isAdmin = devicePolicyManager2.isAdminActive(componentName);
        if (isDeviceOwner) {
            TextView textView2 = this.adminStatusText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adminStatusText");
                textView2 = null;
            }
            textView2.setText("✅  Iron Mode — Device Owner Active");
            TextView textView3 = this.adminStatusText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adminStatusText");
            } else {
                textView = textView3;
            }
            textView.setTextColor(getColor(R.color.zen_green));
        } else if (isAdmin) {
            TextView textView4 = this.adminStatusText;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adminStatusText");
                textView4 = null;
            }
            textView4.setText("⚠️  Run the ADB command for full lock");
            TextView textView5 = this.adminStatusText;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adminStatusText");
            } else {
                textView = textView5;
            }
            textView.setTextColor(getColor(R.color.zen_yellow));
        } else {
            TextView textView6 = this.adminStatusText;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adminStatusText");
                textView6 = null;
            }
            textView6.setText("❌  No admin — tap to enable");
            TextView textView7 = this.adminStatusText;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adminStatusText");
                textView7 = null;
            }
            textView7.setTextColor(getColor(R.color.zen_red));
            TextView textView8 = this.adminStatusText;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adminStatusText");
            } else {
                textView = textView8;
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.updateAdminStatus$lambda$27(this.f$0, view);
                }
            });
        }
        updateNotifAccessStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateAdminStatus$lambda$27(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requestAdminRights();
    }

    private final void updateNotifAccessStatus() {
        TextView textView = null;
        if (NotificationBadgeHelper.INSTANCE.isNotificationAccessGranted(this)) {
            TextView textView2 = this.notifAccessText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notifAccessText");
                textView2 = null;
            }
            textView2.setText("✅  Notification badges enabled");
            TextView textView3 = this.notifAccessText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notifAccessText");
                textView3 = null;
            }
            textView3.setTextColor(getColor(R.color.zen_green));
            TextView textView4 = this.notifAccessText;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notifAccessText");
                textView4 = null;
            }
            textView4.setOnClickListener(null);
            return;
        }
        TextView textView5 = this.notifAccessText;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notifAccessText");
            textView5 = null;
        }
        textView5.setText("🔔  Enable notification badges (optional) — tap here");
        TextView textView6 = this.notifAccessText;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notifAccessText");
            textView6 = null;
        }
        textView6.setTextColor(getColor(R.color.zen_grey));
        TextView textView7 = this.notifAccessText;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notifAccessText");
        } else {
            textView = textView7;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.updateNotifAccessStatus$lambda$28(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateNotifAccessStatus$lambda$28(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
    }

    private final void requestAdminRights() {
        Intent intent = new Intent("android.app.action.ADD_DEVICE_ADMIN");
        ComponentName componentName = this.adminComponent;
        if (componentName == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adminComponent");
            componentName = null;
        }
        intent.putExtra("android.app.extra.DEVICE_ADMIN", componentName);
        intent.putExtra("android.app.extra.ADD_EXPLANATION", "ZenLock needs device admin to enforce focus mode.");
        startActivity(intent);
    }

    private final void setupDurationSlider() {
        SeekBar seekBar = this.durationSlider;
        SeekBar seekBar2 = null;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("durationSlider");
            seekBar = null;
        }
        seekBar.setMax(this.durationSteps.size() - 1);
        SeekBar seekBar3 = this.durationSlider;
        if (seekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("durationSlider");
            seekBar3 = null;
        }
        seekBar3.setProgress(0);
        TextView textView = this.durationValue;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("durationValue");
            textView = null;
        }
        textView.setText(this.durationSteps.get(0).getSecond());
        SeekBar seekBar4 = this.durationSlider;
        if (seekBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("durationSlider");
        } else {
            seekBar2 = seekBar4;
        }
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.dheekshith.zenlock.MainActivity.setupDurationSlider.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar sb, int progress, boolean fromUser) {
                Intrinsics.checkNotNullParameter(sb, "sb");
                TextView textView2 = MainActivity.this.durationValue;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("durationValue");
                    textView2 = null;
                }
                textView2.setText((CharSequence) ((Pair) MainActivity.this.durationSteps.get(progress)).getSecond());
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar sb) {
                Intrinsics.checkNotNullParameter(sb, "sb");
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar sb) {
                Intrinsics.checkNotNullParameter(sb, "sb");
            }
        });
    }

    private final void setupAddAppButton() {
        Button button = this.addAppButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAppButton");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.setupAddAppButton$lambda$30(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupAddAppButton$lambda$30(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.selectedApps.size() >= 30) {
            Toast.makeText(this$0, "Maximum 30 apps", 0).show();
        } else {
            this$0.showAppPicker();
        }
    }

    private final void showAppPicker() {
        boolean phoneAlreadySelected;
        final PackageManager pm = getPackageManager();
        Set setPlus = SetsKt.plus(ZenLockService.INSTANCE.getDEFAULT_ALLOWED(), getPackageName());
        Iterable $this$map$iv = this.selectedApps;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add((String) ((Pair) item$iv$iv).getFirst());
        }
        Set excluded = SetsKt.plus(setPlus, (Iterable) CollectionsKt.toSet((List) destination$iv$iv));
        List phoneCandidates = CollectionsKt.listOf((Object[]) new String[]{"com.google.android.dialer", "com.miui.dialer", "com.android.dialer", "com.samsung.android.dialer"});
        Iterable $this$any$iv = this.selectedApps;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator it = $this$any$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    phoneAlreadySelected = false;
                    break;
                }
                Object element$iv = it.next();
                Pair it2 = (Pair) element$iv;
                if (phoneCandidates.contains(it2.getFirst()) || Intrinsics.areEqual(it2.getFirst(), "PHONE_APP_MARKER")) {
                    phoneAlreadySelected = true;
                    break;
                }
            }
        } else {
            phoneAlreadySelected = false;
        }
        boolean showPhoneOption = !phoneAlreadySelected;
        Iterable installedApplications = pm.getInstalledApplications(128);
        Intrinsics.checkNotNullExpressionValue(installedApplications, "getInstalledApplications(...)");
        Iterable $this$filter$iv = installedApplications;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            ApplicationInfo it3 = (ApplicationInfo) element$iv$iv;
            if ((pm.getLaunchIntentForPackage(it3.packageName) == null || excluded.contains(it3.packageName)) ? false : true) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        Iterable $this$sortedBy$iv = (List) destination$iv$iv2;
        List apps = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.dheekshith.zenlock.MainActivity$showAppPicker$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                ApplicationInfo it4 = (ApplicationInfo) t;
                String lowerCase = pm.getApplicationLabel(it4).toString().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                ApplicationInfo it5 = (ApplicationInfo) t2;
                String lowerCase2 = pm.getApplicationLabel(it5).toString().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                return ComparisonsKt.compareValues(lowerCase, lowerCase2);
            }
        });
        if (apps.isEmpty() && !showPhoneOption) {
            Toast.makeText(this, "No more apps to add", 0).show();
            return;
        }
        final List names = new ArrayList();
        final List packages = new ArrayList();
        if (showPhoneOption) {
            names.add("📞 Phone");
            packages.add("PHONE_APP_MARKER");
        }
        List $this$forEach$iv = apps;
        for (Object element$iv2 : $this$forEach$iv) {
            ApplicationInfo it4 = (ApplicationInfo) element$iv2;
            names.add(pm.getApplicationLabel(it4).toString());
            String packageName = it4.packageName;
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            packages.add(packageName);
            pm = pm;
        }
        List $this$toTypedArray$iv = names;
        new AlertDialog.Builder(this, R.style.ZenDialog).setTitle("Select App (" + this.selectedApps.size() + "/30)").setItems((CharSequence[]) $this$toTypedArray$iv.toArray(new String[0]), new DialogInterface.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.showAppPicker$lambda$36(this.f$0, packages, names, dialogInterface, i);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAppPicker$lambda$36(MainActivity this$0, List packages, List names, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(packages, "$packages");
        Intrinsics.checkNotNullParameter(names, "$names");
        this$0.selectedApps.add(TuplesKt.to(packages.get(i), StringsKt.removePrefix((String) names.get(i), (CharSequence) "📞 ")));
        this$0.refreshAppGrid();
    }

    private final void refreshAppGrid() {
        GridLayout gridLayout = this.appsGrid;
        Button button = null;
        if (gridLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appsGrid");
            gridLayout = null;
        }
        gridLayout.removeAllViews();
        PackageManager pm = getPackageManager();
        final int i = 0;
        while (true) {
            if (i >= 30) {
                break;
            }
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
            if (i < this.selectedApps.size()) {
                Pair<String, String> pair = this.selectedApps.get(i);
                String pkg = pair.component1();
                String appName = pair.component2();
                if (Intrinsics.areEqual(pkg, "PHONE_APP_MARKER")) {
                    icon.setImageResource(android.R.drawable.ic_menu_call);
                    icon.setAlpha(1.0f);
                } else {
                    try {
                        ApplicationInfo info = pm.getApplicationInfo(pkg, 0);
                        Intrinsics.checkNotNullExpressionValue(info, "getApplicationInfo(...)");
                        icon.setImageDrawable(pm.getApplicationIcon(info));
                        icon.setAlpha(1.0f);
                    } catch (Exception e) {
                        icon.setImageResource(android.R.drawable.sym_def_app_icon);
                    }
                }
                name.setText(appName);
                name.setTextColor(getColor(R.color.zen_white));
                remove.setVisibility(0);
                remove.setOnClickListener(new View.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda20
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MainActivity.refreshAppGrid$lambda$37(this.f$0, i, view);
                    }
                });
                cell.setOnClickListener(new View.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda21
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MainActivity.refreshAppGrid$lambda$38(view);
                    }
                });
            } else {
                icon.setImageResource(android.R.drawable.ic_input_add);
                icon.setAlpha(0.3f);
                name.setText("Empty");
                name.setTextColor(getColor(R.color.zen_grey));
                remove.setVisibility(8);
                cell.setOnClickListener(new View.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MainActivity.refreshAppGrid$lambda$39(this.f$0, view);
                    }
                });
            }
            GridLayout gridLayout3 = this.appsGrid;
            if (gridLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appsGrid");
                gridLayout3 = null;
            }
            gridLayout3.addView(cell);
            i++;
        }
        Button button2 = this.addAppButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAppButton");
            button2 = null;
        }
        button2.setEnabled(this.selectedApps.size() < 30);
        Button button3 = this.addAppButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAppButton");
        } else {
            button = button3;
        }
        button.setText(this.selectedApps.size() >= 30 ? "Max 30 apps selected" : "+ Add App  (" + this.selectedApps.size() + "/30)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshAppGrid$lambda$37(MainActivity this$0, int $i, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectedApps.remove($i);
        this$0.refreshAppGrid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshAppGrid$lambda$38(View it) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshAppGrid$lambda$39(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.selectedApps.size() < 30) {
            this$0.showAppPicker();
        }
    }

    private final void setupStartButton() {
        Button button = this.startButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startButton");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.setupStartButton$lambda$41(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupStartButton$lambda$41(final MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.selectedApps.isEmpty()) {
            Toast.makeText(this$0, "Add at least 1 app", 0).show();
            return;
        }
        SeekBar seekBar = null;
        if (!this$0.hasUsageStatsPermission()) {
            new AlertDialog.Builder(this$0, R.style.ZenDialog).setTitle("Permission Needed").setMessage("ZenLock needs Usage Access permission.\n\nTap Open → find ZenLock → enable it.").setPositiveButton("Open Settings", new DialogInterface.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda6
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MainActivity.setupStartButton$lambda$41$lambda$40(this.f$0, dialogInterface, i);
                }
            }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
            return;
        }
        List<Pair<Long, String>> list = this$0.durationSteps;
        SeekBar seekBar2 = this$0.durationSlider;
        if (seekBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("durationSlider");
            seekBar2 = null;
        }
        long durationMs = list.get(seekBar2.getProgress()).getFirst().longValue();
        long endTime = System.currentTimeMillis() + durationMs;
        List<Pair<Long, String>> list2 = this$0.durationSteps;
        SeekBar seekBar3 = this$0.durationSlider;
        if (seekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("durationSlider");
        } else {
            seekBar = seekBar3;
        }
        this$0.showFinalConfirmation(list2.get(seekBar.getProgress()).getSecond(), endTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupStartButton$lambda$41$lambda$40(MainActivity this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
    }

    private final void showFinalConfirmation(String durationText, final long endTime) {
        new AlertDialog.Builder(this, R.style.ZenDialog).setTitle("⚠️ Start ZenLock?").setMessage("Duration: " + durationText + "\nApps: " + this.selectedApps.size() + " + Messages, WhatsApp, Camera\n\nZERO WAY OUT until timer ends.\n\nSure?").setPositiveButton("START", new DialogInterface.OnClickListener() { // from class: com.dheekshith.zenlock.MainActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.showFinalConfirmation$lambda$42(this.f$0, endTime, dialogInterface, i);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFinalConfirmation$lambda$42(MainActivity this$0, long $endTime, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startZenMode($endTime);
    }

    private final void startZenMode(long endTime) {
        boolean phoneMarkerSelected;
        Iterable $this$any$iv = this.selectedApps;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator it = $this$any$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    phoneMarkerSelected = false;
                    break;
                }
                Object element$iv = it.next();
                Pair it2 = (Pair) element$iv;
                if (Intrinsics.areEqual(it2.getFirst(), "PHONE_APP_MARKER")) {
                    phoneMarkerSelected = true;
                    break;
                }
            }
        } else {
            phoneMarkerSelected = false;
        }
        Iterable $this$filter$iv = this.selectedApps;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Pair it3 = (Pair) element$iv$iv;
            if (!Intrinsics.areEqual(it3.getFirst(), "PHONE_APP_MARKER")) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Pair it4 = (Pair) item$iv$iv;
            destination$iv$iv2.add((String) it4.getFirst());
        }
        ArrayList arrayList = (List) destination$iv$iv2;
        ZenPrefs zenPrefs = this.prefs;
        ComponentName componentName = null;
        if (zenPrefs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs = null;
        }
        zenPrefs.startZenSession(phoneMarkerSelected ? CollectionsKt.plus((Collection) arrayList, (Iterable) ZenLockService.INSTANCE.getPHONE_APP_GROUP()) : arrayList, endTime);
        ZenPrefs zenPrefs2 = this.prefs;
        if (zenPrefs2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            zenPrefs2 = null;
        }
        Iterable $this$map$iv2 = this.selectedApps;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            Pair it5 = (Pair) item$iv$iv2;
            destination$iv$iv3.add((String) it5.getFirst());
        }
        zenPrefs2.saveLastUsedApps((List) destination$iv$iv3);
        DevicePolicyManager devicePolicyManager = this.dpm;
        if (devicePolicyManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dpm");
            devicePolicyManager = null;
        }
        if (devicePolicyManager.isDeviceOwnerApp(getPackageName())) {
            Collection $this$toTypedArray$iv = SetsKt.plus((Set<? extends String>) SetsKt.plus(SetsKt.plus((Set) ZenLockService.INSTANCE.getDEFAULT_ALLOWED(), (Iterable) arrayList), (Iterable) (phoneMarkerSelected ? ZenLockService.INSTANCE.getPHONE_APP_GROUP() : SetsKt.emptySet())), getPackageName());
            String[] pkgs = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
            DevicePolicyManager devicePolicyManager2 = this.dpm;
            if (devicePolicyManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dpm");
                devicePolicyManager2 = null;
            }
            ComponentName componentName2 = this.adminComponent;
            if (componentName2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adminComponent");
            } else {
                componentName = componentName2;
            }
            devicePolicyManager2.setLockTaskPackages(componentName, pkgs);
        }
        startForegroundService(new Intent(this, (Class<?>) ZenLockService.class));
        startActivity(new Intent(this, (Class<?>) ZenActivity.class));
        finish();
    }

    private final boolean hasUsageStatsPermission() {
        Object systemService = getSystemService("appops");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AppOpsManager");
        AppOpsManager appOps = (AppOpsManager) systemService;
        return appOps.checkOpNoThrow("android:get_usage_stats", Process.myUid(), getPackageName()) == 0;
    }
}
