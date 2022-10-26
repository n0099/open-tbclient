package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ej implements com.kwad.sdk.core.d {
    public static void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.posId = jSONObject.optLong("posId");
        aVar.add = jSONObject.optInt("adPhotoCountForMedia");
        aVar.ade = jSONObject.optBoolean("enablePreload");
        aVar.adf = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        aVar.adg = jSONObject.optInt("adLoadStrategy");
        aVar.adh = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    public static JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = aVar.posId;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "posId", j);
        }
        int i = aVar.add;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adPhotoCountForMedia", i);
        }
        boolean z = aVar.ade;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "enablePreload", z);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "increaseAdLoadTime", aVar.adf);
        int i2 = aVar.adg;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adLoadStrategy", i2);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "drawAdForcedWatchTimes", aVar.adh);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.response.model.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.response.model.a) bVar, jSONObject);
    }
}
