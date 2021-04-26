package d.a.h0.a.s0.g.i;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f43924a;

    /* renamed from: b  reason: collision with root package name */
    public String f43925b;

    /* renamed from: c  reason: collision with root package name */
    public int f43926c;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f43924a);
            jSONObject.put("displayName", this.f43925b);
            jSONObject.put("volumeLevel", this.f43926c);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
