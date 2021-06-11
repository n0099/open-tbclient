package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdInfo;
import com.qq.e.comm.constants.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c implements com.kwad.sdk.core.c<AdInfo.AdBaseInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(AdInfo.AdBaseInfo adBaseInfo) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "creativeId", adBaseInfo.creativeId);
        com.kwad.sdk.utils.o.a(jSONObject, "adSourceType", adBaseInfo.adSourceType);
        com.kwad.sdk.utils.o.a(jSONObject, "adDescription", adBaseInfo.adDescription);
        com.kwad.sdk.utils.o.a(jSONObject, "adMarkIcon", adBaseInfo.adMarkIcon);
        com.kwad.sdk.utils.o.a(jSONObject, "adGrayMarkIcon", adBaseInfo.adGrayMarkIcon);
        com.kwad.sdk.utils.o.a(jSONObject, "adSourceDescription", adBaseInfo.adSourceDescription);
        com.kwad.sdk.utils.o.a(jSONObject, "adOperationType", adBaseInfo.adOperationType);
        com.kwad.sdk.utils.o.a(jSONObject, "adActionDescription", adBaseInfo.adActionDescription);
        com.kwad.sdk.utils.o.a(jSONObject, "adActionBarColor", adBaseInfo.adActionBarColor);
        com.kwad.sdk.utils.o.a(jSONObject, "adShowDuration", adBaseInfo.adShowDuration);
        com.kwad.sdk.utils.o.a(jSONObject, "appName", adBaseInfo.appName);
        com.kwad.sdk.utils.o.a(jSONObject, "appIconUrl", adBaseInfo.appIconUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "appPackageName", adBaseInfo.appPackageName);
        com.kwad.sdk.utils.o.a(jSONObject, "appScore", adBaseInfo.appScore);
        com.kwad.sdk.utils.o.a(jSONObject, "appDownloadCountDesc", adBaseInfo.appDownloadCountDesc);
        com.kwad.sdk.utils.o.a(jSONObject, "appCategory", adBaseInfo.appCategory);
        com.kwad.sdk.utils.o.a(jSONObject, "appVersion", adBaseInfo.appVersion);
        com.kwad.sdk.utils.o.a(jSONObject, "corporationName", adBaseInfo.corporationName);
        com.kwad.sdk.utils.o.a(jSONObject, "packageSize", adBaseInfo.packageSize);
        com.kwad.sdk.utils.o.a(jSONObject, "appImageUrl", adBaseInfo.appImageUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "appImageSize", adBaseInfo.appImageSize);
        com.kwad.sdk.utils.o.a(jSONObject, "appDescription", adBaseInfo.appDescription);
        com.kwad.sdk.utils.o.a(jSONObject, "enableSkipAd", adBaseInfo.enableSkipAd);
        com.kwad.sdk.utils.o.a(jSONObject, "skipSecond", adBaseInfo.skipSecond);
        com.kwad.sdk.utils.o.a(jSONObject, "ecpm", adBaseInfo.ecpm);
        com.kwad.sdk.utils.o.a(jSONObject, "videoPlayedNS", adBaseInfo.videoPlayedNS);
        com.kwad.sdk.utils.o.a(jSONObject, "productName", adBaseInfo.productName);
        com.kwad.sdk.utils.o.a(jSONObject, "expParam", adBaseInfo.mABParams.toJson().toString());
        com.kwad.sdk.utils.o.a(jSONObject, "showUrl", adBaseInfo.showUrl);
        com.kwad.sdk.utils.o.a(jSONObject, Constants.KEYS.EXPOSED_CLICK_URL_KEY, adBaseInfo.clickUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "convUrl", adBaseInfo.convUrl);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBaseInfo.creativeId = jSONObject.optLong("creativeId");
        adBaseInfo.adSourceType = jSONObject.optInt("adSourceType");
        adBaseInfo.adDescription = jSONObject.optString("adDescription");
        adBaseInfo.adMarkIcon = jSONObject.optString("adMarkIcon");
        adBaseInfo.adGrayMarkIcon = jSONObject.optString("adGrayMarkIcon");
        adBaseInfo.adSourceDescription = jSONObject.optString("adSourceDescription");
        adBaseInfo.adOperationType = jSONObject.optInt("adOperationType");
        adBaseInfo.adActionDescription = jSONObject.optString("adActionDescription");
        adBaseInfo.adActionBarColor = jSONObject.optString("adActionBarColor");
        adBaseInfo.adShowDuration = jSONObject.optInt("adShowDuration");
        adBaseInfo.appName = jSONObject.optString("appName");
        adBaseInfo.appIconUrl = jSONObject.optString("appIconUrl");
        adBaseInfo.appPackageName = jSONObject.optString("appPackageName");
        adBaseInfo.appScore = jSONObject.optInt("appScore");
        adBaseInfo.appDownloadCountDesc = jSONObject.optString("appDownloadCountDesc");
        adBaseInfo.appCategory = jSONObject.optString("appCategory");
        adBaseInfo.appVersion = jSONObject.optString("appVersion");
        adBaseInfo.corporationName = jSONObject.optString("corporationName");
        adBaseInfo.packageSize = jSONObject.optLong("packageSize");
        adBaseInfo.appImageUrl = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("appImageUrl");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                adBaseInfo.appImageUrl.add((String) optJSONArray.opt(i2));
            }
        }
        AdInfo.MaterialSize materialSize = new AdInfo.MaterialSize();
        adBaseInfo.appImageSize = materialSize;
        materialSize.parseJson(jSONObject.optJSONObject("appImageSize"));
        adBaseInfo.appDescription = jSONObject.optString("appDescription");
        adBaseInfo.enableSkipAd = jSONObject.optInt("enableSkipAd");
        adBaseInfo.skipSecond = jSONObject.optInt("skipSecond");
        adBaseInfo.ecpm = jSONObject.optInt("ecpm");
        adBaseInfo.videoPlayedNS = jSONObject.optString("videoPlayedNS");
        adBaseInfo.productName = jSONObject.optString("productName");
        ABParams aBParams = new ABParams();
        adBaseInfo.mABParams = aBParams;
        try {
            aBParams.parseJson(new JSONObject(jSONObject.optString("expParam")));
        } catch (Exception unused) {
        }
        adBaseInfo.showUrl = jSONObject.optString("showUrl");
        adBaseInfo.clickUrl = jSONObject.optString(Constants.KEYS.EXPOSED_CLICK_URL_KEY);
        adBaseInfo.convUrl = jSONObject.optString("convUrl");
    }
}
