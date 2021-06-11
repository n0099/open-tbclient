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
import com.google.android.material.internal.ManufacturerUtils;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.platform.PlatformViewsController;
/* loaded from: classes7.dex */
public class TextInputPlugin {
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
    public final InputMethodManager mImm;
    public boolean mRestartInputPending;
    @NonNull
    public final View mView;
    @NonNull
    public PlatformViewsController platformViewsController;
    public final boolean restartAlwaysRequired;
    @NonNull
    public final TextInputChannel textInputChannel;

    /* loaded from: classes7.dex */
    public static class InputTarget {
        public int id;
        @NonNull
        public Type type;

        /* loaded from: classes7.dex */
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

    public TextInputPlugin(View view, @NonNull DartExecutor dartExecutor, @NonNull PlatformViewsController platformViewsController) {
        this.mView = view;
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
        TextInputChannel textInputChannel = new TextInputChannel(dartExecutor);
        this.textInputChannel = textInputChannel;
        textInputChannel.setTextInputMethodHandler(new TextInputChannel.TextInputMethodHandler() { // from class: io.flutter.plugin.editing.TextInputPlugin.1
            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void clearClient() {
                TextInputPlugin.this.clearTextInputClient();
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void hide() {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.hideTextInput(textInputPlugin.mView);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setClient(int i2, TextInputChannel.Configuration configuration) {
                TextInputPlugin.this.setTextInputClient(i2, configuration);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setEditingState(TextInputChannel.TextEditState textEditState) {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.setTextInputEditingState(textInputPlugin.mView, textEditState);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setPlatformViewClient(int i2) {
                TextInputPlugin.this.setPlatformViewTextInputClient(i2);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void show() {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.showTextInput(textInputPlugin.mView);
            }
        });
        this.textInputChannel.requestExistingInputState();
        this.platformViewsController = platformViewsController;
        platformViewsController.attachTextInputPlugin(this);
        this.restartAlwaysRequired = isRestartAlwaysRequired();
    }

    private void applyStateToSelection(TextInputChannel.TextEditState textEditState) {
        int i2 = textEditState.selectionStart;
        int i3 = textEditState.selectionEnd;
        if (i2 >= 0 && i2 <= this.mEditable.length() && i3 >= 0 && i3 <= this.mEditable.length()) {
            Selection.setSelection(this.mEditable, i2, i3);
        } else {
            Selection.removeSelection(this.mEditable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTextInputClient() {
        if (this.inputTarget.type == InputTarget.Type.PLATFORM_VIEW) {
            return;
        }
        this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
        unlockPlatformViewInputConnection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTextInput(View view) {
        this.mImm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
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

    @SuppressLint({"NewApi"})
    private boolean isRestartAlwaysRequired() {
        if (this.mImm.getCurrentInputMethodSubtype() == null || Build.VERSION.SDK_INT < 21 || !Build.MANUFACTURER.equals(ManufacturerUtils.SAMSUNG)) {
            return false;
        }
        return Settings.Secure.getString(this.mView.getContext().getContentResolver(), "default_input_method").contains("Samsung");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlatformViewTextInputClient(int i2) {
        this.mView.requestFocus();
        this.inputTarget = new InputTarget(InputTarget.Type.PLATFORM_VIEW, i2);
        this.mImm.restartInput(this.mView);
        this.mRestartInputPending = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTextInput(View view) {
        view.requestFocus();
        this.mImm.showSoftInput(view, 0);
    }

    public void clearPlatformViewClient(int i2) {
        InputTarget inputTarget = this.inputTarget;
        if (inputTarget.type == InputTarget.Type.PLATFORM_VIEW && inputTarget.id == i2) {
            this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
            hideTextInput(this.mView);
            this.mImm.restartInput(this.mView);
            this.mRestartInputPending = false;
        }
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

    public void destroy() {
        this.platformViewsController.detachTextInputPlugin();
    }

    @VisibleForTesting
    public Editable getEditable() {
        return this.mEditable;
    }

    @NonNull
    public InputMethodManager getInputMethodManager() {
        return this.mImm;
    }

    @Nullable
    public InputConnection getLastInputConnection() {
        return this.lastInputConnection;
    }

    public void lockPlatformViewInputConnection() {
        if (this.inputTarget.type == InputTarget.Type.PLATFORM_VIEW) {
            this.isInputConnectionLocked = true;
        }
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

    public void unlockPlatformViewInputConnection() {
        this.isInputConnectionLocked = false;
    }
}
