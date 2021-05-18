package d.a.k0.r.a.f;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public a() {
    }

    public a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("code")) {
                jSONObject.getInt("code");
            }
            if (jSONObject.has("msg")) {
                jSONObject.getString("msg");
            }
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
