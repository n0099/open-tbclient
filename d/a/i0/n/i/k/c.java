package d.a.i0.n.i.k;

import d.a.i0.n.f.g;
import d.a.i0.n.h.h;
import d.a.i0.n.o.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.i0.n.i.d<d.a.i0.n.i.l.c> {
    public c(g gVar, d.a.i0.n.i.m.g gVar2) {
        super(gVar, gVar2);
    }

    @Override // d.a.i0.n.i.d
    public String f() {
        return "getplugin";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.i0.n.i.l.c cVar) {
        if (cVar == null) {
            return false;
        }
        h hVar = cVar.f47917a;
        return hVar == null || hVar.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.i.d
    /* renamed from: p */
    public d.a.i0.n.h.a m(d.a.i0.n.i.l.c cVar) {
        this.f47852e.D();
        f fVar = new f();
        k(cVar.f47917a, fVar);
        if (fVar.l() == 0) {
            this.f47852e.E();
            return null;
        }
        this.f47852e.F(fVar);
        d.a.i0.n.i.i.a.c(cVar, this.f47852e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.i.d
    /* renamed from: q */
    public d.a.i0.n.i.l.c n(JSONObject jSONObject) {
        return d.a.i0.n.o.e.g(jSONObject);
    }
}
