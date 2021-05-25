package d.a.l0.a.e0.h;

import android.annotation.SuppressLint;
import android.util.Log;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f41512h = k.f43199a;

    /* renamed from: i  reason: collision with root package name */
    public static String f41513i = "V8Master";
    public static String j = "page";
    public static String k = "runtime/index.js";
    public static String l = "ws://localhost:4000";

    /* renamed from: a  reason: collision with root package name */
    public String f41514a = String.valueOf(System.currentTimeMillis());
    @SuppressLint({"BDOfflineUrl"})

    /* renamed from: b  reason: collision with root package name */
    public String f41515b = "http://chrome-devtools-frontend.appspot.com/serve_rev/@74dd8d5ea19a92d0e6092e59a0c8bd3a40877b71/inspector.html?ws=localhost:4000";

    /* renamed from: c  reason: collision with root package name */
    public boolean f41516c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41517d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f41518e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f41519f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f41520g = true;

    public String toString() {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("title", f41513i);
            jSONObject.putOpt("type", j);
            jSONObject.putOpt("url", k);
            jSONObject.putOpt("webSocketDebuggerUrl", l);
            jSONObject.putOpt("id", this.f41514a);
            jSONObject.putOpt("devtoolsFrontendUrl", this.f41515b);
            jSONObject.putOpt("swanJsVersion", d.a.l0.a.m2.b.h(0));
            jSONObject.putOpt("appVersion", q0.D());
            jSONObject2.putOpt("attached", Boolean.valueOf(this.f41516c));
            jSONObject2.putOpt("empty", Boolean.valueOf(this.f41517d));
            jSONObject2.putOpt("screenX", Integer.valueOf(this.f41518e));
            jSONObject2.putOpt("screenY", Integer.valueOf(this.f41519f));
            jSONObject2.putOpt("visible", Boolean.valueOf(this.f41520g));
            jSONObject.putOpt("description", jSONObject2.toString());
            jSONArray.put(jSONObject);
        } catch (JSONException e2) {
            if (f41512h) {
                Log.e("V8Module", "Build V8 module fail", e2);
            }
        }
        return jSONArray.toString();
    }
}
