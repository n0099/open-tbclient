package d.b.h0.e.a.r;

import com.baidu.wallet.router.RouterCallback;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48463b = d.b.h0.a.k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.g.e.d.a f48464a;

    public static k d(d.b.h0.g.e.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        k kVar = new k();
        kVar.f48464a = d.b.h0.g.e.d.a.e(cVar);
        return kVar;
    }

    public final JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", d.b.h0.e.a.q.b.a(str));
        } catch (Exception e2) {
            if (f48463b) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void b(String str) {
        JSONObject a2 = a(str);
        d.b.h0.g.e.d.a aVar = this.f48464a;
        if (aVar != null) {
            aVar.b(a2);
        }
    }

    public void c() {
        d.b.h0.g.e.d.a aVar = this.f48464a;
        if (aVar != null) {
            aVar.c();
        }
    }
}
