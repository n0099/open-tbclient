package com.qiniu.android.storage;

import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.qiniu.android.utils.UrlSafeBase64;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class UpToken {
    public static UpToken nMO = new UpToken("", "", "");
    public final String nLr;
    private String returnUrl;
    public final String token;

    private UpToken(String str, String str2, String str3) {
        this.returnUrl = null;
        this.returnUrl = str;
        this.token = str2;
        this.nLr = str3;
    }

    public static UpToken Su(String str) {
        try {
            String[] split = str.split(":");
            if (split.length != 3) {
                return nMO;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(UrlSafeBase64.decode(split[2])));
                if (jSONObject.optString("scope").equals("")) {
                    return nMO;
                }
                if (jSONObject.optInt("deadline") == 0) {
                    return nMO;
                }
                return new UpToken(jSONObject.optString(CashierData.RETURN_URL), str, split[0]);
            } catch (JSONException e) {
                return nMO;
            }
        } catch (Exception e2) {
            return nMO;
        }
    }

    public String toString() {
        return this.token;
    }

    public boolean dQr() {
        return !this.returnUrl.equals("");
    }
}
