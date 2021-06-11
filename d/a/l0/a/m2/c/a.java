package d.a.l0.a.m2.c;

import android.util.Log;
import d.a.l0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47176a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f47177b;

    public static synchronized JSONObject a() {
        synchronized (a.class) {
            if (f47177b != null) {
                if (f47176a) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + f47177b.toString());
                }
                return f47177b;
            }
            JSONObject rawSwitch = d.a.l0.a.c1.a.Z().getRawSwitch();
            if (rawSwitch == null) {
                f47177b = new JSONObject();
                if (f47176a) {
                    Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                }
                return f47177b;
            }
            Iterator<String> keys = rawSwitch.keys();
            while (keys.hasNext()) {
                if (!keys.next().startsWith("swanswitch")) {
                    keys.remove();
                }
            }
            f47177b = rawSwitch;
            if (f47176a) {
                Log.d("SwanCoreConfigHelper", "return new obj : " + f47177b.toString());
            }
            return f47177b;
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
            if (f47176a) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            f47177b = null;
        }
    }
}
