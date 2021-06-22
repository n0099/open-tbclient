package d.a.m0.a.y0.g.i;

import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f49616a;

    /* renamed from: b  reason: collision with root package name */
    public String f49617b;

    /* renamed from: c  reason: collision with root package name */
    public String f49618c;

    /* renamed from: d  reason: collision with root package name */
    public int f49619d;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f49616a);
            jSONObject.put("displayName", this.f49617b);
            jSONObject.put(Config.EVENT_ATTR, this.f49618c);
            jSONObject.put("role", this.f49619d);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
