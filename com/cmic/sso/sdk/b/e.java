package com.cmic.sso.sdk.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    public static JSONObject a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", str);
            jSONObject.put("desc", str2);
        } catch (Exception e) {
            Log.e("AuthnResult", "Exception", e);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject a(String str, com.cmic.sso.sdk.a aVar, JSONObject jSONObject) {
        String[] strArr = {FileUtils.UNKNOW, "移动", "联通", "电信"};
        try {
            String b2 = aVar.b("operatortype", "0");
            if ("0".equals(b2) || TextUtils.isEmpty(b2)) {
                if ("103000".equals(str)) {
                    jSONObject.put("operatorType", strArr[1]);
                } else {
                    jSONObject.put("operatorType", strArr[0]);
                }
            } else {
                jSONObject.put("operatorType", strArr[Integer.parseInt(b2)]);
            }
        } catch (Exception e) {
            Log.e("AuthnResult", "JSONException", e);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", "103000");
            jSONObject.put("desc", "true");
            jSONObject.put("securityphone", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject c(String str, String str2, com.cmic.sso.sdk.a aVar, JSONObject jSONObject) {
        String str3;
        String str4;
        JSONObject jSONObject2 = new JSONObject();
        try {
            int intValue = Integer.valueOf(aVar.b("authtype", "0")).intValue();
            int c = aVar.c("networktype");
            switch (intValue) {
                case 2:
                    str3 = "7";
                    str4 = "短信验证码";
                    break;
                case 3:
                    if (c == 3) {
                        str4 = "WIFI下网关鉴权";
                        str3 = "1";
                        break;
                    } else {
                        str4 = "网关鉴权";
                        str3 = "2";
                        break;
                    }
                case 4:
                    str3 = "3";
                    str4 = "短信上行";
                    break;
                default:
                    str3 = "0";
                    str4 = "其他";
                    break;
            }
            jSONObject2.put("resultCode", str);
            jSONObject2.put("authType", str3 + "");
            jSONObject2.put("authTypeDes", str4);
            if ("103000".equals(str)) {
                if (1 == aVar.b("logintype", 0)) {
                    jSONObject2.put("openId", aVar.b("openId"));
                    jSONObject2.put("securityphone", aVar.b("securityphone"));
                }
                jSONObject2.put("token", jSONObject.optString("token"));
            } else {
                jSONObject2.put("desc", str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.cmic.sso.sdk.e.c.b("AuthnResult", "返回参数:" + jSONObject2.toString());
        return jSONObject2;
    }
}
