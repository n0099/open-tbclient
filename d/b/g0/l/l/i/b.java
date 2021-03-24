package d.b.g0.l.l.i;

import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.g0.l.h.g;
import d.b.g0.l.k.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.b.g0.l.l.d<d.b.g0.l.l.j.b> {
    public b(g gVar, d.b.g0.l.l.k.g gVar2) {
        super(gVar, gVar2);
    }

    @Override // d.b.g0.l.l.d
    public String e() {
        return "getpkg";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.l.d
    /* renamed from: n */
    public boolean d(d.b.g0.l.l.j.b bVar) {
        List<d.b.g0.l.k.g> list;
        if (bVar == null) {
            return false;
        }
        if (bVar.f48983a == null && (((list = bVar.f48984b) == null || list.isEmpty()) && bVar.f48985c == null && bVar.f48987e == null && bVar.f48986d == null)) {
            return false;
        }
        f fVar = bVar.f48983a;
        if (fVar == null || fVar.a()) {
            List<d.b.g0.l.k.g> list2 = bVar.f48984b;
            if (list2 != null) {
                for (d.b.g0.l.k.g gVar : list2) {
                    if (!gVar.a()) {
                        return false;
                    }
                }
            }
            d.b.g0.l.k.d dVar = bVar.f48985c;
            if (dVar == null || dVar.a()) {
                d.b.g0.l.k.b bVar2 = bVar.f48987e;
                if (bVar2 == null || bVar2.a()) {
                    PMSAppInfo pMSAppInfo = bVar.f48986d;
                    return pMSAppInfo == null || pMSAppInfo.a();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.l.d
    /* renamed from: o */
    public d.b.g0.l.k.a l(d.b.g0.l.l.j.b bVar) {
        this.f48931e.E();
        d.b.g0.l.r.f fVar = new d.b.g0.l.r.f();
        h(bVar.f48983a, fVar);
        i(bVar.f48984b, fVar);
        g(bVar.f48985c, fVar);
        f(bVar.f48987e, fVar);
        k(bVar.f48986d);
        if (fVar.k() == 0) {
            this.f48931e.F();
            return null;
        }
        this.f48931e.G(fVar);
        d.b.g0.l.l.h.a.b(bVar, this.f48931e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.l.d
    /* renamed from: p */
    public d.b.g0.l.l.j.b m(JSONObject jSONObject) {
        return d.b.g0.l.r.e.f(jSONObject);
    }
}
