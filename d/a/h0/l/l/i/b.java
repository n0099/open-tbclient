package d.a.h0.l.l.i;

import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.h0.l.h.g;
import d.a.h0.l.k.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.h0.l.l.d<d.a.h0.l.l.j.b> {
    public b(g gVar, d.a.h0.l.l.k.g gVar2) {
        super(gVar, gVar2);
    }

    @Override // d.a.h0.l.l.d
    public String e() {
        return "getpkg";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.l.d
    /* renamed from: n */
    public boolean d(d.a.h0.l.l.j.b bVar) {
        List<d.a.h0.l.k.g> list;
        if (bVar == null) {
            return false;
        }
        if (bVar.f47217a == null && (((list = bVar.f47218b) == null || list.isEmpty()) && bVar.f47219c == null && bVar.f47221e == null && bVar.f47220d == null)) {
            return false;
        }
        f fVar = bVar.f47217a;
        if (fVar == null || fVar.a()) {
            List<d.a.h0.l.k.g> list2 = bVar.f47218b;
            if (list2 != null) {
                for (d.a.h0.l.k.g gVar : list2) {
                    if (!gVar.a()) {
                        return false;
                    }
                }
            }
            d.a.h0.l.k.d dVar = bVar.f47219c;
            if (dVar == null || dVar.a()) {
                d.a.h0.l.k.b bVar2 = bVar.f47221e;
                if (bVar2 == null || bVar2.a()) {
                    PMSAppInfo pMSAppInfo = bVar.f47220d;
                    return pMSAppInfo == null || pMSAppInfo.a();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.l.d
    /* renamed from: o */
    public d.a.h0.l.k.a l(d.a.h0.l.l.j.b bVar) {
        this.f47163e.D();
        d.a.h0.l.r.f fVar = new d.a.h0.l.r.f();
        h(bVar.f47217a, fVar);
        i(bVar.f47218b, fVar);
        g(bVar.f47219c, fVar);
        f(bVar.f47221e, fVar);
        k(bVar.f47220d);
        if (fVar.k() == 0) {
            this.f47163e.E();
            return null;
        }
        this.f47163e.F(fVar);
        d.a.h0.l.l.h.a.b(bVar, this.f47163e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.l.d
    /* renamed from: p */
    public d.a.h0.l.l.j.b m(JSONObject jSONObject) {
        return d.a.h0.l.r.e.f(jSONObject);
    }
}
