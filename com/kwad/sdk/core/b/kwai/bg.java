package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bg implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("entryType");
        aVar.b = jSONObject.optString("sourceDesc");
        if (jSONObject.opt("sourceDesc") == JSONObject.NULL) {
            aVar.b = "";
        }
        aVar.c = jSONObject.optInt("sourceDescPos", new Integer("1").intValue());
        aVar.d = jSONObject.optInt("likePos");
        aVar.e = jSONObject.optString("entryId");
        if (jSONObject.opt("entryId") == JSONObject.NULL) {
            aVar.e = "";
        }
        aVar.f = jSONObject.optString("entryTitle", new String("精彩短视频"));
        aVar.g = jSONObject.optInt("entryTitlePos", new Integer("1").intValue());
        aVar.h = jSONObject.optInt("videoDurationPos", new Integer("1").intValue());
        aVar.i = jSONObject.optInt("videoDescPos", new Integer("1").intValue());
        aVar.j = jSONObject.optInt("commentsPos", new Integer("1").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "entryType", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "sourceDesc", aVar.b);
        com.kwad.sdk.utils.t.a(jSONObject, "sourceDescPos", aVar.c);
        com.kwad.sdk.utils.t.a(jSONObject, "likePos", aVar.d);
        com.kwad.sdk.utils.t.a(jSONObject, "entryId", aVar.e);
        com.kwad.sdk.utils.t.a(jSONObject, "entryTitle", aVar.f);
        com.kwad.sdk.utils.t.a(jSONObject, "entryTitlePos", aVar.g);
        com.kwad.sdk.utils.t.a(jSONObject, "videoDurationPos", aVar.h);
        com.kwad.sdk.utils.t.a(jSONObject, "videoDescPos", aVar.i);
        com.kwad.sdk.utils.t.a(jSONObject, "commentsPos", aVar.j);
        return jSONObject;
    }
}
