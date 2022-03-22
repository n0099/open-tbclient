package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j implements com.kwad.sdk.core.d<AdMatrixInfo.AdDataV2> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
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
        AdMatrixInfo.SplashInfo splashInfo = new AdMatrixInfo.SplashInfo();
        adDataV2.splashInfo = splashInfo;
        splashInfo.parseJson(jSONObject.optJSONObject("splashInfo"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "templateDatas", adDataV2.templateDataList);
        com.kwad.sdk.utils.t.a(jSONObject, "bottomBannerInfo", adDataV2.bottomBannerInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "actionBarInfo", adDataV2.actionBarInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "fullPageActionBarInfo", adDataV2.fullPageActionBarInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "halfCardInfo", adDataV2.halfCardInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "endCardInfo", adDataV2.endCardInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "interactionInfo", adDataV2.interactionInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "interstitialCardInfo", adDataV2.interstitialCardInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "feedInfo", adDataV2.feedInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "splashInfo", adDataV2.splashInfo);
        return jSONObject;
    }
}
