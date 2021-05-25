package d.a.l0.a.h1.c.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements d.a.l0.a.l1.a {

    /* renamed from: e  reason: collision with root package name */
    public double f42673e = -200.0d;

    /* renamed from: f  reason: collision with root package name */
    public double f42674f = -200.0d;

    @Override // d.a.l0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("longitude") && jSONObject.has("latitude")) {
            this.f42673e = jSONObject.optDouble("latitude", this.f42673e);
            this.f42674f = jSONObject.optDouble("longitude", this.f42674f);
        }
    }

    @Override // d.a.l0.a.l1.a
    public boolean isValid() {
        double d2 = this.f42673e;
        if (d2 >= -90.0d && d2 <= 90.0d) {
            double d3 = this.f42674f;
            if (d3 >= -180.0d && d3 <= 180.0d) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "[latitude：" + this.f42673e + "longitude：" + this.f42674f + "]";
    }
}
