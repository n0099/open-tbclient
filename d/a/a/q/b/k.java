package d.a.a.q.b;

import java.util.List;
/* loaded from: classes.dex */
public class k extends f<d.a.a.w.d> {
    public k(List<d.a.a.w.a<d.a.a.w.d>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.q.b.a
    /* renamed from: n */
    public d.a.a.w.d i(d.a.a.w.a<d.a.a.w.d> aVar, float f2) {
        d.a.a.w.d dVar;
        d.a.a.w.d dVar2;
        d.a.a.w.d dVar3 = aVar.f41451b;
        if (dVar3 != null && (dVar = aVar.f41452c) != null) {
            d.a.a.w.d dVar4 = dVar3;
            d.a.a.w.d dVar5 = dVar;
            d.a.a.w.c<A> cVar = this.f41293e;
            return (cVar == 0 || (dVar2 = (d.a.a.w.d) cVar.b(aVar.f41454e, aVar.f41455f.floatValue(), dVar4, dVar5, f2, e(), f())) == null) ? new d.a.a.w.d(d.a.a.v.e.j(dVar4.a(), dVar5.a(), f2), d.a.a.v.e.j(dVar4.b(), dVar5.b(), f2)) : dVar2;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
