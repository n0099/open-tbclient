package com.idlefish.flutterboost;

import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
/* loaded from: classes5.dex */
class XInputConnectionAdaptor extends BaseInputConnection {
    private int mBatchCount;
    private final int mClient;
    private final Editable mEditable;
    private final View mFlutterView;
    private InputMethodManager mImm;
    private final Layout mLayout;
    private final TextInputChannel textInputChannel;

    public XInputConnectionAdaptor(View view, int i, TextInputChannel textInputChannel, Editable editable) {
        super(view, true);
        this.mFlutterView = view;
        this.mClient = i;
        this.textInputChannel = textInputChannel;
        this.mEditable = editable;
        this.mBatchCount = 0;
        this.mLayout = new DynamicLayout(this.mEditable, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
    }

    private void updateEditingState() {
        if (this.mBatchCount <= 0) {
            int selectionStart = Selection.getSelectionStart(this.mEditable);
            int selectionEnd = Selection.getSelectionEnd(this.mEditable);
            int composingSpanStart = BaseInputConnection.getComposingSpanStart(this.mEditable);
            int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(this.mEditable);
            this.mImm.updateSelection(this.mFlutterView, selectionStart, selectionEnd, composingSpanStart, composingSpanEnd);
            this.textInputChannel.updateEditingState(this.mClient, this.mEditable.toString(), selectionStart, selectionEnd, composingSpanStart, composingSpanEnd);
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection
    public Editable getEditable() {
        return this.mEditable;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        this.mBatchCount++;
        return super.beginBatchEdit();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        boolean endBatchEdit = super.endBatchEdit();
        this.mBatchCount--;
        updateEditingState();
        return endBatchEdit;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        boolean commitText = super.commitText(charSequence, i);
        updateEditingState();
        return commitText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i, int i2) {
        if (Selection.getSelectionStart(this.mEditable) == -1) {
            return true;
        }
        boolean deleteSurroundingText = super.deleteSurroundingText(i, i2);
        updateEditingState();
        return deleteSurroundingText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i, int i2) {
        boolean composingRegion = super.setComposingRegion(i, i2);
        updateEditingState();
        return composingRegion;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i) {
        boolean composingText;
        if (charSequence.length() == 0) {
            composingText = super.commitText(charSequence, i);
        } else {
            composingText = super.setComposingText(charSequence, i);
        }
        updateEditingState();
        return composingText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setSelection(int i, int i2) {
        boolean selection = super.setSelection(i, i2);
        updateEditingState();
        return selection;
    }

    private static int clampIndexToEditable(int i, Editable editable) {
        int max = Math.max(0, Math.min(editable.length(), i));
        if (max != i) {
            Log.d("flutter", "Text selection index was clamped (" + i + PerfFrameTrackUIUtil.SEPERATOR_ARROR + max + ") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
        }
        return max;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 67) {
                int clampIndexToEditable = clampIndexToEditable(Selection.getSelectionStart(this.mEditable), this.mEditable);
                int clampIndexToEditable2 = clampIndexToEditable(Selection.getSelectionEnd(this.mEditable), this.mEditable);
                if (clampIndexToEditable2 > clampIndexToEditable) {
                    Selection.setSelection(this.mEditable, clampIndexToEditable);
                    this.mEditable.delete(clampIndexToEditable, clampIndexToEditable2);
                    updateEditingState();
                    return true;
                } else if (clampIndexToEditable > 0) {
                    try {
                        if (this.mLayout.isRtlCharAt(this.mLayout.getLineForOffset(clampIndexToEditable))) {
                            Selection.extendRight(this.mEditable, this.mLayout);
                        } else {
                            Selection.extendLeft(this.mEditable, this.mLayout);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        Selection.setSelection(this.mEditable, clampIndexToEditable, clampIndexToEditable - 1);
                    }
                    int clampIndexToEditable3 = clampIndexToEditable(Selection.getSelectionStart(this.mEditable), this.mEditable);
                    int clampIndexToEditable4 = clampIndexToEditable(Selection.getSelectionEnd(this.mEditable), this.mEditable);
                    Selection.setSelection(this.mEditable, Math.min(clampIndexToEditable3, clampIndexToEditable4));
                    this.mEditable.delete(Math.min(clampIndexToEditable3, clampIndexToEditable4), Math.max(clampIndexToEditable3, clampIndexToEditable4));
                    updateEditingState();
                    return true;
                }
            } else if (keyEvent.getKeyCode() == 21) {
                int max = Math.max(Selection.getSelectionStart(this.mEditable) - 1, 0);
                setSelection(max, max);
                return true;
            } else if (keyEvent.getKeyCode() == 22) {
                int min = Math.min(Selection.getSelectionStart(this.mEditable) + 1, this.mEditable.length());
                setSelection(min, min);
                return true;
            } else {
                int unicodeChar = keyEvent.getUnicodeChar();
                if (unicodeChar != 0) {
                    int max2 = Math.max(0, Selection.getSelectionStart(this.mEditable));
                    int max3 = Math.max(0, Selection.getSelectionEnd(this.mEditable));
                    if (max3 != max2) {
                        this.mEditable.delete(max2, max3);
                    }
                    this.mEditable.insert(max2, String.valueOf((char) unicodeChar));
                    setSelection(max2 + 1, max2 + 1);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i) {
        switch (i) {
            case 0:
                this.textInputChannel.unspecifiedAction(this.mClient);
                return true;
            case 1:
                this.textInputChannel.newline(this.mClient);
                return true;
            case 2:
                this.textInputChannel.go(this.mClient);
                return true;
            case 3:
                this.textInputChannel.search(this.mClient);
                return true;
            case 4:
                this.textInputChannel.send(this.mClient);
                return true;
            case 5:
                this.textInputChannel.next(this.mClient);
                return true;
            case 6:
            default:
                this.textInputChannel.done(this.mClient);
                return true;
            case 7:
                this.textInputChannel.previous(this.mClient);
                return true;
        }
    }
}
