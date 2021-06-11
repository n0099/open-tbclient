package d.a.l0.n.i.k;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.n.f.g;
import d.a.l0.n.h.f;
import d.a.l0.n.i.l.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.l0.n.i.d<d.a.l0.n.i.l.a> {
    public a(g gVar, d.a.l0.n.i.m.g gVar2) {
        super(gVar, gVar2);
    }

    @Override // d.a.l0.n.i.d
    public String f() {
        return "getpkglist";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.l0.n.i.l.a aVar) {
        List<a.C1134a> list;
        if (aVar == null || (list = aVar.f51754a) == null || list.isEmpty()) {
            return false;
        }
        for (a.C1134a c1134a : aVar.f51754a) {
            if (TextUtils.isEmpty(c1134a.f51756b)) {
                return false;
            }
            if (c1134a.f51755a == 0) {
                if (c1134a.f51758d == null && c1134a.f51760f == null && c1134a.f51759e == null) {
                    return false;
                }
                f fVar = c1134a.f51758d;
                if (fVar != null && !fVar.a()) {
                    return false;
                }
                PMSAppInfo pMSAppInfo = c1134a.f51760f;
                if (pMSAppInfo != null && !pMSAppInfo.a()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.i.d
    /* renamed from: p */
    public d.a.l0.n.h.a m(d.a.l0.n.i.l.a aVar) {
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        this.f51702e.D();
        d.a.l0.n.o.f fVar = new d.a.l0.n.o.f();
        Map<String, PMSAppInfo> t = d.a.l0.n.g.a.h().t();
        ArrayList arrayList = new ArrayList();
        for (a.C1134a c1134a : aVar.f51754a) {
            if (c1134a != null) {
                int i2 = c1134a.f51755a;
                if (i2 != 0) {
                    this.f51702e.u().o(c1134a, t.get(c1134a.f51756b), new d.a.l0.n.h.a(i2, c1134a.f51756b + "，Server返回错误"));
                } else {
                    List<d.a.l0.n.h.g> list = c1134a.f51759e;
                    if (list != null) {
                        for (d.a.l0.n.h.g gVar : list) {
                            if (gVar != null) {
                                gVar.o = c1134a.f51756b;
                            }
                        }
                        j(c1134a.f51759e, fVar);
                        arrayList.addAll(c1134a.f51759e);
                    }
                    if (c1134a.f51758d != null && (pMSAppInfo2 = c1134a.f51760f) != null) {
                        pMSAppInfo2.appId = c1134a.f51756b;
                        this.f51702e.u().l(c1134a.f51760f);
                        i(c1134a.f51758d, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo3 = t.get(c1134a.f51756b);
                        if (pMSAppInfo3 == null) {
                            PMSAppInfo pMSAppInfo4 = c1134a.f51760f;
                            if (pMSAppInfo4 != null) {
                                pMSAppInfo4.appId = c1134a.f51756b;
                                List<d.a.l0.n.h.g> list2 = c1134a.f51759e;
                                if (list2 != null && !list2.isEmpty()) {
                                    c1134a.f51760f.d(c1134a.f51759e.get(0));
                                }
                                this.f51702e.u().p(c1134a.f51760f, null);
                            } else {
                                int i3 = c1134a.f51755a;
                                this.f51702e.u().o(c1134a, null, new d.a.l0.n.h.a(i3, c1134a.f51756b + "，本地记录不存在"));
                            }
                        } else if (c1134a.f51758d == null && (pMSAppInfo = c1134a.f51760f) != null) {
                            pMSAppInfo.appId = c1134a.f51756b;
                            this.f51702e.u().p(c1134a.f51760f, pMSAppInfo3);
                        } else {
                            f fVar2 = c1134a.f51758d;
                            if (fVar2 != null && c1134a.f51760f == null) {
                                c1134a.f51761g = true;
                                c1134a.f51760f = pMSAppInfo3;
                                i(fVar2, fVar);
                            }
                        }
                    }
                }
            }
        }
        if (fVar.l() == 0) {
            this.f51702e.E();
        } else {
            this.f51702e.F(fVar);
            d.a.l0.n.i.i.a.a(aVar, arrayList, this.f51702e);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.i.d
    /* renamed from: q */
    public d.a.l0.n.i.l.a n(JSONObject jSONObject) {
        return d.a.l0.n.o.e.e(jSONObject);
    }
}
