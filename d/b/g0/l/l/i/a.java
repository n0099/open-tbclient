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
        List<a.C1019a> list;
        if (aVar == null || (list = aVar.f48975a) == null || list.isEmpty()) {
            return false;
        }
        for (a.C1019a c1019a : aVar.f48975a) {
            if (TextUtils.isEmpty(c1019a.f48977b)) {
                return false;
            }
            if (c1019a.f48976a == 0) {
                if (c1019a.f48979d == null && c1019a.f48981f == null && c1019a.f48980e == null) {
                    return false;
                }
                f fVar = c1019a.f48979d;
                if (fVar != null && !fVar.a()) {
                    return false;
                }
                PMSAppInfo pMSAppInfo = c1019a.f48981f;
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
        this.f48931e.E();
        d.b.g0.l.r.f fVar = new d.b.g0.l.r.f();
        Map<String, PMSAppInfo> s = d.b.g0.l.i.a.h().s();
        ArrayList arrayList = new ArrayList();
        for (a.C1019a c1019a : aVar.f48975a) {
            if (c1019a != null) {
                int i = c1019a.f48976a;
                if (i != 0) {
                    this.f48931e.v().m(c1019a, s.get(c1019a.f48977b), new d.b.g0.l.k.a(i, c1019a.f48977b + "，Server返回错误"));
                } else {
                    List<d.b.g0.l.k.g> list = c1019a.f48980e;
                    if (list != null) {
                        for (d.b.g0.l.k.g gVar : list) {
                            if (gVar != null) {
                                gVar.o = c1019a.f48977b;
                            }
                        }
                        i(c1019a.f48980e, fVar);
                        arrayList.addAll(c1019a.f48980e);
                    }
                    f fVar2 = c1019a.f48979d;
                    if (fVar2 != null && (pMSAppInfo2 = c1019a.f48981f) != null) {
                        pMSAppInfo2.appId = c1019a.f48977b;
                        h(fVar2, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo3 = s.get(c1019a.f48977b);
                        if (pMSAppInfo3 == null) {
                            PMSAppInfo pMSAppInfo4 = c1019a.f48981f;
                            if (pMSAppInfo4 != null) {
                                pMSAppInfo4.appId = c1019a.f48977b;
                                List<d.b.g0.l.k.g> list2 = c1019a.f48980e;
                                if (list2 != null && !list2.isEmpty()) {
                                    c1019a.f48981f.d(c1019a.f48980e.get(0));
                                }
                                this.f48931e.v().n(c1019a.f48981f, null);
                            } else {
                                int i2 = c1019a.f48976a;
                                this.f48931e.v().m(c1019a, null, new d.b.g0.l.k.a(i2, c1019a.f48977b + "，本地记录不存在"));
                            }
                        } else if (c1019a.f48979d == null && (pMSAppInfo = c1019a.f48981f) != null) {
                            pMSAppInfo.appId = c1019a.f48977b;
                            this.f48931e.v().n(c1019a.f48981f, pMSAppInfo3);
                        } else {
                            f fVar3 = c1019a.f48979d;
                            if (fVar3 != null && c1019a.f48981f == null) {
                                c1019a.f48982g = true;
                                c1019a.f48981f = pMSAppInfo3;
                                h(fVar3, fVar);
                            }
                        }
                    }
                }
            }
        }
        if (fVar.k() == 0) {
            this.f48931e.F();
        } else {
            this.f48931e.G(fVar);
            d.b.g0.l.l.h.a.a(aVar, arrayList, this.f48931e);
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
