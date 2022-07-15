package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class dn implements com.kwad.sdk.core.d<com.kwad.components.core.webview.b.kwai.i> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.b.kwai.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        iVar.a = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            iVar.a = "";
        }
        iVar.b = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            iVar.b = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.b.kwai.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "url", iVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "title", iVar.b);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.b.kwai.i iVar, JSONObject jSONObject) {
        a2(iVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.b.kwai.i iVar, JSONObject jSONObject) {
        return b2(iVar, jSONObject);
    }
}
