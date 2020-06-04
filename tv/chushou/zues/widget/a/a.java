package tv.chushou.zues.widget.a;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
/* loaded from: classes5.dex */
public class a extends ClickableSpan {
    private tv.chushou.zues.a nSx;

    public a(tv.chushou.zues.a aVar) {
        this.nSx = aVar;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (this.nSx != null) {
            this.nSx.onClick(view);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
    }
}
