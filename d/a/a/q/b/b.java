package d.a.a.q.b;

import java.util.List;
/* loaded from: classes.dex */
public class b extends f<Integer> {
    public b(List<d.a.a.w.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.q.b.a
    /* renamed from: n */
    public Integer i(d.a.a.w.a<Integer> aVar, float f2) {
        Integer num;
        Integer num2 = aVar.f41450b;
        if (num2 != null && aVar.f41451c != null) {
            int intValue = num2.intValue();
            int intValue2 = aVar.f41451c.intValue();
            d.a.a.w.c<A> cVar = this.f41292e;
            return (cVar == 0 || (num = (Integer) cVar.b(aVar.f41453e, aVar.f41454f.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f2, e(), f())) == null) ? Integer.valueOf(d.a.a.v.b.c(f2, intValue, intValue2)) : num;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
