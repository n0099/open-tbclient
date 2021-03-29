package d.a.a.s.j;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.a.s.a> f41394a;

    /* renamed from: b  reason: collision with root package name */
    public PointF f41395b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41396c;

    public h(PointF pointF, boolean z, List<d.a.a.s.a> list) {
        ArrayList arrayList = new ArrayList();
        this.f41394a = arrayList;
        this.f41395b = pointF;
        this.f41396c = z;
        arrayList.addAll(list);
    }

    public List<d.a.a.s.a> a() {
        return this.f41394a;
    }

    public PointF b() {
        return this.f41395b;
    }

    public void c(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f41395b == null) {
            this.f41395b = new PointF();
        }
        this.f41396c = hVar.d() || hVar2.d();
        if (hVar.a().size() != hVar2.a().size()) {
            d.a.a.c.d("Curves must have the same number of control points. Shape 1: " + hVar.a().size() + "\tShape 2: " + hVar2.a().size());
        }
        if (this.f41394a.isEmpty()) {
            int min = Math.min(hVar.a().size(), hVar2.a().size());
            for (int i = 0; i < min; i++) {
                this.f41394a.add(new d.a.a.s.a());
            }
        }
        PointF b2 = hVar.b();
        PointF b3 = hVar2.b();
        e(d.a.a.v.e.j(b2.x, b3.x, f2), d.a.a.v.e.j(b2.y, b3.y, f2));
        if (this.f41394a.size() > hVar.a().size() || this.f41394a.size() > hVar2.a().size()) {
            return;
        }
        for (int size = this.f41394a.size() - 1; size >= 0; size--) {
            d.a.a.s.a aVar = hVar.a().get(size);
            d.a.a.s.a aVar2 = hVar2.a().get(size);
            PointF a2 = aVar.a();
            PointF b4 = aVar.b();
            PointF c2 = aVar.c();
            PointF a3 = aVar2.a();
            PointF b5 = aVar2.b();
            PointF c3 = aVar2.c();
            this.f41394a.get(size).d(d.a.a.v.e.j(a2.x, a3.x, f2), d.a.a.v.e.j(a2.y, a3.y, f2));
            this.f41394a.get(size).e(d.a.a.v.e.j(b4.x, b5.x, f2), d.a.a.v.e.j(b4.y, b5.y, f2));
            this.f41394a.get(size).f(d.a.a.v.e.j(c2.x, c3.x, f2), d.a.a.v.e.j(c2.y, c3.y, f2));
        }
    }

    public boolean d() {
        return this.f41396c;
    }

    public final void e(float f2, float f3) {
        if (this.f41395b == null) {
            this.f41395b = new PointF();
        }
        this.f41395b.set(f2, f3);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f41394a.size() + "closed=" + this.f41396c + '}';
    }

    public h() {
        this.f41394a = new ArrayList();
    }
}
