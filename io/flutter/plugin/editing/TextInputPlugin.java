package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.os.Build;
import android.provider.Settings;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.ManufacturerUtils;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.platform.PlatformViewsController;
/* loaded from: classes2.dex */
public class TextInputPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public TextInputChannel.Configuration configuration;
    @NonNull
    public InputTarget inputTarget;
    public boolean isInputConnectionLocked;
    @Nullable
    public InputConnection lastInputConnection;
    @Nullable
    public Editable mEditable;
    @NonNull
    public final InputMethodManager mImm;
    public boolean mRestartInputPending;
    @NonNull
    public final View mView;
    @NonNull
    public PlatformViewsController platformViewsController;
    public final boolean restartAlwaysRequired;
    @NonNull
    public final TextInputChannel textInputChannel;

    /* loaded from: classes2.dex */
    public static class InputTarget {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int id;
        @NonNull
        public Type type;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes2.dex */
        public static final class Type {
            public static final /* synthetic */ Type[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final Type FRAMEWORK_CLIENT;
            public static final Type NO_TARGET;
            public static final Type PLATFORM_VIEW;
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
                Type type = new Type("PLATFORM_VIEW", 2);
                PLATFORM_VIEW = type;
                $VALUES = new Type[]{NO_TARGET, FRAMEWORK_CLIENT, type};
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

    public TextInputPlugin(View view, @NonNull DartExecutor dartExecutor, @NonNull PlatformViewsController platformViewsController) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, dartExecutor, platformViewsController};
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
        TextInputChannel textInputChannel = new TextInputChannel(dartExecutor);
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
            public void hide() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    TextInputPlugin textInputPlugin = this.this$0;
                    textInputPlugin.hideTextInput(textInputPlugin.mView);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setClient(int i4, TextInputChannel.Configuration configuration) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i4, configuration) == null) {
                    this.this$0.setTextInputClient(i4, configuration);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setEditingState(TextInputChannel.TextEditState textEditState) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, textEditState) == null) {
                    TextInputPlugin textInputPlugin = this.this$0;
                    textInputPlugin.setTextInputEditingState(textInputPlugin.mView, textEditState);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setPlatformViewClient(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048580, this, i4) == null) {
                    this.this$0.setPlatformViewTextInputClient(i4);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void show() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    TextInputPlugin textInputPlugin = this.this$0;
                    textInputPlugin.showTextInput(textInputPlugin.mView);
                }
            }
        });
        this.textInputChannel.requestExistingInputState();
        this.platformViewsController = platformViewsController;
        platformViewsController.attachTextInputPlugin(this);
        this.restartAlwaysRequired = isRestartAlwaysRequired();
    }

    private void applyStateToSelection(TextInputChannel.TextEditState textEditState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, textEditState) == null) {
            int i2 = textEditState.selectionStart;
            int i3 = textEditState.selectionEnd;
            if (i2 >= 0 && i2 <= this.mEditable.length() && i3 >= 0 && i3 <= this.mEditable.length()) {
                Selection.setSelection(this.mEditable, i2, i3);
            } else {
                Selection.removeSelection(this.mEditable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTextInputClient() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.inputTarget.type == InputTarget.Type.PLATFORM_VIEW) {
            return;
        }
        this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
        unlockPlatformViewInputConnection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTextInput(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, view) == null) {
            this.mImm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
        }
    }

    public static int inputTypeFromTextInputType(TextInputChannel.InputType inputType, boolean z, boolean z2, boolean z3, TextInputChannel.TextCapitalization textCapitalization) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{inputType, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), textCapitalization})) == null) {
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
                int i3 = 1;
                if (textInputType == TextInputChannel.TextInputType.MULTILINE) {
                    i3 = 131073;
                } else if (textInputType == TextInputChannel.TextInputType.EMAIL_ADDRESS) {
                    i3 = 33;
                } else if (textInputType == TextInputChannel.TextInputType.URL) {
                    i3 = 17;
                } else if (textInputType == TextInputChannel.TextInputType.VISIBLE_PASSWORD) {
                    i3 = 145;
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

    @SuppressLint({"NewApi"})
    private boolean isRestartAlwaysRequired() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.mImm.getCurrentInputMethodSubtype() == null || Build.VERSION.SDK_INT < 21 || !Build.MANUFACTURER.equals(ManufacturerUtils.SAMSUNG)) {
                return false;
            }
            return Settings.Secure.getString(this.mView.getContext().getContentResolver(), "default_input_method").contains("Samsung");
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlatformViewTextInputClient(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, this, i2) == null) {
            this.mView.requestFocus();
            this.inputTarget = new InputTarget(InputTarget.Type.PLATFORM_VIEW, i2);
            this.mImm.restartInput(this.mView);
            this.mRestartInputPending = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTextInput(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, view) == null) {
            view.requestFocus();
            this.mImm.showSoftInput(view, 0);
        }
    }

    public void clearPlatformViewClient(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            InputTarget inputTarget = this.inputTarget;
            if (inputTarget.type == InputTarget.Type.PLATFORM_VIEW && inputTarget.id == i2) {
                this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
                hideTextInput(this.mView);
                this.mImm.restartInput(this.mView);
                this.mRestartInputPending = false;
            }
        }
    }

    public InputConnection createInputConnection(View view, EditorInfo editorInfo) {
        InterceptResult invokeLL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, editorInfo)) == null) {
            InputTarget inputTarget = this.inputTarget;
            InputTarget.Type type = inputTarget.type;
            if (type == InputTarget.Type.NO_TARGET) {
                this.lastInputConnection = null;
                return null;
            } else if (type == InputTarget.Type.PLATFORM_VIEW) {
                if (this.isInputConnectionLocked) {
                    return this.lastInputConnection;
                }
                InputConnection onCreateInputConnection = this.platformViewsController.getPlatformViewById(Integer.valueOf(inputTarget.id)).onCreateInputConnection(editorInfo);
                this.lastInputConnection = onCreateInputConnection;
                return onCreateInputConnection;
            } else {
                TextInputChannel.Configuration configuration = this.configuration;
                int inputTypeFromTextInputType = inputTypeFromTextInputType(configuration.inputType, configuration.obscureText, configuration.autocorrect, configuration.enableSuggestions, configuration.textCapitalization);
                editorInfo.inputType = inputTypeFromTextInputType;
                editorInfo.imeOptions = 33554432;
                Integer num = this.configuration.inputAction;
                if (num == null) {
                    intValue = (inputTypeFromTextInputType & 131072) != 0 ? 1 : 6;
                } else {
                    intValue = num.intValue();
                }
                String str = this.configuration.actionLabel;
                if (str != null) {
                    editorInfo.actionLabel = str;
                    editorInfo.actionId = intValue;
                }
                editorInfo.imeOptions = intValue | editorInfo.imeOptions;
                InputConnectionAdaptor inputConnectionAdaptor = new InputConnectionAdaptor(view, this.inputTarget.id, this.textInputChannel, this.mEditable, editorInfo);
                editorInfo.initialSelStart = Selection.getSelectionStart(this.mEditable);
                editorInfo.initialSelEnd = Selection.getSelectionEnd(this.mEditable);
                this.lastInputConnection = inputConnectionAdaptor;
                return inputConnectionAdaptor;
            }
        }
        return (InputConnection) invokeLL.objValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.platformViewsController.detachTextInputPlugin();
        }
    }

    @VisibleForTesting
    public Editable getEditable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mEditable : (Editable) invokeV.objValue;
    }

    @NonNull
    public InputMethodManager getInputMethodManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mImm : (InputMethodManager) invokeV.objValue;
    }

    @Nullable
    public InputConnection getLastInputConnection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.lastInputConnection : (InputConnection) invokeV.objValue;
    }

    public void lockPlatformViewInputConnection() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.inputTarget.type == InputTarget.Type.PLATFORM_VIEW) {
            this.isInputConnectionLocked = true;
        }
    }

    @VisibleForTesting
    public void setTextInputClient(int i2, TextInputChannel.Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, configuration) == null) {
            this.inputTarget = new InputTarget(InputTarget.Type.FRAMEWORK_CLIENT, i2);
            this.configuration = configuration;
            this.mEditable = Editable.Factory.getInstance().newEditable("");
            this.mRestartInputPending = true;
            unlockPlatformViewInputConnection();
        }
    }

    @VisibleForTesting
    public void setTextInputEditingState(View view, TextInputChannel.TextEditState textEditState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, textEditState) == null) {
            if (!textEditState.text.equals(this.mEditable.toString())) {
                Editable editable = this.mEditable;
                editable.replace(0, editable.length(), textEditState.text);
            }
            applyStateToSelection(textEditState);
            if (!this.restartAlwaysRequired && !this.mRestartInputPending) {
                this.mImm.updateSelection(this.mView, Math.max(Selection.getSelectionStart(this.mEditable), 0), Math.max(Selection.getSelectionEnd(this.mEditable), 0), BaseInputConnection.getComposingSpanStart(this.mEditable), BaseInputConnection.getComposingSpanEnd(this.mEditable));
                return;
            }
            this.mImm.restartInput(view);
            this.mRestartInputPending = false;
        }
    }

    public void unlockPlatformViewInputConnection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.isInputConnectionLocked = false;
        }
    }
}
