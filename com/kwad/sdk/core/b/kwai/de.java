package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class de implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.response.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optLong("posId");
        bVar.f56408b = jSONObject.optInt("adPhotoCountForMedia");
        bVar.f56409c = jSONObject.optBoolean("enablePreload");
        bVar.f56410d = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        bVar.f56411e = jSONObject.optInt("adLoadStrategy");
        bVar.f56412f = jSONObject.optInt("entryAutoPlay");
        bVar.f56413g = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.response.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "posId", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "adPhotoCountForMedia", bVar.f56408b);
        com.kwad.sdk.utils.t.a(jSONObject, "enablePreload", bVar.f56409c);
        com.kwad.sdk.utils.t.a(jSONObject, "increaseAdLoadTime", bVar.f56410d);
        com.kwad.sdk.utils.t.a(jSONObject, "adLoadStrategy", bVar.f56411e);
        com.kwad.sdk.utils.t.a(jSONObject, "entryAutoPlay", bVar.f56412f);
        com.kwad.sdk.utils.t.a(jSONObject, "drawAdForcedWatchTimes", bVar.f56413g);
        return jSONObject;
    }
}
