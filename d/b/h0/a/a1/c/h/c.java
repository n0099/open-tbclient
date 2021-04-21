package d.b.h0.a.a1.c.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c implements d.b.h0.a.e1.a {

    /* renamed from: e  reason: collision with root package name */
    public double f43912e = -200.0d;

    /* renamed from: f  reason: collision with root package name */
    public double f43913f = -200.0d;

    @Override // d.b.h0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("longitude") && jSONObject.has("latitude")) {
            this.f43912e = jSONObject.optDouble("latitude", this.f43912e);
            this.f43913f = jSONObject.optDouble("longitude", this.f43913f);
        }
    }

    @Override // d.b.h0.a.e1.a
    public boolean isValid() {
        double d2 = this.f43912e;
        if (d2 >= -90.0d && d2 <= 90.0d) {
            double d3 = this.f43913f;
            if (d3 >= -180.0d && d3 <= 180.0d) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "[latitude：" + this.f43912e + "longitude：" + this.f43913f + "]";
    }
}
