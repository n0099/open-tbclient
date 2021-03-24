package d.b.g0.a.s0.g.i;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f45835a;

    /* renamed from: b  reason: collision with root package name */
    public String f45836b;

    /* renamed from: c  reason: collision with root package name */
    public int f45837c;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f45835a);
            jSONObject.put("displayName", this.f45836b);
            jSONObject.put("volumeLevel", this.f45837c);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
