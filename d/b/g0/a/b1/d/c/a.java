package d.b.g0.a.b1.d.c;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
/* loaded from: classes2.dex */
public class a extends Scroller {

    /* renamed from: b  reason: collision with root package name */
    public static final Interpolator f43420b = new animation.InterpolatorC0607a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f43421a;

    /* renamed from: d.b.g0.a.b1.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class animation.InterpolatorC0607a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    public a(Context context) {
        this(context, f43420b);
    }

    public void a(boolean z) {
        this.f43421a = z;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        if (this.f43421a) {
            super.startScroll(i, i2, i3, i4, 0);
        } else {
            super.startScroll(i, i2, i3, i4, i5);
        }
    }

    public a(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }
}
