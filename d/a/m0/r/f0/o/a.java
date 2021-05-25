package d.a.m0.r.f0.o;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.util.SkinManager;
/* loaded from: classes3.dex */
public class a extends ReplacementSpan {

    /* renamed from: e  reason: collision with root package name */
    public int f49754e;

    /* renamed from: f  reason: collision with root package name */
    public int f49755f;

    /* renamed from: g  reason: collision with root package name */
    public int f49756g;

    /* renamed from: h  reason: collision with root package name */
    public int f49757h;

    /* renamed from: i  reason: collision with root package name */
    public int f49758i;
    public int j;
    public int k;
    public int l;
    public int m = 0;

    public a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f49755f = i2;
        this.f49756g = i3;
        this.f49757h = i4;
        this.f49758i = i5;
        this.j = i6;
        this.k = i7;
        this.l = i8;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        float textSize = paint.getTextSize();
        int color = paint.getColor();
        float f3 = f2 + this.l;
        paint.setTextSize(this.f49757h);
        paint.setColor(SkinManager.getColor(this.f49755f));
        paint.setAntiAlias(true);
        int i7 = i4 + i6;
        int i8 = this.f49757h;
        int i9 = this.f49756g;
        int i10 = this.k;
        RectF rectF = new RectF(f3, (((i7 - i8) - i9) - i10) / 2, (this.f49754e + f3) - this.m, (((i7 + i8) + i9) + i10) / 2);
        int i11 = this.f49756g;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        paint.setColor(SkinManager.getColor(this.f49758i));
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        canvas.drawText(charSequence, i2, i3, f3 + this.f49756g + this.j, (int) ((rectF.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), paint);
        paint.setTextSize(textSize);
        paint.setColor(color);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        float textSize = paint.getTextSize();
        paint.setTextSize(this.f49757h);
        this.f49754e = (int) (paint.measureText(charSequence, i2, i3) + (this.f49756g * 2) + (this.j * 2) + this.m);
        paint.setTextSize(textSize);
        return this.f49754e;
    }
}
