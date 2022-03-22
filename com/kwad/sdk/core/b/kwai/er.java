package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class er implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.a.kwai.f> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.webview.a.kwai.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.a = jSONObject.optInt("currentTime");
        fVar.f39991b = jSONObject.optBoolean("failed");
        fVar.f39992c = jSONObject.optBoolean("finished");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.webview.a.kwai.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "currentTime", fVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "failed", fVar.f39991b);
        com.kwad.sdk.utils.t.a(jSONObject, "finished", fVar.f39992c);
        return jSONObject;
    }
}
