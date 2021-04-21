package d.b.h0.l.l.i;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.h0.l.h.g;
import d.b.h0.l.k.f;
import d.b.h0.l.l.j.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.b.h0.l.l.d<d.b.h0.l.l.j.a> {
    public a(g gVar, d.b.h0.l.l.k.g gVar2) {
        super(gVar, gVar2);
    }

    @Override // d.b.h0.l.l.d
    public String e() {
        return "getpkglist";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.l.l.d
    /* renamed from: n */
    public boolean d(d.b.h0.l.l.j.a aVar) {
        List<a.C1052a> list;
        if (aVar == null || (list = aVar.f49697a) == null || list.isEmpty()) {
            return false;
        }
        for (a.C1052a c1052a : aVar.f49697a) {
            if (TextUtils.isEmpty(c1052a.f49699b)) {
                return false;
            }
            if (c1052a.f49698a == 0) {
                if (c1052a.f49701d == null && c1052a.f49703f == null && c1052a.f49702e == null) {
                    return false;
                }
                f fVar = c1052a.f49701d;
                if (fVar != null && !fVar.a()) {
                    return false;
                }
                PMSAppInfo pMSAppInfo = c1052a.f49703f;
                if (pMSAppInfo != null && !pMSAppInfo.a()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.l.l.d
    /* renamed from: o */
    public d.b.h0.l.k.a l(d.b.h0.l.l.j.a aVar) {
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        this.f49653e.D();
        d.b.h0.l.r.f fVar = new d.b.h0.l.r.f();
        Map<String, PMSAppInfo> s = d.b.h0.l.i.a.h().s();
        ArrayList arrayList = new ArrayList();
        for (a.C1052a c1052a : aVar.f49697a) {
            if (c1052a != null) {
                int i = c1052a.f49698a;
                if (i != 0) {
                    this.f49653e.u().m(c1052a, s.get(c1052a.f49699b), new d.b.h0.l.k.a(i, c1052a.f49699b + "，Server返回错误"));
                } else {
                    List<d.b.h0.l.k.g> list = c1052a.f49702e;
                    if (list != null) {
                        for (d.b.h0.l.k.g gVar : list) {
                            if (gVar != null) {
                                gVar.o = c1052a.f49699b;
                            }
                        }
                        i(c1052a.f49702e, fVar);
                        arrayList.addAll(c1052a.f49702e);
                    }
                    f fVar2 = c1052a.f49701d;
                    if (fVar2 != null && (pMSAppInfo2 = c1052a.f49703f) != null) {
                        pMSAppInfo2.appId = c1052a.f49699b;
                        h(fVar2, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo3 = s.get(c1052a.f49699b);
                        if (pMSAppInfo3 == null) {
                            PMSAppInfo pMSAppInfo4 = c1052a.f49703f;
                            if (pMSAppInfo4 != null) {
                                pMSAppInfo4.appId = c1052a.f49699b;
                                List<d.b.h0.l.k.g> list2 = c1052a.f49702e;
                                if (list2 != null && !list2.isEmpty()) {
                                    c1052a.f49703f.d(c1052a.f49702e.get(0));
                                }
                                this.f49653e.u().o(c1052a.f49703f, null);
                            } else {
                                int i2 = c1052a.f49698a;
                                this.f49653e.u().m(c1052a, null, new d.b.h0.l.k.a(i2, c1052a.f49699b + "，本地记录不存在"));
                            }
                        } else if (c1052a.f49701d == null && (pMSAppInfo = c1052a.f49703f) != null) {
                            pMSAppInfo.appId = c1052a.f49699b;
                            this.f49653e.u().o(c1052a.f49703f, pMSAppInfo3);
                        } else {
                            f fVar3 = c1052a.f49701d;
                            if (fVar3 != null && c1052a.f49703f == null) {
                                c1052a.f49704g = true;
                                c1052a.f49703f = pMSAppInfo3;
                                h(fVar3, fVar);
                            }
                        }
                    }
                }
            }
        }
        if (fVar.k() == 0) {
            this.f49653e.E();
        } else {
            this.f49653e.F(fVar);
            d.b.h0.l.l.h.a.a(aVar, arrayList, this.f49653e);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.l.l.d
    /* renamed from: p */
    public d.b.h0.l.l.j.a m(JSONObject jSONObject) {
        return d.b.h0.l.r.e.e(jSONObject);
    }
}
