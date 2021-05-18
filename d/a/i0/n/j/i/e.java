package d.a.i0.n.j.i;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f47961a;

    public static e a() {
        if (f47961a == null) {
            synchronized (e.class) {
                if (f47961a == null) {
                    f47961a = new e();
                }
            }
        }
        return f47961a;
    }

    public String b() {
        return d.a.i0.n.c.b().j().getString("get_pkg_retry_version", "0");
    }

    public void c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        if (d.a.i0.n.c.f47808a) {
            Log.d("GetPkgRetryManager", WebGLImageLoader.DATA_URL + jSONObject);
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null || !optJSONObject.has(SetImageWatermarkTypeReqMsg.SWITCH)) {
            return;
        }
        int optInt = optJSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 0);
        if (d.a.i0.n.c.f47808a) {
            Log.d("GetPkgRetryManager", "retrySwitch:" + optInt);
        }
        d.a.i0.n.c.b().j().putString("get_pkg_retry_version", optString);
        d.a.i0.n.c.b().j().putInt("get_pkg_retry_switch", optInt);
    }
}
