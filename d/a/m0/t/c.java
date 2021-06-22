package d.a.m0.t;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static String a(JSONObject jSONObject, String str, String str2) {
        return jSONObject == null ? str2 : jSONObject.optString(str, str2);
    }

    public static JSONObject b(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            str = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (TextUtils.isEmpty(a(jSONObject, "pre_source", null))) {
                jSONObject.put("pre_source", str);
            }
            if (TextUtils.isEmpty(a(jSONObject, "pre_appid", null))) {
                jSONObject.put("pre_appid", AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
