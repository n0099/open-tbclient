package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ds implements com.kwad.sdk.core.d {
    public static void a(com.kwad.components.core.webview.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.url = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            bVar.url = "";
        }
        bVar.title = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            bVar.title = "";
        }
        bVar.params = jSONObject.optString("params");
        if (jSONObject.opt("params") == JSONObject.NULL) {
            bVar.params = "";
        }
    }

    public static JSONObject b(com.kwad.components.core.webview.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "url", bVar.url);
        }
        String str2 = bVar.title;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "title", bVar.title);
        }
        String str3 = bVar.params;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "params", bVar.params);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.b) bVar, jSONObject);
    }
}
