package com.kwad.sdk.emotion.widget;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    protected final WeakReference<TextView> f10066a;
    private int d = 1;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f10067b = false;
    protected boolean c = true;

    public e(@NonNull TextView textView) {
        this.f10066a = new WeakReference<>(textView);
    }

    public abstract void a(Editable editable);

    protected abstract void a(Editable editable, TextView textView, int i, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(CharSequence charSequence) {
        ImageSpan[] imageSpanArr;
        String charSequence2 = charSequence.toString();
        if (charSequence instanceof Spanned) {
            Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
            for (ImageSpan imageSpan : (ImageSpan[]) spannableString.getSpans(0, spannableString.length(), ImageSpan.class)) {
                int spanStart = spannableString.getSpanStart(imageSpan);
                if (spanStart > spannableString.length() - 1 || spannableString.getSpanEnd(imageSpan) > spannableString.length() || (imageSpan.getSource() != null && charSequence2.indexOf(imageSpan.getSource(), spanStart) != spannableString.getSpanStart(imageSpan))) {
                    spannableString.removeSpan(imageSpan);
                }
            }
        }
    }

    public boolean a() {
        return true;
    }
}
