package d.a.i0.a.c0.c.e.c;

import d.a.i0.a.c0.a.c.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b extends c {
    public int G;
    public String H;

    public b() {
        super("coverView", "viewId");
        this.H = "";
    }

    @Override // d.a.i0.a.c0.a.c.c, d.a.i0.a.c0.a.d.b, d.a.i0.a.c0.b.b, d.a.i0.a.l1.a
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
        d.a.i0.a.l1.e.a.a aVar = this.l;
        if (aVar == null || (jSONObject2 = this.n) == null) {
            return;
        }
        aVar.j(jSONObject2.optBoolean("fixed", false));
    }
}
