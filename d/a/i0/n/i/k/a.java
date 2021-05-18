package d.a.i0.n.i.k;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.i0.n.f.g;
import d.a.i0.n.h.f;
import d.a.i0.n.i.l.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.i0.n.i.d<d.a.i0.n.i.l.a> {
    public a(g gVar, d.a.i0.n.i.m.g gVar2) {
        super(gVar, gVar2);
    }

    @Override // d.a.i0.n.i.d
    public String f() {
        return "getpkglist";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.i0.n.i.l.a aVar) {
        List<a.C1067a> list;
        if (aVar == null || (list = aVar.f47904a) == null || list.isEmpty()) {
            return false;
        }
        for (a.C1067a c1067a : aVar.f47904a) {
            if (TextUtils.isEmpty(c1067a.f47906b)) {
                return false;
            }
            if (c1067a.f47905a == 0) {
                if (c1067a.f47908d == null && c1067a.f47910f == null && c1067a.f47909e == null) {
                    return false;
                }
                f fVar = c1067a.f47908d;
                if (fVar != null && !fVar.a()) {
                    return false;
                }
                PMSAppInfo pMSAppInfo = c1067a.f47910f;
                if (pMSAppInfo != null && !pMSAppInfo.a()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.i.d
    /* renamed from: p */
    public d.a.i0.n.h.a m(d.a.i0.n.i.l.a aVar) {
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        this.f47852e.D();
        d.a.i0.n.o.f fVar = new d.a.i0.n.o.f();
        Map<String, PMSAppInfo> t = d.a.i0.n.g.a.h().t();
        ArrayList arrayList = new ArrayList();
        for (a.C1067a c1067a : aVar.f47904a) {
            if (c1067a != null) {
                int i2 = c1067a.f47905a;
                if (i2 != 0) {
                    this.f47852e.u().o(c1067a, t.get(c1067a.f47906b), new d.a.i0.n.h.a(i2, c1067a.f47906b + "，Server返回错误"));
                } else {
                    List<d.a.i0.n.h.g> list = c1067a.f47909e;
                    if (list != null) {
                        for (d.a.i0.n.h.g gVar : list) {
                            if (gVar != null) {
                                gVar.o = c1067a.f47906b;
                            }
                        }
                        j(c1067a.f47909e, fVar);
                        arrayList.addAll(c1067a.f47909e);
                    }
                    if (c1067a.f47908d != null && (pMSAppInfo2 = c1067a.f47910f) != null) {
                        pMSAppInfo2.appId = c1067a.f47906b;
                        this.f47852e.u().l(c1067a.f47910f);
                        i(c1067a.f47908d, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo3 = t.get(c1067a.f47906b);
                        if (pMSAppInfo3 == null) {
                            PMSAppInfo pMSAppInfo4 = c1067a.f47910f;
                            if (pMSAppInfo4 != null) {
                                pMSAppInfo4.appId = c1067a.f47906b;
                                List<d.a.i0.n.h.g> list2 = c1067a.f47909e;
                                if (list2 != null && !list2.isEmpty()) {
                                    c1067a.f47910f.d(c1067a.f47909e.get(0));
                                }
                                this.f47852e.u().p(c1067a.f47910f, null);
                            } else {
                                int i3 = c1067a.f47905a;
                                this.f47852e.u().o(c1067a, null, new d.a.i0.n.h.a(i3, c1067a.f47906b + "，本地记录不存在"));
                            }
                        } else if (c1067a.f47908d == null && (pMSAppInfo = c1067a.f47910f) != null) {
                            pMSAppInfo.appId = c1067a.f47906b;
                            this.f47852e.u().p(c1067a.f47910f, pMSAppInfo3);
                        } else {
                            f fVar2 = c1067a.f47908d;
                            if (fVar2 != null && c1067a.f47910f == null) {
                                c1067a.f47911g = true;
                                c1067a.f47910f = pMSAppInfo3;
                                i(fVar2, fVar);
                            }
                        }
                    }
                }
            }
        }
        if (fVar.l() == 0) {
            this.f47852e.E();
        } else {
            this.f47852e.F(fVar);
            d.a.i0.n.i.i.a.a(aVar, arrayList, this.f47852e);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.i.d
    /* renamed from: q */
    public d.a.i0.n.i.l.a n(JSONObject jSONObject) {
        return d.a.i0.n.o.e.e(jSONObject);
    }
}
