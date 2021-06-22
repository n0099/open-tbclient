package d.a.m0.n.j.i;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f51926a;

    public static h a() {
        if (f51926a == null) {
            synchronized (h.class) {
                if (f51926a == null) {
                    f51926a = new h();
                }
            }
        }
        return f51926a;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        if (d.a.m0.n.c.f51766a) {
            Log.d("OnlineDescriptionControlManager", WebGLImageLoader.DATA_URL + jSONObject);
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null || d.a.m0.n.c.b() == null || d.a.m0.n.c.b().j() == null) {
            return;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("webview");
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("js");
        boolean o = optJSONArray != null ? d.a.m0.n.c.b().o(false, optJSONArray) : true;
        boolean o2 = optJSONArray2 != null ? d.a.m0.n.c.b().o(true, optJSONArray2) : true;
        if (o && o2) {
            d.a.m0.n.c.b().j().putString("key_online_description_fix_version", optString);
        }
    }
}
