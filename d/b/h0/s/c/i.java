package d.b.h0.s.c;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optString(Constants.APP_ID, "");
        jSONObject.optString(DpStatConstants.KEY_APP_NAME, "");
        jSONObject.optString("package_name", "");
    }
}
