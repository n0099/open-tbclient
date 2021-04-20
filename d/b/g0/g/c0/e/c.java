package d.b.g0.g.c0.e;

import com.baidu.wallet.router.RouterCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d {

    /* renamed from: b  reason: collision with root package name */
    public String f48417b;

    /* renamed from: c  reason: collision with root package name */
    public int f48418c;

    @Override // d.b.g0.g.c0.e.d
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("packageName", this.f48417b);
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, this.f48418c);
            jSONObject.put("errMsg", this.f48419a);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
