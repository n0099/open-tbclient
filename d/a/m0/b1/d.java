package d.a.m0.b1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d extends ImageSpan {

    /* renamed from: e  reason: collision with root package name */
    public int f52641e;

    /* renamed from: f  reason: collision with root package name */
    public int f52642f;

    /* renamed from: g  reason: collision with root package name */
    public int f52643g;

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<Drawable> f52644h;

    public d(Drawable drawable) {
        super(drawable);
        this.f52641e = 0;
    }

    public final Drawable a() {
        WeakReference<Drawable> weakReference = this.f52644h;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.f52644h = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    public void b(int i2) {
        this.f52642f = i2;
    }

    public void c(int i2) {
        this.f52643g = i2;
    }

    public void d(int i2) {
        this.f52641e = i2;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Drawable a2 = a();
        if (a2 == null) {
            return;
        }
        canvas.save();
        canvas.translate(f2 + this.f52642f, ((((i6 - i4) - a2.getBounds().bottom) / 2) + i4) - this.f52641e);
        a2.draw(canvas);
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
        return bounds.right + this.f52642f + this.f52643g;
    }
}
