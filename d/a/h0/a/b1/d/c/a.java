package d.a.h0.a.b1.d.c;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
/* loaded from: classes3.dex */
public class a extends Scroller {

    /* renamed from: b  reason: collision with root package name */
    public static final Interpolator f41416b = new animation.InterpolatorC0578a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f41417a;

    /* renamed from: d.a.h0.a.b1.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class animation.InterpolatorC0578a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    public a(Context context) {
        this(context, f41416b);
    }

    public void a(boolean z) {
        this.f41417a = z;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i2, int i3, int i4, int i5, int i6) {
        if (this.f41417a) {
            super.startScroll(i2, i3, i4, i5, 0);
        } else {
            super.startScroll(i2, i3, i4, i5, i6);
        }
    }

    public a(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }
}
