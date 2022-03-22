package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class m implements com.kwad.sdk.core.d<com.kwad.sdk.internal.api.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("thirdAge");
        aVar.f40580b = jSONObject.optInt("thirdGender");
        aVar.f40581c = jSONObject.optString("thirdInterest");
        if (jSONObject.opt("thirdInterest") == JSONObject.NULL) {
            aVar.f40581c = "";
        }
        aVar.f40582d = jSONObject.optString("prevTitle");
        if (jSONObject.opt("prevTitle") == JSONObject.NULL) {
            aVar.f40582d = "";
        }
        aVar.f40583e = jSONObject.optString("postTitle");
        if (jSONObject.opt("postTitle") == JSONObject.NULL) {
            aVar.f40583e = "";
        }
        aVar.f40584f = jSONObject.optString("historyTitle");
        if (jSONObject.opt("historyTitle") == JSONObject.NULL) {
            aVar.f40584f = "";
        }
        aVar.f40585g = jSONObject.optString("channel");
        if (jSONObject.opt("channel") == JSONObject.NULL) {
            aVar.f40585g = "";
        }
        aVar.f40586h = jSONObject.optLong("cpmBidFloor");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "thirdAge", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "thirdGender", aVar.f40580b);
        com.kwad.sdk.utils.t.a(jSONObject, "thirdInterest", aVar.f40581c);
        com.kwad.sdk.utils.t.a(jSONObject, "prevTitle", aVar.f40582d);
        com.kwad.sdk.utils.t.a(jSONObject, "postTitle", aVar.f40583e);
        com.kwad.sdk.utils.t.a(jSONObject, "historyTitle", aVar.f40584f);
        com.kwad.sdk.utils.t.a(jSONObject, "channel", aVar.f40585g);
        com.kwad.sdk.utils.t.a(jSONObject, "cpmBidFloor", aVar.f40586h);
        return jSONObject;
    }
}
