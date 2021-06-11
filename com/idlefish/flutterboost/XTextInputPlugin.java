package com.idlefish.flutterboost;

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
import com.google.android.material.internal.ManufacturerUtils;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.platform.PlatformViewsController;
/* loaded from: classes6.dex */
public class XTextInputPlugin {
    public static XTextInputPlugin xTextInputPlugin;
    @Nullable
    public TextInputChannel.Configuration configuration;
    @NonNull
    public InputTarget inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
    public boolean isInputConnectionLocked;
    @Nullable
    public InputConnection lastInputConnection;
    @Nullable
    public Editable mEditable;
    @NonNull
    public InputMethodManager mImm;
    public boolean mRestartInputPending;
    @NonNull
    public View mView;
    @NonNull
    public PlatformViewsController platformViewsController;
    public boolean restartAlwaysRequired;
    @NonNull
    public TextInputChannel textInputChannel;

    /* loaded from: classes6.dex */
    public static class InputTarget {
        public int id;
        @NonNull
        public Type type;

        /* loaded from: classes6.dex */
        public enum Type {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            PLATFORM_VIEW
        }

        public InputTarget(@NonNull Type type, int i2) {
            this.type = type;
            this.id = i2;
        }
    }

    public XTextInputPlugin(@NonNull DartExecutor dartExecutor, @NonNull PlatformViewsController platformViewsController) {
        TextInputChannel textInputChannel = new TextInputChannel(dartExecutor);
        this.textInputChannel = textInputChannel;
        textInputChannel.requestExistingInputState();
        this.platformViewsController = platformViewsController;
    }

    public static XTextInputPlugin getTextInputPlugin(DartExecutor dartExecutor, @NonNull PlatformViewsController platformViewsController) {
        XTextInputPlugin xTextInputPlugin2 = xTextInputPlugin;
        if (xTextInputPlugin2 != null) {
            return xTextInputPlugin2;
        }
        XTextInputPlugin xTextInputPlugin3 = new XTextInputPlugin(dartExecutor, platformViewsController);
        xTextInputPlugin = xTextInputPlugin3;
        return xTextInputPlugin3;
    }

