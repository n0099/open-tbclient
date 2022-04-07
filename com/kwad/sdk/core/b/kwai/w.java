package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class w implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo.AdWebCardInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "typeLandscape", adWebCardInfo.typeLandscape);
        com.kwad.sdk.utils.t.a(jSONObject, "typePortrait", adWebCardInfo.typePortrait);
        com.kwad.sdk.utils.t.a(jSONObject, "cardUrl", adWebCardInfo.cardUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "cardData", adWebCardInfo.cardData);
        com.kwad.sdk.utils.t.a(jSONObject, "cardShowPlayCount", adWebCardInfo.cardShowPlayCount);
        com.kwad.sdk.utils.t.a(jSONObject, "cardShowTime", adWebCardInfo.cardShowTime);
        com.kwad.sdk.utils.t.a(jSONObject, "cardDelayTime", adWebCardInfo.cardDelayTime);
        return jSONObject;
    }
}
