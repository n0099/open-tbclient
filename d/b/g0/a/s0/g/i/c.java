package d.b.g0.a.s0.g.i;

import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f45844a;

    /* renamed from: b  reason: collision with root package name */
    public String f45845b;

    /* renamed from: c  reason: collision with root package name */
    public String f45846c;

    /* renamed from: d  reason: collision with root package name */
    public int f45847d;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f45844a);
            jSONObject.put("displayName", this.f45845b);
            jSONObject.put(Config.EVENT_ATTR, this.f45846c);
            jSONObject.put("role", this.f45847d);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
