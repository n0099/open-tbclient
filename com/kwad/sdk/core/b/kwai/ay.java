package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ay implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailWebCardInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailWebCardInfo.style = jSONObject.optInt("style");
        detailWebCardInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
        detailWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        detailWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        detailWebCardInfo.cardUrl = jSONObject.optString("cardUrl");
        if (jSONObject.opt("cardUrl") == JSONObject.NULL) {
            detailWebCardInfo.cardUrl = "";
        }
        detailWebCardInfo.cardData = jSONObject.optString("cardData");
        if (jSONObject.opt("cardData") == JSONObject.NULL) {
            detailWebCardInfo.cardData = "";
        }
        detailWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "style", detailWebCardInfo.style);
        com.kwad.sdk.utils.t.a(jSONObject, "maxTimeOut", detailWebCardInfo.maxTimeOut);
        com.kwad.sdk.utils.t.a(jSONObject, "typeLandscape", detailWebCardInfo.typeLandscape);
        com.kwad.sdk.utils.t.a(jSONObject, "typePortrait", detailWebCardInfo.typePortrait);
        com.kwad.sdk.utils.t.a(jSONObject, "cardUrl", detailWebCardInfo.cardUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "cardData", detailWebCardInfo.cardData);
        com.kwad.sdk.utils.t.a(jSONObject, "cardShowTime", detailWebCardInfo.cardShowTime);
        return jSONObject;
    }
}
