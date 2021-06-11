package d.a.n0.v3;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
/* loaded from: classes5.dex */
public abstract class g extends ClickableSpan {

    /* renamed from: e  reason: collision with root package name */
    public boolean f66099e;

    public abstract void a(TextPaint textPaint, boolean z);

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        a(textPaint, this.f66099e);
        textPaint.setUnderlineText(false);
        textPaint.clearShadowLayer();
    }
}
