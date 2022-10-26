package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ax implements com.kwad.sdk.core.d {
    public static void a(com.kwad.components.core.webview.b.a.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.Mn = jSONObject.optString("payload");
        if (jSONObject.opt("payload") == JSONObject.NULL) {
            fVar.Mn = "";
        }
        fVar.Mm = jSONObject.optInt("actionType");
    }

    public static JSONObject b(com.kwad.components.core.webview.b.a.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = fVar.Mn;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "payload", fVar.Mn);
        }
        int i = fVar.Mm;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "actionType", i);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.b.a.f) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.b.a.f) bVar, jSONObject);
    }
}
