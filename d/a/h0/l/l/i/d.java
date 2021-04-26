package d.a.h0.l.l.i;

import d.a.h0.l.h.g;
import d.a.h0.l.r.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.a.h0.l.l.d<d.a.h0.l.l.j.d> {
    public d(g gVar, d.a.h0.l.l.k.g gVar2) {
        super(gVar, gVar2);
    }

    @Override // d.a.h0.l.l.d
    public String e() {
        return "getpkg";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.l.d
    /* renamed from: n */
    public boolean d(d.a.h0.l.l.j.d dVar) {
        List<d.a.h0.l.k.g> list;
        if (dVar == null || (list = dVar.f47223a) == null) {
            return false;
        }
        for (d.a.h0.l.k.g gVar : list) {
            if (!gVar.a()) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.l.d
    /* renamed from: o */
    public d.a.h0.l.k.a l(d.a.h0.l.l.j.d dVar) {
        this.f47163e.D();
        f fVar = new f();
        i(dVar.f47223a, fVar);
        if (fVar.k() == 0) {
            this.f47163e.E();
            return null;
        }
        this.f47163e.F(fVar);
        d.a.h0.l.l.h.a.d(dVar, this.f47163e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.l.d
    /* renamed from: p */
    public d.a.h0.l.l.j.d m(JSONObject jSONObject) {
        return d.a.h0.l.r.e.h(jSONObject);
    }
}
