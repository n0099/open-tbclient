package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class er implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.a.kwai.f> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.webview.a.kwai.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.a = jSONObject.optInt("currentTime");
        fVar.f56551b = jSONObject.optBoolean(com.alipay.sdk.util.f.f31162j);
        fVar.f56552c = jSONObject.optBoolean("finished");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.webview.a.kwai.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "currentTime", fVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, com.alipay.sdk.util.f.f31162j, fVar.f56551b);
        com.kwad.sdk.utils.t.a(jSONObject, "finished", fVar.f56552c);
        return jSONObject;
    }
}
