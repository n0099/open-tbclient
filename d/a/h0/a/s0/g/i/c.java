package d.a.h0.a.s0.g.i;

import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f43932a;

    /* renamed from: b  reason: collision with root package name */
    public String f43933b;

    /* renamed from: c  reason: collision with root package name */
    public String f43934c;

    /* renamed from: d  reason: collision with root package name */
    public int f43935d;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f43932a);
            jSONObject.put("displayName", this.f43933b);
            jSONObject.put(Config.EVENT_ATTR, this.f43934c);
            jSONObject.put("role", this.f43935d);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
