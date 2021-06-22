package d.a.m0.n.i.k;

import d.a.m0.n.f.g;
import d.a.m0.n.h.h;
import d.a.m0.n.o.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.m0.n.i.d<d.a.m0.n.i.l.c> {
    public c(g gVar, d.a.m0.n.i.m.g gVar2) {
        super(gVar, gVar2);
    }

    @Override // d.a.m0.n.i.d
    public String f() {
        return "getplugin";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.m0.n.i.l.c cVar) {
        if (cVar == null) {
            return false;
        }
        h hVar = cVar.f51875a;
        return hVar == null || hVar.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.n.i.d
    /* renamed from: p */
    public d.a.m0.n.h.a m(d.a.m0.n.i.l.c cVar) {
        this.f51810e.D();
        f fVar = new f();
        k(cVar.f51875a, fVar);
        if (fVar.l() == 0) {
            this.f51810e.E();
            return null;
        }
        this.f51810e.F(fVar);
        d.a.m0.n.i.i.a.c(cVar, this.f51810e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.n.i.d
    /* renamed from: q */
    public d.a.m0.n.i.l.c n(JSONObject jSONObject) {
        return d.a.m0.n.o.e.g(jSONObject);
    }
}
