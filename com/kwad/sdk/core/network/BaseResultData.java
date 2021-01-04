package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final int CODE_RESULT_OK = 1;
    private static final long serialVersionUID = -8657363515914699792L;
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

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.llsid = jSONObject.optLong("llsid");
        this.result = jSONObject.optInt("result");
        this.errorMsg = jSONObject.optString(TiebaInitialize.LogFields.ERROR_MESSAGE);
        String optString = jSONObject.optString("extra");
        if (!TextUtils.isEmpty(optString)) {
            this.extra = com.kwad.sdk.core.b.d.b(optString);
        }
        this.cookie = jSONObject.optString("cookie");
        if (TextUtils.isEmpty(this.cookie)) {
            return;
        }
        e.a().a(this.cookie);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "llsid", this.llsid);
        o.a(jSONObject, "extra", this.extra);
        o.a(jSONObject, "result", this.result);
        o.a(jSONObject, TiebaInitialize.LogFields.ERROR_MESSAGE, this.errorMsg);
        o.a(jSONObject, "cookie", this.cookie);
        return jSONObject;
    }
}
