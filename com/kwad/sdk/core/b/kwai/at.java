package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class at implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.g> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.report.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.a = jSONObject.optLong("llsid");
        gVar.b = jSONObject.optLong("creative_id");
        gVar.c = jSONObject.optInt("score");
        gVar.d = jSONObject.optInt("is_bidding");
        gVar.e = jSONObject.optString("source");
        if (jSONObject.opt("source") == JSONObject.NULL) {
            gVar.e = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.report.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "llsid", gVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "creative_id", gVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "score", gVar.c);
        com.kwad.sdk.utils.r.a(jSONObject, "is_bidding", gVar.d);
        com.kwad.sdk.utils.r.a(jSONObject, "source", gVar.e);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.g gVar, JSONObject jSONObject) {
        a2(gVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.g gVar, JSONObject jSONObject) {
        return b2(gVar, jSONObject);
    }
}
