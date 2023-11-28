package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class cc implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.g> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.tachikoma.b.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.Xd = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(gVar.Xd)) {
            gVar.Xd = "";
        }
        gVar.actionType = jSONObject.optInt("actionType");
        gVar.VA = jSONObject.optInt("adCacheId");
        gVar.Jw = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(gVar.Jw)) {
            gVar.Jw = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = gVar.Xd;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", gVar.Xd);
        }
        int i = gVar.actionType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "actionType", i);
        }
        int i2 = gVar.VA;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adCacheId", i2);
        }
        String str2 = gVar.Jw;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", gVar.Jw);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.g gVar, JSONObject jSONObject) {
        a2(gVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.g gVar, JSONObject jSONObject) {
        return b2(gVar, jSONObject);
    }
}
