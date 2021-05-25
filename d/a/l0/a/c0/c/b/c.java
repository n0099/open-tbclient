package d.a.l0.a.c0.c.b;

import d.a.l0.a.v2.n0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c extends d.a.l0.a.c0.a.c.c {
    public c() {
        super("button", "buttonId");
    }

    @Override // d.a.l0.a.c0.a.c.c, d.a.l0.a.c0.a.d.b, d.a.l0.a.c0.b.b, d.a.l0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        JSONObject jSONObject2 = this.n;
        if (jSONObject2 != null) {
            n0.g((float) jSONObject2.optDouble("lineHeight", 0.0d));
        }
    }
}
