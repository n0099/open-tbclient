package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ad implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo.AdWebCardInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
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

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "typeLandscape", adWebCardInfo.typeLandscape);
        com.kwad.sdk.utils.r.a(jSONObject, "typePortrait", adWebCardInfo.typePortrait);
        com.kwad.sdk.utils.r.a(jSONObject, "cardUrl", adWebCardInfo.cardUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "cardData", adWebCardInfo.cardData);
        com.kwad.sdk.utils.r.a(jSONObject, "cardShowPlayCount", adWebCardInfo.cardShowPlayCount);
        com.kwad.sdk.utils.r.a(jSONObject, "cardShowTime", adWebCardInfo.cardShowTime);
        com.kwad.sdk.utils.r.a(jSONObject, "cardDelayTime", adWebCardInfo.cardDelayTime);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        a2(adWebCardInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        return b2(adWebCardInfo, jSONObject);
    }
}
