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
        aVar.f33436a = jSONObject.optInt("entryType");
        aVar.f33437b = jSONObject.optString("sourceDesc");
        aVar.f33438c = jSONObject.optInt("sourceDescPos", new Integer("1").intValue());
        aVar.f33439d = jSONObject.optInt("likePos");
        aVar.f33440e = jSONObject.optString("entryId");
        aVar.f33441f = jSONObject.optString("entryTitle", new String("精彩短视频"));
        aVar.f33442g = jSONObject.optInt("entryTitlePos", new Integer("1").intValue());
        aVar.f33443h = jSONObject.optInt("videoDurationPos", new Integer("1").intValue());
        aVar.f33444i = jSONObject.optInt("videoDescPos", new Integer("1").intValue());
        aVar.j = jSONObject.optInt("commentsPos", new Integer("1").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "entryType", aVar.f33436a);
        com.kwad.sdk.utils.o.a(jSONObject, "sourceDesc", aVar.f33437b);
        com.kwad.sdk.utils.o.a(jSONObject, "sourceDescPos", aVar.f33438c);
        com.kwad.sdk.utils.o.a(jSONObject, "likePos", aVar.f33439d);
        com.kwad.sdk.utils.o.a(jSONObject, "entryId", aVar.f33440e);
        com.kwad.sdk.utils.o.a(jSONObject, "entryTitle", aVar.f33441f);
        com.kwad.sdk.utils.o.a(jSONObject, "entryTitlePos", aVar.f33442g);
        com.kwad.sdk.utils.o.a(jSONObject, "videoDurationPos", aVar.f33443h);
        com.kwad.sdk.utils.o.a(jSONObject, "videoDescPos", aVar.f33444i);
        com.kwad.sdk.utils.o.a(jSONObject, "commentsPos", aVar.j);
        return jSONObject;
    }
}
