package com.kwad.sdk.emotion.widget;

import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class d extends e {
    public d(@NonNull TextView textView) {
        super(textView);
    }

    @Override // com.kwad.sdk.emotion.widget.e
    public void a(Editable editable) {
        TextView textView = this.f9768a.get();
        if (editable == null) {
            return;
        }
        int length = editable.length();
        this.f9769b = true;
        try {
            a((CharSequence) editable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (a()) {
            a(editable, textView, 0, length);
        }
        try {
            if (textView instanceof EditText) {
                ((EditText) textView).setSelection(textView.getSelectionStart(), textView.getSelectionEnd());
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f9769b = false;
    }

    @Override // com.kwad.sdk.emotion.widget.e
    protected void a(Editable editable, TextView textView, int i, int i2) {
        a.a(textView, i, i2, false);
    }
}
