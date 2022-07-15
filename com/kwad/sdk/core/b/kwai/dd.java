package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class dd implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.a.a.c> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.webview.a.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.a = jSONObject.optInt("convertType");
        cVar.b = jSONObject.optString("payload");
        if (jSONObject.opt("payload") == JSONObject.NULL) {
            cVar.b = "";
        }
        com.kwad.sdk.core.webview.a.a.b bVar = new com.kwad.sdk.core.webview.a.a.b();
        cVar.c = bVar;
        bVar.parseJson(jSONObject.optJSONObject("clickInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.webview.a.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "convertType", cVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "payload", cVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "clickInfo", cVar.c);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.a.a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.a.a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