    public static int inputTypeFromTextInputType(TextInputChannel.InputType inputType, boolean z, boolean z2, boolean z3, TextInputChannel.TextCapitalization textCapitalization) {
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

    public final void applyStateToSelection(TextInputChannel.TextEditState textEditState) {
        int i2 = textEditState.selectionStart;
        int i3 = textEditState.selectionEnd;
        if (i2 >= 0 && i2 <= this.mEditable.length() && i3 >= 0 && i3 <= this.mEditable.length()) {
            Selection.setSelection(this.mEditable, i2, i3);
        } else {
            Selection.removeSelection(this.mEditable);
        }
    }

    public final void clearTextInputClient() {
        if (this.inputTarget.type == InputTarget.Type.PLATFORM_VIEW) {
            return;
        }
        this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
        unlockPlatformViewInputConnection();
    }

    public InputConnection createInputConnection(View view, EditorInfo editorInfo) {
        int intValue;
        InputTarget inputTarget = this.inputTarget;
        InputTarget.Type type = inputTarget.type;
        if (type == InputTarget.Type.NO_TARGET) {
            this.lastInputConnection = null;
            return null;
        } else if (type == InputTarget.Type.PLATFORM_VIEW) {
            if (this.isInputConnectionLocked) {
                return this.lastInputConnection;
            }
            PlatformViewsController platformViewsController = this.platformViewsController;
            if (platformViewsController != null && platformViewsController.getPlatformViewById(Integer.valueOf(inputTarget.id)) != null) {
                this.lastInputConnection = this.platformViewsController.getPlatformViewById(Integer.valueOf(this.inputTarget.id)).onCreateInputConnection(editorInfo);
            }
            return this.lastInputConnection;
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
            XInputConnectionAdaptor xInputConnectionAdaptor = new XInputConnectionAdaptor(view, this.inputTarget.id, this.textInputChannel, this.mEditable);
            editorInfo.initialSelStart = Selection.getSelectionStart(this.mEditable);
            editorInfo.initialSelEnd = Selection.getSelectionEnd(this.mEditable);
            this.lastInputConnection = xInputConnectionAdaptor;
            return xInputConnectionAdaptor;
        }
    }

    @NonNull
    public InputMethodManager getInputMethodManager() {
        return this.mImm;
    }

    @Nullable
    public InputConnection getLastInputConnection() {
        return this.lastInputConnection;
    }

    public final void hideTextInput(View view) {
        this.mImm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    @SuppressLint({"NewApi"})
    public final boolean isRestartAlwaysRequired() {
        String string;
        if (this.mImm.getCurrentInputMethodSubtype() == null || Build.VERSION.SDK_INT < 21 || !Build.MANUFACTURER.equals(ManufacturerUtils.SAMSUNG) || (string = Settings.Secure.getString(this.mView.getContext().getContentResolver(), "default_input_method")) == null) {
            return false;
        }
        return string.contains("Samsung");
    }

    public void release(View view) {
        View view2 = this.mView;
        if (view2 == null || view2.hashCode() != view.hashCode()) {
            return;
        }
        this.mView = null;
    }

    public final void setPlatformViewTextInputClient(int i2) {
        this.mView.requestFocus();
        this.inputTarget = new InputTarget(InputTarget.Type.PLATFORM_VIEW, i2);
        this.mImm.restartInput(this.mView);
        this.mRestartInputPending = false;
    }

    @VisibleForTesting
    public void setTextInputClient(int i2, TextInputChannel.Configuration configuration) {
        this.inputTarget = new InputTarget(InputTarget.Type.FRAMEWORK_CLIENT, i2);
        this.configuration = configuration;
        this.mEditable = Editable.Factory.getInstance().newEditable("");
        this.mRestartInputPending = true;
        unlockPlatformViewInputConnection();
    }

    @VisibleForTesting
    public void setTextInputEditingState(View view, TextInputChannel.TextEditState textEditState) {
        if (!this.restartAlwaysRequired && !this.mRestartInputPending && textEditState.text.equals(this.mEditable.toString())) {
            applyStateToSelection(textEditState);
            this.mImm.updateSelection(this.mView, Math.max(Selection.getSelectionStart(this.mEditable), 0), Math.max(Selection.getSelectionEnd(this.mEditable), 0), BaseInputConnection.getComposingSpanStart(this.mEditable), BaseInputConnection.getComposingSpanEnd(this.mEditable));
            return;
        }
        Editable editable = this.mEditable;
        editable.replace(0, editable.length(), textEditState.text);
        applyStateToSelection(textEditState);
        this.mImm.restartInput(view);
        this.mRestartInputPending = false;
    }

    public final void showTextInput(View view) {
        view.requestFocus();
        this.mImm.showSoftInput(view, 0);
    }

    public void unlockPlatformViewInputConnection() {
        this.isInputConnectionLocked = false;
    }

    public void updateView(View view) {
        this.mView = view;
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
        this.textInputChannel.setTextInputMethodHandler(new TextInputChannel.TextInputMethodHandler() { // from class: com.idlefish.flutterboost.XTextInputPlugin.1
            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void clearClient() {
                XTextInputPlugin.this.clearTextInputClient();
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void hide() {
                XTextInputPlugin xTextInputPlugin2 = XTextInputPlugin.this;
                xTextInputPlugin2.hideTextInput(xTextInputPlugin2.mView);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setClient(int i2, TextInputChannel.Configuration configuration) {
                XTextInputPlugin.this.setTextInputClient(i2, configuration);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setEditingState(TextInputChannel.TextEditState textEditState) {
                XTextInputPlugin xTextInputPlugin2 = XTextInputPlugin.this;
                xTextInputPlugin2.setTextInputEditingState(xTextInputPlugin2.mView, textEditState);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setPlatformViewClient(int i2) {
                XTextInputPlugin.this.setPlatformViewTextInputClient(i2);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void show() {
                XTextInputPlugin xTextInputPlugin2 = XTextInputPlugin.this;
                xTextInputPlugin2.showTextInput(xTextInputPlugin2.mView);
            }
        });
        this.restartAlwaysRequired = isRestartAlwaysRequired();
    }
}
