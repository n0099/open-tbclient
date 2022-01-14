package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bg implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("entryType");
        aVar.f56187b = jSONObject.optString("sourceDesc");
        if (jSONObject.opt("sourceDesc") == JSONObject.NULL) {
            aVar.f56187b = "";
        }
        aVar.f56188c = jSONObject.optInt("sourceDescPos", new Integer("1").intValue());
        aVar.f56189d = jSONObject.optInt("likePos");
        aVar.f56190e = jSONObject.optString("entryId");
        if (jSONObject.opt("entryId") == JSONObject.NULL) {
            aVar.f56190e = "";
        }
        aVar.f56191f = jSONObject.optString("entryTitle", new String("精彩短视频"));
        aVar.f56192g = jSONObject.optInt("entryTitlePos", new Integer("1").intValue());
        aVar.f56193h = jSONObject.optInt("videoDurationPos", new Integer("1").intValue());
        aVar.f56194i = jSONObject.optInt("videoDescPos", new Integer("1").intValue());
        aVar.f56195j = jSONObject.optInt("commentsPos", new Integer("1").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "entryType", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "sourceDesc", aVar.f56187b);
        com.kwad.sdk.utils.t.a(jSONObject, "sourceDescPos", aVar.f56188c);
        com.kwad.sdk.utils.t.a(jSONObject, "likePos", aVar.f56189d);
        com.kwad.sdk.utils.t.a(jSONObject, "entryId", aVar.f56190e);
        com.kwad.sdk.utils.t.a(jSONObject, "entryTitle", aVar.f56191f);
        com.kwad.sdk.utils.t.a(jSONObject, "entryTitlePos", aVar.f56192g);
        com.kwad.sdk.utils.t.a(jSONObject, "videoDurationPos", aVar.f56193h);
        com.kwad.sdk.utils.t.a(jSONObject, "videoDescPos", aVar.f56194i);
        com.kwad.sdk.utils.t.a(jSONObject, "commentsPos", aVar.f56195j);
        return jSONObject;
    }
}
