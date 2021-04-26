package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class y implements com.kwad.sdk.core.c<AdStyleInfo.PlayDetailInfo.DetailWebCardInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailWebCardInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
        detailWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        detailWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        detailWebCardInfo.cardUrl = jSONObject.optString("cardUrl");
        detailWebCardInfo.cardData = jSONObject.optString("cardData");
        detailWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "maxTimeOut", detailWebCardInfo.maxTimeOut);
        com.kwad.sdk.utils.o.a(jSONObject, "typeLandscape", detailWebCardInfo.typeLandscape);
        com.kwad.sdk.utils.o.a(jSONObject, "typePortrait", detailWebCardInfo.typePortrait);
        com.kwad.sdk.utils.o.a(jSONObject, "cardUrl", detailWebCardInfo.cardUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "cardData", detailWebCardInfo.cardData);
        com.kwad.sdk.utils.o.a(jSONObject, "cardShowTime", detailWebCardInfo.cardShowTime);
        return jSONObject;
    }
}
