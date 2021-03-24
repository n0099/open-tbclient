package d.b.g0.a.b2.c;

import android.util.Log;
import d.b.g0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43568a = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f43569b;

    public static synchronized JSONObject a() {
        synchronized (a.class) {
            if (f43569b != null) {
                if (f43568a) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + f43569b.toString());
                }
                return f43569b;
            }
            JSONObject rawSwitch = d.b.g0.a.w0.a.N().getRawSwitch();
            if (rawSwitch == null) {
                f43569b = new JSONObject();
                if (f43568a) {
                    Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                }
                return f43569b;
            }
            Iterator<String> keys = rawSwitch.keys();
            while (keys.hasNext()) {
                if (!keys.next().startsWith("swanswitch")) {
                    keys.remove();
                }
            }
            f43569b = rawSwitch;
            if (f43568a) {
                Log.d("SwanCoreConfigHelper", "return new obj : " + f43569b.toString());
            }
            return f43569b;
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
            if (f43568a) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            f43569b = null;
        }
    }
}
