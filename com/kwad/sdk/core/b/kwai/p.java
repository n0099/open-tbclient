package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class p implements com.kwad.sdk.core.d<AdInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo adInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdInfo.AdBaseInfo adBaseInfo = new AdInfo.AdBaseInfo();
        adInfo.adBaseInfo = adBaseInfo;
        adBaseInfo.parseJson(jSONObject.optJSONObject("adBaseInfo"));
        AdInfo.AdvertiserInfo advertiserInfo = new AdInfo.AdvertiserInfo();
        adInfo.advertiserInfo = advertiserInfo;
        advertiserInfo.parseJson(jSONObject.optJSONObject("advertiserInfo"));
        AdInfo.AdConversionInfo adConversionInfo = new AdInfo.AdConversionInfo();
        adInfo.adConversionInfo = adConversionInfo;
        adConversionInfo.parseJson(jSONObject.optJSONObject("adConversionInfo"));
        AdInfo.AdMaterialInfo adMaterialInfo = new AdInfo.AdMaterialInfo();
        adInfo.adMaterialInfo = adMaterialInfo;
        adMaterialInfo.parseJson(jSONObject.optJSONObject("adMaterialInfo"));
        adInfo.adTrackInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("adTrackInfo");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                AdInfo.AdTrackInfo adTrackInfo = new AdInfo.AdTrackInfo();
                adTrackInfo.parseJson(optJSONArray.optJSONObject(i));
                adInfo.adTrackInfoList.add(adTrackInfo);
            }
        }
        AdInfo.DownloadSafeInfo downloadSafeInfo = new AdInfo.DownloadSafeInfo();
        adInfo.downloadSafeInfo = downloadSafeInfo;
        downloadSafeInfo.parseJson(jSONObject.optJSONObject("downloadSafeInfo"));
        AdInfo.UnDownloadConf unDownloadConf = new AdInfo.UnDownloadConf();
        adInfo.unDownloadConf = unDownloadConf;
        unDownloadConf.parseJson(jSONObject.optJSONObject("unDownloadConf"));
        adInfo.status = jSONObject.optInt("status");
        adInfo.progress = jSONObject.optInt("progress");
        adInfo.soFarBytes = jSONObject.optLong("soFarBytes");
        adInfo.totalBytes = jSONObject.optLong("totalBytes");
        adInfo.downloadFilePath = jSONObject.optString("downloadFilePath");
        if (jSONObject.opt("downloadFilePath") == JSONObject.NULL) {
            adInfo.downloadFilePath = "";
        }
        adInfo.downloadId = jSONObject.optString("downloadId");
        if (jSONObject.opt("downloadId") == JSONObject.NULL) {
            adInfo.downloadId = "";
        }
        AdInfo.AdPreloadInfo adPreloadInfo = new AdInfo.AdPreloadInfo();
        adInfo.adPreloadInfo = adPreloadInfo;
        adPreloadInfo.parseJson(jSONObject.optJSONObject("adPreloadInfo"));
        AdInfo.AdSplashInfo adSplashInfo = new AdInfo.AdSplashInfo();
        adInfo.adSplashInfo = adSplashInfo;
        adSplashInfo.parseJson(jSONObject.optJSONObject("adSplashInfo"));
        AdStyleInfo adStyleInfo = new AdStyleInfo();
        adInfo.adStyleInfo = adStyleInfo;
        adStyleInfo.parseJson(jSONObject.optJSONObject("adStyleInfo"));
        AdStyleInfo adStyleInfo2 = new AdStyleInfo();
        adInfo.adStyleInfo2 = adStyleInfo2;
        adStyleInfo2.parseJson(jSONObject.optJSONObject("adStyleInfo2"));
        AdInfo.AdAggregateInfo adAggregateInfo = new AdInfo.AdAggregateInfo();
        adInfo.adAggregateInfo = adAggregateInfo;
        adAggregateInfo.parseJson(jSONObject.optJSONObject("adAggregateInfo"));
        AdInfo.AdRewardInfo adRewardInfo = new AdInfo.AdRewardInfo();
        adInfo.adRewardInfo = adRewardInfo;
        adRewardInfo.parseJson(jSONObject.optJSONObject("adRewardInfo"));
        AdInfo.AdStyleConfInfo adStyleConfInfo = new AdInfo.AdStyleConfInfo();
        adInfo.adStyleConfInfo = adStyleConfInfo;
        adStyleConfInfo.parseJson(jSONObject.optJSONObject("adStyleConfInfo"));
        AdInfo.FullScreenVideoInfo fullScreenVideoInfo = new AdInfo.FullScreenVideoInfo();
        adInfo.fullScreenVideoInfo = fullScreenVideoInfo;
        fullScreenVideoInfo.parseJson(jSONObject.optJSONObject("fullScreenVideoInfo"));
        AdInfo.AdFeedInfo adFeedInfo = new AdInfo.AdFeedInfo();
        adInfo.adFeedInfo = adFeedInfo;
        adFeedInfo.parseJson(jSONObject.optJSONObject("adFeedInfo"));
        AdInfo.AdInsertScreenInfo adInsertScreenInfo = new AdInfo.AdInsertScreenInfo();
        adInfo.adInsertScreenInfo = adInsertScreenInfo;
        adInsertScreenInfo.parseJson(jSONObject.optJSONObject("adInsertScreenInfo"));
        AdProductInfo adProductInfo = new AdProductInfo();
        adInfo.adProductInfo = adProductInfo;
        adProductInfo.parseJson(jSONObject.optJSONObject("adProductInfo"));
        adInfo.ocpcActionType = jSONObject.optInt("ocpcActionType");
        AdMatrixInfo adMatrixInfo = new AdMatrixInfo();
        adInfo.adMatrixInfo = adMatrixInfo;
        adMatrixInfo.parseJson(jSONObject.optJSONObject("adMatrixInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo adInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "adBaseInfo", adInfo.adBaseInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "advertiserInfo", adInfo.advertiserInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "adConversionInfo", adInfo.adConversionInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "adMaterialInfo", adInfo.adMaterialInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "adTrackInfo", adInfo.adTrackInfoList);
        com.kwad.sdk.utils.r.a(jSONObject, "downloadSafeInfo", adInfo.downloadSafeInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "unDownloadConf", adInfo.unDownloadConf);
        com.kwad.sdk.utils.r.a(jSONObject, "status", adInfo.status);
        com.kwad.sdk.utils.r.a(jSONObject, "progress", adInfo.progress);
        com.kwad.sdk.utils.r.a(jSONObject, "soFarBytes", adInfo.soFarBytes);
        com.kwad.sdk.utils.r.a(jSONObject, "totalBytes", adInfo.totalBytes);
        com.kwad.sdk.utils.r.a(jSONObject, "downloadFilePath", adInfo.downloadFilePath);
        com.kwad.sdk.utils.r.a(jSONObject, "downloadId", adInfo.downloadId);
        com.kwad.sdk.utils.r.a(jSONObject, "adPreloadInfo", adInfo.adPreloadInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "adSplashInfo", adInfo.adSplashInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "adStyleInfo", adInfo.adStyleInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "adStyleInfo2", adInfo.adStyleInfo2);
        com.kwad.sdk.utils.r.a(jSONObject, "adAggregateInfo", adInfo.adAggregateInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "adRewardInfo", adInfo.adRewardInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "adStyleConfInfo", adInfo.adStyleConfInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "fullScreenVideoInfo", adInfo.fullScreenVideoInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "adFeedInfo", adInfo.adFeedInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "adInsertScreenInfo", adInfo.adInsertScreenInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "adProductInfo", adInfo.adProductInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "ocpcActionType", adInfo.ocpcActionType);
        com.kwad.sdk.utils.r.a(jSONObject, "adMatrixInfo", adInfo.adMatrixInfo);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo adInfo, JSONObject jSONObject) {
        a2(adInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo adInfo, JSONObject jSONObject) {
        return b2(adInfo, jSONObject);
    }
}
