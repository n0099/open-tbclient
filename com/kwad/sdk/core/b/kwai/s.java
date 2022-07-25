package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class s implements com.kwad.sdk.core.d<com.kwad.sdk.internal.api.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.acZ = jSONObject.optInt("thirdAge");
        aVar.ada = jSONObject.optInt("thirdGender");
        aVar.adb = jSONObject.optString("thirdInterest");
        if (jSONObject.opt("thirdInterest") == JSONObject.NULL) {
            aVar.adb = "";
        }
        aVar.aiz = jSONObject.optString("prevTitle");
        if (jSONObject.opt("prevTitle") == JSONObject.NULL) {
            aVar.aiz = "";
        }
        aVar.aiA = jSONObject.optString("postTitle");
        if (jSONObject.opt("postTitle") == JSONObject.NULL) {
            aVar.aiA = "";
        }
        aVar.aiB = jSONObject.optString("historyTitle");
        if (jSONObject.opt("historyTitle") == JSONObject.NULL) {
            aVar.aiB = "";
        }
        aVar.agM = jSONObject.optString("channel");
        if (jSONObject.opt("channel") == JSONObject.NULL) {
            aVar.agM = "";
        }
        aVar.aiC = jSONObject.optLong("cpmBidFloor");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.acZ;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "thirdAge", i);
        }
        int i2 = aVar.ada;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "thirdGender", i2);
        }
        String str = aVar.adb;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "thirdInterest", aVar.adb);
        }
        String str2 = aVar.aiz;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "prevTitle", aVar.aiz);
        }
        String str3 = aVar.aiA;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "postTitle", aVar.aiA);
        }
        String str4 = aVar.aiB;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "historyTitle", aVar.aiB);
        }
        String str5 = aVar.agM;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "channel", aVar.agM);
        }
        long j = aVar.aiC;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "cpmBidFloor", j);
        }
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
