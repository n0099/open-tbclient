package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import io.flutter.Log;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.editing.ListenableEditingState;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class TextInputPlugin implements ListenableEditingState.EditingStateWatcher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TextInputPlugin";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final AutofillManager afm;
    @Nullable
    public TextInputChannel.Configuration configuration;
    public ImeSyncDeferringInsetsCallback imeSyncCallback;
    @NonNull
    public InputTarget inputTarget;
    public boolean isInputConnectionLocked;
    @Nullable
    public Rect lastClientRect;
    @Nullable
    public InputConnection lastInputConnection;
    @Nullable
    public SparseArray<TextInputChannel.Configuration> mAutofillConfigurations;
    @Nullable
    public ListenableEditingState mEditable;
    @NonNull
    public final InputMethodManager mImm;
    public TextInputChannel.TextEditState mLastKnownFrameworkTextEditingState;
    public boolean mRestartInputPending;
    @NonNull
    public final View mView;
    @NonNull
    public PlatformViewsController platformViewsController;
    @NonNull
    public final TextInputChannel textInputChannel;

    /* loaded from: classes4.dex */
    public static class InputTarget {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int id;
        @NonNull
        public Type type;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes4.dex */
        public static final class Type {
            public static final /* synthetic */ Type[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final Type FRAMEWORK_CLIENT;
            public static final Type HC_PLATFORM_VIEW;
            public static final Type NO_TARGET;
            public static final Type VD_PLATFORM_VIEW;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1259591551, "Lio/flutter/plugin/editing/TextInputPlugin$InputTarget$Type;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1259591551, "Lio/flutter/plugin/editing/TextInputPlugin$InputTarget$Type;");
                        return;
                    }
                }
                NO_TARGET = new Type("NO_TARGET", 0);
                FRAMEWORK_CLIENT = new Type("FRAMEWORK_CLIENT", 1);
                VD_PLATFORM_VIEW = new Type("VD_PLATFORM_VIEW", 2);
                Type type = new Type("HC_PLATFORM_VIEW", 3);
                HC_PLATFORM_VIEW = type;
                $VALUES = new Type[]{NO_TARGET, FRAMEWORK_CLIENT, VD_PLATFORM_VIEW, type};
            }

            public Type(String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static Type valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Type) Enum.valueOf(Type.class, str) : (Type) invokeL.objValue;
            }

            public static Type[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Type[]) $VALUES.clone() : (Type[]) invokeV.objValue;
            }
        }

        public InputTarget(@NonNull Type type, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {type, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.type = type;
            this.id = i2;
        }
    }

    /* loaded from: classes4.dex */
    public interface MinMax {
        void inspect(double d2, double d3);
    }

    @SuppressLint({"NewApi"})
    public TextInputPlugin(View view, @NonNull TextInputChannel textInputChannel, @NonNull PlatformViewsController platformViewsController) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, textInputChannel, platformViewsController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
        this.mView = view;
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (Build.VERSION.SDK_INT >= 26) {
            this.afm = (AutofillManager) view.getContext().getSystemService(AutofillManager.class);
        } else {
            this.afm = null;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            int navigationBars = (this.mView.getWindowSystemUiVisibility() & 2) == 0 ? 0 | WindowInsets.Type.navigationBars() : 0;
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view, (this.mView.getWindowSystemUiVisibility() & 4) == 0 ? navigationBars | WindowInsets.Type.statusBars() : navigationBars, WindowInsets.Type.ime());
            this.imeSyncCallback = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
        }
        this.textInputChannel = textInputChannel;
        textInputChannel.setTextInputMethodHandler(new TextInputChannel.TextInputMethodHandler(this) { // from class: io.flutter.plugin.editing.TextInputPlugin.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TextInputPlugin this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void clearClient() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.clearTextInputClient();
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void finishAutofillContext(boolean z) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || Build.VERSION.SDK_INT < 26 || this.this$0.afm == null) {
                    return;
                }
                if (z) {
                    this.this$0.afm.commit();
                } else {
                    this.this$0.afm.cancel();
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void hide() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    if (this.this$0.inputTarget.type == InputTarget.Type.HC_PLATFORM_VIEW) {
                        this.this$0.notifyViewExited();
                        return;
                    }
                    TextInputPlugin textInputPlugin = this.this$0;
                    textInputPlugin.hideTextInput(textInputPlugin.mView);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void requestAutofill() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.this$0.notifyViewEntered();
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void sendAppPrivateCommand(String str, Bundle bundle) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048580, this, str, bundle) == null) {
                    this.this$0.sendTextInputAppPrivateCommand(str, bundle);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setClient(int i4, TextInputChannel.Configuration configuration) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048581, this, i4, configuration) == null) {
                    this.this$0.setTextInputClient(i4, configuration);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setEditableSizeAndTransform(double d2, double d3, double[] dArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048582, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), dArr}) == null) {
                    this.this$0.saveEditableSizeAndTransform(d2, d3, dArr);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setEditingState(TextInputChannel.TextEditState textEditState) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048583, this, textEditState) == null) {
                    TextInputPlugin textInputPlugin = this.this$0;
                    textInputPlugin.setTextInputEditingState(textInputPlugin.mView, textEditState);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setPlatformViewClient(int i4, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
                    this.this$0.setPlatformViewTextInputClient(i4, z);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void show() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048585, this) == null) {
                    TextInputPlugin textInputPlugin = this.this$0;
                    textInputPlugin.showTextInput(textInputPlugin.mView);
                }
            }
        });
        textInputChannel.requestExistingInputState();
        this.platformViewsController = platformViewsController;
        platformViewsController.attachTextInputPlugin(this);
    }

    private boolean canShowTextInput() {
        InterceptResult invokeV;
        TextInputChannel.InputType inputType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            TextInputChannel.Configuration configuration = this.configuration;
            return configuration == null || (inputType = configuration.inputType) == null || inputType.type != TextInputChannel.TextInputType.NONE;
        }
        return invokeV.booleanValue;
    }

    public static boolean composingChanged(TextInputChannel.TextEditState textEditState, TextInputChannel.TextEditState textEditState2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, textEditState, textEditState2)) == null) {
            int i2 = textEditState.composingEnd - textEditState.composingStart;
            if (i2 != textEditState2.composingEnd - textEditState2.composingStart) {
                return true;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                if (textEditState.text.charAt(textEditState.composingStart + i3) != textEditState2.text.charAt(textEditState2.composingStart + i3)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTextInput(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, view) == null) {
            notifyViewExited();
            this.mImm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
        }
    }

    public static int inputTypeFromTextInputType(TextInputChannel.InputType inputType, boolean z, boolean z2, boolean z3, boolean z4, TextInputChannel.TextCapitalization textCapitalization) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{inputType, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), textCapitalization})) == null) {
            TextInputChannel.TextInputType textInputType = inputType.type;
            if (textInputType == TextInputChannel.TextInputType.DATETIME) {
                return 4;
            }
            if (textInputType == TextInputChannel.TextInputType.NUMBER) {
                int i2 = inputType.isSigned ? 4098 : 2;
                return inputType.isDecimal ? i2 | 8192 : i2;
            } else if (textInputType == TextInputChannel.TextInputType.PHONE) {
                return 3;
            } else {
                if (textInputType == TextInputChannel.TextInputType.NONE) {
                    return 0;
                }
                int i3 = 1;
                if (textInputType == TextInputChannel.TextInputType.MULTILINE) {
                    i3 = 131073;
                } else if (textInputType == TextInputChannel.TextInputType.EMAIL_ADDRESS) {
                    i3 = 33;
                } else if (textInputType == TextInputChannel.TextInputType.URL) {
                    i3 = 17;
                } else if (textInputType == TextInputChannel.TextInputType.VISIBLE_PASSWORD) {
                    i3 = w0.n;
                } else if (textInputType == TextInputChannel.TextInputType.NAME) {
                    i3 = 97;
                } else if (textInputType == TextInputChannel.TextInputType.POSTAL_ADDRESS) {
                    i3 = 113;
                }
                if (z) {
                    i3 = i3 | 524288 | 128;
                } else {
                    if (z2) {
                        i3 |= 32768;
                    }
                    if (!z3) {
                        i3 |= 524288;
                    }
                }
                return textCapitalization == TextInputChannel.TextCapitalization.CHARACTERS ? i3 | 4096 : textCapitalization == TextInputChannel.TextCapitalization.WORDS ? i3 | 8192 : textCapitalization == TextInputChannel.TextCapitalization.SENTENCES ? i3 | 16384 : i3;
            }
        }
        return invokeCommon.intValue;
    }

    private boolean needsAutofill() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? this.mAutofillConfigurations != null : invokeV.booleanValue;
    }

    private void notifyValueChanged(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, this, str) == null) || Build.VERSION.SDK_INT < 26 || this.afm == null || !needsAutofill()) {
            return;
        }
        this.afm.notifyValueChanged(this.mView, this.configuration.autofill.uniqueIdentifier.hashCode(), AutofillValue.forText(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyViewEntered() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || Build.VERSION.SDK_INT < 26 || this.afm == null || !needsAutofill()) {
            return;
        }
        String str = this.configuration.autofill.uniqueIdentifier;
        int[] iArr = new int[2];
        this.mView.getLocationOnScreen(iArr);
        Rect rect = new Rect(this.lastClientRect);
        rect.offset(iArr[0], iArr[1]);
        this.afm.notifyViewEntered(this.mView, str.hashCode(), rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyViewExited() {
        TextInputChannel.Configuration configuration;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || Build.VERSION.SDK_INT < 26 || this.afm == null || (configuration = this.configuration) == null || configuration.autofill == null || !needsAutofill()) {
            return;
        }
        this.afm.notifyViewExited(this.mView, this.configuration.autofill.uniqueIdentifier.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveEditableSizeAndTransform(double d2, double d3, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), dArr}) == null) {
            double[] dArr2 = new double[4];
            boolean z = dArr[3] == 0.0d && dArr[7] == 0.0d && dArr[15] == 1.0d;
            double d4 = dArr[12] / dArr[15];
            dArr2[1] = d4;
            dArr2[0] = d4;
            double d5 = dArr[13] / dArr[15];
            dArr2[3] = d5;
            dArr2[2] = d5;
            MinMax minMax = new MinMax(this, z, dArr, dArr2) { // from class: io.flutter.plugin.editing.TextInputPlugin.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TextInputPlugin this$0;
                public final /* synthetic */ boolean val$isAffine;
                public final /* synthetic */ double[] val$matrix;
                public final /* synthetic */ double[] val$minMax;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), dArr, dArr2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$isAffine = z;
                    this.val$matrix = dArr;
                    this.val$minMax = dArr2;
                }

                @Override // io.flutter.plugin.editing.TextInputPlugin.MinMax
                public void inspect(double d6, double d7) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Double.valueOf(d6), Double.valueOf(d7)}) == null) {
                        double d8 = 1.0d;
                        if (!this.val$isAffine) {
                            double[] dArr3 = this.val$matrix;
                            d8 = 1.0d / (((dArr3[3] * d6) + (dArr3[7] * d7)) + dArr3[15]);
                        }
                        double[] dArr4 = this.val$matrix;
                        double d9 = ((dArr4[0] * d6) + (dArr4[4] * d7) + dArr4[12]) * d8;
                        double d10 = ((dArr4[1] * d6) + (dArr4[5] * d7) + dArr4[13]) * d8;
                        double[] dArr5 = this.val$minMax;
                        if (d9 < dArr5[0]) {
                            dArr5[0] = d9;
                        } else if (d9 > dArr5[1]) {
                            dArr5[1] = d9;
                        }
                        double[] dArr6 = this.val$minMax;
                        if (d10 < dArr6[2]) {
                            dArr6[2] = d10;
                        } else if (d10 > dArr6[3]) {
                            dArr6[3] = d10;
                        }
                    }
                }
            };
            minMax.inspect(d2, 0.0d);
            minMax.inspect(d2, d3);
            minMax.inspect(0.0d, d3);
            Float valueOf = Float.valueOf(this.mView.getContext().getResources().getDisplayMetrics().density);
            this.lastClientRect = new Rect((int) (dArr2[0] * valueOf.floatValue()), (int) (dArr2[2] * valueOf.floatValue()), (int) Math.ceil(dArr2[1] * valueOf.floatValue()), (int) Math.ceil(dArr2[3] * valueOf.floatValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlatformViewTextInputClient(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                this.mView.requestFocus();
                this.inputTarget = new InputTarget(InputTarget.Type.VD_PLATFORM_VIEW, i2);
                this.mImm.restartInput(this.mView);
                this.mRestartInputPending = false;
                return;
            }
            this.inputTarget = new InputTarget(InputTarget.Type.HC_PLATFORM_VIEW, i2);
            this.lastInputConnection = null;
        }
    }

    private void updateAutofillConfigurationIfNeeded(TextInputChannel.Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, this, configuration) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (configuration != null && configuration.autofill != null) {
            TextInputChannel.Configuration[] configurationArr = configuration.fields;
            SparseArray<TextInputChannel.Configuration> sparseArray = new SparseArray<>();
            this.mAutofillConfigurations = sparseArray;
            if (configurationArr == null) {
                sparseArray.put(configuration.autofill.uniqueIdentifier.hashCode(), configuration);
                return;
            }
            for (TextInputChannel.Configuration configuration2 : configurationArr) {
                TextInputChannel.Configuration.Autofill autofill = configuration2.autofill;
                if (autofill != null) {
                    this.mAutofillConfigurations.put(autofill.uniqueIdentifier.hashCode(), configuration2);
                    this.afm.notifyValueChanged(this.mView, autofill.uniqueIdentifier.hashCode(), AutofillValue.forText(autofill.editState.text));
                }
            }
            return;
        }
        this.mAutofillConfigurations = null;
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        TextInputChannel.Configuration.Autofill autofill;
        TextInputChannel.Configuration.Autofill autofill2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, sparseArray) == null) || Build.VERSION.SDK_INT < 26 || (autofill = this.configuration.autofill) == null) {
            return;
        }
        HashMap<String, TextInputChannel.TextEditState> hashMap = new HashMap<>();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            TextInputChannel.Configuration configuration = this.mAutofillConfigurations.get(sparseArray.keyAt(i2));
            if (configuration != null && (autofill2 = configuration.autofill) != null) {
                String charSequence = sparseArray.valueAt(i2).getTextValue().toString();
                TextInputChannel.TextEditState textEditState = new TextInputChannel.TextEditState(charSequence, charSequence.length(), charSequence.length(), -1, -1);
                if (autofill2.uniqueIdentifier.equals(autofill.uniqueIdentifier)) {
                    this.mEditable.setEditingState(textEditState);
                } else {
                    hashMap.put(autofill2.uniqueIdentifier, textEditState);
                }
            }
        }
        this.textInputChannel.updateEditingStateWithTag(this.inputTarget.id, hashMap);
    }

    public void clearPlatformViewClient(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            InputTarget.Type type = this.inputTarget.type;
            if ((type == InputTarget.Type.VD_PLATFORM_VIEW || type == InputTarget.Type.HC_PLATFORM_VIEW) && this.inputTarget.id == i2) {
                this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
                notifyViewExited();
                this.mImm.hideSoftInputFromWindow(this.mView.getApplicationWindowToken(), 0);
                this.mImm.restartInput(this.mView);
                this.mRestartInputPending = false;
            }
        }
    }

    @VisibleForTesting
    public void clearTextInputClient() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.inputTarget.type == InputTarget.Type.VD_PLATFORM_VIEW) {
            return;
        }
        this.mEditable.removeEditingStateListener(this);
        notifyViewExited();
        updateAutofillConfigurationIfNeeded(null);
        this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
        unlockPlatformViewInputConnection();
        this.lastClientRect = null;
    }

    public InputConnection createInputConnection(View view, KeyboardManager keyboardManager, EditorInfo editorInfo) {
        InterceptResult invokeLLL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, view, keyboardManager, editorInfo)) == null) {
            InputTarget inputTarget = this.inputTarget;
            InputTarget.Type type = inputTarget.type;
            if (type == InputTarget.Type.NO_TARGET) {
                this.lastInputConnection = null;
                return null;
            } else if (type == InputTarget.Type.HC_PLATFORM_VIEW) {
                return null;
            } else {
                if (type == InputTarget.Type.VD_PLATFORM_VIEW) {
                    if (this.isInputConnectionLocked) {
                        return this.lastInputConnection;
                    }
                    InputConnection onCreateInputConnection = this.platformViewsController.getPlatformViewById(Integer.valueOf(inputTarget.id)).onCreateInputConnection(editorInfo);
                    this.lastInputConnection = onCreateInputConnection;
                    return onCreateInputConnection;
                }
                TextInputChannel.Configuration configuration = this.configuration;
                editorInfo.inputType = inputTypeFromTextInputType(configuration.inputType, configuration.obscureText, configuration.autocorrect, configuration.enableSuggestions, configuration.enableIMEPersonalizedLearning, configuration.textCapitalization);
                editorInfo.imeOptions = 33554432;
                if (Build.VERSION.SDK_INT >= 26 && !this.configuration.enableIMEPersonalizedLearning) {
                    editorInfo.imeOptions = 33554432 | 16777216;
                }
                Integer num = this.configuration.inputAction;
                if (num == null) {
                    intValue = (131072 & editorInfo.inputType) != 0 ? 1 : 6;
                } else {
                    intValue = num.intValue();
                }
                String str = this.configuration.actionLabel;
                if (str != null) {
                    editorInfo.actionLabel = str;
                    editorInfo.actionId = intValue;
                }
                editorInfo.imeOptions = intValue | editorInfo.imeOptions;
                InputConnectionAdaptor inputConnectionAdaptor = new InputConnectionAdaptor(view, this.inputTarget.id, this.textInputChannel, keyboardManager, this.mEditable, editorInfo);
                editorInfo.initialSelStart = this.mEditable.getSelectionStart();
                editorInfo.initialSelEnd = this.mEditable.getSelectionEnd();
                this.lastInputConnection = inputConnectionAdaptor;
                return inputConnectionAdaptor;
            }
        }
        return (InputConnection) invokeLLL.objValue;
    }

    @SuppressLint({"NewApi"})
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.platformViewsController.detachTextInputPlugin();
            this.textInputChannel.setTextInputMethodHandler(null);
            notifyViewExited();
            ListenableEditingState listenableEditingState = this.mEditable;
            if (listenableEditingState != null) {
                listenableEditingState.removeEditingStateListener(this);
            }
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.imeSyncCallback;
            if (imeSyncDeferringInsetsCallback != null) {
                imeSyncDeferringInsetsCallback.remove();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        if (r7 == r0.composingEnd) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    @Override // io.flutter.plugin.editing.ListenableEditingState.EditingStateWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void didChangeEditingState(boolean z, boolean z2, boolean z3) {
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) {
            return;
        }
        if (z) {
            notifyValueChanged(this.mEditable.toString());
        }
        int selectionStart = this.mEditable.getSelectionStart();
        int selectionEnd = this.mEditable.getSelectionEnd();
        int composingStart = this.mEditable.getComposingStart();
        int composingEnd = this.mEditable.getComposingEnd();
        if (this.mLastKnownFrameworkTextEditingState != null) {
            if (this.mEditable.toString().equals(this.mLastKnownFrameworkTextEditingState.text)) {
                TextInputChannel.TextEditState textEditState = this.mLastKnownFrameworkTextEditingState;
                if (selectionStart == textEditState.selectionStart) {
                    if (selectionEnd == textEditState.selectionEnd) {
                        if (composingStart == textEditState.composingStart) {
                        }
                    }
                }
            }
            z4 = false;
            if (z4) {
                Log.v(TAG, "send EditingState to flutter: " + this.mEditable.toString());
                this.textInputChannel.updateEditingState(this.inputTarget.id, this.mEditable.toString(), selectionStart, selectionEnd, composingStart, composingEnd);
                this.mLastKnownFrameworkTextEditingState = new TextInputChannel.TextEditState(this.mEditable.toString(), selectionStart, selectionEnd, composingStart, composingEnd);
                return;
            }
            return;
        }
        z4 = true;
        if (z4) {
        }
    }

    @VisibleForTesting
    public Editable getEditable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mEditable : (Editable) invokeV.objValue;
    }

    @VisibleForTesting
    public ImeSyncDeferringInsetsCallback getImeSyncCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.imeSyncCallback : (ImeSyncDeferringInsetsCallback) invokeV.objValue;
    }

    @NonNull
    public InputMethodManager getInputMethodManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mImm : (InputMethodManager) invokeV.objValue;
    }

    @Nullable
    public InputConnection getLastInputConnection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.lastInputConnection : (InputConnection) invokeV.objValue;
    }

    public boolean handleKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        InputConnection inputConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, keyEvent)) == null) {
            if (!getInputMethodManager().isAcceptingText() || (inputConnection = this.lastInputConnection) == null) {
                return false;
            }
            if (inputConnection instanceof InputConnectionAdaptor) {
                return ((InputConnectionAdaptor) inputConnection).handleKeyEvent(keyEvent);
            }
            return inputConnection.sendKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    public void lockPlatformViewInputConnection() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.inputTarget.type == InputTarget.Type.VD_PLATFORM_VIEW) {
            this.isInputConnectionLocked = true;
        }
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i2) {
        Rect rect;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048588, this, viewStructure, i2) == null) && Build.VERSION.SDK_INT >= 26 && needsAutofill()) {
            String str = this.configuration.autofill.uniqueIdentifier;
            AutofillId autofillId = viewStructure.getAutofillId();
            for (int i3 = 0; i3 < this.mAutofillConfigurations.size(); i3++) {
                int keyAt = this.mAutofillConfigurations.keyAt(i3);
                TextInputChannel.Configuration.Autofill autofill = this.mAutofillConfigurations.valueAt(i3).autofill;
                if (autofill != null) {
                    viewStructure.addChildCount(1);
                    ViewStructure newChild = viewStructure.newChild(i3);
                    newChild.setAutofillId(autofillId, keyAt);
                    newChild.setAutofillHints(autofill.hints);
                    newChild.setAutofillType(1);
                    newChild.setVisibility(0);
                    if (str.hashCode() == keyAt && (rect = this.lastClientRect) != null) {
                        newChild.setDimens(rect.left, rect.top, 0, 0, rect.width(), this.lastClientRect.height());
                        newChild.setAutofillValue(AutofillValue.forText(this.mEditable));
                    } else {
                        newChild.setDimens(0, 0, 0, 0, 1, 1);
                        newChild.setAutofillValue(AutofillValue.forText(autofill.editState.text));
                    }
                }
            }
        }
    }

    public void sendTextInputAppPrivateCommand(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, bundle) == null) {
            this.mImm.sendAppPrivateCommand(this.mView, str, bundle);
        }
    }

    @VisibleForTesting
    public void setTextInputClient(int i2, TextInputChannel.Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, configuration) == null) {
            notifyViewExited();
            this.configuration = configuration;
            if (canShowTextInput()) {
                this.inputTarget = new InputTarget(InputTarget.Type.FRAMEWORK_CLIENT, i2);
            } else {
                this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, i2);
            }
            ListenableEditingState listenableEditingState = this.mEditable;
            if (listenableEditingState != null) {
                listenableEditingState.removeEditingStateListener(this);
            }
            TextInputChannel.Configuration.Autofill autofill = configuration.autofill;
            this.mEditable = new ListenableEditingState(autofill != null ? autofill.editState : null, this.mView);
            updateAutofillConfigurationIfNeeded(configuration);
            this.mRestartInputPending = true;
            unlockPlatformViewInputConnection();
            this.lastClientRect = null;
            this.mEditable.addEditingStateListener(this);
        }
    }

    @VisibleForTesting
    public void setTextInputEditingState(View view, TextInputChannel.TextEditState textEditState) {
        TextInputChannel.TextEditState textEditState2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, view, textEditState) == null) {
            if (!this.mRestartInputPending && (textEditState2 = this.mLastKnownFrameworkTextEditingState) != null && textEditState2.hasComposing()) {
                boolean composingChanged = composingChanged(this.mLastKnownFrameworkTextEditingState, textEditState);
                this.mRestartInputPending = composingChanged;
                if (composingChanged) {
                    Log.i(TAG, "Composing region changed by the framework. Restarting the input method.");
                }
            }
            this.mLastKnownFrameworkTextEditingState = textEditState;
            this.mEditable.setEditingState(textEditState);
            if (this.mRestartInputPending) {
                this.mImm.restartInput(view);
                this.mRestartInputPending = false;
            }
        }
    }

    @VisibleForTesting
    public void showTextInput(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            if (canShowTextInput()) {
                view.requestFocus();
                this.mImm.showSoftInput(view, 0);
                return;
            }
            hideTextInput(view);
        }
    }

    public void unlockPlatformViewInputConnection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.isInputConnectionLocked = false;
        }
    }
}
