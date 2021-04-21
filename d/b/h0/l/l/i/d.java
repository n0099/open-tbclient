package d.b.h0.l.l.i;

import d.b.h0.l.h.g;
import d.b.h0.l.r.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.b.h0.l.l.d<d.b.h0.l.l.j.d> {
    public d(g gVar, d.b.h0.l.l.k.g gVar2) {
        super(gVar, gVar2);
    }

    @Override // d.b.h0.l.l.d
    public String e() {
        return "getpkg";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.l.l.d
    /* renamed from: n */
    public boolean d(d.b.h0.l.l.j.d dVar) {
        List<d.b.h0.l.k.g> list;
        if (dVar == null || (list = dVar.f49711a) == null) {
            return false;
        }
        for (d.b.h0.l.k.g gVar : list) {
            if (!gVar.a()) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.l.l.d
    /* renamed from: o */
    public d.b.h0.l.k.a l(d.b.h0.l.l.j.d dVar) {
        this.f49653e.D();
        f fVar = new f();
        i(dVar.f49711a, fVar);
        if (fVar.k() == 0) {
            this.f49653e.E();
            return null;
        }
        this.f49653e.F(fVar);
        d.b.h0.l.l.h.a.d(dVar, this.f49653e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.l.l.d
    /* renamed from: p */
    public d.b.h0.l.l.j.d m(JSONObject jSONObject) {
        return d.b.h0.l.r.e.h(jSONObject);
    }
}
