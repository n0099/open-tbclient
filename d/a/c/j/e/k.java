package d.a.c.j.e;

import android.view.animation.OvershootInterpolator;
/* loaded from: classes.dex */
public class k extends OvershootInterpolator {

    /* renamed from: a  reason: collision with root package name */
    public final float f39630a;

    public k(float f2) {
        super(f2);
        this.f39630a = f2;
    }

    @Override // android.view.animation.OvershootInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        float f3 = f2 - 1.0f;
        float f4 = this.f39630a;
        return ((-0.5f) * f3 * (((f4 + 1.0f) * f3) + f4)) + 1.0f;
    }
}
