package com.idlefish.flutterboost;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.platform.PlatformViewsController;
/* loaded from: classes6.dex */
public class XTextInputPlugin {
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
    private final InputMethodManager mImm;
    private boolean mRestartInputPending;
    @NonNull
    private View mView;
    @NonNull
    private PlatformViewsController platformViewsController;
    @NonNull
    private final TextInputChannel textInputChannel;

    public XTextInputPlugin(View view, @NonNull TextInputChannel textInputChannel, @NonNull PlatformViewsController platformViewsController) {
        this.mView = view;
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
        this.textInputChannel = textInputChannel;
        this.platformViewsController = platformViewsController;
    }

    public void release() {
        this.mView = null;
    }

    public void setTextInputMethodHandler() {
        this.textInputChannel.setTextInputMethodHandler(new TextInputChannel.TextInputMethodHandler() { // from class: com.idlefish.flutterboost.XTextInputPlugin.1
            public void show() {
                XTextInputPlugin.this.showTextInput(XTextInputPlugin.this.mView);
            }

            public void hide() {
                XTextInputPlugin.this.hideTextInput(XTextInputPlugin.this.mView);
            }

            public void setClient(int i, TextInputChannel.Configuration configuration) {
                XTextInputPlugin.this.setTextInputClient(i, configuration);
            }

            public void setPlatformViewClient(int i) {
                XTextInputPlugin.this.setPlatformViewTextInputClient(i);
            }

            public void setEditingState(TextInputChannel.TextEditState textEditState) {
                XTextInputPlugin.this.setTextInputEditingState(XTextInputPlugin.this.mView, textEditState);
            }

            public void clearClient() {
                XTextInputPlugin.this.clearTextInputClient();
            }
        });
    }

    @NonNull
    public InputMethodManager getInputMethodManager() {
        return this.mImm;
    }

    public void unlockPlatformViewInputConnection() {
        this.isInputConnectionLocked = false;
    }

    private static int inputTypeFromTextInputType(TextInputChannel.InputType inputType, boolean z, boolean z2, TextInputChannel.TextCapitalization textCapitalization) {
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
            } else if (z2) {
                i2 |= 32768;
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
            this.lastInputConnection = this.platformViewsController.getPlatformViewById(Integer.valueOf(this.inputTarget.id)).onCreateInputConnection(editorInfo);
            return this.lastInputConnection;
        } else {
            editorInfo.inputType = inputTypeFromTextInputType(this.configuration.inputType, this.configuration.obscureText, this.configuration.autocorrect, this.configuration.textCapitalization);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextInputClient(int i, TextInputChannel.Configuration configuration) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextInputEditingState(View view, TextInputChannel.TextEditState textEditState) {
        if (!this.mRestartInputPending && textEditState.text.equals(this.mEditable.toString())) {
            applyStateToSelection(textEditState);
            this.mImm.updateSelection(this.mView, Math.max(Selection.getSelectionStart(this.mEditable), 0), Math.max(Selection.getSelectionEnd(this.mEditable), 0), BaseInputConnection.getComposingSpanStart(this.mEditable), BaseInputConnection.getComposingSpanEnd(this.mEditable));
            return;
        }
        this.mEditable.replace(0, this.mEditable.length(), textEditState.text);
        applyStateToSelection(textEditState);
        this.mImm.restartInput(view);
        this.mRestartInputPending = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTextInputClient() {
        if (this.inputTarget.type != InputTarget.Type.PLATFORM_VIEW) {
            this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
            unlockPlatformViewInputConnection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class InputTarget {
        int id;
        @NonNull
        Type type;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
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
