package d.a.l0.a.y0.g.i;

import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f49508a;

    /* renamed from: b  reason: collision with root package name */
    public String f49509b;

    /* renamed from: c  reason: collision with root package name */
    public String f49510c;

    /* renamed from: d  reason: collision with root package name */
    public int f49511d;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f49508a);
            jSONObject.put("displayName", this.f49509b);
            jSONObject.put(Config.EVENT_ATTR, this.f49510c);
            jSONObject.put("role", this.f49511d);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
