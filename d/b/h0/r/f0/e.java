package d.b.h0.r.f0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
/* loaded from: classes3.dex */
public class e extends ImageSpan {

    /* renamed from: e  reason: collision with root package name */
    public int f50503e;

    /* renamed from: f  reason: collision with root package name */
    public int f50504f;

    public e(Drawable drawable, int i) {
        super(drawable, i);
        this.f50503e = 0;
        this.f50504f = 2;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        super.draw(canvas, charSequence, i, i2, f2 + this.f50503e, i3, i4, i5, paint);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return super.getSize(paint, charSequence, i, i2, fontMetricsInt) + this.f50503e + this.f50504f;
    }
}
