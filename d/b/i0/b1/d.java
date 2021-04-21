package d.b.i0.b1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d extends ImageSpan {

    /* renamed from: e  reason: collision with root package name */
    public int f50557e;

    /* renamed from: f  reason: collision with root package name */
    public int f50558f;

    /* renamed from: g  reason: collision with root package name */
    public int f50559g;

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<Drawable> f50560h;

    public d(Drawable drawable) {
        super(drawable);
        this.f50557e = 0;
    }

    public final Drawable a() {
        WeakReference<Drawable> weakReference = this.f50560h;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.f50560h = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    public void b(int i) {
        this.f50558f = i;
    }

    public void c(int i) {
        this.f50559g = i;
    }

    public void d(int i) {
        this.f50557e = i;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        Drawable a2 = a();
        if (a2 == null) {
            return;
        }
        canvas.save();
        canvas.translate(f2 + this.f50558f, ((((i5 - i3) - a2.getBounds().bottom) / 2) + i3) - this.f50557e);
        a2.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Drawable a2 = a();
        if (a2 == null) {
            return super.getSize(paint, charSequence, i, i2, fontMetricsInt);
        }
        Rect bounds = a2.getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i4 = (bounds.bottom - bounds.top) / 2;
            int i5 = i3 / 4;
            int i6 = i4 - i5;
            int i7 = -(i4 + i5);
            fontMetricsInt.ascent = i7;
            fontMetricsInt.top = i7;
            fontMetricsInt.bottom = i6;
            fontMetricsInt.descent = i6;
        }
        return bounds.right + this.f50558f + this.f50559g;
    }
}
