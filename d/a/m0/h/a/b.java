package d.a.m0.h.a;

import android.util.Log;
import d.a.m0.a.j2.p.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends e {
    public String k = "";

    @Override // d.a.m0.a.j2.p.e
    public JSONObject f() {
        if (this.f46976h == null) {
            this.f46976h = new JSONObject();
        }
        try {
            this.f46976h.put("error_code", this.k);
        } catch (JSONException e2) {
            if (e.j) {
                e2.printStackTrace();
            }
        }
        if (e.j) {
            Log.d("SwanGameAdEvent", "SwanGameAdEvent: mExt=" + this.f46976h + "\t " + Thread.currentThread().getId());
        }
        return super.f();
    }
}
