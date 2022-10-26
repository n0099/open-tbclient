package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class fh implements com.kwad.sdk.core.d {
    public static void a(com.kwad.components.ad.splashscreen.local.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.en = jSONObject.optLong("lastShowTimestamp");
        cVar.eo = jSONObject.optInt("currentDailyCount");
    }

    public static JSONObject b(com.kwad.components.ad.splashscreen.local.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = cVar.en;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "lastShowTimestamp", j);
        }
        int i = cVar.eo;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "currentDailyCount", i);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.splashscreen.local.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.splashscreen.local.c) bVar, jSONObject);
    }
}
