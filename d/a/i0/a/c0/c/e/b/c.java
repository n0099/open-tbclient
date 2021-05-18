package d.a.i0.a.c0.c.e.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c extends d.a.i0.a.c0.a.b.b {
    public boolean y;

    public c() {
        super("coverImage", "viewId");
        this.y = false;
    }

    @Override // d.a.i0.a.c0.a.b.b, d.a.i0.a.c0.a.d.b, d.a.i0.a.c0.b.b, d.a.i0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.y = jSONObject.optBoolean("loadState", false);
        d.a.i0.a.l1.e.a.a aVar = this.l;
        if (aVar == null || (jSONObject2 = this.n) == null) {
            return;
        }
        aVar.j(jSONObject2.optBoolean("fixed", false));
    }
}
