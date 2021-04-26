package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f implements com.kwad.sdk.core.c<AdInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdInfo adInfo, JSONObject jSONObject) {
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
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                AdInfo.AdTrackInfo adTrackInfo = new AdInfo.AdTrackInfo();
                adTrackInfo.parseJson(optJSONArray.optJSONObject(i2));
                adInfo.adTrackInfoList.add(adTrackInfo);
            }
        }
        AdInfo.DownloadSafeInfo downloadSafeInfo = new AdInfo.DownloadSafeInfo();
        adInfo.downloadSafeInfo = downloadSafeInfo;
        downloadSafeInfo.parseJson(jSONObject.optJSONObject("downloadSafeInfo"));
        adInfo.status = jSONObject.optInt("status");
        adInfo.progress = jSONObject.optInt("progress");
        adInfo.soFarBytes = jSONObject.optLong("soFarBytes");
        adInfo.totalBytes = jSONObject.optLong("totalBytes");
        adInfo.downloadFilePath = jSONObject.optString("downloadFilePath");
        adInfo.downloadId = jSONObject.optString("downloadId");
        AdInfo.AdPreloadInfo adPreloadInfo = new AdInfo.AdPreloadInfo();
        adInfo.adPreloadInfo = adPreloadInfo;
        adPreloadInfo.parseJson(jSONObject.optJSONObject("adPreloadInfo"));
        AdInfo.AdSplashInfo adSplashInfo = new AdInfo.AdSplashInfo();
        adInfo.adSplashInfo = adSplashInfo;
        adSplashInfo.parseJson(jSONObject.optJSONObject("adSplashInfo"));
        AdStyleInfo adStyleInfo = new AdStyleInfo();
        adInfo.adStyleInfo = adStyleInfo;
        adStyleInfo.parseJson(jSONObject.optJSONObject("adStyleInfo"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(AdInfo adInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "adBaseInfo", adInfo.adBaseInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "advertiserInfo", adInfo.advertiserInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "adConversionInfo", adInfo.adConversionInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "adMaterialInfo", adInfo.adMaterialInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "adTrackInfo", adInfo.adTrackInfoList);
        com.kwad.sdk.utils.o.a(jSONObject, "downloadSafeInfo", adInfo.downloadSafeInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "status", adInfo.status);
        com.kwad.sdk.utils.o.a(jSONObject, "progress", adInfo.progress);
        com.kwad.sdk.utils.o.a(jSONObject, "soFarBytes", adInfo.soFarBytes);
        com.kwad.sdk.utils.o.a(jSONObject, "totalBytes", adInfo.totalBytes);
        com.kwad.sdk.utils.o.a(jSONObject, "downloadFilePath", adInfo.downloadFilePath);
        com.kwad.sdk.utils.o.a(jSONObject, "downloadId", adInfo.downloadId);
        com.kwad.sdk.utils.o.a(jSONObject, "adPreloadInfo", adInfo.adPreloadInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "adSplashInfo", adInfo.adSplashInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "adStyleInfo", adInfo.adStyleInfo);
        return jSONObject;
    }
}
