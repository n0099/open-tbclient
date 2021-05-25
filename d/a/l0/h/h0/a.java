package d.a.l0.h.h0;

import d.a.l0.a.j2.p.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends e {
    public int k;
    public String l;
    public int m;
    public int n;
    public long o;

    @Override // d.a.l0.a.j2.p.e
    public JSONObject f() {
        if (this.f43192h == null) {
            this.f43192h = new JSONObject();
        }
        try {
            this.f43192h.put("stage", this.k);
            this.f43192h.put("errMsg", this.l);
            this.f43192h.put("netStatus", this.m);
            this.f43192h.put("touch", this.n);
            this.f43192h.put("stuck_interval", this.o);
        } catch (JSONException e2) {
            if (e.j) {
                e2.printStackTrace();
            }
        }
        return super.f();
    }
}
