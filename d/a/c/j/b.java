package d.a.c.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b extends ImageSpan {

    /* renamed from: e  reason: collision with root package name */
    public int f39537e;

    /* renamed from: f  reason: collision with root package name */
    public int f39538f;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<Drawable> f39539g;

    /* renamed from: h  reason: collision with root package name */
    public int f39540h;

    public b(Context context, Bitmap bitmap, int i2) {
        super(context, bitmap, i2);
    }

    public final Drawable a() {
        WeakReference<Drawable> weakReference = this.f39539g;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.f39539g = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    public void b(int i2) {
        this.f39538f = i2;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Drawable a2 = a();
        canvas.save();
        int i7 = paint.getFontMetricsInt().top;
        canvas.translate(f2 + this.f39538f, ((i6 - a2.getBounds().bottom) - (((paint.getFontMetricsInt().bottom - i7) / 2) - ((a2.getBounds().top + a2.getBounds().bottom) / 2))) + this.f39540h);
        a2.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i2, int i3, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return super.getSize(paint, charSequence, i2, i3, fontMetricsInt) + this.f39538f + this.f39537e;
    }

    public b(Drawable drawable, int i2) {
        super(drawable, i2);
    }

    public b(Context context, int i2) {
        super(context, i2);
    }
}
