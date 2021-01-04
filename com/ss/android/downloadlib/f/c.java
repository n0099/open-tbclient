package com.ss.android.downloadlib.f;

import android.text.TextUtils;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static String c(String str, String str2, boolean z, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("notification_jump_url", str2);
            }
            jSONObject.put("show_toast", z);
            jSONObject.put(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE, str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
