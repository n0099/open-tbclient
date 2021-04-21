package d.b.h0.g.e0;

import d.b.h0.a.z1.k.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends e {
    public int j;
    public String k;
    public int l;
    public int m;
    public long n;

    @Override // d.b.h0.a.z1.k.e
    public JSONObject f() {
        if (this.f47978g == null) {
            this.f47978g = new JSONObject();
        }
        try {
            this.f47978g.put("stage", this.j);
            this.f47978g.put("errMsg", this.k);
            this.f47978g.put("netStatus", this.l);
            this.f47978g.put("touch", this.m);
            this.f47978g.put("stuck_interval", this.n);
        } catch (JSONException e2) {
            if (e.i) {
                e2.printStackTrace();
            }
        }
        return super.f();
    }
}
