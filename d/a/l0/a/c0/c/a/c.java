package d.a.l0.a.c0.c.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c extends d.a.l0.a.c0.a.d.b {
    public String A;
    public String x;
    public boolean y;
    public boolean z;

    public c() {
        super("animateview", "sanId");
        this.y = false;
        this.z = true;
        this.A = null;
    }

    @Override // d.a.l0.a.c0.a.d.b, d.a.l0.a.c0.b.b, d.a.l0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.x = jSONObject.optString("path");
        this.y = jSONObject.optBoolean("loop");
        this.z = jSONObject.optBoolean("autoPlay");
        this.A = jSONObject.optString("action");
    }

    @Override // d.a.l0.a.c0.b.b, d.a.l0.a.l1.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.f40846g) || TextUtils.isEmpty(this.f40845f)) ? false : true;
    }

    public boolean j() {
        return isValid() && !TextUtils.isEmpty(this.x);
    }
}
