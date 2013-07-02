package com.mofamulu.tieba.tail;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.mofamulu.tieba.ch.bf;
/* loaded from: classes.dex */
class aw implements TextWatcher {
    private final /* synthetic */ EditText a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(EditText editText) {
        this.a = editText;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String editable2 = editable.toString();
        if (editable2.contains("  ")) {
            int selectionStart = this.a.getSelectionStart();
            String b = bf.b(editable2, "  ", "\u3000");
            this.a.setText(b);
            int i = selectionStart - 1;
            if (i > 0 && i < b.length()) {
                this.a.setSelection(i);
            } else {
                this.a.setSelection(b.length() - 1);
            }
        }
    }
}
