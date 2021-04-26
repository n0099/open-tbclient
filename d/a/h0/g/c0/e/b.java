package d.a.h0.g.c0.e;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d {

    /* renamed from: b  reason: collision with root package name */
    public String f46212b;

    @Override // d.a.h0.g.c0.e.d
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.f46212b);
            jSONObject.put("errMsg", this.f46215a);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
