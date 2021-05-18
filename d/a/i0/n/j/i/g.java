package d.a.i0.n.j.i;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47966a = d.a.i0.n.c.f47808a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile g f47967b;

    public static g a() {
        if (f47967b == null) {
            synchronized (g.class) {
                if (f47967b == null) {
                    f47967b = new g();
                }
            }
        }
        return f47967b;
    }

    public String b() {
        return d.a.i0.n.c.b() == null ? "0" : d.a.i0.n.c.b().j().getString("local_debug_version", "0");
    }

    public void c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        if (f47966a) {
            Log.d("LocalDebugSwitchManager", WebGLImageLoader.DATA_URL + jSONObject);
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null || d.a.i0.n.c.b() == null) {
            return;
        }
        d.a.i0.n.c.b().j().putString("local_debug_version", optString);
        d.a.i0.n.c.b().j().putString("enable_local_debug_switch", optJSONObject.optString("enable_local_debug_switch"));
        d.a.i0.n.c.b().j().putString("error_url", optJSONObject.optString("error_url"));
        d.a.i0.n.c.b().j().putString("auth_white_list", optJSONObject.optString("auth_white_list"));
    }
}
