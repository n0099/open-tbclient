package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cq implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.kwai.i> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.webview.kwai.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        iVar.a = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            iVar.a = "";
        }
        iVar.f56695b = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            iVar.f56695b = "";
        }
        iVar.f56696c = jSONObject.optString("params");
        if (jSONObject.opt("params") == JSONObject.NULL) {
            iVar.f56696c = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.webview.kwai.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "url", iVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "title", iVar.f56695b);
        com.kwad.sdk.utils.t.a(jSONObject, "params", iVar.f56696c);
        return jSONObject;
    }
}
