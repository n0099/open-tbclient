package com.qiniu.android.storage;

import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.qiniu.android.utils.UrlSafeBase64;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class UpToken {
    public static UpToken ogI = new UpToken("", "", "");
    public final String ofl;
    private String returnUrl;
    public final String token;

    private UpToken(String str, String str2, String str3) {
        this.returnUrl = null;
        this.returnUrl = str;
        this.token = str2;
        this.ofl = str3;
    }

    public static UpToken Vy(String str) {
        try {
            String[] split = str.split(":");
            if (split.length != 3) {
                return ogI;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(UrlSafeBase64.decode(split[2])));
                if (jSONObject.optString("scope").equals("")) {
                    return ogI;
                }
                if (jSONObject.optInt("deadline") == 0) {
                    return ogI;
                }
                return new UpToken(jSONObject.optString(CashierData.RETURN_URL), str, split[0]);
            } catch (JSONException e) {
                return ogI;
            }
        } catch (Exception e2) {
            return ogI;
        }
    }

    public String toString() {
        return this.token;
    }

    public boolean ect() {
        return !this.returnUrl.equals("");
    }
}
