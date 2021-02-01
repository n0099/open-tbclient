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
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.platform.PlatformViewsController;
/* loaded from: classes5.dex */
public class XTextInputPlugin {
    private static XTextInputPlugin xTextInputPlugin;
    @Nullable
    private TextInputChannel.Configuration configuration;
    @NonNull
    private InputTarget inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
    private boolean isInputConnectionLocked;
    @Nullable
    private InputConnection lastInputConnection;
    @Nullable
    private Editable mEditable;
    @NonNull
    private InputMethodManager mImm;
    private boolean mRestartInputPending;
    @NonNull
    private View mView;
    @NonNull
    private PlatformViewsController platformViewsController;
    private boolean restartAlwaysRequired;
    @NonNull
    private TextInputChannel textInputChannel;

    public static XTextInputPlugin getTextInputPlugin(DartExecutor dartExecutor, @NonNull PlatformViewsController platformViewsController) {
        if (xTextInputPlugin != null) {
            return xTextInputPlugin;
        }
        xTextInputPlugin = new XTextInputPlugin(dartExecutor, platformViewsController);
        return xTextInputPlugin;
    }

    public XTextInputPlugin(@NonNull DartExecutor dartExecutor, @NonNull PlatformViewsController platformViewsController) {
        this.textInputChannel = new TextInputChannel(dartExecutor);
        this.textInputChannel.requestExistingInputState();
        this.platformViewsController = platformViewsController;
    }

    public void release(View view) {
        if (this.mView != null && this.mView.hashCode() == view.hashCode()) {
            this.mView = null;
        }
    }

