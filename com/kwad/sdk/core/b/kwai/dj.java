package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class dj implements com.kwad.sdk.core.d<com.kwad.components.core.webview.b.kwai.h> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.b.kwai.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hVar.a = jSONObject.optBoolean("muted");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.b.kwai.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "muted", hVar.a);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.b.kwai.h hVar, JSONObject jSONObject) {
        a2(hVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.b.kwai.h hVar, JSONObject jSONObject) {
        return b2(hVar, jSONObject);
    }
}
