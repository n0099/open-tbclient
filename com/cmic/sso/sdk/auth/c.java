package com.cmic.sso.sdk.auth;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.FileUtils;
import com.baidu.sapi2.activity.BaseActivity;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static JSONObject a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, str);
            jSONObject.put("desc", str2);
        } catch (Exception e2) {
            Log.e("AuthnResult", "Exception", e2);
        }
        return jSONObject;
    }

    public static JSONObject a(String str, com.cmic.sso.sdk.a aVar, JSONObject jSONObject) {
        String b2;
        String[] strArr = {FileUtils.UNKNOW, "移动", "联通", "电信"};
        try {
            b2 = aVar.b("operatortype", "0");
        } catch (Exception e2) {
            Log.e("AuthnResult", "JSONException", e2);
        }
        if (!"0".equals(b2) && !TextUtils.isEmpty(b2)) {
            jSONObject.put("operatorType", strArr[Integer.parseInt(b2)]);
            return jSONObject;
        }
        if ("103000".equals(str)) {
            jSONObject.put("operatorType", strArr[1]);
        } else {
            jSONObject.put("operatorType", strArr[0]);
        }
        return jSONObject;
    }

    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, "103000");
            jSONObject.put("desc", "true");
            jSONObject.put("securityphone", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject a(String str, String str2, com.cmic.sso.sdk.a aVar, JSONObject jSONObject) {
        String str3;
        String str4 = "0";
        JSONObject jSONObject2 = new JSONObject();
        try {
            int intValue = Integer.valueOf(aVar.b("authtype", "0")).intValue();
            int c2 = aVar.c("networktype");
            if (intValue == 2) {
                str4 = "7";
                str3 = "短信验证码";
            } else if (intValue != 3) {
                if (intValue != 4) {
                    str3 = "其他";
                } else {
                    str4 = "3";
                    str3 = "短信上行";
                }
            } else if (c2 == 3) {
                str3 = "WIFI下网关鉴权";
                str4 = "1";
            } else {
                str3 = "网关鉴权";
                str4 = "2";
            }
            jSONObject2.put(MiPushCommandMessage.KEY_RESULT_CODE, str);
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append("");
            jSONObject2.put("authType", sb.toString());
            jSONObject2.put("authTypeDes", str3);
            if ("103000".equals(str)) {
                if (1 == aVar.b("logintype", 0)) {
                    jSONObject2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, aVar.b(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID));
                    jSONObject2.put("securityphone", aVar.b("securityphone"));
                }
                jSONObject2.put("token", jSONObject.optString("token"));
            } else {
                jSONObject2.put("desc", str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.cmic.sso.sdk.d.c.b("AuthnResult", "返回参数:" + jSONObject2.toString());
        return jSONObject2;
    }
}
