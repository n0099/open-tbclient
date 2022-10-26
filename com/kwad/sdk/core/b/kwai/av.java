package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class av implements com.kwad.sdk.core.d {
    public static void a(com.kwad.components.core.webview.b.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.NN = jSONObject.optInt("closeDelaySeconds");
    }

    public static JSONObject b(com.kwad.components.core.webview.b.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = eVar.NN;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "closeDelaySeconds", i);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.b.a.e) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.b.a.e) bVar, jSONObject);
    }
}
