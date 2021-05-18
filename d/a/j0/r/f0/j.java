package d.a.j0.r.f0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class j extends h {

    /* renamed from: e  reason: collision with root package name */
    public int f49697e;

    /* renamed from: f  reason: collision with root package name */
    public int f49698f;

    /* renamed from: g  reason: collision with root package name */
    public int f49699g;

    public j(Drawable drawable, int i2, int i3, int i4) {
        super(drawable, i2);
        this.f49697e = 0;
        this.f49698f = 0;
        this.f49699g = 0;
        this.f49697e = i3;
        this.f49698f = i4;
    }

    @Override // d.a.j0.r.f0.h, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.f49699g);
        super.draw(canvas, charSequence, i2, i3, f2 + this.f49697e, i4, i5, i6, paint);
        canvas.restore();
    }

    @Override // d.a.j0.r.f0.h, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        if (this.f49697e == 0 && this.f49698f == 0) {
            return super.getSize(paint, charSequence, i2, i3, fontMetricsInt);
        }
        return getDrawable().getBounds().width() + this.f49697e + this.f49698f;
    }
}
