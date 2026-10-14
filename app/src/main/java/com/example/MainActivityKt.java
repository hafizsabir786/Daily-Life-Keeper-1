package com.example;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.example.data.model.ExpenseEntity;
import com.example.data.model.TaskEntity;
import com.example.localization.AppLanguage;
import com.example.localization.AppLanguageKt;
import com.example.ui.navigation.Screen;
import com.example.ui.viewmodel.AppViewModel;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001aG\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\tX\u008a\u008e\u0002"}, d2 = {"QuickAddModal", "", "viewModel", "Lcom/example/ui/viewmodel/AppViewModel;", "onDismiss", "Lkotlin/Function0;", "(Lcom/example/ui/viewmodel/AppViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "QuickAddChoice", LinkHeader.Parameters.Title, "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "bgColor", "Landroidx/compose/ui/graphics/Color;", "tintColor", "modifier", "Landroidx/compose/ui/Modifier;", "onClick", "QuickAddChoice-Y0xEhic", "(Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;JJLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app", "showTaskDialog", "", "showExpenseDialog", "quickTaskTitle", "quickExpenseTitle", "quickExpenseAmount"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes11.dex */
public final class MainActivityKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddChoice_Y0xEhic$lambda$62(String str, ImageVector imageVector, long j, long j2, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        m6938QuickAddChoiceY0xEhic(str, imageVector, j, j2, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$56(AppViewModel appViewModel, Function0 function0, int i, Composer composer, int i2) {
        QuickAddModal(appViewModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void QuickAddModal(final AppViewModel viewModel, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        int i;
        String str;
        int i2;
        boolean z;
        final AppViewModel appViewModel;
        final MutableState showExpenseDialog$delegate;
        Object obj6;
        final MutableState showTaskDialog$delegate;
        Object obj7;
        final Function0<Unit> onDismiss = function0;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer $composer2 = $composer.startRestartGroup(1330811231);
        ComposerKt.sourceInformation($composer2, "C(QuickAddModal)P(1)291@14578L7,292@14612L34,293@14676L34,295@14738L31,296@14799L31,297@14861L31,301@14993L11,303@15078L3561,299@14898L3741:MainActivity.kt#to5c3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(viewModel) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(onDismiss) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            appViewModel = viewModel;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1330811231, $dirty2, -1, "com.example.QuickAddModal (MainActivity.kt:290)");
            }
            ProvidableCompositionLocal<AppLanguage> localAppLanguage = AppLanguageKt.getLocalAppLanguage();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localAppLanguage);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final AppLanguage language = (AppLanguage) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, -990654783, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue = $composer2.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            final MutableState showTaskDialog$delegate2 = (MutableState) obj;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -990652735, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue2 = $composer2.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                obj2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(obj2);
            } else {
                obj2 = rememberedValue2;
            }
            final MutableState showExpenseDialog$delegate2 = (MutableState) obj2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -990650754, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue3 = $composer2.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                obj3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                $composer2.updateRememberedValue(obj3);
            } else {
                obj3 = rememberedValue3;
            }
            final MutableState quickTaskTitle$delegate = (MutableState) obj3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -990648802, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue4 = $composer2.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                obj4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                $composer2.updateRememberedValue(obj4);
            } else {
                obj4 = rememberedValue4;
            }
            final MutableState quickExpenseTitle$delegate = (MutableState) obj4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -990646818, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue5 = $composer2.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                obj5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                $composer2.updateRememberedValue(obj5);
            } else {
                obj5 = rememberedValue5;
            }
            final MutableState quickExpenseAmount$delegate = (MutableState) obj5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            onDismiss = function0;
            ModalBottomSheetKt.m2242ModalBottomSheetdYc4hso(onDismiss, null, null, 0.0f, null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurface(), 0L, 0.0f, 0L, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$1166606946$app(), null, null, ComposableLambdaKt.rememberComposableLambda(-920483934, true, new Function3() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj8, Object obj9, Object obj10) {
                    return MainActivityKt.QuickAddModal$lambda$30(AppLanguage.this, viewModel, function0, showTaskDialog$delegate2, showExpenseDialog$delegate2, (ColumnScope) obj8, (Composer) obj9, ((Integer) obj10).intValue());
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 3) & 14) | 805306368, 384, 3550);
            if (QuickAddModal$lambda$1(showTaskDialog$delegate2)) {
                $composer2.startReplaceGroup(-641458945);
                ComposerKt.sourceInformation($composer2, "396@18719L26,406@19140L905,429@20075L146,398@18819L291,395@18675L1556");
                ComposerKt.sourceInformationMarkerStart($composer2, -990523367, "CC(remember):MainActivity.kt#9igjgp");
                Object rememberedValue6 = $composer2.rememberedValue();
                if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    showTaskDialog$delegate = showTaskDialog$delegate2;
                    obj7 = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainActivityKt.QuickAddModal$lambda$32$lambda$31(MutableState.this);
                        }
                    };
                    $composer2.updateRememberedValue(obj7);
                } else {
                    showTaskDialog$delegate = showTaskDialog$delegate2;
                    obj7 = rememberedValue6;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                i2 = 54;
                z = true;
                i = -660024349;
                str = "CC(remember):MainActivity.kt#9igjgp";
                AndroidAlertDialog_androidKt.m1762AlertDialogOix01E0((Function0) obj7, ComposableLambdaKt.rememberComposableLambda(162188076, true, new Function2() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj8, Object obj9) {
                        return MainActivityKt.QuickAddModal$lambda$35(AppViewModel.this, onDismiss, quickTaskTitle$delegate, showTaskDialog$delegate, (Composer) obj8, ((Integer) obj9).intValue());
                    }
                }, $composer2, 54), null, ComposableLambdaKt.rememberComposableLambda(-1485174866, true, new Function2() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj8, Object obj9) {
                        return MainActivityKt.QuickAddModal$lambda$38(MutableState.this, (Composer) obj8, ((Integer) obj9).intValue());
                    }
                }, $composer2, 54), null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$1162429488$app(), ComposableLambdaKt.rememberComposableLambda(338748017, true, new Function2() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj8, Object obj9) {
                        return MainActivityKt.QuickAddModal$lambda$41(MutableState.this, (Composer) obj8, ((Integer) obj9).intValue());
                    }
                }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, 1772598, 0, 16276);
                $composer2 = $composer2;
            } else {
                $composer2 = $composer2;
                i = -660024349;
                str = "CC(remember):MainActivity.kt#9igjgp";
                i2 = 54;
                z = true;
                $composer2.startReplaceGroup(-660024349);
            }
            $composer2.endReplaceGroup();
            if (QuickAddModal$lambda$4(showExpenseDialog$delegate2)) {
                $composer2.startReplaceGroup(-639853517);
                ComposerKt.sourceInformation($composer2, "439@20320L29,457@21184L1015,481@22229L149,441@20426L728,438@20276L2112");
                ComposerKt.sourceInformationMarkerStart($composer2, -990472132, str);
                Composer composer = $composer2;
                Object rememberedValue7 = composer.rememberedValue();
                if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    showExpenseDialog$delegate = showExpenseDialog$delegate2;
                    obj6 = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainActivityKt.QuickAddModal$lambda$43$lambda$42(MutableState.this);
                        }
                    };
                    composer.updateRememberedValue(obj6);
                } else {
                    showExpenseDialog$delegate = showExpenseDialog$delegate2;
                    obj6 = rememberedValue7;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final MutableState showExpenseDialog$delegate3 = showExpenseDialog$delegate;
                int i3 = i2;
                boolean z2 = z;
                onDismiss = function0;
                appViewModel = viewModel;
                Composer $composer3 = $composer2;
                AndroidAlertDialog_androidKt.m1762AlertDialogOix01E0((Function0) obj6, ComposableLambdaKt.rememberComposableLambda(1128942357, z2, new Function2() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj8, Object obj9) {
                        return MainActivityKt.QuickAddModal$lambda$46(AppViewModel.this, function0, quickExpenseAmount$delegate, quickExpenseTitle$delegate, showExpenseDialog$delegate3, (Composer) obj8, ((Integer) obj9).intValue());
                    }
                }, $composer2, i3), null, ComposableLambdaKt.rememberComposableLambda(-1438879977, z2, new Function2() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj8, Object obj9) {
                        return MainActivityKt.QuickAddModal$lambda$49(MutableState.this, (Composer) obj8, ((Integer) obj9).intValue());
                    }
                }, $composer2, i3), null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$288264985$app(), ComposableLambdaKt.rememberComposableLambda(-995646182, z2, new Function2() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj8, Object obj9) {
                        return MainActivityKt.QuickAddModal$lambda$55(MutableState.this, quickExpenseAmount$delegate, (Composer) obj8, ((Integer) obj9).intValue());
                    }
                }, $composer2, i3), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer3, 1772598, 0, 16276);
                $composer2 = $composer3;
                $composer2.endReplaceGroup();
            } else {
                appViewModel = viewModel;
                $composer2.startReplaceGroup(i);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj8, Object obj9) {
                    return MainActivityKt.QuickAddModal$lambda$56(AppViewModel.this, onDismiss, $changed, (Composer) obj8, ((Integer) obj9).intValue());
                }
            });
        }
    }

    private static final boolean QuickAddModal$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void QuickAddModal$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean QuickAddModal$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void QuickAddModal$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String QuickAddModal$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String QuickAddModal$lambda$10(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String QuickAddModal$lambda$13(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0589  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x05cc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0676  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x06e8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x075e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x07bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x076c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x06f6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x05e2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit QuickAddModal$lambda$30(com.example.localization.AppLanguage r92, final com.example.ui.viewmodel.AppViewModel r93, final kotlin.jvm.functions.Function0 r94, final androidx.compose.runtime.MutableState r95, final androidx.compose.runtime.MutableState r96, androidx.compose.foundation.layout.ColumnScope r97, androidx.compose.runtime.Composer r98, int r99) {
        /*
            Method dump skipped, instructions count: 1989
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivityKt.QuickAddModal$lambda$30(com.example.localization.AppLanguage, com.example.ui.viewmodel.AppViewModel, kotlin.jvm.functions.Function0, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$30$lambda$29$lambda$21$lambda$16$lambda$15(MutableState $showTaskDialog$delegate) {
        QuickAddModal$lambda$2($showTaskDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$30$lambda$29$lambda$21$lambda$18$lambda$17(MutableState $showExpenseDialog$delegate) {
        QuickAddModal$lambda$5($showExpenseDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$30$lambda$29$lambda$21$lambda$20$lambda$19(AppViewModel $viewModel, Function0 $onDismiss) {
        $viewModel.addWaterGlass();
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$30$lambda$29$lambda$28$lambda$23$lambda$22(Function0 $onDismiss, AppViewModel $viewModel) {
        $onDismiss.invoke();
        $viewModel.navigateTo(Screen.MEDICINE_REMINDER);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$30$lambda$29$lambda$28$lambda$25$lambda$24(Function0 $onDismiss, AppViewModel $viewModel) {
        $onDismiss.invoke();
        $viewModel.navigateTo(Screen.SHOPPING_LIST);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$30$lambda$29$lambda$28$lambda$27$lambda$26(Function0 $onDismiss, AppViewModel $viewModel) {
        $onDismiss.invoke();
        $viewModel.navigateTo(Screen.NOTES);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$32$lambda$31(MutableState $showTaskDialog$delegate) {
        QuickAddModal$lambda$2($showTaskDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$41(final MutableState $quickTaskTitle$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C401@18936L23,399@18837L259:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(338748017, $changed, -1, "com.example.QuickAddModal.<anonymous> (MainActivity.kt:399)");
            }
            String QuickAddModal$lambda$7 = QuickAddModal$lambda$7($quickTaskTitle$delegate);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer, -880666392, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return MainActivityKt.QuickAddModal$lambda$41$lambda$40$lambda$39(MutableState.this, (String) obj2);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            OutlinedTextFieldKt.OutlinedTextField(QuickAddModal$lambda$7, (Function1<? super String, Unit>) obj, fillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$MainActivityKt.INSTANCE.m6937getLambda$694501237$app(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 1573296, 0, 0, 8388536);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$41$lambda$40$lambda$39(MutableState $quickTaskTitle$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $quickTaskTitle$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$35(final AppViewModel $viewModel, final Function0 $onDismiss, final MutableState $quickTaskTitle$delegate, final MutableState $showTaskDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C408@19196L753,407@19158L873:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(162188076, $changed, -1, "com.example.QuickAddModal.<anonymous> (MainActivity.kt:407)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1243920925, "CC(remember):MainActivity.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($viewModel) | $composer.changed($onDismiss);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.QuickAddModal$lambda$35$lambda$34$lambda$33(AppViewModel.this, $onDismiss, $quickTaskTitle$delegate, $showTaskDialog$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$MainActivityKt.INSTANCE.m6935getLambda$198331620$app(), $composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$35$lambda$34$lambda$33(AppViewModel $viewModel, Function0 $onDismiss, MutableState $quickTaskTitle$delegate, MutableState $showTaskDialog$delegate) {
        if (!StringsKt.isBlank(QuickAddModal$lambda$7($quickTaskTitle$delegate))) {
            $viewModel.addTask(new TaskEntity(0L, QuickAddModal$lambda$7($quickTaskTitle$delegate), QuickAddModal$lambda$7($quickTaskTitle$delegate), null, "Today", "General", "عام", null, false, null, null, null, null, null, false, false, false, null, null, 523913, null));
            $quickTaskTitle$delegate.setValue("");
            QuickAddModal$lambda$2($showTaskDialog$delegate, false);
            $onDismiss.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$38(final MutableState $showTaskDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C430@20114L26,430@20093L114:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1485174866, $changed, -1, "com.example.QuickAddModal.<anonymous> (MainActivity.kt:430)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1323902680, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.QuickAddModal$lambda$38$lambda$37$lambda$36(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$1528406123$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$38$lambda$37$lambda$36(MutableState $showTaskDialog$delegate) {
        QuickAddModal$lambda$2($showTaskDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$43$lambda$42(MutableState $showExpenseDialog$delegate) {
        QuickAddModal$lambda$5($showExpenseDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x017e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit QuickAddModal$lambda$55(final androidx.compose.runtime.MutableState r55, final androidx.compose.runtime.MutableState r56, androidx.compose.runtime.Composer r57, int r58) {
        /*
            Method dump skipped, instructions count: 627
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivityKt.QuickAddModal$lambda$55(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$55$lambda$54$lambda$51$lambda$50(MutableState $quickExpenseTitle$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $quickExpenseTitle$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$55$lambda$54$lambda$53$lambda$52(MutableState $quickExpenseAmount$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $quickExpenseAmount$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$46(final AppViewModel $viewModel, final Function0 $onDismiss, final MutableState $quickExpenseAmount$delegate, final MutableState $quickExpenseTitle$delegate, final MutableState $showExpenseDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C459@21240L863,458@21202L983:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1128942357, $changed, -1, "com.example.QuickAddModal.<anonymous> (MainActivity.kt:458)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1713118156, "CC(remember):MainActivity.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($viewModel) | $composer.changed($onDismiss);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.QuickAddModal$lambda$46$lambda$45$lambda$44(AppViewModel.this, $onDismiss, $quickExpenseAmount$delegate, $quickExpenseTitle$delegate, $showExpenseDialog$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$MainActivityKt.INSTANCE.m6933getLambda$1733101819$app(), $composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$46$lambda$45$lambda$44(AppViewModel $viewModel, Function0 $onDismiss, MutableState $quickExpenseAmount$delegate, MutableState $quickExpenseTitle$delegate, MutableState $showExpenseDialog$delegate) {
        Double doubleOrNull = StringsKt.toDoubleOrNull(QuickAddModal$lambda$13($quickExpenseAmount$delegate));
        double amt = doubleOrNull != null ? doubleOrNull.doubleValue() : 0.0d;
        if (!StringsKt.isBlank(QuickAddModal$lambda$10($quickExpenseTitle$delegate)) && amt > 0.0d) {
            String QuickAddModal$lambda$10 = QuickAddModal$lambda$10($quickExpenseTitle$delegate);
            String value = $viewModel.getSelectedDate().getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
            $viewModel.addExpense(new ExpenseEntity(0L, QuickAddModal$lambda$10, amt, "General", "Cash", value, null, 65, null));
            $quickExpenseTitle$delegate.setValue("");
            $quickExpenseAmount$delegate.setValue("");
            QuickAddModal$lambda$5($showExpenseDialog$delegate, false);
            $onDismiss.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$49(final MutableState $showExpenseDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C482@22268L29,482@22247L117:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1438879977, $changed, -1, "com.example.QuickAddModal.<anonymous> (MainActivity.kt:482)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 215812692, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.QuickAddModal$lambda$49$lambda$48$lambda$47(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$MainActivityKt.INSTANCE.m6934getLambda$195507052$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddModal$lambda$49$lambda$48$lambda$47(MutableState $showExpenseDialog$delegate) {
        QuickAddModal$lambda$5($showExpenseDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* renamed from: QuickAddChoice-Y0xEhic, reason: not valid java name */
    private static final void m6938QuickAddChoiceY0xEhic(final String title, final ImageVector icon, final long bgColor, final long tintColor, Modifier modifier, final Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier.Companion modifier3;
        long m4157copywmQWz5c;
        RoundedCornerShape roundedCornerShape;
        Object obj;
        Composer $composer2;
        final Modifier modifier4;
        Composer $composer3 = $composer.startRestartGroup(905668012);
        ComposerKt.sourceInformation($composer3, "C(QuickAddChoice)P(5,1,0:c#ui.graphics.Color,4:c#ui.graphics.Color)501@22704L55,506@22941L13,508@23011L893,499@22625L1279:MainActivity.kt#to5c3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(icon) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(bgColor) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(tintColor) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 131072 : 65536;
        }
        if ((74899 & $dirty) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier2;
            $composer2 = $composer3;
        } else {
            if (i2 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(905668012, $dirty, -1, "com.example.QuickAddChoice (MainActivity.kt:498)");
            }
            RoundedCornerShape m953RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6622constructorimpl(16));
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            int $dirty2 = $dirty;
            Modifier modifier5 = modifier3;
            m4157copywmQWz5c = Color.m4157copywmQWz5c(bgColor, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(bgColor) : 0.5f, (r12 & 2) != 0 ? Color.m4165getRedimpl(bgColor) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(bgColor) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(bgColor) : 0.0f);
            CardColors m1829cardColorsro_MJ88 = cardDefaults.m1829cardColorsro_MJ88(m4157copywmQWz5c, 0L, 0L, 0L, $composer3, CardDefaults.$stable << 12, 14);
            BorderStroke m252BorderStrokecXLIe8U = BorderStrokeKt.m252BorderStrokecXLIe8U(Dp.m6622constructorimpl(1), bgColor);
            Modifier m701height3ABfNKs = SizeKt.m701height3ABfNKs(SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, null), Dp.m6622constructorimpl(84));
            ComposerKt.sourceInformationMarkerStart($composer3, -1531384167, "CC(remember):MainActivity.kt#9igjgp");
            boolean z = ($dirty2 & 458752) == 131072;
            Object rememberedValue = $composer3.rememberedValue();
            if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                roundedCornerShape = m953RoundedCornerShape0680j_4;
                obj = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.QuickAddChoice_Y0xEhic$lambda$58$lambda$57(Function0.this);
                    }
                };
                $composer3.updateRememberedValue(obj);
            } else {
                roundedCornerShape = m953RoundedCornerShape0680j_4;
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            CardKt.Card(TestTagKt.testTag(ClickableKt.m258clickableXHw0xAI$default(m701height3ABfNKs, false, null, null, (Function0) obj, 7, null), "quick_add_choice_" + title), roundedCornerShape, m1829cardColorsro_MJ88, null, m252BorderStrokecXLIe8U, ComposableLambdaKt.rememberComposableLambda(1821773178, true, new Function3() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return MainActivityKt.QuickAddChoice_Y0xEhic$lambda$61(bgColor, title, icon, tintColor, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, $composer3, 54), $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier5;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return MainActivityKt.QuickAddChoice_Y0xEhic$lambda$62(title, icon, bgColor, tintColor, modifier4, function0, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickAddChoice_Y0xEhic$lambda$58$lambda$57(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit QuickAddChoice_Y0xEhic$lambda$61(long r58, java.lang.String r60, androidx.compose.ui.graphics.vector.ImageVector r61, long r62, androidx.compose.foundation.layout.ColumnScope r64, androidx.compose.runtime.Composer r65, int r66) {
        /*
            Method dump skipped, instructions count: 829
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivityKt.QuickAddChoice_Y0xEhic$lambda$61(long, java.lang.String, androidx.compose.ui.graphics.vector.ImageVector, long, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }
}
