package d.a.i0.a.y0.g.i;

import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f45658a;

    /* renamed from: b  reason: collision with root package name */
    public String f45659b;

    /* renamed from: c  reason: collision with root package name */
    public String f45660c;

    /* renamed from: d  reason: collision with root package name */
    public int f45661d;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f45658a);
            jSONObject.put("displayName", this.f45659b);
            jSONObject.put(Config.EVENT_ATTR, this.f45660c);
            jSONObject.put("role", this.f45661d);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
