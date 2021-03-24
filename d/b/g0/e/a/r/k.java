package d.b.g0.e.a.r;

import com.baidu.wallet.router.RouterCallback;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47741b = d.b.g0.a.k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.e.d.a f47742a;

    public static k d(d.b.g0.g.e.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        k kVar = new k();
        kVar.f47742a = d.b.g0.g.e.d.a.e(cVar);
        return kVar;
    }

    public final JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", d.b.g0.e.a.q.b.a(str));
        } catch (Exception e2) {
            if (f47741b) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void b(String str) {
        JSONObject a2 = a(str);
        d.b.g0.g.e.d.a aVar = this.f47742a;
        if (aVar != null) {
            aVar.b(a2);
        }
    }

    public void c() {
        d.b.g0.g.e.d.a aVar = this.f47742a;
        if (aVar != null) {
            aVar.c();
        }
    }
}
