package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ar implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.j.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.anE = jSONObject.optInt("ad_action_type");
        bVar.aof = jSONObject.optString("origin_url");
        if (JSONObject.NULL.toString().equals(bVar.aof)) {
            bVar.aof = "";
        }
        bVar.anD = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(bVar.anD)) {
            bVar.anD = "";
        }
        bVar.aog = jSONObject.optInt("request_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i);
        }
        int i2 = bVar.anE;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_action_type", i2);
        }
        String str = bVar.aof;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "origin_url", bVar.aof);
        }
        String str2 = bVar.anD;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "final_url", bVar.anD);
        }
        int i3 = bVar.aog;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_type", i3);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
