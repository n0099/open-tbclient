package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ez implements com.kwad.sdk.core.d<com.kwad.components.ad.splashscreen.local.c> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.ad.splashscreen.local.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.a = jSONObject.optLong("lastShowTimestamp");
        cVar.b = jSONObject.optInt("currentDailyCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.ad.splashscreen.local.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "lastShowTimestamp", cVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "currentDailyCount", cVar.b);
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
