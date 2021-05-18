package d.a.k0.k0.d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class a extends ImageSpan {

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Drawable> f56993e;

    /* renamed from: f  reason: collision with root package name */
    public int f56994f;

    public a(@NonNull Drawable drawable, int i2) {
        super(drawable, i2);
    }

    public final Drawable a() {
        WeakReference<Drawable> weakReference = this.f56993e;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.f56993e = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Drawable a2 = a();
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i7 = fontMetricsInt.descent;
        canvas.translate(f2, ((i5 + i7) - ((i7 - fontMetricsInt.ascent) / 2)) - ((a2.getBounds().bottom - a2.getBounds().top) / 2));
        a2.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i4 = fontMetricsInt2.descent;
            int i5 = fontMetricsInt2.ascent;
            int i6 = i5 + ((i4 - i5) / 2);
            int i7 = (bounds.bottom - bounds.top) / 2;
            int i8 = i6 - i7;
            fontMetricsInt.ascent = i8;
            fontMetricsInt.top = i8;
            int i9 = i6 + i7;
            fontMetricsInt.bottom = i9;
            fontMetricsInt.descent = i9;
        }
        return bounds.right + this.f56994f;
    }

    public a(@NonNull Drawable drawable, int i2, int i3) {
        super(drawable, i2);
        this.f56994f = i3;
    }
}
