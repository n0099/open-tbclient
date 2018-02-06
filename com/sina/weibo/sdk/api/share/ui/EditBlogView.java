package com.sina.weibo.sdk.api.share.ui;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class EditBlogView extends EditText {
    private boolean canSelectionChanged;
    private int count;
    private Context ctx;
    private List<OnSelectionListener> listeners;
    private OnEnterListener mOnEnterListener;

    /* loaded from: classes3.dex */
    public interface OnEnterListener {
        void onEnterKey();
    }

    /* loaded from: classes3.dex */
    public interface OnSelectionListener {
        void onSelectionChanged(int i, int i2);
    }

    public EditBlogView(Context context) {
        super(context);
        this.canSelectionChanged = true;
        init();
    }

    public EditBlogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.canSelectionChanged = true;
        init();
    }

    public EditBlogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.canSelectionChanged = true;
        init();
    }

    private void init() {
        this.ctx = getContext();
        this.listeners = new ArrayList();
    }

    public void setOnSelectionListener(OnSelectionListener onSelectionListener) {
        this.listeners.add(onSelectionListener);
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (this.canSelectionChanged && this.listeners != null && !this.listeners.isEmpty()) {
            for (OnSelectionListener onSelectionListener : this.listeners) {
                onSelectionListener.onSelectionChanged(i, i2);
            }
        }
    }

    public void enableSelectionChanged(boolean z) {
        this.canSelectionChanged = z;
    }

    public void setOnEnterListener(OnEnterListener onEnterListener) {
        this.mOnEnterListener = onEnterListener;
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 66 && this.mOnEnterListener != null) {
            this.mOnEnterListener.onEnterKey();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public int correctPosition(int i) {
        Object[] spans;
        if (i != -1) {
            Editable text = getText();
            if (i < text.length() && (spans = text.getSpans(i, i, ImageSpan.class)) != null && spans.length != 0 && i != text.getSpanStart(spans[0])) {
                return text.getSpanEnd(spans[0]);
            }
            return i;
        }
        return i;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new InputConnectionWrapper(super.onCreateInputConnection(editorInfo), false) { // from class: com.sina.weibo.sdk.api.share.ui.EditBlogView.1
            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean commitText(CharSequence charSequence, int i) {
                Editable editableText = EditBlogView.this.getEditableText();
                new String(editableText.toString());
                int selectionStart = Selection.getSelectionStart(editableText);
                int selectionEnd = Selection.getSelectionEnd(editableText);
                if (selectionStart != -1 && selectionEnd != -1) {
                    int correctPosition = EditBlogView.this.correctPosition(selectionStart);
                    int correctPosition2 = EditBlogView.this.correctPosition(selectionEnd);
                    if (correctPosition <= correctPosition2) {
                        correctPosition2 = correctPosition;
                        correctPosition = correctPosition2;
                    }
                    if (correctPosition2 != selectionStart || correctPosition != selectionEnd) {
                        Selection.setSelection(editableText, correctPosition2, correctPosition);
                    }
                    if (correctPosition2 != correctPosition) {
                        EditBlogView.this.getText().delete(correctPosition2, correctPosition);
                    }
                }
                return super.commitText(charSequence, i);
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean setComposingText(CharSequence charSequence, int i) {
                Editable editableText = EditBlogView.this.getEditableText();
                new String(editableText.toString());
                int selectionStart = Selection.getSelectionStart(editableText);
                int selectionEnd = Selection.getSelectionEnd(editableText);
                if (selectionStart != -1 && selectionEnd != -1) {
                    int correctPosition = EditBlogView.this.correctPosition(selectionStart);
                    int correctPosition2 = EditBlogView.this.correctPosition(selectionEnd);
                    if (correctPosition <= correctPosition2) {
                        correctPosition2 = correctPosition;
                        correctPosition = correctPosition2;
                    }
                    if (correctPosition2 != selectionStart || correctPosition != selectionEnd) {
                        Selection.setSelection(editableText, correctPosition2, correctPosition);
                    }
                    if (correctPosition2 != correctPosition) {
                        EditBlogView.this.getText().delete(correctPosition2, correctPosition);
                    }
                }
                return super.setComposingText(charSequence, i);
            }
        };
    }
}
