package d.a.m0.a.y0.g.i;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f49608a;

    /* renamed from: b  reason: collision with root package name */
    public String f49609b;

    /* renamed from: c  reason: collision with root package name */
    public int f49610c;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f49608a);
            jSONObject.put("displayName", this.f49609b);
            jSONObject.put("volumeLevel", this.f49610c);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
