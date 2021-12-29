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
        aVar.f59224b = jSONObject.optInt("thirdGender");
        aVar.f59225c = jSONObject.optString("thirdInterest");
        if (jSONObject.opt("thirdInterest") == JSONObject.NULL) {
            aVar.f59225c = "";
        }
        aVar.f59226d = jSONObject.optString("prevTitle");
        if (jSONObject.opt("prevTitle") == JSONObject.NULL) {
            aVar.f59226d = "";
        }
        aVar.f59227e = jSONObject.optString("postTitle");
        if (jSONObject.opt("postTitle") == JSONObject.NULL) {
            aVar.f59227e = "";
        }
        aVar.f59228f = jSONObject.optString("historyTitle");
        if (jSONObject.opt("historyTitle") == JSONObject.NULL) {
            aVar.f59228f = "";
        }
        aVar.f59229g = jSONObject.optString("channel");
        if (jSONObject.opt("channel") == JSONObject.NULL) {
            aVar.f59229g = "";
        }
        aVar.f59230h = jSONObject.optLong("cpmBidFloor");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "thirdAge", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "thirdGender", aVar.f59224b);
        com.kwad.sdk.utils.t.a(jSONObject, "thirdInterest", aVar.f59225c);
        com.kwad.sdk.utils.t.a(jSONObject, "prevTitle", aVar.f59226d);
        com.kwad.sdk.utils.t.a(jSONObject, "postTitle", aVar.f59227e);
        com.kwad.sdk.utils.t.a(jSONObject, "historyTitle", aVar.f59228f);
        com.kwad.sdk.utils.t.a(jSONObject, "channel", aVar.f59229g);
        com.kwad.sdk.utils.t.a(jSONObject, "cpmBidFloor", aVar.f59230h);
        return jSONObject;
    }
}
