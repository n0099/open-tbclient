package d.a.m0.a.h1.c.h;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements d.a.m0.a.l1.a {

    /* renamed from: e  reason: collision with root package name */
    public double f46457e = -200.0d;

    /* renamed from: f  reason: collision with root package name */
    public double f46458f = -200.0d;

    @Override // d.a.m0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("longitude") && jSONObject.has("latitude")) {
            this.f46457e = jSONObject.optDouble("latitude", this.f46457e);
            this.f46458f = jSONObject.optDouble("longitude", this.f46458f);
        }
    }

    @Override // d.a.m0.a.l1.a
    public boolean isValid() {
        double d2 = this.f46457e;
        if (d2 >= -90.0d && d2 <= 90.0d) {
            double d3 = this.f46458f;
            if (d3 >= -180.0d && d3 <= 180.0d) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "[latitude：" + this.f46457e + "longitude：" + this.f46458f + PreferencesUtil.RIGHT_MOUNT;
    }
}
