package d.a.i0.h.a.f;

import com.baidu.wallet.router.RouterCallback;
import d.a.i0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46933b = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.h.d.c.a f46934a;

    public static c d(d.a.i0.a.y.b.a aVar) {
        if (aVar == null) {
            return null;
        }
        c cVar = new c();
        cVar.f46934a = d.a.i0.h.d.c.a.e(aVar);
        return cVar;
    }

    public final JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", d.a.i0.f.i.r.b.a(str));
        } catch (Exception e2) {
            if (f46933b) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void b(String str) {
        JSONObject a2 = a(str);
        d.a.i0.h.d.c.a aVar = this.f46934a;
        if (aVar != null) {
            aVar.b(a2);
        }
    }

    public void c() {
        d.a.i0.h.d.c.a aVar = this.f46934a;
        if (aVar != null) {
            aVar.c();
        }
    }
}
