package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class am implements com.kwad.sdk.core.d<com.kwad.components.core.webview.b.a.d> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.b.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.NM = jSONObject.optBoolean("autoPlay");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.b.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = dVar.NM;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "autoPlay", z);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.b.a.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.b.a.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }
}
