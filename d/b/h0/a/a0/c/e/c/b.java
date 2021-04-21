package d.b.h0.a.a0.c.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b extends d.b.h0.a.a0.a.c.b {
    public int G;
    public String H;

    public b() {
        super("coverView", "viewId");
        this.H = "";
    }

    @Override // d.b.h0.a.a0.a.c.b, d.b.h0.a.a0.a.d.b, d.b.h0.a.a0.b.b, d.b.h0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.G = jSONObject.optInt("scrollTop");
        JSONObject jSONObject3 = this.n;
        if (jSONObject3 != null) {
            this.H = jSONObject3.optString("overflowY");
        }
        d.b.h0.a.e1.d.a.a aVar = this.l;
        if (aVar == null || (jSONObject2 = this.n) == null) {
            return;
        }
        aVar.j(jSONObject2.optBoolean("fixed", false));
    }
}
