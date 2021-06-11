package d.a.l0.h.a.f;

import com.baidu.wallet.router.RouterCallback;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f50783b = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.h.d.c.a f50784a;

    public static c d(d.a.l0.a.y.b.a aVar) {
        if (aVar == null) {
            return null;
        }
        c cVar = new c();
        cVar.f50784a = d.a.l0.h.d.c.a.e(aVar);
        return cVar;
    }

    public final JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, str);
            jSONObject.put("errMsg", com.baidu.pass.biometrics.face.liveness.b.b.g0);
            jSONObject.put("errDes", d.a.l0.f.i.r.b.a(str));
        } catch (Exception e2) {
            if (f50783b) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void b(String str) {
        JSONObject a2 = a(str);
        d.a.l0.h.d.c.a aVar = this.f50784a;
        if (aVar != null) {
            aVar.b(a2);
        }
    }

    public void c() {
        d.a.l0.h.d.c.a aVar = this.f50784a;
        if (aVar != null) {
            aVar.c();
        }
    }
}
