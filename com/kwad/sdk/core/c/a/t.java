package com.kwad.sdk.core.c.a;

import com.kwad.sdk.home.download.HomeApkBannerData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class t implements com.kwad.sdk.core.c<HomeApkBannerData> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(HomeApkBannerData homeApkBannerData) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "appPackageName", homeApkBannerData.appPackageName);
        com.kwad.sdk.utils.o.a(jSONObject, "mAdTemplateUniqueId", homeApkBannerData.mAdTemplateUniqueId);
        com.kwad.sdk.utils.o.a(jSONObject, "mDownloadFilePath", homeApkBannerData.mDownloadFilePath);
        com.kwad.sdk.utils.o.a(jSONObject, "mTimeStamp", homeApkBannerData.mTimeStamp);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(HomeApkBannerData homeApkBannerData, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        homeApkBannerData.appPackageName = jSONObject.optString("appPackageName");
        homeApkBannerData.mAdTemplateUniqueId = jSONObject.optString("mAdTemplateUniqueId");
        homeApkBannerData.mDownloadFilePath = jSONObject.optString("mDownloadFilePath");
        homeApkBannerData.mTimeStamp = jSONObject.optLong("mTimeStamp");
    }
}
