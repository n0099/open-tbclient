package d.a.l0.n.i.k;

import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.n.f.g;
import d.a.l0.n.h.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.l0.n.i.d<d.a.l0.n.i.l.b> {

    /* renamed from: h  reason: collision with root package name */
    public final String f48076h;

    public b(String str, g gVar, d.a.l0.n.i.m.g gVar2) {
        super(gVar, gVar2);
        this.f48076h = str;
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
        if (bVar.f48088a == null && (((list = bVar.f48089b) == null || list.isEmpty()) && bVar.f48090c == null && bVar.f48092e == null && bVar.f48091d == null)) {
            return false;
        }
        f fVar = bVar.f48088a;
        if (fVar == null || fVar.a()) {
            List<d.a.l0.n.h.g> list2 = bVar.f48089b;
            if (list2 != null) {
                for (d.a.l0.n.h.g gVar : list2) {
                    if (!gVar.a()) {
                        return false;
                    }
                }
            }
            d.a.l0.n.h.d dVar = bVar.f48090c;
            if (dVar == null || dVar.a()) {
                d.a.l0.n.h.b bVar2 = bVar.f48092e;
                if (bVar2 == null || bVar2.a()) {
                    PMSAppInfo pMSAppInfo = bVar.f48091d;
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
        this.f48028e.D();
        d.a.l0.n.o.f fVar = new d.a.l0.n.o.f();
        i(bVar.f48088a, fVar);
        j(bVar.f48089b, fVar);
        h(bVar.f48090c, fVar);
        g(bVar.f48092e, fVar);
        l(bVar.f48091d);
        if (fVar.l() == 0) {
            this.f48028e.E();
            return null;
        }
        this.f48028e.F(fVar);
        d.a.l0.n.i.i.a.b(bVar, this.f48028e);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.i.d
    /* renamed from: q */
    public d.a.l0.n.i.l.b n(JSONObject jSONObject) {
        return d.a.l0.n.o.e.f(this.f48076h, jSONObject);
    }
}
