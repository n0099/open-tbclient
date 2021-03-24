package d.b.g0.l.l.i;

import d.b.g0.l.h.g;
import d.b.g0.l.k.h;
import d.b.g0.l.r.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.b.g0.l.l.d<d.b.g0.l.l.j.c> {
    public c(g gVar, d.b.g0.l.l.k.g gVar2) {
        super(gVar, gVar2);
    }

    @Override // d.b.g0.l.l.d
    public String e() {
        return "getplugin";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.l.d
    /* renamed from: n */
    public boolean d(d.b.g0.l.l.j.c cVar) {
        if (cVar == null) {
            return false;
        }
        h hVar = cVar.f48988a;
        return hVar == null || hVar.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.l.d
    /* renamed from: o */
    public d.b.g0.l.k.a l(d.b.g0.l.l.j.c cVar) {
        this.f48931e.E();
        f fVar = new f();
        j(cVar.f48988a, fVar);
        if (fVar.k() == 0) {
            this.f48931e.F();
            return null;
        }
        this.f48931e.G(fVar);
        d.b.g0.l.l.h.a.c(cVar, this.f48931e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.l.d
    /* renamed from: p */
    public d.b.g0.l.l.j.c m(JSONObject jSONObject) {
        return d.b.g0.l.r.e.g(jSONObject);
    }
}
