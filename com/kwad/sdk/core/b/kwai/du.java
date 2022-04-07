package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class du implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.a.kwai.e> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.webview.a.kwai.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.a = jSONObject.optBoolean("needPromopt");
        eVar.b = jSONObject.optBoolean("needReport");
        eVar.c = jSONObject.optInt("showTime");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.webview.a.kwai.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "needPromopt", eVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "needReport", eVar.b);
        com.kwad.sdk.utils.t.a(jSONObject, "showTime", eVar.c);
        return jSONObject;
    }
}
