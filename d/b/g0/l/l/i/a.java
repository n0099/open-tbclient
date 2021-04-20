package d.b.g0.l.l.i;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.g0.l.h.g;
import d.b.g0.l.k.f;
import d.b.g0.l.l.j.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.b.g0.l.l.d<d.b.g0.l.l.j.a> {
    public a(g gVar, d.b.g0.l.l.k.g gVar2) {
        super(gVar, gVar2);
    }

    @Override // d.b.g0.l.l.d
    public String e() {
        return "getpkglist";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.l.d
    /* renamed from: n */
    public boolean d(d.b.g0.l.l.j.a aVar) {
        List<a.C1032a> list;
        if (aVar == null || (list = aVar.f49368a) == null || list.isEmpty()) {
            return false;
        }
        for (a.C1032a c1032a : aVar.f49368a) {
            if (TextUtils.isEmpty(c1032a.f49370b)) {
                return false;
            }
            if (c1032a.f49369a == 0) {
                if (c1032a.f49372d == null && c1032a.f49374f == null && c1032a.f49373e == null) {
                    return false;
                }
                f fVar = c1032a.f49372d;
                if (fVar != null && !fVar.a()) {
                    return false;
                }
                PMSAppInfo pMSAppInfo = c1032a.f49374f;
                if (pMSAppInfo != null && !pMSAppInfo.a()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.l.d
    /* renamed from: o */
    public d.b.g0.l.k.a l(d.b.g0.l.l.j.a aVar) {
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        this.f49324e.D();
        d.b.g0.l.r.f fVar = new d.b.g0.l.r.f();
        Map<String, PMSAppInfo> s = d.b.g0.l.i.a.h().s();
        ArrayList arrayList = new ArrayList();
        for (a.C1032a c1032a : aVar.f49368a) {
            if (c1032a != null) {
                int i = c1032a.f49369a;
                if (i != 0) {
                    this.f49324e.u().m(c1032a, s.get(c1032a.f49370b), new d.b.g0.l.k.a(i, c1032a.f49370b + "，Server返回错误"));
                } else {
                    List<d.b.g0.l.k.g> list = c1032a.f49373e;
                    if (list != null) {
                        for (d.b.g0.l.k.g gVar : list) {
                            if (gVar != null) {
                                gVar.o = c1032a.f49370b;
                            }
                        }
                        i(c1032a.f49373e, fVar);
                        arrayList.addAll(c1032a.f49373e);
                    }
                    f fVar2 = c1032a.f49372d;
                    if (fVar2 != null && (pMSAppInfo2 = c1032a.f49374f) != null) {
                        pMSAppInfo2.appId = c1032a.f49370b;
                        h(fVar2, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo3 = s.get(c1032a.f49370b);
                        if (pMSAppInfo3 == null) {
                            PMSAppInfo pMSAppInfo4 = c1032a.f49374f;
                            if (pMSAppInfo4 != null) {
                                pMSAppInfo4.appId = c1032a.f49370b;
                                List<d.b.g0.l.k.g> list2 = c1032a.f49373e;
                                if (list2 != null && !list2.isEmpty()) {
                                    c1032a.f49374f.d(c1032a.f49373e.get(0));
                                }
                                this.f49324e.u().o(c1032a.f49374f, null);
                            } else {
                                int i2 = c1032a.f49369a;
                                this.f49324e.u().m(c1032a, null, new d.b.g0.l.k.a(i2, c1032a.f49370b + "，本地记录不存在"));
                            }
                        } else if (c1032a.f49372d == null && (pMSAppInfo = c1032a.f49374f) != null) {
                            pMSAppInfo.appId = c1032a.f49370b;
                            this.f49324e.u().o(c1032a.f49374f, pMSAppInfo3);
                        } else {
                            f fVar3 = c1032a.f49372d;
                            if (fVar3 != null && c1032a.f49374f == null) {
                                c1032a.f49375g = true;
                                c1032a.f49374f = pMSAppInfo3;
                                h(fVar3, fVar);
                            }
                        }
                    }
                }
            }
        }
        if (fVar.k() == 0) {
            this.f49324e.E();
        } else {
            this.f49324e.F(fVar);
            d.b.g0.l.l.h.a.a(aVar, arrayList, this.f49324e);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.l.d
    /* renamed from: p */
    public d.b.g0.l.l.j.a m(JSONObject jSONObject) {
        return d.b.g0.l.r.e.e(jSONObject);
    }
}
