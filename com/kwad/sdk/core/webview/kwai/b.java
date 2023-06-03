package com.kwad.sdk.core.webview.kwai;

import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.WebChromeClient;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b implements com.kwad.sdk.core.b {
    public String agi;
    public String agj;
    public String data;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.agi = jSONObject.optString("action");
        this.data = jSONObject.optString("data");
        this.agj = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.putValue(jSONObject, "action", this.agi);
        r.putValue(jSONObject, "data", this.data);
        r.putValue(jSONObject, WebChromeClient.KEY_ARG_CALLBACK, this.agj);
        return jSONObject;
    }
}
