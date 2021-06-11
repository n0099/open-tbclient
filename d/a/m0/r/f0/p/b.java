package d.a.m0.r.f0.p;

import android.text.Editable;
import android.text.SpannableStringBuilder;
/* loaded from: classes3.dex */
public class b extends Editable.Factory {

    /* renamed from: a  reason: collision with root package name */
    public c f53449a;

    public b(c cVar) {
        this.f53449a = cVar;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.setSpan(this.f53449a, 0, charSequence.length(), 18);
        return spannableStringBuilder;
    }
}
