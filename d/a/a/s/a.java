package d.a.a.s;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final PointF f41324a;

    /* renamed from: b  reason: collision with root package name */
    public final PointF f41325b;

    /* renamed from: c  reason: collision with root package name */
    public final PointF f41326c;

    public a() {
        this.f41324a = new PointF();
        this.f41325b = new PointF();
        this.f41326c = new PointF();
    }

    public PointF a() {
        return this.f41324a;
    }

    public PointF b() {
        return this.f41325b;
    }

    public PointF c() {
        return this.f41326c;
    }

    public void d(float f2, float f3) {
        this.f41324a.set(f2, f3);
    }

    public void e(float f2, float f3) {
        this.f41325b.set(f2, f3);
    }

    public void f(float f2, float f3) {
        this.f41326c.set(f2, f3);
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f41324a = pointF;
        this.f41325b = pointF2;
        this.f41326c = pointF3;
    }
}
