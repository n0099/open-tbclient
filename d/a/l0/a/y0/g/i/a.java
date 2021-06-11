package d.a.l0.a.y0.g.i;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f49500a;

    /* renamed from: b  reason: collision with root package name */
    public String f49501b;

    /* renamed from: c  reason: collision with root package name */
    public int f49502c;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f49500a);
            jSONObject.put("displayName", this.f49501b);
            jSONObject.put("volumeLevel", this.f49502c);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
