package d.b.h0.r.f0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class j extends h {

    /* renamed from: e  reason: collision with root package name */
    public int f50515e;

    /* renamed from: f  reason: collision with root package name */
    public int f50516f;

    /* renamed from: g  reason: collision with root package name */
    public int f50517g;

    public j(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        this.f50515e = 0;
        this.f50516f = 0;
        this.f50517g = 0;
        this.f50515e = i2;
        this.f50516f = i3;
    }

    @Override // d.b.h0.r.f0.h, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.f50517g);
        super.draw(canvas, charSequence, i, i2, f2 + this.f50515e, i3, i4, i5, paint);
        canvas.restore();
    }

    @Override // d.b.h0.r.f0.h, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.f50515e == 0 && this.f50516f == 0) {
            return super.getSize(paint, charSequence, i, i2, fontMetricsInt);
        }
        return getDrawable().getBounds().width() + this.f50515e + this.f50516f;
    }
}
