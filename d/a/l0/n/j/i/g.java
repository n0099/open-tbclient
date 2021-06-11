package d.a.l0.n.j.i;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51816a = d.a.l0.n.c.f51658a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile g f51817b;

    public static g a() {
        if (f51817b == null) {
            synchronized (g.class) {
                if (f51817b == null) {
                    f51817b = new g();
                }
            }
        }
        return f51817b;
    }

    public String b() {
        return d.a.l0.n.c.b() == null ? "0" : d.a.l0.n.c.b().j().getString("local_debug_version", "0");
    }

    public void c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        if (f51816a) {
            Log.d("LocalDebugSwitchManager", WebGLImageLoader.DATA_URL + jSONObject);
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null || d.a.l0.n.c.b() == null) {
            return;
        }
        d.a.l0.n.c.b().j().putString("local_debug_version", optString);
        d.a.l0.n.c.b().j().putString("enable_local_debug_switch", optJSONObject.optString("enable_local_debug_switch"));
        d.a.l0.n.c.b().j().putString("error_url", optJSONObject.optString("error_url"));
        d.a.l0.n.c.b().j().putString("auth_white_list", optJSONObject.optString("auth_white_list"));
    }
}
