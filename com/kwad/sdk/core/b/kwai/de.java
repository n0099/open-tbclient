package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class de implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.response.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optLong("posId");
        bVar.f58401b = jSONObject.optInt("adPhotoCountForMedia");
        bVar.f58402c = jSONObject.optBoolean("enablePreload");
        bVar.f58403d = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        bVar.f58404e = jSONObject.optInt("adLoadStrategy");
        bVar.f58405f = jSONObject.optInt("entryAutoPlay");
        bVar.f58406g = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.response.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "posId", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "adPhotoCountForMedia", bVar.f58401b);
        com.kwad.sdk.utils.t.a(jSONObject, "enablePreload", bVar.f58402c);
        com.kwad.sdk.utils.t.a(jSONObject, "increaseAdLoadTime", bVar.f58403d);
        com.kwad.sdk.utils.t.a(jSONObject, "adLoadStrategy", bVar.f58404e);
        com.kwad.sdk.utils.t.a(jSONObject, "entryAutoPlay", bVar.f58405f);
        com.kwad.sdk.utils.t.a(jSONObject, "drawAdForcedWatchTimes", bVar.f58406g);
        return jSONObject;
    }
}
