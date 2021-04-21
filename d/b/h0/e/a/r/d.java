package d.b.h0.e.a.r;

import com.baidu.wallet.router.RouterCallback;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, str);
            jSONObject.put("errMsg", "fail");
            jSONObject.put("errDes", d.b.h0.e.a.q.b.a(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject b(f fVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", fVar.realWidth);
            jSONObject.put("height", fVar.realHeight);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
