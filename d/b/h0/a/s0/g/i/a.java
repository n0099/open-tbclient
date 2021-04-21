package d.b.h0.a.s0.g.i;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f46557a;

    /* renamed from: b  reason: collision with root package name */
    public String f46558b;

    /* renamed from: c  reason: collision with root package name */
    public int f46559c;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f46557a);
            jSONObject.put("displayName", this.f46558b);
            jSONObject.put("volumeLevel", this.f46559c);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
