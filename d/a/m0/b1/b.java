package d.a.m0.b1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class b extends ImageSpan {

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Drawable> f52629e;

    /* renamed from: f  reason: collision with root package name */
    public int f52630f;

    /* renamed from: g  reason: collision with root package name */
    public int f52631g;

    public b(Drawable drawable, int i2) {
        super(drawable);
        this.f52630f = 0;
        this.f52631g = 1;
        this.f52631g = i2;
    }

    public final Drawable a() {
        WeakReference<Drawable> weakReference = this.f52629e;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.f52629e = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Drawable a2 = a();
        if (a2 == null) {
            return;
        }
        int i7 = this.f52631g;
        float f3 = i7 != 0 ? i7 != 1 ? i7 != 2 ? 0.0f : 0.2f : 0.15f : 0.1f;
        float height = f3 != 0.0f ? ((i5 - i6) + (a2.getBounds().height() * f3)) - this.f52630f : 0.0f;
        canvas.save();
        canvas.translate(a2.getBounds().width() * 0.15f, height);
        super.draw(canvas, charSequence, i2, i3, f2, i4, i5, i6, paint);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        Drawable a2 = a();
        if (a2 == null) {
            return super.getSize(paint, charSequence, i2, i3, fontMetricsInt);
        }
        Rect bounds = a2.getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i4 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i5 = (bounds.bottom - bounds.top) / 2;
            int i6 = i4 / 4;
            int i7 = i5 - i6;
            int i8 = -(i5 + i6);
            fontMetricsInt.ascent = i8;
            fontMetricsInt.top = i8;
            fontMetricsInt.bottom = i7;
            fontMetricsInt.descent = i7;
        }
        return bounds.right;
    }
}
