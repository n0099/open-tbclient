package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ja implements com.kwad.sdk.core.d<com.kwad.components.ad.splashscreen.local.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.ad.splashscreen.local.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.gM = jSONObject.optLong("lastShowTimestamp");
        aVar.gN = jSONObject.optInt("currentDailyCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.ad.splashscreen.local.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = aVar.gM;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "lastShowTimestamp", j);
        }
        int i = aVar.gN;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentDailyCount", i);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.splashscreen.local.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.splashscreen.local.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
