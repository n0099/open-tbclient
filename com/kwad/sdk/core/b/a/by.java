package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class by implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.k> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.report.k kVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kVar.llsid = jSONObject.optLong("llsid");
        kVar.creativeId = jSONObject.optLong("creative_id");
        kVar.score = jSONObject.optInt("score");
        kVar.avD = jSONObject.optInt("is_bidding");
        kVar.source = jSONObject.optString("source");
        if (JSONObject.NULL.toString().equals(kVar.source)) {
            kVar.source = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.report.k kVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = kVar.llsid;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j);
        }
        long j2 = kVar.creativeId;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creative_id", j2);
        }
        int i = kVar.score;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "score", i);
        }
        int i2 = kVar.avD;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_bidding", i2);
        }
        String str = kVar.source;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "source", kVar.source);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.k kVar, JSONObject jSONObject) {
        a2(kVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.k kVar, JSONObject jSONObject) {
        return b2(kVar, jSONObject);
    }
}
