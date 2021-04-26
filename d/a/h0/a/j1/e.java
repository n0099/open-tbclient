package d.a.h0.a.j1;

import android.util.Log;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42922a = d.a.h0.a.k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f42923b;

    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject d2 = i.n().d();
            if (d2 != null && d2.has("events")) {
                jSONObject = d2;
            } else if (f42923b != null) {
                jSONObject = f42923b;
            }
        } catch (JSONException e2) {
            if (f42922a) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e2);
            }
        }
        f42923b = null;
        return jSONObject;
    }

    public static void b() {
        try {
            JSONObject d2 = i.n().d();
            f42923b = d2;
            if (d2 != null) {
                d2.put("_ts", d.a.h0.a.i2.j.b(new Date(), "yyyy-MM-dd HH:mm:ss"));
            }
        } catch (JSONException e2) {
            if (f42922a) {
                Log.e("PerformanceUbcSnapshot", "JSONException:", e2);
            }
        }
    }
}
