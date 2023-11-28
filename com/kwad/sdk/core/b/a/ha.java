package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ha implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.c> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.Vy = jSONObject.optString("originalID");
        if (JSONObject.NULL.toString().equals(cVar.Vy)) {
            cVar.Vy = "";
        }
        cVar.Vz = jSONObject.optString("path");
        if (JSONObject.NULL.toString().equals(cVar.Vz)) {
            cVar.Vz = "";
        }
        cVar.VA = jSONObject.optInt("adCacheId");
        cVar.Jw = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(cVar.Jw)) {
            cVar.Jw = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cVar.Vy;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "originalID", cVar.Vy);
        }
        String str2 = cVar.Vz;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "path", cVar.Vz);
        }
        int i = cVar.VA;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adCacheId", i);
        }
        String str3 = cVar.Jw;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", cVar.Jw);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
