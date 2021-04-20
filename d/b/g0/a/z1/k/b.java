package d.b.g0.a.z1.k;

import android.text.TextUtils;
import d.b.g0.a.y0.e.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends e {
    public String j = "";

    @Override // d.b.g0.a.z1.k.e
    public JSONObject f() {
        d.b.g0.a.r1.e t;
        if (this.f47649g == null) {
            this.f47649g = new JSONObject();
        }
        if (TextUtils.isEmpty(this.j) && (t = d.b.g0.a.z0.f.V().t()) != null) {
            b.a L = t.L();
            this.j = L != null ? L.S() : "";
        }
        try {
            this.f47649g.put("source", this.j);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return super.f();
    }
}
