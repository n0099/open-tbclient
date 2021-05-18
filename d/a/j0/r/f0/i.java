package d.a.j0.r.f0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class i extends ImageSpan {

    /* renamed from: e  reason: collision with root package name */
    public int f49695e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<Drawable> f49696f;

    public i(Drawable drawable) {
        super(drawable);
    }

    public final Drawable a() {
        WeakReference<Drawable> weakReference = this.f49696f;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.f49696f = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    public void b(int i2) {
        this.f49695e = i2;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Drawable a2 = a();
        canvas.save();
        canvas.translate(f2, (((i5 + paint.getFontMetricsInt().descent) - a2.getBounds().height()) / 2) + this.f49695e);
        a2.draw(canvas);
        canvas.restore();
    }
}
