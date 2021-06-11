package d.a.l0.n.i.k;

import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.n.f.g;
import d.a.l0.n.h.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.l0.n.i.d<d.a.l0.n.i.l.b> {

    /* renamed from: h  reason: collision with root package name */
    public final String f51750h;

    public b(String str, g gVar, d.a.l0.n.i.m.g gVar2) {
        super(gVar, gVar2);
        this.f51750h = str;
    }

    @Override // d.a.l0.n.i.d
    public String f() {
        return "getpkg";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.l0.n.i.l.b bVar) {
        List<d.a.l0.n.h.g> list;
        if (bVar == null) {
            return false;
        }
        if (bVar.f51762a == null && (((list = bVar.f51763b) == null || list.isEmpty()) && bVar.f51764c == null && bVar.f51766e == null && bVar.f51765d == null)) {
            return false;
        }
        f fVar = bVar.f51762a;
        if (fVar == null || fVar.a()) {
            List<d.a.l0.n.h.g> list2 = bVar.f51763b;
            if (list2 != null) {
                for (d.a.l0.n.h.g gVar : list2) {
                    if (!gVar.a()) {
                        return false;
                    }
                }
            }
            d.a.l0.n.h.d dVar = bVar.f51764c;
            if (dVar == null || dVar.a()) {
                d.a.l0.n.h.b bVar2 = bVar.f51766e;
                if (bVar2 == null || bVar2.a()) {
                    PMSAppInfo pMSAppInfo = bVar.f51765d;
                    return pMSAppInfo == null || pMSAppInfo.a();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.i.d
    /* renamed from: p */
    public d.a.l0.n.h.a m(d.a.l0.n.i.l.b bVar) {
        this.f51702e.D();
        d.a.l0.n.o.f fVar = new d.a.l0.n.o.f();
        i(bVar.f51762a, fVar);
        j(bVar.f51763b, fVar);
        h(bVar.f51764c, fVar);
        g(bVar.f51766e, fVar);
        l(bVar.f51765d);
        if (fVar.l() == 0) {
            this.f51702e.E();
            return null;
        }
        this.f51702e.F(fVar);
        d.a.l0.n.i.i.a.b(bVar, this.f51702e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.i.d
    /* renamed from: q */
    public d.a.l0.n.i.l.b n(JSONObject jSONObject) {
        return d.a.l0.n.o.e.f(this.f51750h, jSONObject);
    }
}
