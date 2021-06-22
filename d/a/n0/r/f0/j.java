package d.a.n0.r.f0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class j extends h {

    /* renamed from: e  reason: collision with root package name */
    public int f53523e;

    /* renamed from: f  reason: collision with root package name */
    public int f53524f;

    /* renamed from: g  reason: collision with root package name */
    public int f53525g;

    public j(Drawable drawable, int i2, int i3, int i4) {
        super(drawable, i2);
        this.f53523e = 0;
        this.f53524f = 0;
        this.f53525g = 0;
        this.f53523e = i3;
        this.f53524f = i4;
    }

    @Override // d.a.n0.r.f0.h, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.f53525g);
        super.draw(canvas, charSequence, i2, i3, f2 + this.f53523e, i4, i5, i6, paint);
        canvas.restore();
    }

    @Override // d.a.n0.r.f0.h, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        if (this.f53523e == 0 && this.f53524f == 0) {
            return super.getSize(paint, charSequence, i2, i3, fontMetricsInt);
        }
        return getDrawable().getBounds().width() + this.f53523e + this.f53524f;
    }
}