    public void updateView(View view) {
        this.mView = view;
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
        this.textInputChannel.setTextInputMethodHandler(new TextInputChannel.TextInputMethodHandler() { // from class: com.idlefish.flutterboost.XTextInputPlugin.1
            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void show() {
                XTextInputPlugin.this.showTextInput(XTextInputPlugin.this.mView);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void hide() {
                XTextInputPlugin.this.hideTextInput(XTextInputPlugin.this.mView);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setClient(int i, TextInputChannel.Configuration configuration) {
                XTextInputPlugin.this.setTextInputClient(i, configuration);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setPlatformViewClient(int i) {
                XTextInputPlugin.this.setPlatformViewTextInputClient(i);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setEditingState(TextInputChannel.TextEditState textEditState) {
                XTextInputPlugin.this.setTextInputEditingState(XTextInputPlugin.this.mView, textEditState);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void clearClient() {
                XTextInputPlugin.this.clearTextInputClient();
            }
        });
        this.restartAlwaysRequired = isRestartAlwaysRequired();
    }

    @NonNull
    public InputMethodManager getInputMethodManager() {
        return this.mImm;
    }

    public void unlockPlatformViewInputConnection() {
        this.isInputConnectionLocked = false;
    }

    private static int inputTypeFromTextInputType(TextInputChannel.InputType inputType, boolean z, boolean z2, boolean z3, TextInputChannel.TextCapitalization textCapitalization) {
        if (inputType.type == TextInputChannel.TextInputType.DATETIME) {
            return 4;
        }
        if (inputType.type == TextInputChannel.TextInputType.NUMBER) {
            int i = 2;
            if (inputType.isSigned) {
                i = 4098;
            }
            if (inputType.isDecimal) {
                return i | 8192;
            }
            return i;
        } else if (inputType.type == TextInputChannel.TextInputType.PHONE) {
            return 3;
        } else {
            int i2 = 1;
            if (inputType.type == TextInputChannel.TextInputType.MULTILINE) {
                i2 = 131073;
            } else if (inputType.type == TextInputChannel.TextInputType.EMAIL_ADDRESS) {
                i2 = 33;
            } else if (inputType.type == TextInputChannel.TextInputType.URL) {
                i2 = 17;
            } else if (inputType.type == TextInputChannel.TextInputType.VISIBLE_PASSWORD) {
                i2 = 145;
            }
            if (z) {
                i2 = i2 | 524288 | 128;
            } else {
                if (z2) {
                    i2 |= 32768;
                }
                if (!z3) {
                    i2 |= 524288;
                }
            }
            if (textCapitalization == TextInputChannel.TextCapitalization.CHARACTERS) {
                return i2 | 4096;
            }
            if (textCapitalization == TextInputChannel.TextCapitalization.WORDS) {
                return i2 | 8192;
            }
            if (textCapitalization == TextInputChannel.TextCapitalization.SENTENCES) {
                return i2 | 16384;
            }
            return i2;
        }
    }

    public InputConnection createInputConnection(View view, EditorInfo editorInfo) {
        int intValue;
        if (this.inputTarget.type == InputTarget.Type.NO_TARGET) {
            this.lastInputConnection = null;
            return null;
        } else if (this.inputTarget.type == InputTarget.Type.PLATFORM_VIEW) {
            if (this.isInputConnectionLocked) {
                return this.lastInputConnection;
            }
            if (this.platformViewsController != null && this.platformViewsController.getPlatformViewById(Integer.valueOf(this.inputTarget.id)) != null) {
                this.lastInputConnection = this.platformViewsController.getPlatformViewById(Integer.valueOf(this.inputTarget.id)).onCreateInputConnection(editorInfo);
            }
            return this.lastInputConnection;
        } else {
            editorInfo.inputType = inputTypeFromTextInputType(this.configuration.inputType, this.configuration.obscureText, this.configuration.autocorrect, this.configuration.enableSuggestions, this.configuration.textCapitalization);
            editorInfo.imeOptions = 33554432;
            if (this.configuration.inputAction == null) {
                intValue = (131072 & editorInfo.inputType) != 0 ? 1 : 6;
            } else {
                intValue = this.configuration.inputAction.intValue();
            }
            if (this.configuration.actionLabel != null) {
                editorInfo.actionLabel = this.configuration.actionLabel;
                editorInfo.actionId = intValue;
            }
            editorInfo.imeOptions = intValue | editorInfo.imeOptions;
            XInputConnectionAdaptor xInputConnectionAdaptor = new XInputConnectionAdaptor(view, this.inputTarget.id, this.textInputChannel, this.mEditable);
            editorInfo.initialSelStart = Selection.getSelectionStart(this.mEditable);
            editorInfo.initialSelEnd = Selection.getSelectionEnd(this.mEditable);
            this.lastInputConnection = xInputConnectionAdaptor;
            return this.lastInputConnection;
        }
    }

    @Nullable
    public InputConnection getLastInputConnection() {
        return this.lastInputConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTextInput(View view) {
        view.requestFocus();
        this.mImm.showSoftInput(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTextInput(View view) {
        this.mImm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    @VisibleForTesting
    void setTextInputClient(int i, TextInputChannel.Configuration configuration) {
        this.inputTarget = new InputTarget(InputTarget.Type.FRAMEWORK_CLIENT, i);
        this.configuration = configuration;
        this.mEditable = Editable.Factory.getInstance().newEditable("");
        this.mRestartInputPending = true;
        unlockPlatformViewInputConnection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlatformViewTextInputClient(int i) {
        this.mView.requestFocus();
        this.inputTarget = new InputTarget(InputTarget.Type.PLATFORM_VIEW, i);
        this.mImm.restartInput(this.mView);
        this.mRestartInputPending = false;
    }

    private void applyStateToSelection(TextInputChannel.TextEditState textEditState) {
        int i = textEditState.selectionStart;
        int i2 = textEditState.selectionEnd;
        if (i >= 0 && i <= this.mEditable.length() && i2 >= 0 && i2 <= this.mEditable.length()) {
            Selection.setSelection(this.mEditable, i, i2);
        } else {
            Selection.removeSelection(this.mEditable);
        }
    }

    @VisibleForTesting
    void setTextInputEditingState(View view, TextInputChannel.TextEditState textEditState) {
        if (!this.restartAlwaysRequired && !this.mRestartInputPending && textEditState.text.equals(this.mEditable.toString())) {
            applyStateToSelection(textEditState);
            this.mImm.updateSelection(this.mView, Math.max(Selection.getSelectionStart(this.mEditable), 0), Math.max(Selection.getSelectionEnd(this.mEditable), 0), BaseInputConnection.getComposingSpanStart(this.mEditable), BaseInputConnection.getComposingSpanEnd(this.mEditable));
            return;
        }
        this.mEditable.replace(0, this.mEditable.length(), textEditState.text);
        applyStateToSelection(textEditState);
        this.mImm.restartInput(view);
        this.mRestartInputPending = false;
    }

    @SuppressLint({"NewApi"})
    private boolean isRestartAlwaysRequired() {
        String string;
        if (this.mImm.getCurrentInputMethodSubtype() == null || Build.VERSION.SDK_INT < 21 || !Build.MANUFACTURER.equals("samsung") || (string = Settings.Secure.getString(this.mView.getContext().getContentResolver(), "default_input_method")) == null) {
            return false;
        }
        return string.contains("Samsung");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTextInputClient() {
        if (this.inputTarget.type != InputTarget.Type.PLATFORM_VIEW) {
            this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
            unlockPlatformViewInputConnection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class InputTarget {
        int id;
        @NonNull
        Type type;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public enum Type {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            PLATFORM_VIEW
        }

        public InputTarget(@NonNull Type type, int i) {
            this.type = type;
            this.id = i;
        }
    }
}
