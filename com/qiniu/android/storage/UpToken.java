package com.qiniu.android.storage;

import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.qiniu.android.utils.UrlSafeBase64;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class UpToken {
    public static UpToken nql = new UpToken("", "", "");
    public final String noO;
    private String returnUrl;
    public final String token;

    private UpToken(String str, String str2, String str3) {
        this.returnUrl = null;
        this.returnUrl = str;
        this.token = str2;
        this.noO = str3;
    }

    public static UpToken Rr(String str) {
        try {
            String[] split = str.split(":");
            if (split.length != 3) {
                return nql;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(UrlSafeBase64.decode(split[2])));
                if (jSONObject.optString("scope").equals("")) {
                    return nql;
                }
                if (jSONObject.optInt("deadline") == 0) {
                    return nql;
                }
                return new UpToken(jSONObject.optString(CashierData.RETURN_URL), str, split[0]);
            } catch (JSONException e) {
                return nql;
            }
        } catch (Exception e2) {
            return nql;
        }
    }

    public String toString() {
        return this.token;
    }

    public boolean dGE() {
        return !this.returnUrl.equals("");
    }
}
