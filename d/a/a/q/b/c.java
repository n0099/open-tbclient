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
        if (aVar.f41450b != null && aVar.f41451c != null) {
            d.a.a.w.c<A> cVar = this.f41292e;
            return (cVar == 0 || (f3 = (Float) cVar.b(aVar.f41453e, aVar.f41454f.floatValue(), aVar.f41450b, aVar.f41451c, f2, e(), f())) == null) ? Float.valueOf(d.a.a.v.e.j(aVar.f41450b.floatValue(), aVar.f41451c.floatValue(), f2)) : f3;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
