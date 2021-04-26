package d.a.h0.a.b2.c;

import android.util.Log;
import d.a.h0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41574a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f41575b;

    public static synchronized JSONObject a() {
        synchronized (a.class) {
            if (f41575b != null) {
                if (f41574a) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + f41575b.toString());
                }
                return f41575b;
            }
            JSONObject rawSwitch = d.a.h0.a.w0.a.N().getRawSwitch();
            if (rawSwitch == null) {
                f41575b = new JSONObject();
                if (f41574a) {
                    Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                }
                return f41575b;
            }
            Iterator<String> keys = rawSwitch.keys();
            while (keys.hasNext()) {
                if (!keys.next().startsWith("swanswitch")) {
                    keys.remove();
                }
            }
            f41575b = rawSwitch;
            if (f41574a) {
                Log.d("SwanCoreConfigHelper", "return new obj : " + f41575b.toString());
            }
            return f41575b;
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
            if (f41574a) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            f41575b = null;
        }
    }
}
