package d.a.m0.n.i.k;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.m0.n.f.g;
import d.a.m0.n.h.f;
import d.a.m0.n.i.l.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.m0.n.i.d<d.a.m0.n.i.l.a> {
    public a(g gVar, d.a.m0.n.i.m.g gVar2) {
        super(gVar, gVar2);
    }

    @Override // d.a.m0.n.i.d
    public String f() {
        return "getpkglist";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.m0.n.i.l.a aVar) {
        List<a.C1137a> list;
        if (aVar == null || (list = aVar.f51862a) == null || list.isEmpty()) {
            return false;
        }
        for (a.C1137a c1137a : aVar.f51862a) {
            if (TextUtils.isEmpty(c1137a.f51864b)) {
                return false;
            }
            if (c1137a.f51863a == 0) {
                if (c1137a.f51866d == null && c1137a.f51868f == null && c1137a.f51867e == null) {
                    return false;
                }
                f fVar = c1137a.f51866d;
                if (fVar != null && !fVar.a()) {
                    return false;
                }
                PMSAppInfo pMSAppInfo = c1137a.f51868f;
                if (pMSAppInfo != null && !pMSAppInfo.a()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.n.i.d
    /* renamed from: p */
    public d.a.m0.n.h.a m(d.a.m0.n.i.l.a aVar) {
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        this.f51810e.D();
        d.a.m0.n.o.f fVar = new d.a.m0.n.o.f();
        Map<String, PMSAppInfo> t = d.a.m0.n.g.a.h().t();
        ArrayList arrayList = new ArrayList();
        for (a.C1137a c1137a : aVar.f51862a) {
            if (c1137a != null) {
                int i2 = c1137a.f51863a;
                if (i2 != 0) {
                    this.f51810e.u().o(c1137a, t.get(c1137a.f51864b), new d.a.m0.n.h.a(i2, c1137a.f51864b + "，Server返回错误"));
                } else {
                    List<d.a.m0.n.h.g> list = c1137a.f51867e;
                    if (list != null) {
                        for (d.a.m0.n.h.g gVar : list) {
                            if (gVar != null) {
                                gVar.o = c1137a.f51864b;
                            }
                        }
                        j(c1137a.f51867e, fVar);
                        arrayList.addAll(c1137a.f51867e);
                    }
                    if (c1137a.f51866d != null && (pMSAppInfo2 = c1137a.f51868f) != null) {
                        pMSAppInfo2.appId = c1137a.f51864b;
                        this.f51810e.u().l(c1137a.f51868f);
                        i(c1137a.f51866d, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo3 = t.get(c1137a.f51864b);
                        if (pMSAppInfo3 == null) {
                            PMSAppInfo pMSAppInfo4 = c1137a.f51868f;
                            if (pMSAppInfo4 != null) {
                                pMSAppInfo4.appId = c1137a.f51864b;
                                List<d.a.m0.n.h.g> list2 = c1137a.f51867e;
                                if (list2 != null && !list2.isEmpty()) {
                                    c1137a.f51868f.d(c1137a.f51867e.get(0));
                                }
                                this.f51810e.u().p(c1137a.f51868f, null);
                            } else {
                                int i3 = c1137a.f51863a;
                                this.f51810e.u().o(c1137a, null, new d.a.m0.n.h.a(i3, c1137a.f51864b + "，本地记录不存在"));
                            }
                        } else if (c1137a.f51866d == null && (pMSAppInfo = c1137a.f51868f) != null) {
                            pMSAppInfo.appId = c1137a.f51864b;
                            this.f51810e.u().p(c1137a.f51868f, pMSAppInfo3);
                        } else {
                            f fVar2 = c1137a.f51866d;
                            if (fVar2 != null && c1137a.f51868f == null) {
                                c1137a.f51869g = true;
                                c1137a.f51868f = pMSAppInfo3;
                                i(fVar2, fVar);
                            }
                        }
                    }
                }
            }
        }
        if (fVar.l() == 0) {
            this.f51810e.E();
        } else {
            this.f51810e.F(fVar);
            d.a.m0.n.i.i.a.a(aVar, arrayList, this.f51810e);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.n.i.d
    /* renamed from: q */
    public d.a.m0.n.i.l.a n(JSONObject jSONObject) {
        return d.a.m0.n.o.e.e(jSONObject);
    }
}
