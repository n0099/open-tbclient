package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ad implements com.kwad.sdk.core.d {
    public static void a(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        adWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        adWebCardInfo.cardUrl = jSONObject.optString("cardUrl");
        if (jSONObject.opt("cardUrl") == JSONObject.NULL) {
            adWebCardInfo.cardUrl = "";
        }
        adWebCardInfo.cardData = jSONObject.optString("cardData");
        if (jSONObject.opt("cardData") == JSONObject.NULL) {
            adWebCardInfo.cardData = "";
        }
        adWebCardInfo.cardShowPlayCount = jSONObject.optInt("cardShowPlayCount");
        adWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
        adWebCardInfo.cardDelayTime = jSONObject.optLong("cardDelayTime");
    }

    public static JSONObject b(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = adWebCardInfo.typeLandscape;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "typeLandscape", j);
        }
        long j2 = adWebCardInfo.typePortrait;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "typePortrait", j2);
        }
        String str = adWebCardInfo.cardUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "cardUrl", adWebCardInfo.cardUrl);
        }
        String str2 = adWebCardInfo.cardData;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "cardData", adWebCardInfo.cardData);
        }
        int i = adWebCardInfo.cardShowPlayCount;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "cardShowPlayCount", i);
        }
        long j3 = adWebCardInfo.cardShowTime;
        if (j3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "cardShowTime", j3);
        }
        long j4 = adWebCardInfo.cardDelayTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "cardDelayTime", j4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayEndInfo.AdWebCardInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayEndInfo.AdWebCardInfo) bVar, jSONObject);
    }
}
