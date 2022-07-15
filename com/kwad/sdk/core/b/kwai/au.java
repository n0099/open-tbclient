package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class au implements com.kwad.sdk.core.d<com.kwad.components.core.webview.b.kwai.d> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.b.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.a = jSONObject.optInt("closeDelaySeconds");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.b.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "closeDelaySeconds", dVar.a);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.b.kwai.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.b.kwai.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }
}
