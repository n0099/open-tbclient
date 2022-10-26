package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdInfo;
import com.qq.e.comm.constants.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class g implements com.kwad.sdk.core.d {
    public static void a(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
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
        adBaseInfo.extraClickReward = jSONObject.optBoolean("extraClickReward");
    }

    public static JSONObject b(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = adBaseInfo.creativeId;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "creativeId", j);
        }
        int i = adBaseInfo.adSourceType;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adSourceType", i);
        }
        long j2 = adBaseInfo.viewCount;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "viewCount", j2);
        }
        String str = adBaseInfo.sdkExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "sdkExtraData", adBaseInfo.sdkExtraData);
        }
        String str2 = adBaseInfo.adDescription;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adDescription", adBaseInfo.adDescription);
        }
        String str3 = adBaseInfo.installAppLabel;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "installAppLabel", adBaseInfo.installAppLabel);
        }
        String str4 = adBaseInfo.openAppLabel;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "openAppLabel", adBaseInfo.openAppLabel);
        }
        String str5 = adBaseInfo.adMarkIcon;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adMarkIcon", adBaseInfo.adMarkIcon);
        }
        String str6 = adBaseInfo.adGrayMarkIcon;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adGrayMarkIcon", adBaseInfo.adGrayMarkIcon);
        }
        String str7 = adBaseInfo.adSourceDescription;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adSourceDescription", adBaseInfo.adSourceDescription);
        }
        int i2 = adBaseInfo.adOperationType;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adOperationType", i2);
        }
        String str8 = adBaseInfo.adActionDescription;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adActionDescription", adBaseInfo.adActionDescription);
        }
        String str9 = adBaseInfo.adActionBarColor;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adActionBarColor", adBaseInfo.adActionBarColor);
        }
        int i3 = adBaseInfo.adShowDuration;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adShowDuration", i3);
        }
        String str10 = adBaseInfo.appName;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appName", adBaseInfo.appName);
        }
        String str11 = adBaseInfo.appIconUrl;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appIconUrl", adBaseInfo.appIconUrl);
        }
        String str12 = adBaseInfo.appPackageName;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appPackageName", adBaseInfo.appPackageName);
        }
        int i4 = adBaseInfo.appScore;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appScore", i4);
        }
        String str13 = adBaseInfo.appDownloadCountDesc;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appDownloadCountDesc", adBaseInfo.appDownloadCountDesc);
        }
        String str14 = adBaseInfo.appCategory;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appCategory", adBaseInfo.appCategory);
        }
        String str15 = adBaseInfo.appVersion;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appVersion", adBaseInfo.appVersion);
        }
        String str16 = adBaseInfo.corporationName;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "corporationName", adBaseInfo.corporationName);
        }
        long j3 = adBaseInfo.packageSize;
        if (j3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "packageSize", j3);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "appImageUrl", adBaseInfo.appImageUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "appImageSize", adBaseInfo.appImageSize);
        String str17 = adBaseInfo.appDescription;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appDescription", adBaseInfo.appDescription);
        }
        int i5 = adBaseInfo.enableSkipAd;
        if (i5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "enableSkipAd", i5);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "adCacheSwitch", adBaseInfo.adCacheSwitch);
        com.kwad.sdk.utils.r.putValue(jSONObject, "adCacheSecond", adBaseInfo.adCacheSecond);
        com.kwad.sdk.utils.r.putValue(jSONObject, "adCacheStrategy", adBaseInfo.adCacheStrategy);
        com.kwad.sdk.utils.r.putValue(jSONObject, "adCacheSize", adBaseInfo.adCacheSize);
        int i6 = adBaseInfo.skipSecond;
        if (i6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "skipSecond", i6);
        }
        int i7 = adBaseInfo.ecpm;
        if (i7 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "ecpm", i7);
        }
        String str18 = adBaseInfo.videoPlayedNS;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "videoPlayedNS", adBaseInfo.videoPlayedNS);
        }
        String str19 = adBaseInfo.productName;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "productName", adBaseInfo.productName);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "expParam", adBaseInfo.mABParams.toJson().toString());
        String str20 = adBaseInfo.showUrl;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "showUrl", adBaseInfo.showUrl);
        }
        String str21 = adBaseInfo.clickUrl;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, Constants.KEYS.EXPOSED_CLICK_URL_KEY, adBaseInfo.clickUrl);
        }
        String str22 = adBaseInfo.convUrl;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "convUrl", adBaseInfo.convUrl);
        }
        int i8 = adBaseInfo.adAttributeType;
        if (i8 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adAttributeType", i8);
        }
        com.kwad.sdk.utils.r.a(jSONObject, "apiExpParam", adBaseInfo.apiExpParam);
        int i9 = adBaseInfo.taskType;
        if (i9 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, StatConstants.KEY_EXT_TASK_TYPE, i9);
        }
        int i10 = adBaseInfo.campaignType;
        if (i10 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "campaignType", i10);
        }
        int i11 = adBaseInfo.itemType;
        if (i11 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "itemType", i11);
        }
        int i12 = adBaseInfo.industryFirstLevelId;
        if (i12 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "industryFirstLevelId", i12);
        }
        boolean z = adBaseInfo.extraClickReward;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "extraClickReward", z);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdBaseInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdBaseInfo) bVar, jSONObject);
    }
}
