package d.b.h0.r.f0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class i extends ImageSpan {

    /* renamed from: e  reason: collision with root package name */
    public int f50920e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<Drawable> f50921f;

    public i(Drawable drawable) {
        super(drawable);
    }

    public final Drawable a() {
        WeakReference<Drawable> weakReference = this.f50921f;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.f50921f = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    public void b(int i) {
        this.f50920e = i;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        Drawable a2 = a();
        canvas.save();
        canvas.translate(f2, (((i4 + paint.getFontMetricsInt().descent) - a2.getBounds().height()) / 2) + this.f50920e);
        a2.draw(canvas);
        canvas.restore();
    }
}
