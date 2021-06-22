package d.a.n0.r.f0.p;

import android.text.Editable;
import android.text.SpannableStringBuilder;
/* loaded from: classes3.dex */
public class b extends Editable.Factory {

    /* renamed from: a  reason: collision with root package name */
    public c f53556a;

    public b(c cVar) {
        this.f53556a = cVar;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.setSpan(this.f53556a, 0, charSequence.length(), 18);
        return spannableStringBuilder;
    }
}
