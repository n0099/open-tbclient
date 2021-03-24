package d.b.g0.g.c0.e;

import com.baidu.wallet.router.RouterCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public String f48020b;

    /* renamed from: c  reason: collision with root package name */
    public int f48021c;

    /* renamed from: d  reason: collision with root package name */
    public int f48022d;

    @Override // d.b.g0.g.c0.e.d
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f48020b);
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, this.f48021c);
            jSONObject.put("net", this.f48022d);
            jSONObject.put("errMsg", this.f48026a);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
