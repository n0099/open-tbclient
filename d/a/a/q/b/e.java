package d.a.a.q.b;

import java.util.List;
/* loaded from: classes.dex */
public class e extends f<Integer> {
    public e(List<d.a.a.w.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.q.b.a
    /* renamed from: n */
    public Integer i(d.a.a.w.a<Integer> aVar, float f2) {
        Integer num;
        if (aVar.f41450b != null && aVar.f41451c != null) {
            d.a.a.w.c<A> cVar = this.f41292e;
            return (cVar == 0 || (num = (Integer) cVar.b(aVar.f41453e, aVar.f41454f.floatValue(), aVar.f41450b, aVar.f41451c, f2, e(), f())) == null) ? Integer.valueOf(d.a.a.v.e.k(aVar.f41450b.intValue(), aVar.f41451c.intValue(), f2)) : num;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
