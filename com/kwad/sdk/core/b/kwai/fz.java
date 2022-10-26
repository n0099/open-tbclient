package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class fz implements com.kwad.sdk.core.d {
    public static void a(com.kwad.components.core.webview.b.a.r rVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rVar.NY = jSONObject.optString("status");
        if (jSONObject.opt("status") == JSONObject.NULL) {
            rVar.NY = "";
        }
    }

    public static JSONObject b(com.kwad.components.core.webview.b.a.r rVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rVar.NY;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "status", rVar.NY);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.b.a.r) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.b.a.r) bVar, jSONObject);
    }
}
