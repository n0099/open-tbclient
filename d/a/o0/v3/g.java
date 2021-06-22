package d.a.o0.v3;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
/* loaded from: classes5.dex */
public abstract class g extends ClickableSpan {

    /* renamed from: e  reason: collision with root package name */
    public boolean f66224e;

    public abstract void a(TextPaint textPaint, boolean z);

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        a(textPaint, this.f66224e);
        textPaint.setUnderlineText(false);
        textPaint.clearShadowLayer();
    }
}
