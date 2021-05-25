package d.a.l0.a.y0.g.i;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f45826a;

    /* renamed from: b  reason: collision with root package name */
    public String f45827b;

    /* renamed from: c  reason: collision with root package name */
    public int f45828c;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f45826a);
            jSONObject.put("displayName", this.f45827b);
            jSONObject.put("volumeLevel", this.f45828c);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
