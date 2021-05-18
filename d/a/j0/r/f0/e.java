package d.a.j0.r.f0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
/* loaded from: classes3.dex */
public class e extends ImageSpan {

    /* renamed from: e  reason: collision with root package name */
    public int f49685e;

    /* renamed from: f  reason: collision with root package name */
    public int f49686f;

    public e(Drawable drawable, int i2) {
        super(drawable, i2);
        this.f49685e = 0;
        this.f49686f = 2;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        super.draw(canvas, charSequence, i2, i3, f2 + this.f49685e, i4, i5, i6, paint);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        return super.getSize(paint, charSequence, i2, i3, fontMetricsInt) + this.f49685e + this.f49686f;
    }
}
