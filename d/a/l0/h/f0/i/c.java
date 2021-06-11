package d.a.l0.h.f0.i;

import com.baidu.wallet.router.RouterCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d {

    /* renamed from: b  reason: collision with root package name */
    public String f51053b;

    /* renamed from: c  reason: collision with root package name */
    public int f51054c;

    @Override // d.a.l0.h.f0.i.d
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("packageName", this.f51053b);
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, this.f51054c);
            jSONObject.put("errMsg", this.f51055a);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
