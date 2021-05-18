package d.a.i0.h.h0;

import d.a.i0.a.j2.p.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends e {
    public int k;
    public String l;
    public int m;
    public int n;
    public long o;

    @Override // d.a.i0.a.j2.p.e
    public JSONObject f() {
        if (this.f43018h == null) {
            this.f43018h = new JSONObject();
        }
        try {
            this.f43018h.put("stage", this.k);
            this.f43018h.put("errMsg", this.l);
            this.f43018h.put("netStatus", this.m);
            this.f43018h.put("touch", this.n);
            this.f43018h.put("stuck_interval", this.o);
        } catch (JSONException e2) {
            if (e.j) {
                e2.printStackTrace();
            }
        }
        return super.f();
    }
}
