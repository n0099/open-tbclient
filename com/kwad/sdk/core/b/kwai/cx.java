package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class cx implements com.kwad.sdk.core.d<com.kwad.components.ad.interstitial.a.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.ad.interstitial.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.en = jSONObject.optLong("lastShowTimestamp");
        bVar.fT = jSONObject.optInt("currentDailyAdShowCount");
        bVar.fU = jSONObject.optInt("currentDailyRetainShowCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.ad.interstitial.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = bVar.en;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "lastShowTimestamp", j);
        }
        int i = bVar.fT;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "currentDailyAdShowCount", i);
        }
        int i2 = bVar.fU;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "currentDailyRetainShowCount", i2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.interstitial.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.interstitial.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
