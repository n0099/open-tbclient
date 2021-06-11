package d.a.l0.n.i.k;

import d.a.l0.n.f.g;
import d.a.l0.n.o.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.a.l0.n.i.d<d.a.l0.n.i.l.d> {

    /* renamed from: h  reason: collision with root package name */
    public final String f51751h;

    public d(String str, g gVar, d.a.l0.n.i.m.g gVar2) {
        super(gVar, gVar2);
        this.f51751h = str;
    }

    @Override // d.a.l0.n.i.d
    public String f() {
        return "getpkg";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.l0.n.i.l.d dVar) {
        List<d.a.l0.n.h.g> list;
        if (dVar == null || (list = dVar.f51768a) == null) {
            return false;
        }
        for (d.a.l0.n.h.g gVar : list) {
            if (!gVar.a()) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.i.d
    /* renamed from: p */
    public d.a.l0.n.h.a m(d.a.l0.n.i.l.d dVar) {
        this.f51702e.D();
        f fVar = new f();
        j(dVar.f51768a, fVar);
        if (fVar.l() == 0) {
            this.f51702e.E();
            return null;
        }
        this.f51702e.F(fVar);
        d.a.l0.n.i.i.a.d(dVar, this.f51702e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.i.d
    /* renamed from: q */
    public d.a.l0.n.i.l.d n(JSONObject jSONObject) {
        return d.a.l0.n.o.e.h(this.f51751h, jSONObject);
    }
}
