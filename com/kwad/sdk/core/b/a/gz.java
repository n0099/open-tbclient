package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class gz implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.n> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.tachikoma.b.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(nVar.url)) {
            nVar.url = "";
        }
        nVar.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(nVar.title)) {
            nVar.title = "";
        }
        nVar.aab = jSONObject.optBoolean("showConfirmDialog");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = nVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", nVar.url);
        }
        String str2 = nVar.title;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", nVar.title);
        }
        boolean z = nVar.aab;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showConfirmDialog", z);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.n nVar, JSONObject jSONObject) {
        a2(nVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.n nVar, JSONObject jSONObject) {
        return b2(nVar, jSONObject);
    }
}
