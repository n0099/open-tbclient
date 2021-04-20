package d.b.g0.a.j1;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45270a = d.b.g0.a.k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f45271b;

    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject d2 = i.n().d();
            if (d2 != null && d2.has("events")) {
                jSONObject = d2;
            } else if (f45271b != null) {
                jSONObject = f45271b;
            }
        } catch (JSONException e2) {
            if (f45270a) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e2);
            }
        }
        f45271b = null;
        return jSONObject;
    }

    public static void b() {
        try {
            JSONObject d2 = i.n().d();
            f45271b = d2;
            if (d2 != null) {
                d2.put("_ts", d.b.g0.a.i2.j.b(new Date(), "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (JSONException e2) {
            if (f45270a) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e2);
            }
        }
    }
}
