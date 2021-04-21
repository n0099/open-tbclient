package d.b.h0.a.a1.c;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends c {
    public d.b.h0.a.a1.c.h.c E;
    public String D = "";
    public int F = 1000;

    @Override // d.b.h0.a.a1.c.c, d.b.h0.a.a0.b.b, d.b.h0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.D = jSONObject.optString("markerId");
        d.b.h0.a.a1.c.h.c cVar = new d.b.h0.a.a1.c.h.c();
        this.E = cVar;
        cVar.a(jSONObject.optJSONObject("destination"));
        jSONObject.optBoolean("autoRotate");
        jSONObject.optDouble("rotate");
        this.F = Math.abs(jSONObject.optInt("duration", this.F));
    }

    @Override // d.b.h0.a.a0.b.b, d.b.h0.a.e1.a
    public boolean isValid() {
        d.b.h0.a.a1.c.h.c cVar;
        return (TextUtils.isEmpty(this.f43835g) || TextUtils.isEmpty(this.f43834f) || TextUtils.isEmpty(this.D) || (cVar = this.E) == null || !cVar.isValid()) ? false : true;
    }
}
