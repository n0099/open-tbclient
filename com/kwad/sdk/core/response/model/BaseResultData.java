package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.c;
import com.kwad.sdk.components.f;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static final int CODE_RESULT_OK = 1;
    public static final long serialVersionUID = -8657363515914699792L;
    public String cookie;
    public String errorMsg;
    public String extra;
    public boolean hasAd;
    public long llsid;
    public int result;
    public String testErrorMsg;

    public boolean isDataEmpty() {
        return false;
    }

    public boolean notifyFailOnResultError() {
        return true;
    }

    public boolean hasData() {
        return this.hasAd;
    }

    public boolean isResultOk() {
        if (this.result == 1) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        return baseToJson();
    }

    public JSONObject baseToJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "llsid", this.llsid);
        t.putValue(jSONObject, "extra", this.extra);
        t.putValue(jSONObject, "result", this.result);
        t.putValue(jSONObject, "hasAd", this.hasAd);
        t.putValue(jSONObject, "errorMsg", this.errorMsg);
        t.putValue(jSONObject, "testErrorMsg", this.testErrorMsg);
        t.putValue(jSONObject, "cookie", this.cookie);
        return jSONObject;
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
        this.testErrorMsg = jSONObject.optString("testErrorMsg");
        String optString = jSONObject.optString("extra");
        if (!bg.isNullString(optString)) {
            this.extra = ((e) c.f(e.class)).getResponseData(optString);
        }
        f fVar = (f) c.f(f.class);
        if (fVar != null) {
            fVar.aj(jSONObject.optString("egid"));
            fVar.w(jSONObject.optLong("gidExpireTimeMs"));
        }
        String optString2 = jSONObject.optString("cookie");
        this.cookie = optString2;
        if (!TextUtils.isEmpty(optString2)) {
            com.kwad.sdk.core.response.b.f.DZ().dU(this.cookie);
        }
    }
}
