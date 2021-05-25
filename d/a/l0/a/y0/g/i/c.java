package d.a.l0.a.y0.g.i;

import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f45834a;

    /* renamed from: b  reason: collision with root package name */
    public String f45835b;

    /* renamed from: c  reason: collision with root package name */
    public String f45836c;

    /* renamed from: d  reason: collision with root package name */
    public int f45837d;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f45834a);
            jSONObject.put("displayName", this.f45835b);
            jSONObject.put(Config.EVENT_ATTR, this.f45836c);
            jSONObject.put("role", this.f45837d);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
