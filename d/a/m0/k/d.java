package d.a.m0.k;

import android.graphics.PointF;
import android.view.animation.Interpolator;
/* loaded from: classes3.dex */
public class d implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public int f51724a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final PointF f51725b = new PointF();

    /* renamed from: c  reason: collision with root package name */
    public final PointF f51726c;

    public d(float f2, float f3, float f4, float f5) {
        PointF pointF = new PointF();
        this.f51726c = pointF;
        PointF pointF2 = this.f51725b;
        pointF2.x = f2;
        pointF2.y = f3;
        pointF.x = f4;
        pointF.y = f5;
    }

    public final double a(double d2, double d3, double d4, double d5, double d6) {
        double d7 = 1.0d - d2;
        double d8 = d2 * d2;
        double d9 = d7 * d7;
        return (d9 * d7 * d3) + (d9 * 3.0d * d2 * d4) + (d7 * 3.0d * d8 * d5) + (d8 * d2 * d6);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        int i2 = this.f51724a;
        float f3 = f2;
        while (true) {
            if (i2 >= 4096) {
                break;
            }
            f3 = (i2 * 1.0f) / 4096.0f;
            if (a(f3, 0.0d, this.f51725b.x, this.f51726c.x, 1.0d) >= f2) {
                this.f51724a = i2;
                break;
            }
            i2++;
        }
        double a2 = a(f3, 0.0d, this.f51725b.y, this.f51726c.y, 1.0d);
        if (a2 > 0.999d) {
            a2 = 1.0d;
            this.f51724a = 0;
        }
        return (float) a2;
    }
}
