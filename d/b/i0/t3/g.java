package d.b.i0.t3;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
/* loaded from: classes5.dex */
public abstract class g extends ClickableSpan {

    /* renamed from: e  reason: collision with root package name */
    public boolean f61170e;

    public abstract void a(TextPaint textPaint, boolean z);

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        a(textPaint, this.f61170e);
        textPaint.setUnderlineText(false);
        textPaint.clearShadowLayer();
    }
}
