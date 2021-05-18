package d.a.i0.n.i.k;

import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.i0.n.f.g;
import d.a.i0.n.h.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.i0.n.i.d<d.a.i0.n.i.l.b> {

    /* renamed from: h  reason: collision with root package name */
    public final String f47900h;

    public b(String str, g gVar, d.a.i0.n.i.m.g gVar2) {
        super(gVar, gVar2);
        this.f47900h = str;
    }

    @Override // d.a.i0.n.i.d
    public String f() {
        return "getpkg";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.i0.n.i.l.b bVar) {
        List<d.a.i0.n.h.g> list;
        if (bVar == null) {
            return false;
        }
        if (bVar.f47912a == null && (((list = bVar.f47913b) == null || list.isEmpty()) && bVar.f47914c == null && bVar.f47916e == null && bVar.f47915d == null)) {
            return false;
        }
        f fVar = bVar.f47912a;
        if (fVar == null || fVar.a()) {
            List<d.a.i0.n.h.g> list2 = bVar.f47913b;
            if (list2 != null) {
                for (d.a.i0.n.h.g gVar : list2) {
                    if (!gVar.a()) {
                        return false;
                    }
                }
            }
            d.a.i0.n.h.d dVar = bVar.f47914c;
            if (dVar == null || dVar.a()) {
                d.a.i0.n.h.b bVar2 = bVar.f47916e;
                if (bVar2 == null || bVar2.a()) {
                    PMSAppInfo pMSAppInfo = bVar.f47915d;
                    return pMSAppInfo == null || pMSAppInfo.a();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.i.d
    /* renamed from: p */
    public d.a.i0.n.h.a m(d.a.i0.n.i.l.b bVar) {
        this.f47852e.D();
        d.a.i0.n.o.f fVar = new d.a.i0.n.o.f();
        i(bVar.f47912a, fVar);
        j(bVar.f47913b, fVar);
        h(bVar.f47914c, fVar);
        g(bVar.f47916e, fVar);
        l(bVar.f47915d);
        if (fVar.l() == 0) {
            this.f47852e.E();
            return null;
        }
        this.f47852e.F(fVar);
        d.a.i0.n.i.i.a.b(bVar, this.f47852e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.i.d
    /* renamed from: q */
    public d.a.i0.n.i.l.b n(JSONObject jSONObject) {
        return d.a.i0.n.o.e.f(this.f47900h, jSONObject);
    }
}
