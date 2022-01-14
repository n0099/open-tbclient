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
        aVar.f56993b = jSONObject.optInt("thirdGender");
        aVar.f56994c = jSONObject.optString("thirdInterest");
        if (jSONObject.opt("thirdInterest") == JSONObject.NULL) {
            aVar.f56994c = "";
        }
        aVar.f56995d = jSONObject.optString("prevTitle");
        if (jSONObject.opt("prevTitle") == JSONObject.NULL) {
            aVar.f56995d = "";
        }
        aVar.f56996e = jSONObject.optString("postTitle");
        if (jSONObject.opt("postTitle") == JSONObject.NULL) {
            aVar.f56996e = "";
        }
        aVar.f56997f = jSONObject.optString("historyTitle");
        if (jSONObject.opt("historyTitle") == JSONObject.NULL) {
            aVar.f56997f = "";
        }
        aVar.f56998g = jSONObject.optString("channel");
        if (jSONObject.opt("channel") == JSONObject.NULL) {
            aVar.f56998g = "";
        }
        aVar.f56999h = jSONObject.optLong("cpmBidFloor");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "thirdAge", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "thirdGender", aVar.f56993b);
        com.kwad.sdk.utils.t.a(jSONObject, "thirdInterest", aVar.f56994c);
        com.kwad.sdk.utils.t.a(jSONObject, "prevTitle", aVar.f56995d);
        com.kwad.sdk.utils.t.a(jSONObject, "postTitle", aVar.f56996e);
        com.kwad.sdk.utils.t.a(jSONObject, "historyTitle", aVar.f56997f);
        com.kwad.sdk.utils.t.a(jSONObject, "channel", aVar.f56998g);
        com.kwad.sdk.utils.t.a(jSONObject, "cpmBidFloor", aVar.f56999h);
        return jSONObject;
    }
}
