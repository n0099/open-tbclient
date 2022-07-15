package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ed implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optLong("posId");
        aVar.b = jSONObject.optInt("adPhotoCountForMedia");
        aVar.c = jSONObject.optBoolean("enablePreload");
        aVar.d = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        aVar.e = jSONObject.optInt("adLoadStrategy");
        aVar.f = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "posId", aVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "adPhotoCountForMedia", aVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "enablePreload", aVar.c);
        com.kwad.sdk.utils.r.a(jSONObject, "increaseAdLoadTime", aVar.d);
        com.kwad.sdk.utils.r.a(jSONObject, "adLoadStrategy", aVar.e);
        com.kwad.sdk.utils.r.a(jSONObject, "drawAdForcedWatchTimes", aVar.f);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
