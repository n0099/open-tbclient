package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ax implements com.kwad.sdk.core.d<com.kwad.components.core.webview.b.a.f> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.b.a.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.Mn = jSONObject.optString("payload");
        if (jSONObject.opt("payload") == JSONObject.NULL) {
            fVar.Mn = "";
        }
        fVar.Mm = jSONObject.optInt("actionType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.b.a.f fVar, JSONObject jSONObject) {
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.b.a.f fVar, JSONObject jSONObject) {
        a2(fVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.b.a.f fVar, JSONObject jSONObject) {
        return b2(fVar, jSONObject);
    }
}
