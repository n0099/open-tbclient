package com.kwad.sdk.emotion.widget;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<TextView> f35089a;

    /* renamed from: d  reason: collision with root package name */
    public int f35092d = 1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35090b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35091c = true;

    public e(@NonNull TextView textView) {
        this.f35089a = new WeakReference<>(textView);
    }

    public abstract void a(Editable editable);

    public abstract void a(Editable editable, TextView textView, int i, int i2);

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
