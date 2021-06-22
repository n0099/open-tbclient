package d.a.m0.a.h1.c;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends c {
    public d.a.m0.a.h1.c.h.c E;
    public double F;
    public String D = "";
    public int G = 1000;

    @Override // d.a.m0.a.h1.c.c, d.a.m0.a.c0.b.b, d.a.m0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.D = jSONObject.optString("markerId");
        d.a.m0.a.h1.c.h.c cVar = new d.a.m0.a.h1.c.h.c();
        this.E = cVar;
        cVar.a(jSONObject.optJSONObject("destination"));
        jSONObject.optBoolean("autoRotate");
        this.F = jSONObject.optDouble("rotate");
        this.G = Math.abs(jSONObject.optInt("duration", this.G));
    }

    @Override // d.a.m0.a.c0.b.b, d.a.m0.a.l1.a
    public boolean isValid() {
        d.a.m0.a.h1.c.h.c cVar;
        return (TextUtils.isEmpty(this.f44630g) || TextUtils.isEmpty(this.f44629f) || TextUtils.isEmpty(this.D) || (cVar = this.E) == null || !cVar.isValid()) ? false : true;
    }
}
