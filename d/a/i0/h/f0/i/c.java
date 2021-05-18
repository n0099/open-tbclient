package d.a.i0.h.f0.i;

import com.baidu.wallet.router.RouterCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d {

    /* renamed from: b  reason: collision with root package name */
    public String f47203b;

    /* renamed from: c  reason: collision with root package name */
    public int f47204c;

    @Override // d.a.i0.h.f0.i.d
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("packageName", this.f47203b);
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, this.f47204c);
            jSONObject.put("errMsg", this.f47205a);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
