package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class l implements com.kwad.sdk.core.d<AdMatrixInfo.AdDataV2> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adDataV2.templateDataList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("templateDatas");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                AdMatrixInfo.TemplateData templateData = new AdMatrixInfo.TemplateData();
                templateData.parseJson(optJSONArray.optJSONObject(i));
                adDataV2.templateDataList.add(templateData);
            }
        }
        AdMatrixInfo.BottomBannerInfo bottomBannerInfo = new AdMatrixInfo.BottomBannerInfo();
        adDataV2.bottomBannerInfo = bottomBannerInfo;
        bottomBannerInfo.parseJson(jSONObject.optJSONObject("bottomBannerInfo"));
        AdMatrixInfo.ActionBarInfoNew actionBarInfoNew = new AdMatrixInfo.ActionBarInfoNew();
        adDataV2.actionBarInfo = actionBarInfoNew;
        actionBarInfoNew.parseJson(jSONObject.optJSONObject("actionBarInfo"));
        AdMatrixInfo.FullPageActionBarInfo fullPageActionBarInfo = new AdMatrixInfo.FullPageActionBarInfo();
        adDataV2.fullPageActionBarInfo = fullPageActionBarInfo;
        fullPageActionBarInfo.parseJson(jSONObject.optJSONObject("fullPageActionBarInfo"));
        AdMatrixInfo.AggregationCardInfo aggregationCardInfo = new AdMatrixInfo.AggregationCardInfo();
        adDataV2.aggregationCardInfo = aggregationCardInfo;
        aggregationCardInfo.parseJson(jSONObject.optJSONObject("aggregationCardInfo"));
        AdMatrixInfo.HalfCardInfo halfCardInfo = new AdMatrixInfo.HalfCardInfo();
        adDataV2.halfCardInfo = halfCardInfo;
        halfCardInfo.parseJson(jSONObject.optJSONObject("halfCardInfo"));
        AdMatrixInfo.EndCardInfo endCardInfo = new AdMatrixInfo.EndCardInfo();
        adDataV2.endCardInfo = endCardInfo;
        endCardInfo.parseJson(jSONObject.optJSONObject("endCardInfo"));
        AdMatrixInfo.InteractionInfo interactionInfo = new AdMatrixInfo.InteractionInfo();
        adDataV2.interactionInfo = interactionInfo;
        interactionInfo.parseJson(jSONObject.optJSONObject("interactionInfo"));
        AdMatrixInfo.InterstitialCardInfo interstitialCardInfo = new AdMatrixInfo.InterstitialCardInfo();
        adDataV2.interstitialCardInfo = interstitialCardInfo;
        interstitialCardInfo.parseJson(jSONObject.optJSONObject("interstitialCardInfo"));
        AdMatrixInfo.FeedInfo feedInfo = new AdMatrixInfo.FeedInfo();
        adDataV2.feedInfo = feedInfo;
        feedInfo.parseJson(jSONObject.optJSONObject("feedInfo"));
        AdMatrixInfo.ComplianceCardInfo complianceCardInfo = new AdMatrixInfo.ComplianceCardInfo();
        adDataV2.complianceCardInfo = complianceCardInfo;
        complianceCardInfo.parseJson(jSONObject.optJSONObject("complianceCardInfo"));
        AdMatrixInfo.DownloadConfirmCardInfo downloadConfirmCardInfo = new AdMatrixInfo.DownloadConfirmCardInfo();
        adDataV2.downloadConfirmCardInfo = downloadConfirmCardInfo;
        downloadConfirmCardInfo.parseJson(jSONObject.optJSONObject("downloadConfirmCardInfo"));
        AdMatrixInfo.SplashInfo splashInfo = new AdMatrixInfo.SplashInfo();
        adDataV2.splashInfo = splashInfo;
        splashInfo.parseJson(jSONObject.optJSONObject("splashInfo"));
        AdMatrixInfo.FullScreenInfo fullScreenInfo = new AdMatrixInfo.FullScreenInfo();
        adDataV2.fullScreenInfo = fullScreenInfo;
        fullScreenInfo.parseJson(jSONObject.optJSONObject("fullScreenInfo"));
        AdMatrixInfo.RewardWatchOnceInfo rewardWatchOnceInfo = new AdMatrixInfo.RewardWatchOnceInfo();
        adDataV2.rewardWatchOnceInfo = rewardWatchOnceInfo;
        rewardWatchOnceInfo.parseJson(jSONObject.optJSONObject("rewardWatchOnceInfo"));
        AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo = new AdMatrixInfo.MerchantLiveReservationInfo();
        adDataV2.merchantLiveReservationInfo = merchantLiveReservationInfo;
        merchantLiveReservationInfo.parseJson(jSONObject.optJSONObject("merchantLiveReservationInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "templateDatas", adDataV2.templateDataList);
        com.kwad.sdk.utils.r.a(jSONObject, "bottomBannerInfo", adDataV2.bottomBannerInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "actionBarInfo", adDataV2.actionBarInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "fullPageActionBarInfo", adDataV2.fullPageActionBarInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "aggregationCardInfo", adDataV2.aggregationCardInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "halfCardInfo", adDataV2.halfCardInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "endCardInfo", adDataV2.endCardInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "interactionInfo", adDataV2.interactionInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "interstitialCardInfo", adDataV2.interstitialCardInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "feedInfo", adDataV2.feedInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "complianceCardInfo", adDataV2.complianceCardInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "downloadConfirmCardInfo", adDataV2.downloadConfirmCardInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "splashInfo", adDataV2.splashInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "fullScreenInfo", adDataV2.fullScreenInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "rewardWatchOnceInfo", adDataV2.rewardWatchOnceInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "merchantLiveReservationInfo", adDataV2.merchantLiveReservationInfo);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        a2(adDataV2, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        return b2(adDataV2, jSONObject);
    }
}
