package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class cx implements com.kwad.sdk.core.d {
    public static void a(com.kwad.components.ad.interstitial.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.en = jSONObject.optLong("lastShowTimestamp");
        bVar.fT = jSONObject.optInt("currentDailyAdShowCount");
        bVar.fU = jSONObject.optInt("currentDailyRetainShowCount");
    }

    public static JSONObject b(com.kwad.components.ad.interstitial.a.b bVar, JSONObject jSONObject) {
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

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.interstitial.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.interstitial.a.b) bVar, jSONObject);
    }
}
