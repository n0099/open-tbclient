package d.b.g0.g.c0;

import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f48013a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.g.c0.e.d f48014b;

    /* renamed from: c  reason: collision with root package name */
    public int f48015c;

    /* renamed from: d  reason: collision with root package name */
    public long f48016d;

    public a(int i, d.b.g0.g.c0.e.d dVar) {
        this.f48013a = i;
        this.f48014b = dVar;
        this.f48015c = d.d() ? 20 : 10;
        this.f48016d = System.currentTimeMillis();
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f48013a);
            jSONObject.put("stage", this.f48015c);
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.f48016d);
            if (this.f48014b != null) {
                jSONObject.put("msg", this.f48014b.a());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
