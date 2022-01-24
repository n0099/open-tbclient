package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m implements com.kwad.sdk.core.d<com.kwad.sdk.internal.api.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("thirdAge");
        aVar.f57038b = jSONObject.optInt("thirdGender");
        aVar.f57039c = jSONObject.optString("thirdInterest");
        if (jSONObject.opt("thirdInterest") == JSONObject.NULL) {
            aVar.f57039c = "";
        }
        aVar.f57040d = jSONObject.optString("prevTitle");
        if (jSONObject.opt("prevTitle") == JSONObject.NULL) {
            aVar.f57040d = "";
        }
        aVar.f57041e = jSONObject.optString("postTitle");
        if (jSONObject.opt("postTitle") == JSONObject.NULL) {
            aVar.f57041e = "";
        }
        aVar.f57042f = jSONObject.optString("historyTitle");
        if (jSONObject.opt("historyTitle") == JSONObject.NULL) {
            aVar.f57042f = "";
        }
        aVar.f57043g = jSONObject.optString("channel");
        if (jSONObject.opt("channel") == JSONObject.NULL) {
            aVar.f57043g = "";
        }
        aVar.f57044h = jSONObject.optLong("cpmBidFloor");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "thirdAge", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "thirdGender", aVar.f57038b);
        com.kwad.sdk.utils.t.a(jSONObject, "thirdInterest", aVar.f57039c);
        com.kwad.sdk.utils.t.a(jSONObject, "prevTitle", aVar.f57040d);
        com.kwad.sdk.utils.t.a(jSONObject, "postTitle", aVar.f57041e);
        com.kwad.sdk.utils.t.a(jSONObject, "historyTitle", aVar.f57042f);
        com.kwad.sdk.utils.t.a(jSONObject, "channel", aVar.f57043g);
        com.kwad.sdk.utils.t.a(jSONObject, "cpmBidFloor", aVar.f57044h);
        return jSONObject;
    }
}
