package com.kwad.sdk.core.webview.kwai;

import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.WebChromeClient;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.kwad.sdk.core.b {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f56510b;

    /* renamed from: c  reason: collision with root package name */
    public String f56511c;

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("action");
        this.f56510b = jSONObject.optString("data");
        this.f56511c = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "action", this.a);
        t.a(jSONObject, "data", this.f56510b);
        t.a(jSONObject, WebChromeClient.KEY_ARG_CALLBACK, this.f56511c);
        return jSONObject;
    }
}
