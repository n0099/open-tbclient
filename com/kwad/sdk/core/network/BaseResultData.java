package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.r;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
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
        r.a(jSONObject, "llsid", this.llsid);
        r.a(jSONObject, "extra", this.extra);
        r.a(jSONObject, "result", this.result);
        r.a(jSONObject, "hasAd", this.hasAd);
        r.a(jSONObject, "errorMsg", this.errorMsg);
        r.a(jSONObject, "cookie", this.cookie);
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
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.llsid = jSONObject.optLong("llsid");
        this.result = jSONObject.optInt("result");
        this.hasAd = jSONObject.optBoolean("hasAd");
        this.errorMsg = jSONObject.optString("errorMsg");
        String optString = jSONObject.optString("extra");
        if (!at.a(optString)) {
            this.extra = com.kwad.sdk.core.a.d.b(optString);
        }
        com.kwad.sdk.components.f fVar = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.a(com.kwad.sdk.components.f.class);
        if (fVar != null) {
            fVar.a(jSONObject.optString("egid"));
            fVar.a(jSONObject.optLong("gidExpireTimeMs"));
        }
        String optString2 = jSONObject.optString("cookie");
        this.cookie = optString2;
        if (TextUtils.isEmpty(optString2)) {
            return;
        }
        e.a().a(this.cookie);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        return baseToJson();
    }
}
