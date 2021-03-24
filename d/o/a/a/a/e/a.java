package d.o.a.a.a.e;

import androidx.annotation.NonNull;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static long a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0L;
        }
        try {
            return Long.valueOf(jSONObject.optString(str)).longValue();
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    @NonNull
    public static JSONObject b(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        c(jSONObject, jSONObject2);
        return jSONObject2;
    }

    public static JSONObject c(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject2;
    }

    @NonNull
    public static JSONObject d(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectArr != null && jSONObjectArr.length != 0) {
            for (JSONObject jSONObject2 : jSONObjectArr) {
                if (jSONObject2 != null) {
                    c(jSONObject2, jSONObject);
                }
            }
        }
        return jSONObject;
    }

    public static boolean e(d.o.a.e.b.j.a aVar, String str) {
        if (aVar == null || aVar.b("apk_update_handler_enable", 1) != 1) {
            return false;
        }
        return "application/ttpatch".equals(str);
    }
}
