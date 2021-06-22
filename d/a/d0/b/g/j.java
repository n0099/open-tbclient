package d.a.d0.b.g;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j {
    public static long a() {
        return d.a.d0.a.c.j.d("last_show_time", 0L);
    }

    public static JSONArray b() {
        String f2 = d.a.d0.a.c.j.f("today_show_list", "");
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONArray(f2);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject optJSONObject = jSONArray2.optJSONObject(i2);
                try {
                    if (d.a.d0.a.c.c.a(Long.valueOf(Long.valueOf(optJSONObject.optString("t").split("_")[0]).longValue()), Long.valueOf(System.currentTimeMillis()))) {
                        jSONArray.put(optJSONObject);
                    }
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        d.a.d0.a.c.j.j("today_show_list", jSONArray.toString());
        return jSONArray;
    }

    public static void c(h hVar) {
        d.a.d0.a.c.j.i("last_show_time", System.currentTimeMillis() / 1000);
        d(hVar);
    }

    public static void d(h hVar) {
        String f2 = d.a.d0.a.c.j.f("today_show_list", "");
        String valueOf = String.valueOf(System.currentTimeMillis());
        try {
            JSONArray jSONArray = new JSONArray(f2);
            boolean z = false;
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (TextUtils.equals(optJSONObject.optString(Config.APP_KEY), hVar.f43444c)) {
                        optJSONObject.put("t", TextUtils.concat(valueOf, "_", optJSONObject.optString("t")).toString());
                        jSONArray.put(i2, optJSONObject);
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Config.APP_KEY, hVar.f43444c);
                jSONObject.put("t", valueOf);
                jSONArray.put(jSONObject);
            }
            d.a.d0.a.c.j.j("today_show_list", jSONArray.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
