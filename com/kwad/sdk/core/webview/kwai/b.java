package com.kwad.sdk.core.webview.kwai;

import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.WebChromeClient;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b implements com.kwad.sdk.core.b {
    public String a;
    public String b;
    public String c;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("action");
        this.b = jSONObject.optString("data");
        this.c = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, "action", this.a);
        r.a(jSONObject, "data", this.b);
        r.a(jSONObject, WebChromeClient.KEY_ARG_CALLBACK, this.c);
        return jSONObject;
    }
}
