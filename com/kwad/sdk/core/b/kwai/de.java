package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class de implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.response.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optLong("posId");
        bVar.b = jSONObject.optInt("adPhotoCountForMedia");
        bVar.c = jSONObject.optBoolean("enablePreload");
        bVar.d = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        bVar.e = jSONObject.optInt("adLoadStrategy");
        bVar.f = jSONObject.optInt("entryAutoPlay");
        bVar.g = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.response.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "posId", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "adPhotoCountForMedia", bVar.b);
        com.kwad.sdk.utils.t.a(jSONObject, "enablePreload", bVar.c);
        com.kwad.sdk.utils.t.a(jSONObject, "increaseAdLoadTime", bVar.d);
        com.kwad.sdk.utils.t.a(jSONObject, "adLoadStrategy", bVar.e);
        com.kwad.sdk.utils.t.a(jSONObject, "entryAutoPlay", bVar.f);
        com.kwad.sdk.utils.t.a(jSONObject, "drawAdForcedWatchTimes", bVar.g);
        return jSONObject;
    }
}
