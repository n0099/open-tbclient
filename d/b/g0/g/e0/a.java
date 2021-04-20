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
        if (this.f47649g == null) {
            this.f47649g = new JSONObject();
        }
        try {
            this.f47649g.put("stage", this.j);
            this.f47649g.put("errMsg", this.k);
            this.f47649g.put("netStatus", this.l);
            this.f47649g.put("touch", this.m);
            this.f47649g.put("stuck_interval", this.n);
        } catch (JSONException e2) {
            if (e.i) {
                e2.printStackTrace();
            }
        }
        return super.f();
    }
}
