package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class m implements com.kwad.sdk.core.d<com.kwad.sdk.internal.api.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("thirdAge");
        aVar.b = jSONObject.optInt("thirdGender");
        aVar.c = jSONObject.optString("thirdInterest");
        if (jSONObject.opt("thirdInterest") == JSONObject.NULL) {
            aVar.c = "";
        }
        aVar.d = jSONObject.optString("prevTitle");
        if (jSONObject.opt("prevTitle") == JSONObject.NULL) {
            aVar.d = "";
        }
        aVar.e = jSONObject.optString("postTitle");
        if (jSONObject.opt("postTitle") == JSONObject.NULL) {
            aVar.e = "";
        }
        aVar.f = jSONObject.optString("historyTitle");
        if (jSONObject.opt("historyTitle") == JSONObject.NULL) {
            aVar.f = "";
        }
        aVar.g = jSONObject.optString("channel");
        if (jSONObject.opt("channel") == JSONObject.NULL) {
            aVar.g = "";
        }
        aVar.h = jSONObject.optLong("cpmBidFloor");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "thirdAge", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "thirdGender", aVar.b);
        com.kwad.sdk.utils.t.a(jSONObject, "thirdInterest", aVar.c);
        com.kwad.sdk.utils.t.a(jSONObject, "prevTitle", aVar.d);
        com.kwad.sdk.utils.t.a(jSONObject, "postTitle", aVar.e);
        com.kwad.sdk.utils.t.a(jSONObject, "historyTitle", aVar.f);
        com.kwad.sdk.utils.t.a(jSONObject, "channel", aVar.g);
        com.kwad.sdk.utils.t.a(jSONObject, "cpmBidFloor", aVar.h);
        return jSONObject;
    }
}
