package d.b.h0.a.s0.g.i;

import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f46565a;

    /* renamed from: b  reason: collision with root package name */
    public String f46566b;

    /* renamed from: c  reason: collision with root package name */
    public String f46567c;

    /* renamed from: d  reason: collision with root package name */
    public int f46568d;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f46565a);
            jSONObject.put("displayName", this.f46566b);
            jSONObject.put(Config.EVENT_ATTR, this.f46567c);
            jSONObject.put("role", this.f46568d);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
