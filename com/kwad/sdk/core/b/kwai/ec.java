package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class ec implements com.kwad.sdk.core.d<com.kwad.components.core.webview.b.a.l> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.b.a.l lVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        lVar.NT = jSONObject.optBoolean("isPlayAgainScene");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.b.a.l lVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = lVar.NT;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "isPlayAgainScene", z);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.b.a.l lVar, JSONObject jSONObject) {
        a2(lVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.b.a.l lVar, JSONObject jSONObject) {
        return b2(lVar, jSONObject);
    }
}
