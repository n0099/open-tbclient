package d.b.h0.a.b2.c;

import android.util.Log;
import d.b.h0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44290a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f44291b;

    public static synchronized JSONObject a() {
        synchronized (a.class) {
            if (f44291b != null) {
                if (f44290a) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + f44291b.toString());
                }
                return f44291b;
            }
            JSONObject rawSwitch = d.b.h0.a.w0.a.N().getRawSwitch();
            if (rawSwitch == null) {
                f44291b = new JSONObject();
                if (f44290a) {
                    Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                }
                return f44291b;
            }
            Iterator<String> keys = rawSwitch.keys();
            while (keys.hasNext()) {
                if (!keys.next().startsWith("swanswitch")) {
                    keys.remove();
                }
            }
            f44291b = rawSwitch;
            if (f44290a) {
                Log.d("SwanCoreConfigHelper", "return new obj : " + f44291b.toString());
            }
            return f44291b;
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
            if (f44290a) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            f44291b = null;
        }
    }
}
