package d.a.i0.n.j.i;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f47968a;

    public static h a() {
        if (f47968a == null) {
            synchronized (h.class) {
                if (f47968a == null) {
                    f47968a = new h();
                }
            }
        }
        return f47968a;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        if (d.a.i0.n.c.f47808a) {
            Log.d("OnlineDescriptionControlManager", WebGLImageLoader.DATA_URL + jSONObject);
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null || d.a.i0.n.c.b() == null || d.a.i0.n.c.b().j() == null) {
            return;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("webview");
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("js");
        boolean o = optJSONArray != null ? d.a.i0.n.c.b().o(false, optJSONArray) : true;
        boolean o2 = optJSONArray2 != null ? d.a.i0.n.c.b().o(true, optJSONArray2) : true;
        if (o && o2) {
            d.a.i0.n.c.b().j().putString("key_online_description_fix_version", optString);
        }
    }
}
