package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
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
        iVar.b = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            iVar.b = "";
        }
        iVar.c = jSONObject.optString("params");
        if (jSONObject.opt("params") == JSONObject.NULL) {
            iVar.c = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.webview.kwai.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "url", iVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "title", iVar.b);
        com.kwad.sdk.utils.t.a(jSONObject, "params", iVar.c);
        return jSONObject;
    }
}
