package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class aw implements com.kwad.sdk.core.d<com.kwad.components.core.webview.b.kwai.e> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.b.kwai.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.a = jSONObject.optString("payload");
        if (jSONObject.opt("payload") == JSONObject.NULL) {
            eVar.a = "";
        }
        eVar.b = jSONObject.optInt("actionType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.b.kwai.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "payload", eVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "actionType", eVar.b);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.b.kwai.e eVar, JSONObject jSONObject) {
        a2(eVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.b.kwai.e eVar, JSONObject jSONObject) {
        return b2(eVar, jSONObject);
    }
}
