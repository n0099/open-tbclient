package d.b.g0.a.s0.g.i;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f46228a;

    /* renamed from: b  reason: collision with root package name */
    public String f46229b;

    /* renamed from: c  reason: collision with root package name */
    public int f46230c;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f46228a);
            jSONObject.put("displayName", this.f46229b);
            jSONObject.put("volumeLevel", this.f46230c);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
