package d.b.g0.a.b2.c;

import android.util.Log;
import d.b.g0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43569a = k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f43570b;

    public static synchronized JSONObject a() {
        synchronized (a.class) {
            if (f43570b != null) {
                if (f43569a) {
                    Log.d("SwanCoreConfigHelper", "return cache obj : " + f43570b.toString());
                }
                return f43570b;
            }
            JSONObject rawSwitch = d.b.g0.a.w0.a.N().getRawSwitch();
            if (rawSwitch == null) {
                f43570b = new JSONObject();
                if (f43569a) {
                    Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                }
                return f43570b;
            }
            Iterator<String> keys = rawSwitch.keys();
            while (keys.hasNext()) {
                if (!keys.next().startsWith("swanswitch")) {
                    keys.remove();
                }
            }
            f43570b = rawSwitch;
            if (f43569a) {
                Log.d("SwanCoreConfigHelper", "return new obj : " + f43570b.toString());
            }
            return f43570b;
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
            if (f43569a) {
                Log.d("SwanCoreConfigHelper", "release cache ab obj ");
            }
            f43570b = null;
        }
    }
}
