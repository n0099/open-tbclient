package com.kwad.sdk.emotion.widget;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<TextView> f35362a;

    /* renamed from: d  reason: collision with root package name */
    public int f35365d = 1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35363b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35364c = true;

    public e(@NonNull TextView textView) {
        this.f35362a = new WeakReference<>(textView);
    }

    public abstract void a(Editable editable);

    public abstract void a(Editable editable, TextView textView, int i2, int i3);

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
