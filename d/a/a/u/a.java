package d.a.a.u;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final PointF f41726a;

    /* renamed from: b  reason: collision with root package name */
    public final PointF f41727b;

    /* renamed from: c  reason: collision with root package name */
    public final PointF f41728c;

    public a() {
        this.f41726a = new PointF();
        this.f41727b = new PointF();
        this.f41728c = new PointF();
    }

    public PointF a() {
        return this.f41726a;
    }

    public PointF b() {
        return this.f41727b;
    }

    public PointF c() {
        return this.f41728c;
    }

    public void d(float f2, float f3) {
        this.f41726a.set(f2, f3);
    }

    public void e(float f2, float f3) {
        this.f41727b.set(f2, f3);
    }

    public void f(float f2, float f3) {
        this.f41728c.set(f2, f3);
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f41726a = pointF;
        this.f41727b = pointF2;
        this.f41728c = pointF3;
    }
}
