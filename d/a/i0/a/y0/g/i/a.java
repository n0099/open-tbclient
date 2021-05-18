package d.a.i0.a.y0.g.i;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f45650a;

    /* renamed from: b  reason: collision with root package name */
    public String f45651b;

    /* renamed from: c  reason: collision with root package name */
    public int f45652c;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f45650a);
            jSONObject.put("displayName", this.f45651b);
            jSONObject.put("volumeLevel", this.f45652c);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
