package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class dt implements com.kwad.sdk.core.d {
    public static void a(com.kwad.components.core.webview.b.a.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.url = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            jVar.url = "";
        }
        jVar.title = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            jVar.title = "";
        }
    }

    public static JSONObject b(com.kwad.components.core.webview.b.a.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = jVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "url", jVar.url);
        }
        String str2 = jVar.title;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "title", jVar.title);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.b.a.j) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.b.a.j) bVar, jSONObject);
    }
}
