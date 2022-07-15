package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class s implements com.kwad.sdk.core.d<com.kwad.sdk.internal.api.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
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

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "thirdAge", aVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "thirdGender", aVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "thirdInterest", aVar.c);
        com.kwad.sdk.utils.r.a(jSONObject, "prevTitle", aVar.d);
        com.kwad.sdk.utils.r.a(jSONObject, "postTitle", aVar.e);
        com.kwad.sdk.utils.r.a(jSONObject, "historyTitle", aVar.f);
        com.kwad.sdk.utils.r.a(jSONObject, "channel", aVar.g);
        com.kwad.sdk.utils.r.a(jSONObject, "cpmBidFloor", aVar.h);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
