package d.a.m0.h.a.f;

import com.baidu.wallet.router.RouterCallback;
import d.a.m0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f50893b = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.h.d.c.a f50894a;

    public static d d(d.a.m0.a.y.b.a aVar) {
        if (aVar == null) {
            return null;
        }
        d dVar = new d();
        dVar.f50894a = d.a.m0.h.d.c.a.e(aVar);
        return dVar;
    }

    public final JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, str);
            jSONObject.put("errMsg", com.baidu.pass.biometrics.face.liveness.b.a.g0);
            jSONObject.put("errDes", d.a.m0.f.i.r.b.a(str));
        } catch (Exception e2) {
            if (f50893b) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void b(String str) {
        JSONObject a2 = a(str);
        d.a.m0.h.d.c.a aVar = this.f50894a;
        if (aVar != null) {
            aVar.b(a2);
        }
    }

    public void c() {
        d.a.m0.h.d.c.a aVar = this.f50894a;
        if (aVar != null) {
            aVar.c();
        }
    }
}
