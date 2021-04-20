package d.a.a.u;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final PointF f41631a;

    /* renamed from: b  reason: collision with root package name */
    public final PointF f41632b;

    /* renamed from: c  reason: collision with root package name */
    public final PointF f41633c;

    public a() {
        this.f41631a = new PointF();
        this.f41632b = new PointF();
        this.f41633c = new PointF();
    }

    public PointF a() {
        return this.f41631a;
    }

    public PointF b() {
        return this.f41632b;
    }

    public PointF c() {
        return this.f41633c;
    }

    public void d(float f2, float f3) {
        this.f41631a.set(f2, f3);
    }

    public void e(float f2, float f3) {
        this.f41632b.set(f2, f3);
    }

    public void f(float f2, float f3) {
        this.f41633c.set(f2, f3);
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f41631a = pointF;
        this.f41632b = pointF2;
        this.f41633c = pointF3;
    }
}
