package d.a.a.s.c;

import java.util.List;
/* loaded from: classes.dex */
public class k extends f<d.a.a.y.d> {
    public final d.a.a.y.d i;

    public k(List<d.a.a.y.a<d.a.a.y.d>> list) {
        super(list);
        this.i = new d.a.a.y.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.s.c.a
    /* renamed from: o */
    public d.a.a.y.d i(d.a.a.y.a<d.a.a.y.d> aVar, float f2) {
        d.a.a.y.d dVar;
        d.a.a.y.d dVar2;
        d.a.a.y.d dVar3 = aVar.f41801b;
        if (dVar3 != null && (dVar = aVar.f41802c) != null) {
            d.a.a.y.d dVar4 = dVar3;
            d.a.a.y.d dVar5 = dVar;
            d.a.a.y.c<A> cVar = this.f41599e;
            if (cVar == 0 || (dVar2 = (d.a.a.y.d) cVar.b(aVar.f41804e, aVar.f41805f.floatValue(), dVar4, dVar5, f2, e(), f())) == null) {
                this.i.d(d.a.a.x.g.k(dVar4.b(), dVar5.b(), f2), d.a.a.x.g.k(dVar4.c(), dVar5.c(), f2));
                return this.i;
            }
            return dVar2;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
