package d.a.m0.a.m2.c;

import android.util.Log;
import d.a.m0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47284a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f47285b;

    public static synchronized JSONObject a() {
        synchronized (a.class) {
            if (f47285b != null) {
                if (f47284a) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + f47285b.toString());
                }
                return f47285b;
            }
            JSONObject rawSwitch = d.a.m0.a.c1.a.Z().getRawSwitch();
            if (rawSwitch == null) {
                f47285b = new JSONObject();
                if (f47284a) {
                    Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                }
                return f47285b;
            }
            Iterator<String> keys = rawSwitch.keys();
            while (keys.hasNext()) {
                if (!keys.next().startsWith("swanswitch")) {
                    keys.remove();
                }
            }
            f47285b = rawSwitch;
            if (f47284a) {
                Log.d("SwanCoreConfigHelper", "return new obj : " + f47285b.toString());
            }
            return f47285b;
        }
    }

    public static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("abTestSwitch", a());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static synchronized void c() {
        synchronized (a.class) {
            if (f47284a) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            f47285b = null;
        }
    }
}
