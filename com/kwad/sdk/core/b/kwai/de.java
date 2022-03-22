package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class de implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.response.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optLong("posId");
        bVar.f39859b = jSONObject.optInt("adPhotoCountForMedia");
        bVar.f39860c = jSONObject.optBoolean("enablePreload");
        bVar.f39861d = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        bVar.f39862e = jSONObject.optInt("adLoadStrategy");
        bVar.f39863f = jSONObject.optInt("entryAutoPlay");
        bVar.f39864g = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.response.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "posId", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "adPhotoCountForMedia", bVar.f39859b);
        com.kwad.sdk.utils.t.a(jSONObject, "enablePreload", bVar.f39860c);
        com.kwad.sdk.utils.t.a(jSONObject, "increaseAdLoadTime", bVar.f39861d);
        com.kwad.sdk.utils.t.a(jSONObject, "adLoadStrategy", bVar.f39862e);
        com.kwad.sdk.utils.t.a(jSONObject, "entryAutoPlay", bVar.f39863f);
        com.kwad.sdk.utils.t.a(jSONObject, "drawAdForcedWatchTimes", bVar.f39864g);
        return jSONObject;
    }
}
