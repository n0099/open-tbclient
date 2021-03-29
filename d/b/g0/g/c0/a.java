package d.b.g0.g.c0;

import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f48014a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.g.c0.e.d f48015b;

    /* renamed from: c  reason: collision with root package name */
    public int f48016c;

    /* renamed from: d  reason: collision with root package name */
    public long f48017d;

    public a(int i, d.b.g0.g.c0.e.d dVar) {
        this.f48014a = i;
        this.f48015b = dVar;
        this.f48016c = d.d() ? 20 : 10;
        this.f48017d = System.currentTimeMillis();
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f48014a);
            jSONObject.put("stage", this.f48016c);
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.f48017d);
            if (this.f48015b != null) {
                jSONObject.put("msg", this.f48015b.a());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
