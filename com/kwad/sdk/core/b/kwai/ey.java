package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ey implements com.kwad.sdk.core.d {
    public static void a(com.kwad.components.core.webview.b.a.p pVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pVar.message = jSONObject.optString("message");
        if (jSONObject.opt("message") == JSONObject.NULL) {
            pVar.message = "";
        }
    }

    public static JSONObject b(com.kwad.components.core.webview.b.a.p pVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = pVar.message;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "message", pVar.message);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.b.a.p) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.b.a.p) bVar, jSONObject);
    }
}
