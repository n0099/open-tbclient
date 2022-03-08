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
        bVar.f54758b = jSONObject.optInt("adPhotoCountForMedia");
        bVar.f54759c = jSONObject.optBoolean("enablePreload");
        bVar.f54760d = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        bVar.f54761e = jSONObject.optInt("adLoadStrategy");
        bVar.f54762f = jSONObject.optInt("entryAutoPlay");
        bVar.f54763g = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.response.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "posId", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "adPhotoCountForMedia", bVar.f54758b);
        com.kwad.sdk.utils.t.a(jSONObject, "enablePreload", bVar.f54759c);
        com.kwad.sdk.utils.t.a(jSONObject, "increaseAdLoadTime", bVar.f54760d);
        com.kwad.sdk.utils.t.a(jSONObject, "adLoadStrategy", bVar.f54761e);
        com.kwad.sdk.utils.t.a(jSONObject, "entryAutoPlay", bVar.f54762f);
        com.kwad.sdk.utils.t.a(jSONObject, "drawAdForcedWatchTimes", bVar.f54763g);
        return jSONObject;
    }
}
