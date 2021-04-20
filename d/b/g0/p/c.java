package d.b.g0.p;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static String a(JSONObject jSONObject, String str, String str2) {
        return jSONObject == null ? str2 : jSONObject.optString(str, str2);
    }

    public static JSONObject b(String str, JSONObject jSONObject, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (TextUtils.isEmpty(a(jSONObject, str2, null))) {
                jSONObject.put(str2, str);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
