package d.a.h0.e.a.r;

import com.baidu.wallet.router.RouterCallback;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class l {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45925b = d.a.h0.a.k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.g.e.d.a f45926a;

    public static l d(d.a.h0.g.e.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        l lVar = new l();
        lVar.f45926a = d.a.h0.g.e.d.a.e(cVar);
        return lVar;
    }

    public final JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", d.a.h0.e.a.q.b.a(str));
        } catch (Exception e2) {
            if (f45925b) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void b(String str) {
        JSONObject a2 = a(str);
        d.a.h0.g.e.d.a aVar = this.f45926a;
        if (aVar != null) {
            aVar.b(a2);
        }
    }

    public void c() {
        d.a.h0.g.e.d.a aVar = this.f45926a;
        if (aVar != null) {
            aVar.c();
        }
    }
}
