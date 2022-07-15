package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ap implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.a.a.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.webview.a.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optDouble("x");
        bVar.b = jSONObject.optDouble("y");
        bVar.c = jSONObject.optInt("width");
        bVar.d = jSONObject.optInt("height");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.webview.a.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "x", bVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "y", bVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "width", bVar.c);
        com.kwad.sdk.utils.r.a(jSONObject, "height", bVar.d);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.a.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.a.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
