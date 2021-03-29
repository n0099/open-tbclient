package d.b.g0.a.s0.g.i;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f45836a;

    /* renamed from: b  reason: collision with root package name */
    public String f45837b;

    /* renamed from: c  reason: collision with root package name */
    public int f45838c;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f45836a);
            jSONObject.put("displayName", this.f45837b);
            jSONObject.put("volumeLevel", this.f45838c);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
