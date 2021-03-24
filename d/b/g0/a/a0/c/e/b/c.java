package d.b.g0.a.a0.c.e.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c extends d.b.g0.a.a0.a.b.b {
    public boolean y;

    public c() {
        super("coverImage", "viewId");
        this.y = false;
    }

    @Override // d.b.g0.a.a0.a.b.b, d.b.g0.a.a0.a.d.b, d.b.g0.a.a0.b.b, d.b.g0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.y = jSONObject.optBoolean("loadState", false);
        d.b.g0.a.e1.d.a.a aVar = this.l;
        if (aVar == null || (jSONObject2 = this.n) == null) {
            return;
        }
        aVar.j(jSONObject2.optBoolean("fixed", false));
    }
}
