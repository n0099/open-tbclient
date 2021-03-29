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
        if (bVar.f48984a == null && (((list = bVar.f48985b) == null || list.isEmpty()) && bVar.f48986c == null && bVar.f48988e == null && bVar.f48987d == null)) {
            return false;
        }
        f fVar = bVar.f48984a;
        if (fVar == null || fVar.a()) {
            List<d.b.g0.l.k.g> list2 = bVar.f48985b;
            if (list2 != null) {
                for (d.b.g0.l.k.g gVar : list2) {
                    if (!gVar.a()) {
                        return false;
                    }
                }
            }
            d.b.g0.l.k.d dVar = bVar.f48986c;
            if (dVar == null || dVar.a()) {
                d.b.g0.l.k.b bVar2 = bVar.f48988e;
                if (bVar2 == null || bVar2.a()) {
                    PMSAppInfo pMSAppInfo = bVar.f48987d;
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
        this.f48932e.E();
        d.b.g0.l.r.f fVar = new d.b.g0.l.r.f();
        h(bVar.f48984a, fVar);
        i(bVar.f48985b, fVar);
        g(bVar.f48986c, fVar);
        f(bVar.f48988e, fVar);
        k(bVar.f48987d);
        if (fVar.k() == 0) {
            this.f48932e.F();
            return null;
        }
        this.f48932e.G(fVar);
        d.b.g0.l.l.h.a.b(bVar, this.f48932e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.l.d
    /* renamed from: p */
    public d.b.g0.l.l.j.b m(JSONObject jSONObject) {
        return d.b.g0.l.r.e.f(jSONObject);
    }
}
