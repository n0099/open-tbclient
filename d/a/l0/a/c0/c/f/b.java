package d.a.l0.a.c0.c.f;

import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b extends d.a.l0.a.c0.a.a.b {
    public String O;
    public boolean P;
    public boolean Q;

    public b() {
        super(Config.INPUT_PART, "viewId");
    }

    @Override // d.a.l0.a.c0.a.a.b, d.a.l0.a.c0.a.c.c, d.a.l0.a.c0.a.d.b, d.a.l0.a.c0.b.b, d.a.l0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        if (this.l == null) {
            this.l = new d.a.l0.a.l1.e.a.a();
        }
        this.x = jSONObject.optString("value");
        this.O = jSONObject.optString("type");
        this.P = jSONObject.optInt("confirmHold") == 1;
        this.Q = jSONObject.optInt("adjustPosition", 1) == 1;
    }
}
