package com.kwad.sdk.core.network;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.r;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static final int CODE_RESULT_OK = 1;
    public static final long serialVersionUID = -8657363515914699792L;
    public String cookie;
    public String errorMsg;
    public String extra;
    public boolean hasAd;
    public long llsid;
    public int result;

    public JSONObject baseToJson() {
        JSONObject jSONObject = new JSONObject();
        r.putValue(jSONObject, "llsid", this.llsid);
        r.putValue(jSONObject, "extra", this.extra);
        r.putValue(jSONObject, TiebaStatic.LogFields.RESULT, this.result);
        r.putValue(jSONObject, "hasAd", this.hasAd);
        r.putValue(jSONObject, "errorMsg", this.errorMsg);
        r.putValue(jSONObject, "cookie", this.cookie);
        return jSONObject;
    }

    public boolean hasData() {
        return this.hasAd;
    }

    public boolean isDataEmpty() {
        return false;
    }

    public boolean isResultOk() {
        return this.result == 1;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.llsid = jSONObject.optLong("llsid");
        this.result = jSONObject.optInt(TiebaStatic.LogFields.RESULT);
        this.hasAd = jSONObject.optBoolean("hasAd");
        this.errorMsg = jSONObject.optString("errorMsg");
        String optString = jSONObject.optString("extra");
        if (!ax.dT(optString)) {
            this.extra = com.kwad.sdk.core.a.d.getResponseData(optString);
        }
        com.kwad.sdk.components.f fVar = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.f(com.kwad.sdk.components.f.class);
        if (fVar != null) {
            fVar.an(jSONObject.optString("egid"));
            fVar.m(jSONObject.optLong("gidExpireTimeMs"));
        }
        String optString2 = jSONObject.optString("cookie");
        this.cookie = optString2;
        if (TextUtils.isEmpty(optString2)) {
            return;
        }
        e.ty().bU(this.cookie);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        return baseToJson();
    }
}
