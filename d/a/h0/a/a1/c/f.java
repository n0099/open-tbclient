package d.a.h0.a.a1.c;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends c {
    public d.a.h0.a.a1.c.h.c E;
    public String D = "";
    public int F = 1000;

    @Override // d.a.h0.a.a1.c.c, d.a.h0.a.a0.b.b, d.a.h0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.D = jSONObject.optString("markerId");
        d.a.h0.a.a1.c.h.c cVar = new d.a.h0.a.a1.c.h.c();
        this.E = cVar;
        cVar.a(jSONObject.optJSONObject("destination"));
        jSONObject.optBoolean("autoRotate");
        jSONObject.optDouble("rotate");
        this.F = Math.abs(jSONObject.optInt("duration", this.F));
    }

    @Override // d.a.h0.a.a0.b.b, d.a.h0.a.e1.a
    public boolean isValid() {
        d.a.h0.a.a1.c.h.c cVar;
        return (TextUtils.isEmpty(this.f41093g) || TextUtils.isEmpty(this.f41092f) || TextUtils.isEmpty(this.D) || (cVar = this.E) == null || !cVar.isValid()) ? false : true;
    }
}
