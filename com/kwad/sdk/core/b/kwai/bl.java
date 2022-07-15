package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bl implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailWebCardInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
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
        detailWebCardInfo.cardType = jSONObject.optInt("cardType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "style", detailWebCardInfo.style);
        com.kwad.sdk.utils.r.a(jSONObject, "maxTimeOut", detailWebCardInfo.maxTimeOut);
        com.kwad.sdk.utils.r.a(jSONObject, "typeLandscape", detailWebCardInfo.typeLandscape);
        com.kwad.sdk.utils.r.a(jSONObject, "typePortrait", detailWebCardInfo.typePortrait);
        com.kwad.sdk.utils.r.a(jSONObject, "cardUrl", detailWebCardInfo.cardUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "cardData", detailWebCardInfo.cardData);
        com.kwad.sdk.utils.r.a(jSONObject, "cardShowTime", detailWebCardInfo.cardShowTime);
        com.kwad.sdk.utils.r.a(jSONObject, "cardType", detailWebCardInfo.cardType);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        a2(detailWebCardInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        return b2(detailWebCardInfo, jSONObject);
    }
}
