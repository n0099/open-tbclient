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
        aVar.f55555b = jSONObject.optInt("thirdGender");
        aVar.f55556c = jSONObject.optString("thirdInterest");
        if (jSONObject.opt("thirdInterest") == JSONObject.NULL) {
            aVar.f55556c = "";
        }
        aVar.f55557d = jSONObject.optString("prevTitle");
        if (jSONObject.opt("prevTitle") == JSONObject.NULL) {
            aVar.f55557d = "";
        }
        aVar.f55558e = jSONObject.optString("postTitle");
        if (jSONObject.opt("postTitle") == JSONObject.NULL) {
            aVar.f55558e = "";
        }
        aVar.f55559f = jSONObject.optString("historyTitle");
        if (jSONObject.opt("historyTitle") == JSONObject.NULL) {
            aVar.f55559f = "";
        }
        aVar.f55560g = jSONObject.optString("channel");
        if (jSONObject.opt("channel") == JSONObject.NULL) {
            aVar.f55560g = "";
        }
        aVar.f55561h = jSONObject.optLong("cpmBidFloor");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "thirdAge", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "thirdGender", aVar.f55555b);
        com.kwad.sdk.utils.t.a(jSONObject, "thirdInterest", aVar.f55556c);
        com.kwad.sdk.utils.t.a(jSONObject, "prevTitle", aVar.f55557d);
        com.kwad.sdk.utils.t.a(jSONObject, "postTitle", aVar.f55558e);
        com.kwad.sdk.utils.t.a(jSONObject, "historyTitle", aVar.f55559f);
        com.kwad.sdk.utils.t.a(jSONObject, "channel", aVar.f55560g);
        com.kwad.sdk.utils.t.a(jSONObject, "cpmBidFloor", aVar.f55561h);
        return jSONObject;
    }
}
