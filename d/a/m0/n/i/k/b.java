package d.a.m0.n.i.k;

import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.m0.n.f.g;
import d.a.m0.n.h.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.m0.n.i.d<d.a.m0.n.i.l.b> {

    /* renamed from: h  reason: collision with root package name */
    public final String f51858h;

    public b(String str, g gVar, d.a.m0.n.i.m.g gVar2) {
        super(gVar, gVar2);
        this.f51858h = str;
    }

    @Override // d.a.m0.n.i.d
    public String f() {
        return "getpkg";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.m0.n.i.l.b bVar) {
        List<d.a.m0.n.h.g> list;
        if (bVar == null) {
            return false;
        }
        if (bVar.f51870a == null && (((list = bVar.f51871b) == null || list.isEmpty()) && bVar.f51872c == null && bVar.f51874e == null && bVar.f51873d == null)) {
            return false;
        }
        f fVar = bVar.f51870a;
        if (fVar == null || fVar.a()) {
            List<d.a.m0.n.h.g> list2 = bVar.f51871b;
            if (list2 != null) {
                for (d.a.m0.n.h.g gVar : list2) {
                    if (!gVar.a()) {
                        return false;
                    }
                }
            }
            d.a.m0.n.h.d dVar = bVar.f51872c;
            if (dVar == null || dVar.a()) {
                d.a.m0.n.h.b bVar2 = bVar.f51874e;
                if (bVar2 == null || bVar2.a()) {
                    PMSAppInfo pMSAppInfo = bVar.f51873d;
                    return pMSAppInfo == null || pMSAppInfo.a();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.n.i.d
    /* renamed from: p */
    public d.a.m0.n.h.a m(d.a.m0.n.i.l.b bVar) {
        this.f51810e.D();
        d.a.m0.n.o.f fVar = new d.a.m0.n.o.f();
        i(bVar.f51870a, fVar);
        j(bVar.f51871b, fVar);
        h(bVar.f51872c, fVar);
        g(bVar.f51874e, fVar);
        l(bVar.f51873d);
        if (fVar.l() == 0) {
            this.f51810e.E();
            return null;
        }
        this.f51810e.F(fVar);
        d.a.m0.n.i.i.a.b(bVar, this.f51810e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.n.i.d
    /* renamed from: q */
    public d.a.m0.n.i.l.b n(JSONObject jSONObject) {
        return d.a.m0.n.o.e.f(this.f51858h, jSONObject);
    }
}
