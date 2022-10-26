package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class au implements com.kwad.sdk.core.d {
    public static void a(com.kwad.sdk.core.report.g gVar, JSONObject jSONObject) {
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

    public static JSONObject b(com.kwad.sdk.core.report.g gVar, JSONObject jSONObject) {
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

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.report.g) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.report.g) bVar, jSONObject);
    }
}
