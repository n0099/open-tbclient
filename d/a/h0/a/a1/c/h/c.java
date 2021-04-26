package d.a.h0.a.a1.c.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c implements d.a.h0.a.e1.a {

    /* renamed from: e  reason: collision with root package name */
    public double f41178e = -200.0d;

    /* renamed from: f  reason: collision with root package name */
    public double f41179f = -200.0d;

    @Override // d.a.h0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("longitude") && jSONObject.has("latitude")) {
            this.f41178e = jSONObject.optDouble("latitude", this.f41178e);
            this.f41179f = jSONObject.optDouble("longitude", this.f41179f);
        }
    }

    @Override // d.a.h0.a.e1.a
    public boolean isValid() {
        double d2 = this.f41178e;
        if (d2 >= -90.0d && d2 <= 90.0d) {
            double d3 = this.f41179f;
            if (d3 >= -180.0d && d3 <= 180.0d) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "[latitude：" + this.f41178e + "longitude：" + this.f41179f + "]";
    }
}
