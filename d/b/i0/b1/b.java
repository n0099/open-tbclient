package d.b.i0.b1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class b extends ImageSpan {

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Drawable> f50546e;

    /* renamed from: f  reason: collision with root package name */
    public int f50547f;

    /* renamed from: g  reason: collision with root package name */
    public int f50548g;

    public b(Drawable drawable, int i) {
        super(drawable);
        this.f50547f = 0;
        this.f50548g = 1;
        this.f50548g = i;
    }

    public final Drawable a() {
        WeakReference<Drawable> weakReference = this.f50546e;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.f50546e = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        Drawable a2 = a();
        if (a2 == null) {
            return;
        }
        int i6 = this.f50548g;
        float f3 = i6 != 0 ? i6 != 1 ? i6 != 2 ? 0.0f : 0.2f : 0.15f : 0.1f;
        float height = f3 != 0.0f ? ((i4 - i5) + (a2.getBounds().height() * f3)) - this.f50547f : 0.0f;
        canvas.save();
        canvas.translate(a2.getBounds().width() * 0.15f, height);
        super.draw(canvas, charSequence, i, i2, f2, i3, i4, i5, paint);
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
        return bounds.right;
    }
}
