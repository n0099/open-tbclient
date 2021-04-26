package d.a.h0.g.k0.e;

import android.util.Log;
import d.a.h0.a.z1.k.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends e {
    public String j = "";

    @Override // d.a.h0.a.z1.k.e
    public JSONObject f() {
        if (this.f45417g == null) {
            this.f45417g = new JSONObject();
        }
        try {
            this.f45417g.put("error_code", this.j);
        } catch (JSONException e2) {
            if (e.f45410i) {
                e2.printStackTrace();
            }
        }
        if (e.f45410i) {
            Log.d("SwanGameAdEvent", "SwanGameAdEvent: mExt=" + this.f45417g + "\t " + Thread.currentThread().getId());
        }
        return super.f();
    }
}
