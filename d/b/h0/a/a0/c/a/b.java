package d.b.h0.a.a0.c.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b extends d.b.h0.a.a0.a.d.b {
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

    @Override // d.b.h0.a.a0.a.d.b, d.b.h0.a.a0.b.b, d.b.h0.a.e1.a
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

    @Override // d.b.h0.a.a0.b.b, d.b.h0.a.e1.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.f43835g) || TextUtils.isEmpty(this.f43834f)) ? false : true;
    }

    public boolean j() {
        return isValid() && !TextUtils.isEmpty(this.x);
    }
}
