package d.a.a.s.c;

import java.util.List;
/* loaded from: classes.dex */
public class d extends f<d.a.a.u.j.c> {
    public final d.a.a.u.j.c i;

    public d(List<d.a.a.y.a<d.a.a.u.j.c>> list) {
        super(list);
        d.a.a.u.j.c cVar = list.get(0).f41801b;
        int c2 = cVar != null ? cVar.c() : 0;
        this.i = new d.a.a.u.j.c(new float[c2], new int[c2]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.s.c.a
    /* renamed from: o */
    public d.a.a.u.j.c i(d.a.a.y.a<d.a.a.u.j.c> aVar, float f2) {
        this.i.d(aVar.f41801b, aVar.f41802c, f2);
        return this.i;
    }
}
