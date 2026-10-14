package com.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.example.localization.AppCountry;
import com.example.localization.AppLanguage;
import com.example.localization.AppLanguageKt;
import com.example.ui.components.CommonUiKt;
import com.example.ui.navigation.Screen;
import com.example.ui.profile.UserProfileManager;
import com.example.ui.screens.AgeCalculatorScreenKt;
import com.example.ui.screens.AppHealthScreenKt;
import com.example.ui.screens.BorrowLendScreenKt;
import com.example.ui.screens.ChecklistScreenKt;
import com.example.ui.screens.CookingScreenKt;
import com.example.ui.screens.DailyPricesScreenKt;
import com.example.ui.screens.ExpensesScreenKt;
import com.example.ui.screens.FileManagerScreenKt;
import com.example.ui.screens.GiftListScreenKt;
import com.example.ui.screens.HomeScreenKt;
import com.example.ui.screens.ImportantDatesScreenKt;
import com.example.ui.screens.MedicineScreenKt;
import com.example.ui.screens.MoreScreenKt;
import com.example.ui.screens.MoreToolsScreenKt;
import com.example.ui.screens.MyDayScreenKt;
import com.example.ui.screens.NotesScreenKt;
import com.example.ui.screens.OtherToolsScreenKt;
import com.example.ui.screens.PrayerTimesScreenKt;
import com.example.ui.screens.ReminderSettingsScreenKt;
import com.example.ui.screens.RemindersScreenKt;
import com.example.ui.screens.ReportsScreenKt;
import com.example.ui.screens.SettingsScreenKt;
import com.example.ui.screens.ShoppingScreenKt;
import com.example.ui.screens.VehicleScreenKt;
import com.example.ui.screens.WaterReminderScreenKt;
import com.example.ui.theme.ThemeKt;
import com.example.ui.viewmodel.AppViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0014R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0017X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u0084\u0002²\u0006\n\u0010\u001a\u001a\u00020\u001bX\u008a\u0084\u0002²\u0006\n\u0010\u001c\u001a\u00020\u0019X\u008a\u0084\u0002"}, d2 = {"Lcom/example/MainActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "viewModel", "Lcom/example/ui/viewmodel/AppViewModel;", "getViewModel", "()Lcom/example/ui/viewmodel/AppViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "dateChangeReceiver", "com/example/MainActivity$dateChangeReceiver$1", "Lcom/example/MainActivity$dateChangeReceiver$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onDestroy", "app", "language", "Lcom/example/localization/AppLanguage;", "country", "Lcom/example/localization/AppCountry;", "isDark", "", "currentScreen", "Lcom/example/ui/navigation/Screen;", "showQuickAdd"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes11.dex */
public final class MainActivity extends ComponentActivity {
    public static final int $stable = 8;
    private final MainActivity$dateChangeReceiver$1 dateChangeReceiver = new BroadcastReceiver() { // from class: com.example.MainActivity$dateChangeReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AppViewModel viewModel;
            AppViewModel viewModel2;
            viewModel = MainActivity.this.getViewModel();
            viewModel.refreshDashboardDate();
            viewModel2 = MainActivity.this.getViewModel();
            viewModel2.updateHeroContentIfNeeded();
        }
    };

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: MainActivity.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes11.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Screen.values().length];
            try {
                iArr[Screen.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Screen.MY_DAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Screen.REPORTS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Screen.SETTINGS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Screen.MORE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Screen.DAILY_EXPENSES.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[Screen.SHOPPING_LIST.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[Screen.MEDICINE_REMINDER.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[Screen.PRAYER_TIMES.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[Screen.WATER_REMINDER.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[Screen.BORROW_LEND.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[Screen.COOKING_RECIPES.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[Screen.COOKING_CALCULATOR.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[Screen.CALCULATOR.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[Screen.UNIT_CONVERTER.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[Screen.NOTES.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr[Screen.BILLS_PAYMENTS.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr[Screen.DAILY_PRICES.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                iArr[Screen.VEHICLE_MAINTENANCE.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                iArr[Screen.IMPORTANT_DATES.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                iArr[Screen.IMPORTANT_CONTACTS.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                iArr[Screen.HABIT_TRACKER.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                iArr[Screen.DAILY_TASKS.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
            try {
                iArr[Screen.CHECK_LIST.ordinal()] = 24;
            } catch (NoSuchFieldError e24) {
            }
            try {
                iArr[Screen.REMINDERS.ordinal()] = 25;
            } catch (NoSuchFieldError e25) {
            }
            try {
                iArr[Screen.HEALTH_TRACKER.ordinal()] = 26;
            } catch (NoSuchFieldError e26) {
            }
            try {
                iArr[Screen.GIFT_LIST.ordinal()] = 27;
            } catch (NoSuchFieldError e27) {
            }
            try {
                iArr[Screen.FILE_MANAGER.ordinal()] = 28;
            } catch (NoSuchFieldError e28) {
            }
            try {
                iArr[Screen.THEMES.ordinal()] = 29;
            } catch (NoSuchFieldError e29) {
            }
            try {
                iArr[Screen.REMINDER_SETTINGS.ordinal()] = 30;
            } catch (NoSuchFieldError e30) {
            }
            try {
                iArr[Screen.SYSTEM_HEALTH.ordinal()] = 31;
            } catch (NoSuchFieldError e31) {
            }
            try {
                iArr[Screen.AGE_CALCULATOR.ordinal()] = 32;
            } catch (NoSuchFieldError e32) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Uri data2;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 9021 || resultCode != -1 || data == null || (data2 = data.getData()) == null) {
            return;
        }
        UserProfileManager.onPhotoSelected(data2);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.example.MainActivity$dateChangeReceiver$1] */
    public MainActivity() {
        final MainActivity mainActivity = this;
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AppViewModel.class), new Function0<ViewModelStore>() { // from class: com.example.MainActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return ComponentActivity.this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.example.MainActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return ComponentActivity.this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.example.MainActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? mainActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppViewModel getViewModel() {
        return (AppViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserProfileManager.setAppContext(this);
        try {
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.intent.action.DATE_CHANGED");
            filter.addAction("android.intent.action.TIME_SET");
            filter.addAction("android.intent.action.TIMEZONE_CHANGED");
            filter.addAction("android.intent.action.TIME_TICK");
            registerReceiver(this.dateChangeReceiver, filter);
        } catch (Exception e) {
            Log.e("MainActivity", "Error registering date receiver: " + e.getMessage());
        }
        EdgeToEdge.enable$default(this, null, null, 3, null);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-601144069, true, new Function2() { // from class: com.example.MainActivity$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MainActivity.onCreate$lambda$84(MainActivity.this, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84(final MainActivity this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C67@2655L16,68@2724L16,69@2789L16,70@2863L16,71@2940L16,79@3274L10660,75@3070L10864:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-601144069, $changed, -1, "com.example.MainActivity.onCreate.<anonymous> (MainActivity.kt:67)");
            }
            State language$delegate = SnapshotStateKt.collectAsState(this$0.getViewModel().getCurrentLanguage(), null, $composer, 0, 1);
            State country$delegate = SnapshotStateKt.collectAsState(this$0.getViewModel().getCurrentCountry(), null, $composer, 0, 1);
            final State isDark$delegate = SnapshotStateKt.collectAsState(this$0.getViewModel().isDarkTheme(), null, $composer, 0, 1);
            final State currentScreen$delegate = SnapshotStateKt.collectAsState(this$0.getViewModel().getCurrentScreen(), null, $composer, 0, 1);
            final State showQuickAdd$delegate = SnapshotStateKt.collectAsState(this$0.getViewModel().getShowQuickAddModal(), null, $composer, 0, 1);
            LayoutDirection layoutDirection = onCreate$lambda$84$lambda$1(language$delegate).isRtl() ? LayoutDirection.Rtl : LayoutDirection.Ltr;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{AppLanguageKt.getLocalAppLanguage().provides(onCreate$lambda$84$lambda$1(language$delegate)), AppLanguageKt.getLocalAppCountry().provides(onCreate$lambda$84$lambda$2(country$delegate)), CompositionLocalsKt.getLocalLayoutDirection().provides(layoutDirection)}, ComposableLambdaKt.rememberComposableLambda(-532867013, true, new Function2() { // from class: com.example.MainActivity$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.onCreate$lambda$84$lambda$83(State.this, this$0, currentScreen$delegate, showQuickAdd$delegate, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer, 54), $composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final AppLanguage onCreate$lambda$84$lambda$1(State<? extends AppLanguage> state) {
        return (AppLanguage) state.getValue();
    }

    private static final AppCountry onCreate$lambda$84$lambda$2(State<? extends AppCountry> state) {
        return (AppCountry) state.getValue();
    }

    private static final boolean onCreate$lambda$84$lambda$3(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    private static final Screen onCreate$lambda$84$lambda$4(State<? extends Screen> state) {
        return (Screen) state.getValue();
    }

    private static final boolean onCreate$lambda$84$lambda$5(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83(State $isDark$delegate, final MainActivity this$0, final State $currentScreen$delegate, final State $showQuickAdd$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C80@3327L10593,80@3292L10628:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-532867013, $changed, -1, "com.example.MainActivity.onCreate.<anonymous>.<anonymous> (MainActivity.kt:80)");
            }
            ThemeKt.DailyLifeTheme(onCreate$lambda$84$lambda$3($isDark$delegate), ComposableLambdaKt.rememberComposableLambda(-1701688359, true, new Function2() { // from class: com.example.MainActivity$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.onCreate$lambda$84$lambda$83$lambda$82(MainActivity.this, $currentScreen$delegate, $showQuickAdd$delegate, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer, 54), $composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82(final MainActivity this$0, final State $currentScreen$delegate, final State $showQuickAdd$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C81@3401L143,81@3349L195,87@3632L7,112@4829L11,91@3779L993,114@4933L8969,89@3661L10241:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1701688359, $changed, -1, "com.example.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:81)");
            }
            boolean z = onCreate$lambda$84$lambda$4($currentScreen$delegate) != Screen.HOME;
            ComposerKt.sourceInformationMarkerStart($composer, 1060029288, "CC(remember):MainActivity.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance(this$0);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$7$lambda$6(MainActivity.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            BackHandlerKt.BackHandler(z, (Function0) obj, $composer, 0, 0);
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd($composer);
            final FocusManager focusManager = (FocusManager) consume;
            ScaffoldKt.m2408ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, ComposableLambdaKt.rememberComposableLambda(269391924, true, new Function2() { // from class: com.example.MainActivity$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$12(FocusManager.this, this$0, $currentScreen$delegate, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), null, null, 0, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getBackground(), 0L, WindowInsetsKt.WindowInsets(0, 0, 0, 0), ComposableLambdaKt.rememberComposableLambda(165637546, true, new Function3() { // from class: com.example.MainActivity$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81(MainActivity.this, $currentScreen$delegate, $showQuickAdd$delegate, (PaddingValues) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, $composer, 54), $composer, 805306758, 186);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$7$lambda$6(MainActivity this$0) {
        if (!this$0.getViewModel().navigateBack()) {
            this$0.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$12(final FocusManager $focusManager, final MainActivity this$0, State $currentScreen$delegate, Composer $composer, int $changed) {
        Object obj;
        Object obj2;
        ComposerKt.sourceInformation($composer, "C:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(269391924, $changed, -1, "com.example.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:92)");
            }
            boolean isMainTab = CollectionsKt.listOf((Object[]) new Screen[]{Screen.HOME, Screen.MY_DAY, Screen.REPORTS, Screen.SETTINGS}).contains(onCreate$lambda$84$lambda$4($currentScreen$delegate));
            if (isMainTab) {
                $composer.startReplaceGroup(-1838719309);
                ComposerKt.sourceInformation($composer, "101@4275L170,105@4496L186,99@4145L571");
                Screen onCreate$lambda$84$lambda$4 = onCreate$lambda$84$lambda$4($currentScreen$delegate);
                ComposerKt.sourceInformationMarkerStart($composer, 1187617246, "CC(remember):MainActivity.kt#9igjgp");
                boolean changedInstance = $composer.changedInstance($focusManager) | $composer.changedInstance(this$0);
                Object rememberedValue = $composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    obj = new Function1() { // from class: com.example.MainActivity$$ExternalSyntheticLambda32
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$12$lambda$9$lambda$8(FocusManager.this, this$0, (Screen) obj3);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue;
                }
                Function1 function1 = (Function1) obj;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 1187624334, "CC(remember):MainActivity.kt#9igjgp");
                boolean changedInstance2 = $composer.changedInstance($focusManager) | $composer.changedInstance(this$0);
                Object rememberedValue2 = $composer.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    obj2 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda34
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$12$lambda$11$lambda$10(FocusManager.this, this$0);
                        }
                    };
                    $composer.updateRememberedValue(obj2);
                } else {
                    obj2 = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                CommonUiKt.AppBottomBar(onCreate$lambda$84$lambda$4, function1, (Function0) obj2, $composer, 0);
            } else {
                $composer.startReplaceGroup(-1842818098);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$12$lambda$9$lambda$8(FocusManager $focusManager, MainActivity this$0, Screen it) {
        Intrinsics.checkNotNullParameter(it, "it");
        FocusManager.clearFocus$default($focusManager, false, 1, null);
        this$0.getViewModel().navigateTo(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$12$lambda$11$lambda$10(FocusManager $focusManager, MainActivity this$0) {
        FocusManager.clearFocus$default($focusManager, false, 1, null);
        this$0.getViewModel().getShowQuickAddModal().setValue(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c2 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81(final com.example.MainActivity r37, final androidx.compose.runtime.State r38, androidx.compose.runtime.State r39, androidx.compose.foundation.layout.PaddingValues r40, androidx.compose.runtime.Composer r41, int r42) {
        /*
            Method dump skipped, instructions count: 625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81(com.example.MainActivity, androidx.compose.runtime.State, androidx.compose.runtime.State, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$14$lambda$13(MainActivity this$0) {
        this$0.getViewModel().navigateTo(Screen.HOME);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$16$lambda$15(MainActivity this$0) {
        this$0.getViewModel().navigateTo(Screen.SYSTEM_HEALTH);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77(final MainActivity this$0, State $currentScreen$delegate, Composer $composer, int $changed) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        Object obj12;
        Object obj13;
        Object obj14;
        Object obj15;
        Object obj16;
        Object obj17;
        Object obj18;
        Object obj19;
        Object obj20;
        Object obj21;
        Object obj22;
        Object obj23;
        Object obj24;
        Object obj25;
        Object obj26;
        Object obj27;
        Object obj28;
        Object obj29;
        Object obj30;
        ComposerKt.sourceInformation($composer, "C:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1833237603, $changed, -1, "com.example.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:125)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[onCreate$lambda$84$lambda$4($currentScreen$delegate).ordinal()]) {
                case 1:
                    $composer.startReplaceGroup(804748612);
                    ComposerKt.sourceInformation($composer, "126@5596L33");
                    HomeScreenKt.HomeScreen(this$0.getViewModel(), null, $composer, 0, 2);
                    $composer.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                    break;
                case 2:
                    $composer.startReplaceGroup(804751629);
                    ComposerKt.sourceInformation($composer, "129@5808L37,127@5683L266");
                    AppViewModel viewModel = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804755400, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance = $composer.changedInstance(this$0);
                    Object rememberedValue = $composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        obj = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda38
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$18$lambda$17(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj);
                    } else {
                        obj = rememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    MyDayScreenKt.MyDayScreen(viewModel, (Function0) obj, false, null, $composer, 384, 8);
                    $composer.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                    break;
                case 3:
                    $composer.startReplaceGroup(804761837);
                    ComposerKt.sourceInformation($composer, "134@6131L37,132@6004L202");
                    AppViewModel viewModel2 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804765736, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance2 = $composer.changedInstance(this$0);
                    Object rememberedValue2 = $composer.rememberedValue();
                    if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        obj2 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$20$lambda$19(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj2);
                    } else {
                        obj2 = rememberedValue2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ReportsScreenKt.ReportsScreen(viewModel2, (Function0) obj2, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit3 = Unit.INSTANCE;
                    break;
                case 4:
                    $composer.startReplaceGroup(804770094);
                    ComposerKt.sourceInformation($composer, "138@6390L37,136@6262L203");
                    AppViewModel viewModel3 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804774024, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance3 = $composer.changedInstance(this$0);
                    Object rememberedValue3 = $composer.rememberedValue();
                    if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        obj3 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$22$lambda$21(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj3);
                    } else {
                        obj3 = rememberedValue3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    SettingsScreenKt.SettingsScreen(viewModel3, (Function0) obj3, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit4 = Unit.INSTANCE;
                    break;
                case 5:
                    $composer.startReplaceGroup(804778241);
                    ComposerKt.sourceInformation($composer, "142@6641L28,140@6517L190");
                    AppViewModel viewModel4 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804782047, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance4 = $composer.changedInstance(this$0);
                    Object rememberedValue4 = $composer.rememberedValue();
                    if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        obj4 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda21
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$24$lambda$23(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj4);
                    } else {
                        obj4 = rememberedValue4;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    MoreScreenKt.MoreScreen(viewModel4, (Function0) obj4, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit5 = Unit.INSTANCE;
                    break;
                case 6:
                    $composer.startReplaceGroup(804786309);
                    ComposerKt.sourceInformation($composer, "146@6897L28,144@6769L194");
                    AppViewModel viewModel5 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804790239, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance5 = $composer.changedInstance(this$0);
                    Object rememberedValue5 = $composer.rememberedValue();
                    if (changedInstance5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        obj5 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda23
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$26$lambda$25(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj5);
                    } else {
                        obj5 = rememberedValue5;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ExpensesScreenKt.ExpensesScreen(viewModel5, (Function0) obj5, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit6 = Unit.INSTANCE;
                    break;
                case 7:
                    $composer.startReplaceGroup(804794469);
                    ComposerKt.sourceInformation($composer, "150@7152L28,148@7024L194");
                    AppViewModel viewModel6 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804798399, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance6 = $composer.changedInstance(this$0);
                    Object rememberedValue6 = $composer.rememberedValue();
                    if (changedInstance6 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        obj6 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda24
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$28$lambda$27(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj6);
                    } else {
                        obj6 = rememberedValue6;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ShoppingScreenKt.ShoppingScreen(viewModel6, (Function0) obj6, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit7 = Unit.INSTANCE;
                    break;
                case 8:
                    $composer.startReplaceGroup(804802757);
                    ComposerKt.sourceInformation($composer, "154@7411L28,152@7283L194");
                    AppViewModel viewModel7 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804806687, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance7 = $composer.changedInstance(this$0);
                    Object rememberedValue7 = $composer.rememberedValue();
                    if (changedInstance7 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        obj7 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda25
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$30$lambda$29(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj7);
                    } else {
                        obj7 = rememberedValue7;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    MedicineScreenKt.MedicineScreen(viewModel7, (Function0) obj7, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit8 = Unit.INSTANCE;
                    break;
                case 9:
                    $composer.startReplaceGroup(804810888);
                    ComposerKt.sourceInformation($composer, "158@7668L28,156@7537L197");
                    AppViewModel viewModel8 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804814911, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance8 = $composer.changedInstance(this$0);
                    Object rememberedValue8 = $composer.rememberedValue();
                    if (changedInstance8 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        obj8 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda26
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$32$lambda$31(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj8);
                    } else {
                        obj8 = rememberedValue8;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    PrayerTimesScreenKt.PrayerTimesScreen(viewModel8, (Function0) obj8, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit9 = Unit.INSTANCE;
                    break;
                case 10:
                    $composer.startReplaceGroup(804819178);
                    ComposerKt.sourceInformation($composer, "162@7929L28,160@7796L199");
                    AppViewModel viewModel9 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804823263, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance9 = $composer.changedInstance(this$0);
                    Object rememberedValue9 = $composer.rememberedValue();
                    if (changedInstance9 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                        obj9 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda27
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$34$lambda$33(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj9);
                    } else {
                        obj9 = rememberedValue9;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    WaterReminderScreenKt.WaterReminderScreen(viewModel9, (Function0) obj9, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit10 = Unit.INSTANCE;
                    break;
                case 11:
                    $composer.startReplaceGroup(804827431);
                    ComposerKt.sourceInformation($composer, "166@8184L28,164@8054L196");
                    AppViewModel viewModel10 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804831423, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance10 = $composer.changedInstance(this$0);
                    Object rememberedValue10 = $composer.rememberedValue();
                    if (changedInstance10 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                        obj10 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda28
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$36$lambda$35(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj10);
                    } else {
                        obj10 = rememberedValue10;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    BorrowLendScreenKt.BorrowLendScreen(viewModel10, (Function0) obj10, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit11 = Unit.INSTANCE;
                    break;
                case 12:
                    $composer.startReplaceGroup(804835772);
                    ComposerKt.sourceInformation($composer, "171@8496L28,168@8313L249");
                    AppViewModel viewModel11 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804841407, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance11 = $composer.changedInstance(this$0);
                    Object rememberedValue11 = $composer.rememberedValue();
                    if (changedInstance11 || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                        obj11 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda39
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$38$lambda$37(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj11);
                    } else {
                        obj11 = rememberedValue11;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    CookingScreenKt.CookingScreen(viewModel11, 1, (Function0) obj11, null, $composer, 48, 8);
                    $composer.endReplaceGroup();
                    Unit unit12 = Unit.INSTANCE;
                    break;
                case 13:
                case 14:
                    $composer.startReplaceGroup(804846460);
                    ComposerKt.sourceInformation($composer, "176@8830L28,173@8647L249");
                    AppViewModel viewModel12 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804852095, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance12 = $composer.changedInstance(this$0);
                    Object rememberedValue12 = $composer.rememberedValue();
                    if (changedInstance12 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                        obj12 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda40
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$40$lambda$39(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj12);
                    } else {
                        obj12 = rememberedValue12;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    CookingScreenKt.CookingScreen(viewModel12, 0, (Function0) obj12, null, $composer, 48, 8);
                    $composer.endReplaceGroup();
                    Unit unit13 = Unit.INSTANCE;
                    break;
                case 15:
                    $composer.startReplaceGroup(804856299);
                    ComposerKt.sourceInformation($composer, "179@9028L28,178@8958L136");
                    ComposerKt.sourceInformationMarkerStart($composer, 804858431, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance13 = $composer.changedInstance(this$0);
                    Object rememberedValue13 = $composer.rememberedValue();
                    if (changedInstance13 || rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                        obj13 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda41
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$42$lambda$41(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj13);
                    } else {
                        obj13 = rememberedValue13;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    OtherToolsScreenKt.UnitConverterScreen((Function0) obj13, null, $composer, 0, 2);
                    $composer.endReplaceGroup();
                    Unit unit14 = Unit.INSTANCE;
                    break;
                case 16:
                    $composer.startReplaceGroup(804862402);
                    ComposerKt.sourceInformation($composer, "183@9272L28,181@9147L191");
                    AppViewModel viewModel13 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804866239, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance14 = $composer.changedInstance(this$0);
                    Object rememberedValue14 = $composer.rememberedValue();
                    if (changedInstance14 || rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                        obj14 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$44$lambda$43(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj14);
                    } else {
                        obj14 = rememberedValue14;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    NotesScreenKt.NotesScreen(viewModel13, (Function0) obj14, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit15 = Unit.INSTANCE;
                    break;
                case 17:
                    $composer.startReplaceGroup(804870498);
                    ComposerKt.sourceInformation($composer, "187@9525L28,185@9400L191");
                    AppViewModel viewModel14 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804874335, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance15 = $composer.changedInstance(this$0);
                    Object rememberedValue15 = $composer.rememberedValue();
                    if (changedInstance15 || rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                        obj15 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$46$lambda$45(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj15);
                    } else {
                        obj15 = rememberedValue15;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    OtherToolsScreenKt.BillsScreen(viewModel14, (Function0) obj15, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit16 = Unit.INSTANCE;
                    break;
                case 18:
                    $composer.startReplaceGroup(804878536);
                    ComposerKt.sourceInformation($composer, "191@9782L28,189@9651L197");
                    AppViewModel viewModel15 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804882559, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance16 = $composer.changedInstance(this$0);
                    Object rememberedValue16 = $composer.rememberedValue();
                    if (changedInstance16 || rememberedValue16 == Composer.INSTANCE.getEmpty()) {
                        obj16 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$48$lambda$47(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj16);
                    } else {
                        obj16 = rememberedValue16;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    DailyPricesScreenKt.DailyPricesScreen(viewModel15, (Function0) obj16, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit17 = Unit.INSTANCE;
                    break;
                case 19:
                    $composer.startReplaceGroup(804886980);
                    ComposerKt.sourceInformation($composer, "195@10042L28,193@9915L193");
                    AppViewModel viewModel16 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804890879, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance17 = $composer.changedInstance(this$0);
                    Object rememberedValue17 = $composer.rememberedValue();
                    if (changedInstance17 || rememberedValue17 == Composer.INSTANCE.getEmpty()) {
                        obj17 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$50$lambda$49(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj17);
                    } else {
                        obj17 = rememberedValue17;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    VehicleScreenKt.VehicleScreen(viewModel16, (Function0) obj17, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit18 = Unit.INSTANCE;
                    break;
                case 20:
                    $composer.startReplaceGroup(804895179);
                    ComposerKt.sourceInformation($composer, "199@10305L28,197@10171L200");
                    AppViewModel viewModel17 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804899295, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance18 = $composer.changedInstance(this$0);
                    Object rememberedValue18 = $composer.rememberedValue();
                    if (changedInstance18 || rememberedValue18 == Composer.INSTANCE.getEmpty()) {
                        obj18 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$52$lambda$51(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj18);
                    } else {
                        obj18 = rememberedValue18;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ImportantDatesScreenKt.ImportantDatesScreen(viewModel17, (Function0) obj18, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit19 = Unit.INSTANCE;
                    break;
                case 21:
                    $composer.startReplaceGroup(804903631);
                    ComposerKt.sourceInformation($composer, "202@10511L28,201@10437L140");
                    ComposerKt.sourceInformationMarkerStart($composer, 804905887, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance19 = $composer.changedInstance(this$0);
                    Object rememberedValue19 = $composer.rememberedValue();
                    if (changedInstance19 || rememberedValue19 == Composer.INSTANCE.getEmpty()) {
                        obj19 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$54$lambda$53(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj19);
                    } else {
                        obj19 = rememberedValue19;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    MoreToolsScreenKt.ImportantContactsScreen((Function0) obj19, null, $composer, 0, 2);
                    $composer.endReplaceGroup();
                    Unit unit20 = Unit.INSTANCE;
                    break;
                case 22:
                    $composer.startReplaceGroup(804910115);
                    ComposerKt.sourceInformation($composer, "206@10764L28,204@10638L192");
                    AppViewModel viewModel18 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804913983, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance20 = $composer.changedInstance(this$0);
                    Object rememberedValue20 = $composer.rememberedValue();
                    if (changedInstance20 || rememberedValue20 == Composer.INSTANCE.getEmpty()) {
                        obj20 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$56$lambda$55(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj20);
                    } else {
                        obj20 = rememberedValue20;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    MoreToolsScreenKt.HabitsScreen(viewModel18, (Function0) obj20, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit21 = Unit.INSTANCE;
                    break;
                case 23:
                    $composer.startReplaceGroup(804918211);
                    ComposerKt.sourceInformation($composer, "210@11014L28,208@10889L256");
                    AppViewModel viewModel19 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804921983, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance21 = $composer.changedInstance(this$0);
                    Object rememberedValue21 = $composer.rememberedValue();
                    if (changedInstance21 || rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                        obj21 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$58$lambda$57(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj21);
                    } else {
                        obj21 = rememberedValue21;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    MyDayScreenKt.MyDayScreen(viewModel19, (Function0) obj21, true, null, $composer, 384, 8);
                    $composer.endReplaceGroup();
                    Unit unit22 = Unit.INSTANCE;
                    break;
                case 24:
                    $composer.startReplaceGroup(804928198);
                    ComposerKt.sourceInformation($composer, "215@11332L28,213@11203L195");
                    AppViewModel viewModel20 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804932159, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance22 = $composer.changedInstance(this$0);
                    Object rememberedValue22 = $composer.rememberedValue();
                    if (changedInstance22 || rememberedValue22 == Composer.INSTANCE.getEmpty()) {
                        obj22 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$60$lambda$59(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj22);
                    } else {
                        obj22 = rememberedValue22;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ChecklistScreenKt.ChecklistScreen(viewModel20, (Function0) obj22, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit23 = Unit.INSTANCE;
                    break;
                case 25:
                    $composer.startReplaceGroup(804936262);
                    ComposerKt.sourceInformation($composer, "219@11584L28,217@11455L195");
                    AppViewModel viewModel21 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804940223, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance23 = $composer.changedInstance(this$0);
                    Object rememberedValue23 = $composer.rememberedValue();
                    if (changedInstance23 || rememberedValue23 == Composer.INSTANCE.getEmpty()) {
                        obj23 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$62$lambda$61(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj23);
                    } else {
                        obj23 = rememberedValue23;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    RemindersScreenKt.RemindersScreen(viewModel21, (Function0) obj23, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit24 = Unit.INSTANCE;
                    break;
                case 26:
                    $composer.startReplaceGroup(804944490);
                    ComposerKt.sourceInformation($composer, "223@11845L28,221@11712L199");
                    AppViewModel viewModel22 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804948575, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance24 = $composer.changedInstance(this$0);
                    Object rememberedValue24 = $composer.rememberedValue();
                    if (changedInstance24 || rememberedValue24 == Composer.INSTANCE.getEmpty()) {
                        obj24 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$64$lambda$63(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj24);
                    } else {
                        obj24 = rememberedValue24;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    WaterReminderScreenKt.WaterReminderScreen(viewModel22, (Function0) obj24, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit25 = Unit.INSTANCE;
                    break;
                case 27:
                    $composer.startReplaceGroup(804952677);
                    ComposerKt.sourceInformation($composer, "227@12096L28,225@11968L194");
                    AppViewModel viewModel23 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804956607, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance25 = $composer.changedInstance(this$0);
                    Object rememberedValue25 = $composer.rememberedValue();
                    if (changedInstance25 || rememberedValue25 == Composer.INSTANCE.getEmpty()) {
                        obj25 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$66$lambda$65(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj25);
                    } else {
                        obj25 = rememberedValue25;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    GiftListScreenKt.GiftListScreen(viewModel23, (Function0) obj25, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit26 = Unit.INSTANCE;
                    break;
                case 28:
                    $composer.startReplaceGroup(804960808);
                    ComposerKt.sourceInformation($composer, "231@12353L28,229@12222L197");
                    AppViewModel viewModel24 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804964831, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance26 = $composer.changedInstance(this$0);
                    Object rememberedValue26 = $composer.rememberedValue();
                    if (changedInstance26 || rememberedValue26 == Composer.INSTANCE.getEmpty()) {
                        obj26 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$68$lambda$67(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj26);
                    } else {
                        obj26 = rememberedValue26;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    FileManagerScreenKt.FileManagerScreen(viewModel24, (Function0) obj26, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit27 = Unit.INSTANCE;
                    break;
                case 29:
                    $composer.startReplaceGroup(804968837);
                    ComposerKt.sourceInformation($composer, "235@12601L28,233@12473L194");
                    AppViewModel viewModel25 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804972767, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance27 = $composer.changedInstance(this$0);
                    Object rememberedValue27 = $composer.rememberedValue();
                    if (changedInstance27 || rememberedValue27 == Composer.INSTANCE.getEmpty()) {
                        obj27 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$70$lambda$69(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj27);
                    } else {
                        obj27 = rememberedValue27;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    SettingsScreenKt.SettingsScreen(viewModel25, (Function0) obj27, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit28 = Unit.INSTANCE;
                    break;
                case 30:
                    $composer.startReplaceGroup(804977133);
                    ComposerKt.sourceInformation($composer, "239@12868L28,237@12732L202");
                    AppViewModel viewModel26 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804981311, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance28 = $composer.changedInstance(this$0);
                    Object rememberedValue28 = $composer.rememberedValue();
                    if (changedInstance28 || rememberedValue28 == Composer.INSTANCE.getEmpty()) {
                        obj28 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$72$lambda$71(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj28);
                    } else {
                        obj28 = rememberedValue28;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ReminderSettingsScreenKt.ReminderSettingsScreen(viewModel26, (Function0) obj28, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit29 = Unit.INSTANCE;
                    break;
                case 31:
                    $composer.startReplaceGroup(804985542);
                    ComposerKt.sourceInformation($composer, "243@13124L28,241@12995L195");
                    AppViewModel viewModel27 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804989503, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance29 = $composer.changedInstance(this$0);
                    Object rememberedValue29 = $composer.rememberedValue();
                    if (changedInstance29 || rememberedValue29 == Composer.INSTANCE.getEmpty()) {
                        obj29 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$74$lambda$73(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj29);
                    } else {
                        obj29 = rememberedValue29;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    AppHealthScreenKt.AppHealthScreen(viewModel27, (Function0) obj29, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit30 = Unit.INSTANCE;
                    break;
                case 32:
                    $composer.startReplaceGroup(804993770);
                    ComposerKt.sourceInformation($composer, "247@13385L28,245@13252L199");
                    AppViewModel viewModel28 = this$0.getViewModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 804997855, "CC(remember):MainActivity.kt#9igjgp");
                    boolean changedInstance30 = $composer.changedInstance(this$0);
                    Object rememberedValue30 = $composer.rememberedValue();
                    if (changedInstance30 || rememberedValue30 == Composer.INSTANCE.getEmpty()) {
                        obj30 = new Function0() { // from class: com.example.MainActivity$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivity.onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$76$lambda$75(MainActivity.this);
                            }
                        };
                        $composer.updateRememberedValue(obj30);
                    } else {
                        obj30 = rememberedValue30;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    AgeCalculatorScreenKt.AgeCalculatorScreen(viewModel28, (Function0) obj30, null, $composer, 0, 4);
                    $composer.endReplaceGroup();
                    Unit unit31 = Unit.INSTANCE;
                    break;
                default:
                    $composer.startReplaceGroup(804754174);
                    $composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$18$lambda$17(MainActivity this$0) {
        this$0.getViewModel().navigateTo(Screen.HOME);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$20$lambda$19(MainActivity this$0) {
        this$0.getViewModel().navigateTo(Screen.HOME);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$22$lambda$21(MainActivity this$0) {
        this$0.getViewModel().navigateTo(Screen.HOME);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$24$lambda$23(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$26$lambda$25(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$28$lambda$27(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$30$lambda$29(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$32$lambda$31(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$34$lambda$33(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$36$lambda$35(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$38$lambda$37(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$40$lambda$39(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$42$lambda$41(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$44$lambda$43(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$46$lambda$45(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$48$lambda$47(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$50$lambda$49(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$52$lambda$51(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$54$lambda$53(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$56$lambda$55(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$58$lambda$57(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$60$lambda$59(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$62$lambda$61(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$64$lambda$63(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$66$lambda$65(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$68$lambda$67(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$70$lambda$69(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$72$lambda$71(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$74$lambda$73(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$78$lambda$77$lambda$76$lambda$75(MainActivity this$0) {
        this$0.getViewModel().navigateBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$84$lambda$83$lambda$82$lambda$81$lambda$80$lambda$79(MainActivity this$0) {
        this$0.getViewModel().getShowQuickAddModal().setValue(false);
        return Unit.INSTANCE;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            getViewModel().onAppResumed();
        } catch (Exception e) {
            Log.e("MainActivity", "onResume safe handle: " + e.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(this.dateChangeReceiver);
        } catch (Exception e) {
        }
    }
}
