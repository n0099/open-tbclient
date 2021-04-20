package d.b.c.j;

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
    public int f42830e;

    /* renamed from: f  reason: collision with root package name */
    public int f42831f;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<Drawable> f42832g;

    /* renamed from: h  reason: collision with root package name */
    public int f42833h;

    public b(Context context, Bitmap bitmap, int i) {
        super(context, bitmap, i);
    }

    public final Drawable a() {
        WeakReference<Drawable> weakReference = this.f42832g;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.f42832g = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    public void b(int i) {
        this.f42831f = i;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        Drawable a2 = a();
        canvas.save();
        int i6 = paint.getFontMetricsInt().top;
        canvas.translate(f2 + this.f42831f, ((i5 - a2.getBounds().bottom) - (((paint.getFontMetricsInt().bottom - i6) / 2) - ((a2.getBounds().top + a2.getBounds().bottom) / 2))) + this.f42833h);
        a2.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return super.getSize(paint, charSequence, i, i2, fontMetricsInt) + this.f42831f + this.f42830e;
    }

    public b(Drawable drawable, int i) {
        super(drawable, i);
    }

    public b(Context context, int i) {
        super(context, i);
    }
}
