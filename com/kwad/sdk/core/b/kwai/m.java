package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class m implements com.kwad.sdk.core.d<com.kwad.sdk.internal.api.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("thirdAge");
        aVar.f57205b = jSONObject.optInt("thirdGender");
        aVar.f57206c = jSONObject.optString("thirdInterest");
        if (jSONObject.opt("thirdInterest") == JSONObject.NULL) {
            aVar.f57206c = "";
        }
        aVar.f57207d = jSONObject.optString("prevTitle");
        if (jSONObject.opt("prevTitle") == JSONObject.NULL) {
            aVar.f57207d = "";
        }
        aVar.f57208e = jSONObject.optString("postTitle");
        if (jSONObject.opt("postTitle") == JSONObject.NULL) {
            aVar.f57208e = "";
        }
        aVar.f57209f = jSONObject.optString("historyTitle");
        if (jSONObject.opt("historyTitle") == JSONObject.NULL) {
            aVar.f57209f = "";
        }
        aVar.f57210g = jSONObject.optString("channel");
        if (jSONObject.opt("channel") == JSONObject.NULL) {
            aVar.f57210g = "";
        }
        aVar.f57211h = jSONObject.optLong("cpmBidFloor");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "thirdAge", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "thirdGender", aVar.f57205b);
        com.kwad.sdk.utils.t.a(jSONObject, "thirdInterest", aVar.f57206c);
        com.kwad.sdk.utils.t.a(jSONObject, "prevTitle", aVar.f57207d);
        com.kwad.sdk.utils.t.a(jSONObject, "postTitle", aVar.f57208e);
        com.kwad.sdk.utils.t.a(jSONObject, "historyTitle", aVar.f57209f);
        com.kwad.sdk.utils.t.a(jSONObject, "channel", aVar.f57210g);
        com.kwad.sdk.utils.t.a(jSONObject, "cpmBidFloor", aVar.f57211h);
        return jSONObject;
    }
}
