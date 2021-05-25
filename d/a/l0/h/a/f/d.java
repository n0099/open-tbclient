package d.a.l0.h.a.f;

import com.baidu.wallet.router.RouterCallback;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47111b = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.h.d.c.a f47112a;

    public static d d(d.a.l0.a.y.b.a aVar) {
        if (aVar == null) {
            return null;
        }
        d dVar = new d();
        dVar.f47112a = d.a.l0.h.d.c.a.e(aVar);
        return dVar;
    }

    public final JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", d.a.l0.f.i.r.b.a(str));
        } catch (Exception e2) {
            if (f47111b) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void b(String str) {
        JSONObject a2 = a(str);
        d.a.l0.h.d.c.a aVar = this.f47112a;
        if (aVar != null) {
            aVar.b(a2);
        }
    }

    public void c() {
        d.a.l0.h.d.c.a aVar = this.f47112a;
        if (aVar != null) {
            aVar.c();
        }
    }
}
