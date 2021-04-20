package d.a.a.s.c;

import java.util.List;
/* loaded from: classes.dex */
public class c extends f<Float> {
    public c(List<d.a.a.y.a<Float>> list) {
        super(list);
    }

    public float o() {
        return p(b(), d());
    }

    public float p(d.a.a.y.a<Float> aVar, float f2) {
        Float f3;
        if (aVar.f41801b != null && aVar.f41802c != null) {
            d.a.a.y.c<A> cVar = this.f41599e;
            if (cVar != 0 && (f3 = (Float) cVar.b(aVar.f41804e, aVar.f41805f.floatValue(), aVar.f41801b, aVar.f41802c, f2, e(), f())) != null) {
                return f3.floatValue();
            }
            return d.a.a.x.g.k(aVar.f(), aVar.c(), f2);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.s.c.a
    /* renamed from: q */
    public Float i(d.a.a.y.a<Float> aVar, float f2) {
        return Float.valueOf(p(aVar, f2));
    }
}
