package d.b.g0.a.a1.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends c {
    public d.b.g0.a.a1.c.h.c D;
    public String E = "";
    public String F = "";
    public String G = "";

    @Override // d.b.g0.a.a1.c.c, d.b.g0.a.a0.b.b, d.b.g0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.E = jSONObject.optString("cb");
        double optDouble = jSONObject.optDouble("latitude");
        double optDouble2 = jSONObject.optDouble("longitude");
        this.F = jSONObject.optString("guideKey");
        this.G = jSONObject.optString("guideIcon");
        if (Double.isNaN(optDouble) || Double.isNaN(optDouble2) || optDouble < -90.0d || optDouble > 90.0d || optDouble2 < -180.0d || optDouble2 > 180.0d) {
            return;
        }
        d.b.g0.a.a1.c.h.c cVar = new d.b.g0.a.a1.c.h.c();
        this.D = cVar;
        cVar.a(jSONObject);
    }

    @Override // d.b.g0.a.a0.b.b, d.b.g0.a.e1.a
    public boolean isValid() {
        return this.D != null;
    }
}
