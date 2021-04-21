package d.a.a.s.c;

import java.util.List;
/* loaded from: classes.dex */
public class e extends f<Integer> {
    public e(List<d.a.a.y.a<Integer>> list) {
        super(list);
    }

    public int o() {
        return p(b(), d());
    }

    public int p(d.a.a.y.a<Integer> aVar, float f2) {
        Integer num;
        if (aVar.f41896b != null && aVar.f41897c != null) {
            d.a.a.y.c<A> cVar = this.f41694e;
            if (cVar != 0 && (num = (Integer) cVar.b(aVar.f41899e, aVar.f41900f.floatValue(), aVar.f41896b, aVar.f41897c, f2, e(), f())) != null) {
                return num.intValue();
            }
            return d.a.a.x.g.l(aVar.g(), aVar.d(), f2);
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
