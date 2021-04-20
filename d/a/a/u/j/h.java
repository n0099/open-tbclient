package d.a.a.u.j;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.a.u.a> f41702a;

    /* renamed from: b  reason: collision with root package name */
    public PointF f41703b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41704c;

    public h(PointF pointF, boolean z, List<d.a.a.u.a> list) {
        this.f41703b = pointF;
        this.f41704c = z;
        this.f41702a = new ArrayList(list);
    }

    public List<d.a.a.u.a> a() {
        return this.f41702a;
    }

    public PointF b() {
        return this.f41703b;
    }

    public void c(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f41703b == null) {
            this.f41703b = new PointF();
        }
        this.f41704c = hVar.d() || hVar2.d();
        if (hVar.a().size() != hVar2.a().size()) {
            d.a.a.x.d.c("Curves must have the same number of control points. Shape 1: " + hVar.a().size() + "\tShape 2: " + hVar2.a().size());
        }
        int min = Math.min(hVar.a().size(), hVar2.a().size());
        if (this.f41702a.size() < min) {
            for (int size = this.f41702a.size(); size < min; size++) {
                this.f41702a.add(new d.a.a.u.a());
            }
        } else if (this.f41702a.size() > min) {
            for (int size2 = this.f41702a.size() - 1; size2 >= min; size2--) {
                List<d.a.a.u.a> list = this.f41702a;
                list.remove(list.size() - 1);
            }
        }
        PointF b2 = hVar.b();
        PointF b3 = hVar2.b();
        e(d.a.a.x.g.k(b2.x, b3.x, f2), d.a.a.x.g.k(b2.y, b3.y, f2));
        for (int size3 = this.f41702a.size() - 1; size3 >= 0; size3--) {
            d.a.a.u.a aVar = hVar.a().get(size3);
            d.a.a.u.a aVar2 = hVar2.a().get(size3);
            PointF a2 = aVar.a();
            PointF b4 = aVar.b();
            PointF c2 = aVar.c();
            PointF a3 = aVar2.a();
            PointF b5 = aVar2.b();
            PointF c3 = aVar2.c();
            this.f41702a.get(size3).d(d.a.a.x.g.k(a2.x, a3.x, f2), d.a.a.x.g.k(a2.y, a3.y, f2));
            this.f41702a.get(size3).e(d.a.a.x.g.k(b4.x, b5.x, f2), d.a.a.x.g.k(b4.y, b5.y, f2));
            this.f41702a.get(size3).f(d.a.a.x.g.k(c2.x, c3.x, f2), d.a.a.x.g.k(c2.y, c3.y, f2));
        }
    }

    public boolean d() {
        return this.f41704c;
    }

    public final void e(float f2, float f3) {
        if (this.f41703b == null) {
            this.f41703b = new PointF();
        }
        this.f41703b.set(f2, f3);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f41702a.size() + "closed=" + this.f41704c + '}';
    }

    public h() {
        this.f41702a = new ArrayList();
    }
}
