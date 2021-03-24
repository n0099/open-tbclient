package d.b.g0.a.s0.g.i;

import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f45843a;

    /* renamed from: b  reason: collision with root package name */
    public String f45844b;

    /* renamed from: c  reason: collision with root package name */
    public String f45845c;

    /* renamed from: d  reason: collision with root package name */
    public int f45846d;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f45843a);
            jSONObject.put("displayName", this.f45844b);
            jSONObject.put(Config.EVENT_ATTR, this.f45845c);
            jSONObject.put("role", this.f45846d);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
