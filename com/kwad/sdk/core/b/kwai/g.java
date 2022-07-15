package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdInfo;
import com.qq.e.comm.constants.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class g implements com.kwad.sdk.core.d<AdInfo.AdBaseInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBaseInfo.creativeId = jSONObject.optLong("creativeId");
        adBaseInfo.adSourceType = jSONObject.optInt("adSourceType");
        adBaseInfo.viewCount = jSONObject.optLong("viewCount");
        adBaseInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (jSONObject.opt("sdkExtraData") == JSONObject.NULL) {
            adBaseInfo.sdkExtraData = "";
        }
        adBaseInfo.adDescription = jSONObject.optString("adDescription");
        if (jSONObject.opt("adDescription") == JSONObject.NULL) {
            adBaseInfo.adDescription = "";
        }
        adBaseInfo.installAppLabel = jSONObject.optString("installAppLabel");
        if (jSONObject.opt("installAppLabel") == JSONObject.NULL) {
            adBaseInfo.installAppLabel = "";
        }
        adBaseInfo.openAppLabel = jSONObject.optString("openAppLabel");
        if (jSONObject.opt("openAppLabel") == JSONObject.NULL) {
            adBaseInfo.openAppLabel = "";
        }
        adBaseInfo.adMarkIcon = jSONObject.optString("adMarkIcon");
        if (jSONObject.opt("adMarkIcon") == JSONObject.NULL) {
            adBaseInfo.adMarkIcon = "";
        }
        adBaseInfo.adGrayMarkIcon = jSONObject.optString("adGrayMarkIcon");
        if (jSONObject.opt("adGrayMarkIcon") == JSONObject.NULL) {
            adBaseInfo.adGrayMarkIcon = "";
        }
        adBaseInfo.adSourceDescription = jSONObject.optString("adSourceDescription");
        if (jSONObject.opt("adSourceDescription") == JSONObject.NULL) {
            adBaseInfo.adSourceDescription = "";
        }
        adBaseInfo.adOperationType = jSONObject.optInt("adOperationType");
        adBaseInfo.adActionDescription = jSONObject.optString("adActionDescription");
        if (jSONObject.opt("adActionDescription") == JSONObject.NULL) {
            adBaseInfo.adActionDescription = "";
        }
        adBaseInfo.adActionBarColor = jSONObject.optString("adActionBarColor");
        if (jSONObject.opt("adActionBarColor") == JSONObject.NULL) {
            adBaseInfo.adActionBarColor = "";
        }
        adBaseInfo.adShowDuration = jSONObject.optInt("adShowDuration");
        adBaseInfo.appName = jSONObject.optString("appName");
        if (jSONObject.opt("appName") == JSONObject.NULL) {
            adBaseInfo.appName = "";
        }
        adBaseInfo.appIconUrl = jSONObject.optString("appIconUrl");
        if (jSONObject.opt("appIconUrl") == JSONObject.NULL) {
            adBaseInfo.appIconUrl = "";
        }
        adBaseInfo.appPackageName = jSONObject.optString("appPackageName");
        if (jSONObject.opt("appPackageName") == JSONObject.NULL) {
            adBaseInfo.appPackageName = "";
        }
        adBaseInfo.appScore = jSONObject.optInt("appScore");
        adBaseInfo.appDownloadCountDesc = jSONObject.optString("appDownloadCountDesc");
        if (jSONObject.opt("appDownloadCountDesc") == JSONObject.NULL) {
            adBaseInfo.appDownloadCountDesc = "";
        }
        adBaseInfo.appCategory = jSONObject.optString("appCategory");
        if (jSONObject.opt("appCategory") == JSONObject.NULL) {
            adBaseInfo.appCategory = "";
        }
        adBaseInfo.appVersion = jSONObject.optString("appVersion");
        if (jSONObject.opt("appVersion") == JSONObject.NULL) {
            adBaseInfo.appVersion = "";
        }
        adBaseInfo.corporationName = jSONObject.optString("corporationName");
        if (jSONObject.opt("corporationName") == JSONObject.NULL) {
            adBaseInfo.corporationName = "";
        }
        adBaseInfo.packageSize = jSONObject.optLong("packageSize");
        adBaseInfo.appImageUrl = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("appImageUrl");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                adBaseInfo.appImageUrl.add((String) optJSONArray.opt(i));
            }
        }
        AdInfo.MaterialSize materialSize = new AdInfo.MaterialSize();
        adBaseInfo.appImageSize = materialSize;
        materialSize.parseJson(jSONObject.optJSONObject("appImageSize"));
        adBaseInfo.appDescription = jSONObject.optString("appDescription");
        if (jSONObject.opt("appDescription") == JSONObject.NULL) {
            adBaseInfo.appDescription = "";
        }
        adBaseInfo.enableSkipAd = jSONObject.optInt("enableSkipAd");
        adBaseInfo.adCacheSwitch = jSONObject.optInt("adCacheSwitch", new Integer("0").intValue());
        adBaseInfo.adCacheSecond = jSONObject.optLong("adCacheSecond", new Long("1800").longValue());
        adBaseInfo.adCacheStrategy = jSONObject.optInt("adCacheStrategy", new Integer("1").intValue());
        adBaseInfo.adCacheSize = jSONObject.optInt("adCacheSize", new Integer("1").intValue());
        adBaseInfo.skipSecond = jSONObject.optInt("skipSecond");
        adBaseInfo.ecpm = jSONObject.optInt("ecpm");
        adBaseInfo.videoPlayedNS = jSONObject.optString("videoPlayedNS");
        if (jSONObject.opt("videoPlayedNS") == JSONObject.NULL) {
            adBaseInfo.videoPlayedNS = "";
        }
        adBaseInfo.productName = jSONObject.optString("productName");
        if (jSONObject.opt("productName") == JSONObject.NULL) {
            adBaseInfo.productName = "";
        }
        ABParams aBParams = new ABParams();
        adBaseInfo.mABParams = aBParams;
        try {
            aBParams.parseJson(new JSONObject(jSONObject.optString("expParam")));
        } catch (Exception unused) {
        }
        adBaseInfo.showUrl = jSONObject.optString("showUrl");
        if (jSONObject.opt("showUrl") == JSONObject.NULL) {
            adBaseInfo.showUrl = "";
        }
        adBaseInfo.clickUrl = jSONObject.optString(Constants.KEYS.EXPOSED_CLICK_URL_KEY);
        if (jSONObject.opt(Constants.KEYS.EXPOSED_CLICK_URL_KEY) == JSONObject.NULL) {
            adBaseInfo.clickUrl = "";
        }
        adBaseInfo.convUrl = jSONObject.optString("convUrl");
        if (jSONObject.opt("convUrl") == JSONObject.NULL) {
            adBaseInfo.convUrl = "";
        }
        adBaseInfo.adAttributeType = jSONObject.optInt("adAttributeType");
        AdInfo.H5Config h5Config = new AdInfo.H5Config();
        adBaseInfo.apiExpParam = h5Config;
        h5Config.parseJson(jSONObject.optJSONObject("apiExpParam"));
        adBaseInfo.taskType = jSONObject.optInt(StatConstants.KEY_EXT_TASK_TYPE);
        adBaseInfo.campaignType = jSONObject.optInt("campaignType");
        adBaseInfo.itemType = jSONObject.optInt("itemType");
        adBaseInfo.industryFirstLevelId = jSONObject.optInt("industryFirstLevelId");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "creativeId", adBaseInfo.creativeId);
        com.kwad.sdk.utils.r.a(jSONObject, "adSourceType", adBaseInfo.adSourceType);
        com.kwad.sdk.utils.r.a(jSONObject, "viewCount", adBaseInfo.viewCount);
        com.kwad.sdk.utils.r.a(jSONObject, "sdkExtraData", adBaseInfo.sdkExtraData);
        com.kwad.sdk.utils.r.a(jSONObject, "adDescription", adBaseInfo.adDescription);
        com.kwad.sdk.utils.r.a(jSONObject, "installAppLabel", adBaseInfo.installAppLabel);
        com.kwad.sdk.utils.r.a(jSONObject, "openAppLabel", adBaseInfo.openAppLabel);
        com.kwad.sdk.utils.r.a(jSONObject, "adMarkIcon", adBaseInfo.adMarkIcon);
        com.kwad.sdk.utils.r.a(jSONObject, "adGrayMarkIcon", adBaseInfo.adGrayMarkIcon);
        com.kwad.sdk.utils.r.a(jSONObject, "adSourceDescription", adBaseInfo.adSourceDescription);
        com.kwad.sdk.utils.r.a(jSONObject, "adOperationType", adBaseInfo.adOperationType);
        com.kwad.sdk.utils.r.a(jSONObject, "adActionDescription", adBaseInfo.adActionDescription);
        com.kwad.sdk.utils.r.a(jSONObject, "adActionBarColor", adBaseInfo.adActionBarColor);
        com.kwad.sdk.utils.r.a(jSONObject, "adShowDuration", adBaseInfo.adShowDuration);
        com.kwad.sdk.utils.r.a(jSONObject, "appName", adBaseInfo.appName);
        com.kwad.sdk.utils.r.a(jSONObject, "appIconUrl", adBaseInfo.appIconUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "appPackageName", adBaseInfo.appPackageName);
        com.kwad.sdk.utils.r.a(jSONObject, "appScore", adBaseInfo.appScore);
        com.kwad.sdk.utils.r.a(jSONObject, "appDownloadCountDesc", adBaseInfo.appDownloadCountDesc);
        com.kwad.sdk.utils.r.a(jSONObject, "appCategory", adBaseInfo.appCategory);
        com.kwad.sdk.utils.r.a(jSONObject, "appVersion", adBaseInfo.appVersion);
        com.kwad.sdk.utils.r.a(jSONObject, "corporationName", adBaseInfo.corporationName);
        com.kwad.sdk.utils.r.a(jSONObject, "packageSize", adBaseInfo.packageSize);
        com.kwad.sdk.utils.r.a(jSONObject, "appImageUrl", adBaseInfo.appImageUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "appImageSize", adBaseInfo.appImageSize);
        com.kwad.sdk.utils.r.a(jSONObject, "appDescription", adBaseInfo.appDescription);
        com.kwad.sdk.utils.r.a(jSONObject, "enableSkipAd", adBaseInfo.enableSkipAd);
        com.kwad.sdk.utils.r.a(jSONObject, "adCacheSwitch", adBaseInfo.adCacheSwitch);
        com.kwad.sdk.utils.r.a(jSONObject, "adCacheSecond", adBaseInfo.adCacheSecond);
        com.kwad.sdk.utils.r.a(jSONObject, "adCacheStrategy", adBaseInfo.adCacheStrategy);
        com.kwad.sdk.utils.r.a(jSONObject, "adCacheSize", adBaseInfo.adCacheSize);
        com.kwad.sdk.utils.r.a(jSONObject, "skipSecond", adBaseInfo.skipSecond);
        com.kwad.sdk.utils.r.a(jSONObject, "ecpm", adBaseInfo.ecpm);
        com.kwad.sdk.utils.r.a(jSONObject, "videoPlayedNS", adBaseInfo.videoPlayedNS);
        com.kwad.sdk.utils.r.a(jSONObject, "productName", adBaseInfo.productName);
        com.kwad.sdk.utils.r.a(jSONObject, "expParam", adBaseInfo.mABParams.toJson().toString());
        com.kwad.sdk.utils.r.a(jSONObject, "showUrl", adBaseInfo.showUrl);
        com.kwad.sdk.utils.r.a(jSONObject, Constants.KEYS.EXPOSED_CLICK_URL_KEY, adBaseInfo.clickUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "convUrl", adBaseInfo.convUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "adAttributeType", adBaseInfo.adAttributeType);
        com.kwad.sdk.utils.r.a(jSONObject, "apiExpParam", adBaseInfo.apiExpParam);
        com.kwad.sdk.utils.r.a(jSONObject, StatConstants.KEY_EXT_TASK_TYPE, adBaseInfo.taskType);
        com.kwad.sdk.utils.r.a(jSONObject, "campaignType", adBaseInfo.campaignType);
        com.kwad.sdk.utils.r.a(jSONObject, "itemType", adBaseInfo.itemType);
        com.kwad.sdk.utils.r.a(jSONObject, "industryFirstLevelId", adBaseInfo.industryFirstLevelId);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        a2(adBaseInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        return b2(adBaseInfo, jSONObject);
    }
}
