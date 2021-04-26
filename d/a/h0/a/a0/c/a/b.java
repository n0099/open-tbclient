package d.a.h0.a.a0.c.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b extends d.a.h0.a.a0.a.d.b {
    public String A;
    public String x;
    public boolean y;
    public boolean z;

    public b() {
        super("animateview", "sanId");
        this.y = false;
        this.z = true;
        this.A = null;
    }

    @Override // d.a.h0.a.a0.a.d.b, d.a.h0.a.a0.b.b, d.a.h0.a.e1.a
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

    @Override // d.a.h0.a.a0.b.b, d.a.h0.a.e1.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.f41093g) || TextUtils.isEmpty(this.f41092f)) ? false : true;
    }

    public boolean j() {
        return isValid() && !TextUtils.isEmpty(this.x);
    }
}
