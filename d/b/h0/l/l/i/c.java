package d.b.h0.l.l.i;

import d.b.h0.l.h.g;
import d.b.h0.l.k.h;
import d.b.h0.l.r.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.b.h0.l.l.d<d.b.h0.l.l.j.c> {
    public c(g gVar, d.b.h0.l.l.k.g gVar2) {
        super(gVar, gVar2);
    }

    @Override // d.b.h0.l.l.d
    public String e() {
        return "getplugin";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.l.l.d
    /* renamed from: n */
    public boolean d(d.b.h0.l.l.j.c cVar) {
        if (cVar == null) {
            return false;
        }
        h hVar = cVar.f49710a;
        return hVar == null || hVar.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.l.l.d
    /* renamed from: o */
    public d.b.h0.l.k.a l(d.b.h0.l.l.j.c cVar) {
        this.f49653e.D();
        f fVar = new f();
        j(cVar.f49710a, fVar);
        if (fVar.k() == 0) {
            this.f49653e.E();
            return null;
        }
        this.f49653e.F(fVar);
        d.b.h0.l.l.h.a.c(cVar, this.f49653e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.l.l.d
    /* renamed from: p */
    public d.b.h0.l.l.j.c m(JSONObject jSONObject) {
        return d.b.h0.l.r.e.g(jSONObject);
    }
}
