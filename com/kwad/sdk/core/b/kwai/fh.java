package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class fh implements com.kwad.sdk.core.d<com.kwad.components.ad.splashscreen.local.c> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.ad.splashscreen.local.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.en = jSONObject.optLong("lastShowTimestamp");
        cVar.eo = jSONObject.optInt("currentDailyCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.ad.splashscreen.local.c cVar, JSONObject jSONObject) {
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.splashscreen.local.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.splashscreen.local.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
