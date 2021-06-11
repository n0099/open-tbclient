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
        if (this.f46868h == null) {
            this.f46868h = new JSONObject();
        }
        try {
            this.f46868h.put("stage", this.k);
            this.f46868h.put("errMsg", this.l);
            this.f46868h.put("netStatus", this.m);
            this.f46868h.put("touch", this.n);
            this.f46868h.put("stuck_interval", this.o);
        } catch (JSONException e2) {
            if (e.j) {
                e2.printStackTrace();
            }
        }
        return super.f();
    }
}
