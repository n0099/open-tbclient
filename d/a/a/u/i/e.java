package d.a.a.u.i;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes.dex */
public class e implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.a.y.a<PointF>> f41748a;

    public e(List<d.a.a.y.a<PointF>> list) {
        this.f41748a = list;
    }

    @Override // d.a.a.u.i.m
    public d.a.a.s.c.a<PointF, PointF> a() {
        if (this.f41748a.get(0).h()) {
            return new d.a.a.s.c.j(this.f41748a);
        }
        return new d.a.a.s.c.i(this.f41748a);
    }

    @Override // d.a.a.u.i.m
    public List<d.a.a.y.a<PointF>> b() {
        return this.f41748a;
    }

    @Override // d.a.a.u.i.m
    public boolean c() {
        return this.f41748a.size() == 1 && this.f41748a.get(0).h();
    }
}
