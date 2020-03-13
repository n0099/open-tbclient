package com.qiniu.android.storage;

import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.qiniu.android.utils.UrlSafeBase64;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class UpToken {
    public static UpToken noy = new UpToken("", "", "");
    public final String nmZ;
    private String returnUrl;
    public final String token;

    private UpToken(String str, String str2, String str3) {
        this.returnUrl = null;
        this.returnUrl = str;
        this.token = str2;
        this.nmZ = str3;
    }

    public static UpToken Rs(String str) {
        try {
            String[] split = str.split(":");
            if (split.length != 3) {
                return noy;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(UrlSafeBase64.decode(split[2])));
                if (jSONObject.optString("scope").equals("")) {
                    return noy;
                }
                if (jSONObject.optInt("deadline") == 0) {
                    return noy;
                }
                return new UpToken(jSONObject.optString(CashierData.RETURN_URL), str, split[0]);
            } catch (JSONException e) {
                return noy;
            }
        } catch (Exception e2) {
            return noy;
        }
    }

    public String toString() {
        return this.token;
    }

    public boolean dGe() {
        return !this.returnUrl.equals("");
    }
}
