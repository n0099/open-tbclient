package d.a.h0.l.l.i;

import d.a.h0.l.h.g;
import d.a.h0.l.k.h;
import d.a.h0.l.r.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.h0.l.l.d<d.a.h0.l.l.j.c> {
    public c(g gVar, d.a.h0.l.l.k.g gVar2) {
        super(gVar, gVar2);
    }

    @Override // d.a.h0.l.l.d
    public String e() {
        return "getplugin";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.l.d
    /* renamed from: n */
    public boolean d(d.a.h0.l.l.j.c cVar) {
        if (cVar == null) {
            return false;
        }
        h hVar = cVar.f47222a;
        return hVar == null || hVar.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.l.d
    /* renamed from: o */
    public d.a.h0.l.k.a l(d.a.h0.l.l.j.c cVar) {
        this.f47163e.D();
        f fVar = new f();
        j(cVar.f47222a, fVar);
        if (fVar.k() == 0) {
            this.f47163e.E();
            return null;
        }
        this.f47163e.F(fVar);
        d.a.h0.l.l.h.a.c(cVar, this.f47163e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.l.d
    /* renamed from: p */
    public d.a.h0.l.l.j.c m(JSONObject jSONObject) {
        return d.a.h0.l.r.e.g(jSONObject);
    }
}
