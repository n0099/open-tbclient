package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bg implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("entryType");
        aVar.f56399b = jSONObject.optString("sourceDesc");
        if (jSONObject.opt("sourceDesc") == JSONObject.NULL) {
            aVar.f56399b = "";
        }
        aVar.f56400c = jSONObject.optInt("sourceDescPos", new Integer("1").intValue());
        aVar.f56401d = jSONObject.optInt("likePos");
        aVar.f56402e = jSONObject.optString("entryId");
        if (jSONObject.opt("entryId") == JSONObject.NULL) {
            aVar.f56402e = "";
        }
        aVar.f56403f = jSONObject.optString("entryTitle", new String("精彩短视频"));
        aVar.f56404g = jSONObject.optInt("entryTitlePos", new Integer("1").intValue());
        aVar.f56405h = jSONObject.optInt("videoDurationPos", new Integer("1").intValue());
        aVar.f56406i = jSONObject.optInt("videoDescPos", new Integer("1").intValue());
        aVar.f56407j = jSONObject.optInt("commentsPos", new Integer("1").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "entryType", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "sourceDesc", aVar.f56399b);
        com.kwad.sdk.utils.t.a(jSONObject, "sourceDescPos", aVar.f56400c);
        com.kwad.sdk.utils.t.a(jSONObject, "likePos", aVar.f56401d);
        com.kwad.sdk.utils.t.a(jSONObject, "entryId", aVar.f56402e);
        com.kwad.sdk.utils.t.a(jSONObject, "entryTitle", aVar.f56403f);
        com.kwad.sdk.utils.t.a(jSONObject, "entryTitlePos", aVar.f56404g);
        com.kwad.sdk.utils.t.a(jSONObject, "videoDurationPos", aVar.f56405h);
        com.kwad.sdk.utils.t.a(jSONObject, "videoDescPos", aVar.f56406i);
        com.kwad.sdk.utils.t.a(jSONObject, "commentsPos", aVar.f56407j);
        return jSONObject;
    }
}
