package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class fp implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.j> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.tachikoma.b.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.data = jSONObject.optString("data");
        if (JSONObject.NULL.toString().equals(jVar.data)) {
            jVar.data = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = jVar.data;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "data", jVar.data);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.j jVar, JSONObject jSONObject) {
        a2(jVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.j jVar, JSONObject jSONObject) {
        return b2(jVar, jSONObject);
    }
}
