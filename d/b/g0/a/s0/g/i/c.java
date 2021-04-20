package d.b.g0.a.s0.g.i;

import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f46236a;

    /* renamed from: b  reason: collision with root package name */
    public String f46237b;

    /* renamed from: c  reason: collision with root package name */
    public String f46238c;

    /* renamed from: d  reason: collision with root package name */
    public int f46239d;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f46236a);
            jSONObject.put("displayName", this.f46237b);
            jSONObject.put(Config.EVENT_ATTR, this.f46238c);
            jSONObject.put("role", this.f46239d);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
