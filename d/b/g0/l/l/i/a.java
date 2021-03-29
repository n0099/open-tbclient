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
        List<a.C1020a> list;
        if (aVar == null || (list = aVar.f48976a) == null || list.isEmpty()) {
            return false;
        }
        for (a.C1020a c1020a : aVar.f48976a) {
            if (TextUtils.isEmpty(c1020a.f48978b)) {
                return false;
            }
            if (c1020a.f48977a == 0) {
                if (c1020a.f48980d == null && c1020a.f48982f == null && c1020a.f48981e == null) {
                    return false;
                }
                f fVar = c1020a.f48980d;
                if (fVar != null && !fVar.a()) {
                    return false;
                }
                PMSAppInfo pMSAppInfo = c1020a.f48982f;
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
        this.f48932e.E();
        d.b.g0.l.r.f fVar = new d.b.g0.l.r.f();
        Map<String, PMSAppInfo> s = d.b.g0.l.i.a.h().s();
        ArrayList arrayList = new ArrayList();
        for (a.C1020a c1020a : aVar.f48976a) {
            if (c1020a != null) {
                int i = c1020a.f48977a;
                if (i != 0) {
                    this.f48932e.v().m(c1020a, s.get(c1020a.f48978b), new d.b.g0.l.k.a(i, c1020a.f48978b + "，Server返回错误"));
                } else {
                    List<d.b.g0.l.k.g> list = c1020a.f48981e;
                    if (list != null) {
                        for (d.b.g0.l.k.g gVar : list) {
                            if (gVar != null) {
                                gVar.o = c1020a.f48978b;
                            }
                        }
                        i(c1020a.f48981e, fVar);
                        arrayList.addAll(c1020a.f48981e);
                    }
                    f fVar2 = c1020a.f48980d;
                    if (fVar2 != null && (pMSAppInfo2 = c1020a.f48982f) != null) {
                        pMSAppInfo2.appId = c1020a.f48978b;
                        h(fVar2, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo3 = s.get(c1020a.f48978b);
                        if (pMSAppInfo3 == null) {
                            PMSAppInfo pMSAppInfo4 = c1020a.f48982f;
                            if (pMSAppInfo4 != null) {
                                pMSAppInfo4.appId = c1020a.f48978b;
                                List<d.b.g0.l.k.g> list2 = c1020a.f48981e;
                                if (list2 != null && !list2.isEmpty()) {
                                    c1020a.f48982f.d(c1020a.f48981e.get(0));
                                }
                                this.f48932e.v().n(c1020a.f48982f, null);
                            } else {
                                int i2 = c1020a.f48977a;
                                this.f48932e.v().m(c1020a, null, new d.b.g0.l.k.a(i2, c1020a.f48978b + "，本地记录不存在"));
                            }
                        } else if (c1020a.f48980d == null && (pMSAppInfo = c1020a.f48982f) != null) {
                            pMSAppInfo.appId = c1020a.f48978b;
                            this.f48932e.v().n(c1020a.f48982f, pMSAppInfo3);
                        } else {
                            f fVar3 = c1020a.f48980d;
                            if (fVar3 != null && c1020a.f48982f == null) {
                                c1020a.f48983g = true;
                                c1020a.f48982f = pMSAppInfo3;
                                h(fVar3, fVar);
                            }
                        }
                    }
                }
            }
        }
        if (fVar.k() == 0) {
            this.f48932e.F();
        } else {
            this.f48932e.G(fVar);
            d.b.g0.l.l.h.a.a(aVar, arrayList, this.f48932e);
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
