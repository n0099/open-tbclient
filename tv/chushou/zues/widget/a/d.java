package tv.chushou.zues.widget.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
/* loaded from: classes6.dex */
public class d extends ReplacementSpan {
    private int ixp;
    private Context mContext;

    public d(Context context, int i) {
        this.mContext = context;
        this.ixp = i;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (int) b(paint).measureText(charSequence.subSequence(i, i2).toString());
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        CharSequence subSequence = charSequence.subSequence(i, i2);
        TextPaint b = b(paint);
        Paint.FontMetricsInt fontMetricsInt = b.getFontMetricsInt();
        canvas.drawText(subSequence.toString(), f, i4 - (((fontMetricsInt.ascent + ((fontMetricsInt.descent + i4) + i4)) / 2) - ((i5 + i3) / 2)), b);
    }

    private TextPaint b(Paint paint) {
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setTextSize(h(this.mContext, this.ixp));
        return textPaint;
    }

    public static int h(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }
}
