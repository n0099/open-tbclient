package d.a.d0.b.g;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    public static int a() {
        return d.a.d0.a.c.j.c("hot_splash_max_count", 3);
    }

    public static float b() {
        return d.a.d0.a.c.j.b("hot_background_time", 5.0f);
    }

    public static float c() {
        return d.a.d0.a.c.j.b("hot_update_split_time", 5.0f);
    }

    public static int d() {
        return d.a.d0.a.c.j.c("query_time_out_advance", 100);
    }

    public static void e(JSONObject jSONObject) {
        g((float) jSONObject.optDouble("hot_background_time", 5.0d));
        f(jSONObject.optInt("hot_splash_max_count", 3));
    }

    public static void f(int i2) {
        d.a.d0.a.c.j.h("hot_splash_max_count", i2);
    }

    public static void g(float f2) {
        d.a.d0.a.c.j.g("hot_background_time", f2);
    }

    public static void h(float f2) {
        d.a.d0.a.c.j.g("hot_update_split_time", f2);
    }

    public static void i(int i2) {
        d.a.d0.a.c.j.h("query_time_out_advance", i2);
    }

    public static void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("freq");
            if (optJSONObject != null) {
                e(optJSONObject);
            }
            i(jSONObject.optInt("query_time_out_advance", 100));
            h((float) jSONObject.optDouble("hot_update_split_time", 5.0d));
        } catch (JSONException e2) {
            if (d.a.d0.a.a.a.f39588a) {
                e2.printStackTrace();
            }
        }
    }
}
