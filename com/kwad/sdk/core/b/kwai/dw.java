package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class dw implements com.kwad.sdk.core.d {
    public static void a(com.kwad.components.core.webview.b.a.k kVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kVar.NS = jSONObject.optInt("scene");
    }

    public static JSONObject b(com.kwad.components.core.webview.b.a.k kVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = kVar.NS;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "scene", i);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.b.a.k) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.b.a.k) bVar, jSONObject);
    }
}
