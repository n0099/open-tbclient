package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bg implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("entryType");
        aVar.f54749b = jSONObject.optString("sourceDesc");
        if (jSONObject.opt("sourceDesc") == JSONObject.NULL) {
            aVar.f54749b = "";
        }
        aVar.f54750c = jSONObject.optInt("sourceDescPos", new Integer("1").intValue());
        aVar.f54751d = jSONObject.optInt("likePos");
        aVar.f54752e = jSONObject.optString("entryId");
        if (jSONObject.opt("entryId") == JSONObject.NULL) {
            aVar.f54752e = "";
        }
        aVar.f54753f = jSONObject.optString("entryTitle", new String("精彩短视频"));
        aVar.f54754g = jSONObject.optInt("entryTitlePos", new Integer("1").intValue());
        aVar.f54755h = jSONObject.optInt("videoDurationPos", new Integer("1").intValue());
        aVar.f54756i = jSONObject.optInt("videoDescPos", new Integer("1").intValue());
        aVar.f54757j = jSONObject.optInt("commentsPos", new Integer("1").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "entryType", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "sourceDesc", aVar.f54749b);
        com.kwad.sdk.utils.t.a(jSONObject, "sourceDescPos", aVar.f54750c);
        com.kwad.sdk.utils.t.a(jSONObject, "likePos", aVar.f54751d);
        com.kwad.sdk.utils.t.a(jSONObject, "entryId", aVar.f54752e);
        com.kwad.sdk.utils.t.a(jSONObject, "entryTitle", aVar.f54753f);
        com.kwad.sdk.utils.t.a(jSONObject, "entryTitlePos", aVar.f54754g);
        com.kwad.sdk.utils.t.a(jSONObject, "videoDurationPos", aVar.f54755h);
        com.kwad.sdk.utils.t.a(jSONObject, "videoDescPos", aVar.f54756i);
        com.kwad.sdk.utils.t.a(jSONObject, "commentsPos", aVar.f54757j);
        return jSONObject;
    }
}
