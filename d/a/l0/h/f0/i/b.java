package d.a.l0.h.f0.i;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d {

    /* renamed from: b  reason: collision with root package name */
    public String f51052b;

    @Override // d.a.l0.h.f0.i.d
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.f51052b);
            jSONObject.put("errMsg", this.f51055a);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
