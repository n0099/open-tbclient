package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class di implements com.kwad.sdk.core.d {
    public static void a(com.kwad.components.ad.fullscreen.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.en = jSONObject.optLong("lastShowTimestamp");
        bVar.eo = jSONObject.optInt("currentDailyCount");
    }

    public static JSONObject b(com.kwad.components.ad.fullscreen.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = bVar.en;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "lastShowTimestamp", j);
        }
        int i = bVar.eo;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "currentDailyCount", i);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.fullscreen.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.fullscreen.a.b) bVar, jSONObject);
    }
}
