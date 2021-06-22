package d.a.m0.h.f0.i;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d {

    /* renamed from: b  reason: collision with root package name */
    public String f51160b;

    @Override // d.a.m0.h.f0.i.d
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.f51160b);
            jSONObject.put("errMsg", this.f51163a);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
