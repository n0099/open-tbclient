package com.kwad.sdk.core.c.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ac implements com.kwad.sdk.core.c<com.kwad.sdk.core.response.model.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f32681a = jSONObject.optInt("entryType");
        aVar.f32682b = jSONObject.optString("sourceDesc");
        aVar.f32683c = jSONObject.optInt("sourceDescPos", new Integer("1").intValue());
        aVar.f32684d = jSONObject.optInt("likePos");
        aVar.f32685e = jSONObject.optString("entryId");
        aVar.f32686f = jSONObject.optString("entryTitle", new String("精彩短视频"));
        aVar.f32687g = jSONObject.optInt("entryTitlePos", new Integer("1").intValue());
        aVar.f32688h = jSONObject.optInt("videoDurationPos", new Integer("1").intValue());
        aVar.f32689i = jSONObject.optInt("videoDescPos", new Integer("1").intValue());
        aVar.j = jSONObject.optInt("commentsPos", new Integer("1").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "entryType", aVar.f32681a);
        com.kwad.sdk.utils.o.a(jSONObject, "sourceDesc", aVar.f32682b);
        com.kwad.sdk.utils.o.a(jSONObject, "sourceDescPos", aVar.f32683c);
        com.kwad.sdk.utils.o.a(jSONObject, "likePos", aVar.f32684d);
        com.kwad.sdk.utils.o.a(jSONObject, "entryId", aVar.f32685e);
        com.kwad.sdk.utils.o.a(jSONObject, "entryTitle", aVar.f32686f);
        com.kwad.sdk.utils.o.a(jSONObject, "entryTitlePos", aVar.f32687g);
        com.kwad.sdk.utils.o.a(jSONObject, "videoDurationPos", aVar.f32688h);
        com.kwad.sdk.utils.o.a(jSONObject, "videoDescPos", aVar.f32689i);
        com.kwad.sdk.utils.o.a(jSONObject, "commentsPos", aVar.j);
        return jSONObject;
    }
}
