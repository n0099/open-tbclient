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
        aVar.f32610a = jSONObject.optInt("entryType");
        aVar.f32611b = jSONObject.optString("sourceDesc");
        aVar.f32612c = jSONObject.optInt("sourceDescPos", new Integer("1").intValue());
        aVar.f32613d = jSONObject.optInt("likePos");
        aVar.f32614e = jSONObject.optString("entryId");
        aVar.f32615f = jSONObject.optString("entryTitle", new String("精彩短视频"));
        aVar.f32616g = jSONObject.optInt("entryTitlePos", new Integer("1").intValue());
        aVar.f32617h = jSONObject.optInt("videoDurationPos", new Integer("1").intValue());
        aVar.f32618i = jSONObject.optInt("videoDescPos", new Integer("1").intValue());
        aVar.j = jSONObject.optInt("commentsPos", new Integer("1").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "entryType", aVar.f32610a);
        com.kwad.sdk.utils.o.a(jSONObject, "sourceDesc", aVar.f32611b);
        com.kwad.sdk.utils.o.a(jSONObject, "sourceDescPos", aVar.f32612c);
        com.kwad.sdk.utils.o.a(jSONObject, "likePos", aVar.f32613d);
        com.kwad.sdk.utils.o.a(jSONObject, "entryId", aVar.f32614e);
        com.kwad.sdk.utils.o.a(jSONObject, "entryTitle", aVar.f32615f);
        com.kwad.sdk.utils.o.a(jSONObject, "entryTitlePos", aVar.f32616g);
        com.kwad.sdk.utils.o.a(jSONObject, "videoDurationPos", aVar.f32617h);
        com.kwad.sdk.utils.o.a(jSONObject, "videoDescPos", aVar.f32618i);
        com.kwad.sdk.utils.o.a(jSONObject, "commentsPos", aVar.j);
        return jSONObject;
    }
}
