package d.a.l0.a.h1.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends c {
    public d.a.l0.a.h1.c.h.c D;

    @Override // d.a.l0.a.h1.c.c, d.a.l0.a.c0.b.b, d.a.l0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        jSONObject.optString("cb");
        double optDouble = jSONObject.optDouble("latitude");
        double optDouble2 = jSONObject.optDouble("longitude");
        jSONObject.optString("guideKey");
        jSONObject.optString("guideIcon");
        if (Double.isNaN(optDouble) || Double.isNaN(optDouble2) || optDouble < -90.0d || optDouble > 90.0d || optDouble2 < -180.0d || optDouble2 > 180.0d) {
            return;
        }
        d.a.l0.a.h1.c.h.c cVar = new d.a.l0.a.h1.c.h.c();
        this.D = cVar;
        cVar.a(jSONObject);
    }

    @Override // d.a.l0.a.c0.b.b, d.a.l0.a.l1.a
    public boolean isValid() {
        return this.D != null;
    }
}
