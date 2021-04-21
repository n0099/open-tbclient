package d.b.j0.k0.d;

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
    public WeakReference<Drawable> f58292e;

    /* renamed from: f  reason: collision with root package name */
    public int f58293f;

    public a(@NonNull Drawable drawable, int i) {
        super(drawable, i);
    }

    public final Drawable a() {
        WeakReference<Drawable> weakReference = this.f58292e;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.f58292e = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        Drawable a2 = a();
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i6 = fontMetricsInt.descent;
        canvas.translate(f2, ((i4 + i6) - ((i6 - fontMetricsInt.ascent) / 2)) - ((a2.getBounds().bottom - a2.getBounds().top) / 2));
        a2.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i3 = fontMetricsInt2.descent;
            int i4 = fontMetricsInt2.ascent;
            int i5 = i4 + ((i3 - i4) / 2);
            int i6 = (bounds.bottom - bounds.top) / 2;
            int i7 = i5 - i6;
            fontMetricsInt.ascent = i7;
            fontMetricsInt.top = i7;
            int i8 = i5 + i6;
            fontMetricsInt.bottom = i8;
            fontMetricsInt.descent = i8;
        }
        return bounds.right + this.f58293f;
    }

    public a(@NonNull Drawable drawable, int i, int i2) {
        super(drawable, i);
        this.f58293f = i2;
    }
}
