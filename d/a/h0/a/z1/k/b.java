package d.a.h0.a.z1.k;

import android.text.TextUtils;
import d.a.h0.a.y0.e.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends e {
    public String j = "";

    @Override // d.a.h0.a.z1.k.e
    public JSONObject f() {
        d.a.h0.a.r1.e F;
        if (this.f45417g == null) {
            this.f45417g = new JSONObject();
        }
        if (TextUtils.isEmpty(this.j) && (F = d.a.h0.a.z0.f.V().F()) != null) {
            b.a L = F.L();
            this.j = L != null ? L.S() : "";
        }
        try {
            this.f45417g.put("source", this.j);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return super.f();
    }
}
