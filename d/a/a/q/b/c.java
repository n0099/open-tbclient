package d.a.a.q.b;

import java.util.List;
/* loaded from: classes.dex */
public class c extends f<Float> {
    public c(List<d.a.a.w.a<Float>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.q.b.a
    /* renamed from: n */
    public Float i(d.a.a.w.a<Float> aVar, float f2) {
        Float f3;
        if (aVar.f41451b != null && aVar.f41452c != null) {
            d.a.a.w.c<A> cVar = this.f41293e;
            return (cVar == 0 || (f3 = (Float) cVar.b(aVar.f41454e, aVar.f41455f.floatValue(), aVar.f41451b, aVar.f41452c, f2, e(), f())) == null) ? Float.valueOf(d.a.a.v.e.j(aVar.f41451b.floatValue(), aVar.f41452c.floatValue(), f2)) : f3;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
