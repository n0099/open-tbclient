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
        aVar.f56232b = jSONObject.optString("sourceDesc");
        if (jSONObject.opt("sourceDesc") == JSONObject.NULL) {
            aVar.f56232b = "";
        }
        aVar.f56233c = jSONObject.optInt("sourceDescPos", new Integer("1").intValue());
        aVar.f56234d = jSONObject.optInt("likePos");
        aVar.f56235e = jSONObject.optString("entryId");
        if (jSONObject.opt("entryId") == JSONObject.NULL) {
            aVar.f56235e = "";
        }
        aVar.f56236f = jSONObject.optString("entryTitle", new String("精彩短视频"));
        aVar.f56237g = jSONObject.optInt("entryTitlePos", new Integer("1").intValue());
        aVar.f56238h = jSONObject.optInt("videoDurationPos", new Integer("1").intValue());
        aVar.f56239i = jSONObject.optInt("videoDescPos", new Integer("1").intValue());
        aVar.f56240j = jSONObject.optInt("commentsPos", new Integer("1").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "entryType", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "sourceDesc", aVar.f56232b);
        com.kwad.sdk.utils.t.a(jSONObject, "sourceDescPos", aVar.f56233c);
        com.kwad.sdk.utils.t.a(jSONObject, "likePos", aVar.f56234d);
        com.kwad.sdk.utils.t.a(jSONObject, "entryId", aVar.f56235e);
        com.kwad.sdk.utils.t.a(jSONObject, "entryTitle", aVar.f56236f);
        com.kwad.sdk.utils.t.a(jSONObject, "entryTitlePos", aVar.f56237g);
        com.kwad.sdk.utils.t.a(jSONObject, "videoDurationPos", aVar.f56238h);
        com.kwad.sdk.utils.t.a(jSONObject, "videoDescPos", aVar.f56239i);
        com.kwad.sdk.utils.t.a(jSONObject, "commentsPos", aVar.f56240j);
        return jSONObject;
    }
}
