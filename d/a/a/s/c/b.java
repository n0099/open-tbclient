package d.a.a.s.c;

import java.util.List;
/* loaded from: classes.dex */
public class b extends f<Integer> {
    public b(List<d.a.a.y.a<Integer>> list) {
        super(list);
    }

    public int o() {
        return p(b(), d());
    }

    public int p(d.a.a.y.a<Integer> aVar, float f2) {
        Integer num;
        Integer num2 = aVar.f41896b;
        if (num2 != null && aVar.f41897c != null) {
            int intValue = num2.intValue();
            int intValue2 = aVar.f41897c.intValue();
            d.a.a.y.c<A> cVar = this.f41694e;
            if (cVar != 0 && (num = (Integer) cVar.b(aVar.f41899e, aVar.f41900f.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f2, e(), f())) != null) {
                return num.intValue();
            }
            return d.a.a.x.b.c(d.a.a.x.g.c(f2, 0.0f, 1.0f), intValue, intValue2);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.s.c.a
    /* renamed from: q */
    public Integer i(d.a.a.y.a<Integer> aVar, float f2) {
        return Integer.valueOf(p(aVar, f2));
    }
}
