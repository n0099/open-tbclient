package d.a.l0.h.a.f;

import com.baidu.wallet.router.RouterCallback;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public static JSONObject a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isEnded", z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject b(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, str);
            jSONObject.put("errMsg", com.baidu.pass.biometrics.face.liveness.b.b.g0);
            jSONObject.put("errDes", d.a.l0.f.i.r.b.a(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
