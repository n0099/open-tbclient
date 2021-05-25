package d.a.l0.a.j2.p;

import android.text.TextUtils;
import d.a.l0.a.f1.e.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends e {
    public String k = "";

    @Override // d.a.l0.a.j2.p.e
    public JSONObject f() {
        d.a.l0.a.a2.e F;
        if (this.f43192h == null) {
            this.f43192h = new JSONObject();
        }
        if (TextUtils.isEmpty(this.k) && (F = d.a.l0.a.g1.f.V().F()) != null) {
            b.a N = F.N();
            this.k = N != null ? N.T() : "";
        }
        try {
            this.f43192h.put("source", this.k);
            String a2 = d.a.l0.a.r1.l.d.a();
            if (a2 != null) {
                this.f43192h.put("launchid", a2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return super.f();
    }
}
