package d.a.m0.s.c;

import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optString(Constants.APP_ID, "");
        jSONObject.optString("app_name", "");
        jSONObject.optString("package_name", "");
    }
}
