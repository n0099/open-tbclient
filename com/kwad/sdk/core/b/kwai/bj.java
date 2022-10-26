package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class bj implements com.kwad.sdk.core.d {
    public static void a(com.kwad.components.core.webview.b.a.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.NO = jSONObject.optInt("hasDeepReward");
    }

    public static JSONObject b(com.kwad.components.core.webview.b.a.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = gVar.NO;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "hasDeepReward", i);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.b.a.g) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.b.a.g) bVar, jSONObject);
    }
}
