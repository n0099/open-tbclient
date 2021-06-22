package d.a.m0.n.j.i;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static int f51942a = -1;

    public static int a(String str) {
        int i2 = 5;
        if (c() <= 0) {
            return 5;
        }
        String string = d.a.m0.n.c.b().j().getString("expire_time", "");
        if (TextUtils.isEmpty(string)) {
            return 5;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            i2 = jSONObject.optInt("time", 5);
            JSONObject optJSONObject = jSONObject.optJSONObject("appkeys");
            if (optJSONObject == null) {
                return i2;
            }
            int optInt = optJSONObject.optInt(str, -1);
            return optInt < 0 ? i2 : optInt;
        } catch (JSONException e2) {
            if (d.a.m0.n.c.f51766a) {
                e2.printStackTrace();
            }
            return i2;
        }
    }

    public static long b(String str) {
        return TimeUnit.HOURS.toMillis(a(str));
    }

    public static int c() {
        if (f51942a < 0) {
            d.a.m0.n.c.b().C("swan_update_expired_time", 0);
            f51942a = 0;
        }
        return f51942a;
    }

    public static String d() {
        return d.a.m0.n.c.b().j().getString("expire_time_version", "0");
    }

    public static void e(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        if (d.a.m0.n.c.f51766a) {
            Log.d("UpdateExpireTimeManager", "processUpdateExpireTime: data" + jSONObject);
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        d.a.m0.n.c.b().j().putString("expire_time_version", optString);
        d.a.m0.n.c.b().j().putString("expire_time", optJSONObject.toString());
    }
}
