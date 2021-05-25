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
        List<a.C1078a> list;
        if (aVar == null || (list = aVar.f48080a) == null || list.isEmpty()) {
            return false;
        }
        for (a.C1078a c1078a : aVar.f48080a) {
            if (TextUtils.isEmpty(c1078a.f48082b)) {
                return false;
            }
            if (c1078a.f48081a == 0) {
                if (c1078a.f48084d == null && c1078a.f48086f == null && c1078a.f48085e == null) {
                    return false;
                }
                f fVar = c1078a.f48084d;
                if (fVar != null && !fVar.a()) {
                    return false;
                }
                PMSAppInfo pMSAppInfo = c1078a.f48086f;
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
        this.f48028e.D();
        d.a.l0.n.o.f fVar = new d.a.l0.n.o.f();
        Map<String, PMSAppInfo> t = d.a.l0.n.g.a.h().t();
        ArrayList arrayList = new ArrayList();
        for (a.C1078a c1078a : aVar.f48080a) {
            if (c1078a != null) {
                int i2 = c1078a.f48081a;
                if (i2 != 0) {
                    this.f48028e.u().o(c1078a, t.get(c1078a.f48082b), new d.a.l0.n.h.a(i2, c1078a.f48082b + "，Server返回错误"));
                } else {
                    List<d.a.l0.n.h.g> list = c1078a.f48085e;
                    if (list != null) {
                        for (d.a.l0.n.h.g gVar : list) {
                            if (gVar != null) {
                                gVar.o = c1078a.f48082b;
                            }
                        }
                        j(c1078a.f48085e, fVar);
                        arrayList.addAll(c1078a.f48085e);
                    }
                    if (c1078a.f48084d != null && (pMSAppInfo2 = c1078a.f48086f) != null) {
                        pMSAppInfo2.appId = c1078a.f48082b;
                        this.f48028e.u().l(c1078a.f48086f);
                        i(c1078a.f48084d, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo3 = t.get(c1078a.f48082b);
                        if (pMSAppInfo3 == null) {
                            PMSAppInfo pMSAppInfo4 = c1078a.f48086f;
                            if (pMSAppInfo4 != null) {
                                pMSAppInfo4.appId = c1078a.f48082b;
                                List<d.a.l0.n.h.g> list2 = c1078a.f48085e;
                                if (list2 != null && !list2.isEmpty()) {
                                    c1078a.f48086f.d(c1078a.f48085e.get(0));
                                }
                                this.f48028e.u().p(c1078a.f48086f, null);
                            } else {
                                int i3 = c1078a.f48081a;
                                this.f48028e.u().o(c1078a, null, new d.a.l0.n.h.a(i3, c1078a.f48082b + "，本地记录不存在"));
                            }
                        } else if (c1078a.f48084d == null && (pMSAppInfo = c1078a.f48086f) != null) {
                            pMSAppInfo.appId = c1078a.f48082b;
                            this.f48028e.u().p(c1078a.f48086f, pMSAppInfo3);
                        } else {
                            f fVar2 = c1078a.f48084d;
                            if (fVar2 != null && c1078a.f48086f == null) {
                                c1078a.f48087g = true;
                                c1078a.f48086f = pMSAppInfo3;
                                i(fVar2, fVar);
                            }
                        }
                    }
                }
            }
        }
        if (fVar.l() == 0) {
            this.f48028e.E();
        } else {
            this.f48028e.F(fVar);
            d.a.l0.n.i.i.a.a(aVar, arrayList, this.f48028e);
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
