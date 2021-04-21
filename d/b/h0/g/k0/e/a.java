package d.b.h0.g.k0.e;

import android.util.Log;
import d.b.h0.a.z1.k.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends e {
    public String j = "";

    @Override // d.b.h0.a.z1.k.e
    public JSONObject f() {
        if (this.f47978g == null) {
            this.f47978g = new JSONObject();
        }
        try {
            this.f47978g.put("error_code", this.j);
        } catch (JSONException e2) {
            if (e.i) {
                e2.printStackTrace();
            }
        }
        if (e.i) {
            Log.d("SwanGameAdEvent", "SwanGameAdEvent: mExt=" + this.f47978g + "\t " + Thread.currentThread().getId());
        }
        return super.f();
    }
}
