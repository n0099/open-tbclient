package d.a.h0.a.a0.c.b;

import d.a.h0.a.i2.h0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c extends d.a.h0.a.a0.a.c.b {
    public c() {
        super("button", "buttonId");
    }

    @Override // d.a.h0.a.a0.a.c.b, d.a.h0.a.a0.a.d.b, d.a.h0.a.a0.b.b, d.a.h0.a.e1.a
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
