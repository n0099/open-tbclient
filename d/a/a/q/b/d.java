package d.a.a.q.b;

import java.util.List;
/* loaded from: classes.dex */
public class d extends f<d.a.a.s.j.c> {

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.s.j.c f41295g;

    public d(List<d.a.a.w.a<d.a.a.s.j.c>> list) {
        super(list);
        d.a.a.s.j.c cVar = list.get(0).f41451b;
        int c2 = cVar != null ? cVar.c() : 0;
        this.f41295g = new d.a.a.s.j.c(new float[c2], new int[c2]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.q.b.a
    /* renamed from: n */
    public d.a.a.s.j.c i(d.a.a.w.a<d.a.a.s.j.c> aVar, float f2) {
        this.f41295g.d(aVar.f41451b, aVar.f41452c, f2);
        return this.f41295g;
    }
}
