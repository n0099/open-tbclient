package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static final int CODE_RESULT_OK = 1;
    public static final long serialVersionUID = -8657363515914699792L;
    public String cookie;
    public String errorMsg;
    public String extra;
    public long llsid;
    public int result;

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
        this.errorMsg = jSONObject.optString("errorMsg");
        String optString = jSONObject.optString("extra");
        if (!at.a(optString)) {
            this.extra = com.kwad.sdk.core.a.d.b(optString);
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
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "llsid", this.llsid);
        t.a(jSONObject, "extra", this.extra);
        t.a(jSONObject, "result", this.result);
        t.a(jSONObject, "errorMsg", this.errorMsg);
        t.a(jSONObject, "cookie", this.cookie);
        return jSONObject;
    }
}
