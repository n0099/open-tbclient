package d.b.g0.g.e0;

import d.b.g0.a.z1.k.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends e {
    public int j;
    public String k;
    public int l;
    public int m;
    public long n;

    @Override // d.b.g0.a.z1.k.e
    public JSONObject f() {
        if (this.f47257g == null) {
            this.f47257g = new JSONObject();
        }
        try {
            this.f47257g.put("stage", this.j);
            this.f47257g.put("errMsg", this.k);
            this.f47257g.put("netStatus", this.l);
            this.f47257g.put("touch", this.m);
            this.f47257g.put("stuck_interval", this.n);
        } catch (JSONException e2) {
            if (e.i) {
                e2.printStackTrace();
            }
        }
        return super.f();
    }
}
