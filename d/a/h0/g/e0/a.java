package d.a.h0.g.e0;

import d.a.h0.a.z1.k.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends e {
    public int j;
    public String k;
    public int l;
    public int m;
    public long n;

    @Override // d.a.h0.a.z1.k.e
    public JSONObject f() {
        if (this.f45417g == null) {
            this.f45417g = new JSONObject();
        }
        try {
            this.f45417g.put("stage", this.j);
            this.f45417g.put("errMsg", this.k);
            this.f45417g.put("netStatus", this.l);
            this.f45417g.put("touch", this.m);
            this.f45417g.put("stuck_interval", this.n);
        } catch (JSONException e2) {
            if (e.f45410i) {
                e2.printStackTrace();
            }
        }
        return super.f();
    }
}
