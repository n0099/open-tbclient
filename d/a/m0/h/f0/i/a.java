package d.a.m0.h.f0.i;

import com.baidu.wallet.router.RouterCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public String f51157b;

    /* renamed from: c  reason: collision with root package name */
    public int f51158c;

    /* renamed from: d  reason: collision with root package name */
    public int f51159d;

    @Override // d.a.m0.h.f0.i.d
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f51157b);
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, this.f51158c);
            jSONObject.put("net", this.f51159d);
            jSONObject.put("errMsg", this.f51163a);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
