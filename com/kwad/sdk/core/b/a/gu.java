package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class gu implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.d> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.ayC = jSONObject.optString("mac");
        if (JSONObject.NULL.toString().equals(dVar.ayC)) {
            dVar.ayC = "";
        }
        dVar.ayD = jSONObject.optString("kMac");
        if (JSONObject.NULL.toString().equals(dVar.ayD)) {
            dVar.ayD = "";
        }
        dVar.ayE = jSONObject.optInt("connectionType");
        dVar.ayF = jSONObject.optInt("operatorType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.ayC;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mac", dVar.ayC);
        }
        String str2 = dVar.ayD;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "kMac", dVar.ayD);
        }
        int i = dVar.ayE;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "connectionType", i);
        }
        int i2 = dVar.ayF;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "operatorType", i2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }
}
