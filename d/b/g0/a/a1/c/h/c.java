package d.b.g0.a.a1.c.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements d.b.g0.a.e1.a {

    /* renamed from: e  reason: collision with root package name */
    public double f43190e = -200.0d;

    /* renamed from: f  reason: collision with root package name */
    public double f43191f = -200.0d;

    @Override // d.b.g0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("longitude") && jSONObject.has("latitude")) {
            this.f43190e = jSONObject.optDouble("latitude", this.f43190e);
            this.f43191f = jSONObject.optDouble("longitude", this.f43191f);
        }
    }

    @Override // d.b.g0.a.e1.a
    public boolean isValid() {
        double d2 = this.f43190e;
        if (d2 >= -90.0d && d2 <= 90.0d) {
            double d3 = this.f43191f;
            if (d3 >= -180.0d && d3 <= 180.0d) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "[latitude：" + this.f43190e + "longitude：" + this.f43191f + "]";
    }
}
