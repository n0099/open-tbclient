package d.a.b0.b.f;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import d.a.b0.a.c.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i {
    public static long a() {
        return j.b("last_show_time", 0L);
    }

    public static JSONArray b() {
        String d2 = j.d("today_show_list", "");
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONArray(d2);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject optJSONObject = jSONArray2.optJSONObject(i2);
                try {
                    if (d.a.b0.a.c.c.a(Long.valueOf(Long.valueOf(optJSONObject.optString("t").split("_")[0]).longValue()), Long.valueOf(System.currentTimeMillis()))) {
                        jSONArray.put(optJSONObject);
                    }
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        j.f("today_show_list", jSONArray.toString());
        return jSONArray;
    }

    public static void c(g gVar) {
        j.e("last_show_time", System.currentTimeMillis() / 1000);
        d(gVar);
    }

    public static void d(g gVar) {
        String d2 = j.d("today_show_list", "");
        String valueOf = String.valueOf(System.currentTimeMillis());
        try {
            JSONArray jSONArray = new JSONArray(d2);
            boolean z = false;
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (TextUtils.equals(optJSONObject.optString(Config.APP_KEY), gVar.f39346c)) {
                        optJSONObject.put("t", TextUtils.concat(valueOf, "_", optJSONObject.optString("t")).toString());
                        jSONArray.put(i2, optJSONObject);
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Config.APP_KEY, gVar.f39346c);
                jSONObject.put("t", valueOf);
                jSONArray.put(jSONObject);
            }
            j.f("today_show_list", jSONArray.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
