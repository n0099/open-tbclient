package d.b.g0.a.i2;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44700a = d.b.g0.a.k.f45051a;

    public static String a() {
        return d.b.g0.a.r1.e.y() != null ? d.b.g0.a.r1.e.y().f45740f : "";
    }

    public static String b() {
        return j.b(j.a(), "yyyy-MM-dd");
    }

    public static int c() {
        JSONObject d2 = d(a());
        if (d2 != null) {
            return d2.optInt("launch_count", 0);
        }
        return 0;
    }

    public static JSONObject d(String str) {
        String string = d.b.g0.a.a2.g.h.a().getString("dailyInfo", "");
        if (f44700a) {
            Log.i("SwanAppUserVisitInfoUtils", "dailyInfo:" + string);
        }
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = TextUtils.isEmpty(string) ? new JSONObject() : new JSONObject(string);
            if (f(jSONObject2)) {
                jSONObject2.put("date", b());
            }
            jSONObject = jSONObject2.optJSONObject(str);
            if (jSONObject == null) {
                jSONObject2.put(str, new JSONObject());
                d.b.g0.a.a2.g.h.a().putString("dailyInfo", jSONObject2.toString());
                return jSONObject;
            }
        } catch (JSONException e2) {
            if (f44700a) {
                Log.e("SwanAppUserVisitInfoUtils", e2.getMessage());
            }
        }
        return jSONObject;
    }

    public static long e() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject d2 = d(a());
        long optLong = d2 != null ? d2.optLong("foreground_aiapp_last_time_local", 0L) : 0L;
        if (d2 != null) {
            return d2.optLong("visit_duration", 0L) + (currentTimeMillis - optLong);
        }
        return 0L;
    }

    public static boolean f(JSONObject jSONObject) {
        String b2 = b();
        String optString = jSONObject.optString("date", "");
        return TextUtils.isEmpty(optString) || !optString.equals(b2);
    }

    public static void g(long j) {
        i(a(), "foreground_aiapp_last_time_local", Long.valueOf(j));
    }

    public static void h() {
        i(a(), "visit_duration", Long.valueOf(e()));
    }

    public static void i(String str, String str2, Object obj) {
        JSONObject jSONObject;
        String string = d.b.g0.a.a2.g.h.a().getString("dailyInfo", "");
        if (f44700a) {
            Log.i("SwanAppUserVisitInfoUtils", TextUtils.isEmpty(string) ? "dailyinfo is null" : string);
        }
        try {
            if (TextUtils.isEmpty(string)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(string);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject != null) {
                optJSONObject.put(str2, obj);
            } else {
                jSONObject.put(str, new JSONObject());
            }
            d.b.g0.a.a2.g.h.a().putString("dailyInfo", jSONObject.toString());
        } catch (JSONException e2) {
            if (f44700a) {
                Log.e("SwanAppUserVisitInfoUtils", e2.getMessage());
            }
        }
    }
}
