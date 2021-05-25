package d.a.l0.h.f0.i;

import com.baidu.wallet.router.RouterCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public String f47375b;

    /* renamed from: c  reason: collision with root package name */
    public int f47376c;

    /* renamed from: d  reason: collision with root package name */
    public int f47377d;

    @Override // d.a.l0.h.f0.i.d
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f47375b);
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, this.f47376c);
            jSONObject.put("net", this.f47377d);
            jSONObject.put("errMsg", this.f47381a);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
