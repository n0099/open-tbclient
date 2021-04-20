package d.a.a.u.i;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes.dex */
public class i implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    public final b f41654a;

    /* renamed from: b  reason: collision with root package name */
    public final b f41655b;

    public i(b bVar, b bVar2) {
        this.f41654a = bVar;
        this.f41655b = bVar2;
    }

    @Override // d.a.a.u.i.m
    public d.a.a.s.c.a<PointF, PointF> a() {
        return new d.a.a.s.c.m(this.f41654a.a(), this.f41655b.a());
    }

    @Override // d.a.a.u.i.m
    public List<d.a.a.y.a<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // d.a.a.u.i.m
    public boolean c() {
        return this.f41654a.c() && this.f41655b.c();
    }
}
