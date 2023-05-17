package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class au implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.g> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.report.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.llsid = jSONObject.optLong("llsid");
        gVar.creativeId = jSONObject.optLong("creative_id");
        gVar.score = jSONObject.optInt("score");
        gVar.ZZ = jSONObject.optInt("is_bidding");
        gVar.source = jSONObject.optString("source");
        if (jSONObject.opt("source") == JSONObject.NULL) {
            gVar.source = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.report.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = gVar.llsid;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "llsid", j);
        }
        long j2 = gVar.creativeId;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "creative_id", j2);
        }
        int i = gVar.score;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "score", i);
        }
        int i2 = gVar.ZZ;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "is_bidding", i2);
        }
        String str = gVar.source;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "source", gVar.source);
        }
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
