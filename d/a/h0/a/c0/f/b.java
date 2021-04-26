package d.a.h0.a.c0.f;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f41687h = k.f43101a;

    /* renamed from: i  reason: collision with root package name */
    public static String f41688i = NotificationCompat.WearableExtender.KEY_BACKGROUND;
    public static String j = "page";
    public static String k = "runtime/index.js";
    public static String l = "ws://localhost:4000";

    /* renamed from: a  reason: collision with root package name */
    public String f41689a = String.valueOf(System.currentTimeMillis());

    /* renamed from: b  reason: collision with root package name */
    public String f41690b = "http://chrome-devtools-frontend.appspot.com/serve_rev/@793eb32f50bafcb87fb5d1a0fd3f44e66470e580/inspector.html?ws=localhost:4000";

    /* renamed from: c  reason: collision with root package name */
    public boolean f41691c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41692d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f41693e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f41694f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f41695g = true;

    public String toString() {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("title", f41688i);
            jSONObject.putOpt("type", j);
            jSONObject.putOpt("url", k);
            jSONObject.putOpt("webSocketDebuggerUrl", l);
            jSONObject.putOpt("id", this.f41689a);
            jSONObject.putOpt("devtoolsFrontendUrl", this.f41690b);
            jSONObject.putOpt("swanJsVersion", d.a.h0.a.b2.b.f(0));
            jSONObject.putOpt("appVersion", k0.z());
            jSONObject2.putOpt("attached", Boolean.valueOf(this.f41691c));
            jSONObject2.putOpt("empty", Boolean.valueOf(this.f41692d));
            jSONObject2.putOpt("screenX", Integer.valueOf(this.f41693e));
            jSONObject2.putOpt("screenY", Integer.valueOf(this.f41694f));
            jSONObject2.putOpt("visible", Boolean.valueOf(this.f41695g));
            jSONObject.putOpt("description", jSONObject2.toString());
            jSONArray.put(jSONObject);
        } catch (JSONException e2) {
            if (f41687h) {
                Log.e("V8Module", "Build V8 module fail", e2);
            }
        }
        return jSONArray.toString();
    }
}
