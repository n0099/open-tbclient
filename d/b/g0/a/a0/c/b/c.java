package d.b.g0.a.a0.c.b;

import d.b.g0.a.i2.h0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c extends d.b.g0.a.a0.a.c.b {
    public c() {
        super("button", "buttonId");
    }

    @Override // d.b.g0.a.a0.a.c.b, d.b.g0.a.a0.a.d.b, d.b.g0.a.a0.b.b, d.b.g0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        JSONObject jSONObject2 = this.n;
        if (jSONObject2 != null) {
            this.B = h0.f((float) jSONObject2.optDouble("lineHeight", 0.0d));
        }
    }
}
