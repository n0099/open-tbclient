package com.kwad.sdk.core.webview.c;

import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.WebChromeClient;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b implements com.kwad.sdk.core.b {
    public String aDy;
    public String aDz;
    public String data;

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "action", this.aDy);
        t.putValue(jSONObject, "data", this.data);
        t.putValue(jSONObject, WebChromeClient.KEY_ARG_CALLBACK, this.aDz);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.aDy = jSONObject.optString("action");
        this.data = jSONObject.optString("data");
        this.aDz = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK);
    }
}
