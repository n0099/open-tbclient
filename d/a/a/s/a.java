package d.a.a.s;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final PointF f41325a;

    /* renamed from: b  reason: collision with root package name */
    public final PointF f41326b;

    /* renamed from: c  reason: collision with root package name */
    public final PointF f41327c;

    public a() {
        this.f41325a = new PointF();
        this.f41326b = new PointF();
        this.f41327c = new PointF();
    }

    public PointF a() {
        return this.f41325a;
    }

    public PointF b() {
        return this.f41326b;
    }

    public PointF c() {
        return this.f41327c;
    }

    public void d(float f2, float f3) {
        this.f41325a.set(f2, f3);
    }

    public void e(float f2, float f3) {
        this.f41326b.set(f2, f3);
    }

    public void f(float f2, float f3) {
        this.f41327c.set(f2, f3);
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f41325a = pointF;
        this.f41326b = pointF2;
        this.f41327c = pointF3;
    }
}
