package d.a.h0.l.l.i;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.h0.l.h.g;
import d.a.h0.l.k.f;
import d.a.h0.l.l.j.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.h0.l.l.d<d.a.h0.l.l.j.a> {
    public a(g gVar, d.a.h0.l.l.k.g gVar2) {
        super(gVar, gVar2);
    }

    @Override // d.a.h0.l.l.d
    public String e() {
        return "getpkglist";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.l.d
    /* renamed from: n */
    public boolean d(d.a.h0.l.l.j.a aVar) {
        List<a.C0991a> list;
        if (aVar == null || (list = aVar.f47209a) == null || list.isEmpty()) {
            return false;
        }
        for (a.C0991a c0991a : aVar.f47209a) {
            if (TextUtils.isEmpty(c0991a.f47211b)) {
                return false;
            }
            if (c0991a.f47210a == 0) {
                if (c0991a.f47213d == null && c0991a.f47215f == null && c0991a.f47214e == null) {
                    return false;
                }
                f fVar = c0991a.f47213d;
                if (fVar != null && !fVar.a()) {
                    return false;
                }
                PMSAppInfo pMSAppInfo = c0991a.f47215f;
                if (pMSAppInfo != null && !pMSAppInfo.a()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.l.d
    /* renamed from: o */
    public d.a.h0.l.k.a l(d.a.h0.l.l.j.a aVar) {
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        this.f47163e.D();
        d.a.h0.l.r.f fVar = new d.a.h0.l.r.f();
        Map<String, PMSAppInfo> s = d.a.h0.l.i.a.h().s();
        ArrayList arrayList = new ArrayList();
        for (a.C0991a c0991a : aVar.f47209a) {
            if (c0991a != null) {
                int i2 = c0991a.f47210a;
                if (i2 != 0) {
                    this.f47163e.u().l(c0991a, s.get(c0991a.f47211b), new d.a.h0.l.k.a(i2, c0991a.f47211b + "，Server返回错误"));
                } else {
                    List<d.a.h0.l.k.g> list = c0991a.f47214e;
                    if (list != null) {
                        for (d.a.h0.l.k.g gVar : list) {
                            if (gVar != null) {
                                gVar.o = c0991a.f47211b;
                            }
                        }
                        i(c0991a.f47214e, fVar);
                        arrayList.addAll(c0991a.f47214e);
                    }
                    f fVar2 = c0991a.f47213d;
                    if (fVar2 != null && (pMSAppInfo2 = c0991a.f47215f) != null) {
                        pMSAppInfo2.appId = c0991a.f47211b;
                        h(fVar2, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo3 = s.get(c0991a.f47211b);
                        if (pMSAppInfo3 == null) {
                            PMSAppInfo pMSAppInfo4 = c0991a.f47215f;
                            if (pMSAppInfo4 != null) {
                                pMSAppInfo4.appId = c0991a.f47211b;
                                List<d.a.h0.l.k.g> list2 = c0991a.f47214e;
                                if (list2 != null && !list2.isEmpty()) {
                                    c0991a.f47215f.d(c0991a.f47214e.get(0));
                                }
                                this.f47163e.u().o(c0991a.f47215f, null);
                            } else {
                                int i3 = c0991a.f47210a;
                                this.f47163e.u().l(c0991a, null, new d.a.h0.l.k.a(i3, c0991a.f47211b + "，本地记录不存在"));
                            }
                        } else if (c0991a.f47213d == null && (pMSAppInfo = c0991a.f47215f) != null) {
                            pMSAppInfo.appId = c0991a.f47211b;
                            this.f47163e.u().o(c0991a.f47215f, pMSAppInfo3);
                        } else {
                            f fVar3 = c0991a.f47213d;
                            if (fVar3 != null && c0991a.f47215f == null) {
                                c0991a.f47216g = true;
                                c0991a.f47215f = pMSAppInfo3;
                                h(fVar3, fVar);
                            }
                        }
                    }
                }
            }
        }
        if (fVar.k() == 0) {
            this.f47163e.E();
        } else {
            this.f47163e.F(fVar);
            d.a.h0.l.l.h.a.a(aVar, arrayList, this.f47163e);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.l.d
    /* renamed from: p */
    public d.a.h0.l.l.j.a m(JSONObject jSONObject) {
        return d.a.h0.l.r.e.e(jSONObject);
    }
}
