package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m implements com.kwad.sdk.core.c<AdStyleInfo.PlayEndInfo.AdWebCardInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        adWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        adWebCardInfo.cardUrl = jSONObject.optString("cardUrl");
        adWebCardInfo.cardData = jSONObject.optString("cardData");
        adWebCardInfo.cardShowPlayCount = jSONObject.optInt("cardShowPlayCount");
        adWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
        adWebCardInfo.cardDelayTime = jSONObject.optLong("cardDelayTime");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "typeLandscape", adWebCardInfo.typeLandscape);
        com.kwad.sdk.utils.o.a(jSONObject, "typePortrait", adWebCardInfo.typePortrait);
        com.kwad.sdk.utils.o.a(jSONObject, "cardUrl", adWebCardInfo.cardUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "cardData", adWebCardInfo.cardData);
        com.kwad.sdk.utils.o.a(jSONObject, "cardShowPlayCount", adWebCardInfo.cardShowPlayCount);
        com.kwad.sdk.utils.o.a(jSONObject, "cardShowTime", adWebCardInfo.cardShowTime);
        com.kwad.sdk.utils.o.a(jSONObject, "cardDelayTime", adWebCardInfo.cardDelayTime);
        return jSONObject;
    }
}
