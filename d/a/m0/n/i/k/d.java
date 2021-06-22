package d.a.m0.n.i.k;

import d.a.m0.n.f.g;
import d.a.m0.n.o.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.a.m0.n.i.d<d.a.m0.n.i.l.d> {

    /* renamed from: h  reason: collision with root package name */
    public final String f51859h;

    public d(String str, g gVar, d.a.m0.n.i.m.g gVar2) {
        super(gVar, gVar2);
        this.f51859h = str;
    }

    @Override // d.a.m0.n.i.d
    public String f() {
        return "getpkg";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.m0.n.i.l.d dVar) {
        List<d.a.m0.n.h.g> list;
        if (dVar == null || (list = dVar.f51876a) == null) {
            return false;
        }
        for (d.a.m0.n.h.g gVar : list) {
            if (!gVar.a()) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.n.i.d
    /* renamed from: p */
    public d.a.m0.n.h.a m(d.a.m0.n.i.l.d dVar) {
        this.f51810e.D();
        f fVar = new f();
        j(dVar.f51876a, fVar);
        if (fVar.l() == 0) {
            this.f51810e.E();
            return null;
        }
        this.f51810e.F(fVar);
        d.a.m0.n.i.i.a.d(dVar, this.f51810e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.n.i.d
    /* renamed from: q */
    public d.a.m0.n.i.l.d n(JSONObject jSONObject) {
        return d.a.m0.n.o.e.h(this.f51859h, jSONObject);
    }
}
