package d.b.h0.r.f0.o;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.util.SkinManager;
/* loaded from: classes3.dex */
public class a extends ReplacementSpan {

    /* renamed from: e  reason: collision with root package name */
    public int f50934e;

    /* renamed from: f  reason: collision with root package name */
    public int f50935f;

    /* renamed from: g  reason: collision with root package name */
    public int f50936g;

    /* renamed from: h  reason: collision with root package name */
    public int f50937h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m = 0;

    public a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f50935f = i;
        this.f50936g = i2;
        this.f50937h = i3;
        this.i = i4;
        this.j = i5;
        this.k = i6;
        this.l = i7;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        float textSize = paint.getTextSize();
        int color = paint.getColor();
        float f3 = f2 + this.l;
        paint.setTextSize(this.f50937h);
        paint.setColor(SkinManager.getColor(this.f50935f));
        paint.setAntiAlias(true);
        int i6 = i3 + i5;
        int i7 = this.f50937h;
        int i8 = this.f50936g;
        int i9 = this.k;
        RectF rectF = new RectF(f3, (((i6 - i7) - i8) - i9) / 2, (this.f50934e + f3) - this.m, (((i6 + i7) + i8) + i9) / 2);
        int i10 = this.f50936g;
        canvas.drawRoundRect(rectF, i10, i10, paint);
        paint.setColor(SkinManager.getColor(this.i));
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        canvas.drawText(charSequence, i, i2, f3 + this.f50936g + this.j, (int) ((rectF.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), paint);
        paint.setTextSize(textSize);
        paint.setColor(color);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        float textSize = paint.getTextSize();
        paint.setTextSize(this.f50937h);
        this.f50934e = (int) (paint.measureText(charSequence, i, i2) + (this.f50936g * 2) + (this.j * 2) + this.m);
        paint.setTextSize(textSize);
        return this.f50934e;
    }
}
