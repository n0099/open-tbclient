package d.b.c.j;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Interpolator f42829a = new animation.InterpolatorC0568a();

    /* renamed from: d.b.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class animation.InterpolatorC0568a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    public static int a(float f2, float f3, boolean z) {
        float interpolation;
        if (z) {
            interpolation = f2 - (f42829a.getInterpolation(f3 / (f3 - f2)) * f2);
        } else {
            interpolation = f2 * f42829a.getInterpolation(f3 / f2);
        }
        return (int) interpolation;
    }
}
