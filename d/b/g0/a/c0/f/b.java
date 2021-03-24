package d.b.g0.a.c0.f;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f43677h = k.f45050a;
    public static String i = NotificationCompat.WearableExtender.KEY_BACKGROUND;
    public static String j = "page";
    public static String k = "runtime/index.js";
    public static String l = "ws://localhost:4000";

    /* renamed from: a  reason: collision with root package name */
    public String f43678a = String.valueOf(System.currentTimeMillis());

    /* renamed from: b  reason: collision with root package name */
    public String f43679b = "http://chrome-devtools-frontend.appspot.com/serve_rev/@793eb32f50bafcb87fb5d1a0fd3f44e66470e580/inspector.html?ws=localhost:4000";

    /* renamed from: c  reason: collision with root package name */
    public boolean f43680c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43681d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f43682e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f43683f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43684g = true;

    public String toString() {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("title", i);
            jSONObject.putOpt("type", j);
            jSONObject.putOpt("url", k);
            jSONObject.putOpt("webSocketDebuggerUrl", l);
            jSONObject.putOpt("id", this.f43678a);
            jSONObject.putOpt("devtoolsFrontendUrl", this.f43679b);
            jSONObject.putOpt("swanJsVersion", d.b.g0.a.b2.b.f(0));
            jSONObject.putOpt("appVersion", k0.z());
            jSONObject2.putOpt("attached", Boolean.valueOf(this.f43680c));
            jSONObject2.putOpt(SchemeCollecter.CLASSIFY_EMPTY, Boolean.valueOf(this.f43681d));
            jSONObject2.putOpt("screenX", Integer.valueOf(this.f43682e));
            jSONObject2.putOpt("screenY", Integer.valueOf(this.f43683f));
            jSONObject2.putOpt("visible", Boolean.valueOf(this.f43684g));
            jSONObject.putOpt("description", jSONObject2.toString());
            jSONArray.put(jSONObject);
        } catch (JSONException e2) {
            if (f43677h) {
                Log.e("V8Module", "Build V8 module fail", e2);
            }
        }
        return jSONArray.toString();
    }
}
