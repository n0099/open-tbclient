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
        if (bVar.f49376a == null && (((list = bVar.f49377b) == null || list.isEmpty()) && bVar.f49378c == null && bVar.f49380e == null && bVar.f49379d == null)) {
            return false;
        }
        f fVar = bVar.f49376a;
        if (fVar == null || fVar.a()) {
            List<d.b.g0.l.k.g> list2 = bVar.f49377b;
            if (list2 != null) {
                for (d.b.g0.l.k.g gVar : list2) {
                    if (!gVar.a()) {
                        return false;
                    }
                }
            }
            d.b.g0.l.k.d dVar = bVar.f49378c;
            if (dVar == null || dVar.a()) {
                d.b.g0.l.k.b bVar2 = bVar.f49380e;
                if (bVar2 == null || bVar2.a()) {
                    PMSAppInfo pMSAppInfo = bVar.f49379d;
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
        this.f49324e.D();
        d.b.g0.l.r.f fVar = new d.b.g0.l.r.f();
        h(bVar.f49376a, fVar);
        i(bVar.f49377b, fVar);
        g(bVar.f49378c, fVar);
        f(bVar.f49380e, fVar);
        k(bVar.f49379d);
        if (fVar.k() == 0) {
            this.f49324e.E();
            return null;
        }
        this.f49324e.F(fVar);
        d.b.g0.l.l.h.a.b(bVar, this.f49324e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.l.d
    /* renamed from: p */
    public d.b.g0.l.l.j.b m(JSONObject jSONObject) {
        return d.b.g0.l.r.e.f(jSONObject);
    }
}
