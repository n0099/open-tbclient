package d.b.h0.l.l.i;

import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.h0.l.h.g;
import d.b.h0.l.k.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.b.h0.l.l.d<d.b.h0.l.l.j.b> {
    public b(g gVar, d.b.h0.l.l.k.g gVar2) {
        super(gVar, gVar2);
    }

    @Override // d.b.h0.l.l.d
    public String e() {
        return "getpkg";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.l.l.d
    /* renamed from: n */
    public boolean d(d.b.h0.l.l.j.b bVar) {
        List<d.b.h0.l.k.g> list;
        if (bVar == null) {
            return false;
        }
        if (bVar.f49705a == null && (((list = bVar.f49706b) == null || list.isEmpty()) && bVar.f49707c == null && bVar.f49709e == null && bVar.f49708d == null)) {
            return false;
        }
        f fVar = bVar.f49705a;
        if (fVar == null || fVar.a()) {
            List<d.b.h0.l.k.g> list2 = bVar.f49706b;
            if (list2 != null) {
                for (d.b.h0.l.k.g gVar : list2) {
                    if (!gVar.a()) {
                        return false;
                    }
                }
            }
            d.b.h0.l.k.d dVar = bVar.f49707c;
            if (dVar == null || dVar.a()) {
                d.b.h0.l.k.b bVar2 = bVar.f49709e;
                if (bVar2 == null || bVar2.a()) {
                    PMSAppInfo pMSAppInfo = bVar.f49708d;
                    return pMSAppInfo == null || pMSAppInfo.a();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.l.l.d
    /* renamed from: o */
    public d.b.h0.l.k.a l(d.b.h0.l.l.j.b bVar) {
        this.f49653e.D();
        d.b.h0.l.r.f fVar = new d.b.h0.l.r.f();
        h(bVar.f49705a, fVar);
        i(bVar.f49706b, fVar);
        g(bVar.f49707c, fVar);
        f(bVar.f49709e, fVar);
        k(bVar.f49708d);
        if (fVar.k() == 0) {
            this.f49653e.E();
            return null;
        }
        this.f49653e.F(fVar);
        d.b.h0.l.l.h.a.b(bVar, this.f49653e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.l.l.d
    /* renamed from: p */
    public d.b.h0.l.l.j.b m(JSONObject jSONObject) {
        return d.b.h0.l.r.e.f(jSONObject);
    }
}
