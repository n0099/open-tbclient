package com.qiniu.android.storage;

import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.qiniu.android.utils.UrlSafeBase64;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class UpToken {
    public static UpToken pxx = new UpToken("", "", "");
    public final String pvZ;
    private String returnUrl;
    public final String token;

    private UpToken(String str, String str2, String str3) {
        this.returnUrl = null;
        this.returnUrl = str;
        this.token = str2;
        this.pvZ = str3;
    }

    public static UpToken YB(String str) {
        try {
            String[] split = str.split(":");
            if (split.length != 3) {
                return pxx;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(UrlSafeBase64.decode(split[2])));
                if (jSONObject.optString("scope").equals("")) {
                    return pxx;
                }
                if (jSONObject.optInt("deadline") == 0) {
                    return pxx;
                }
                return new UpToken(jSONObject.optString(CashierData.RETURN_URL), str, split[0]);
            } catch (JSONException e) {
                return pxx;
            }
        } catch (Exception e2) {
            return pxx;
        }
    }

    public String toString() {
        return this.token;
    }

    public boolean euk() {
        return !this.returnUrl.equals("");
    }
}
