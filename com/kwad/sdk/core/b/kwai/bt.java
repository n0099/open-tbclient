package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.home.download.HomeApkBannerData;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bt implements com.kwad.sdk.core.d<HomeApkBannerData> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(HomeApkBannerData homeApkBannerData, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        homeApkBannerData.appPackageName = jSONObject.optString("appPackageName");
        if (jSONObject.opt("appPackageName") == JSONObject.NULL) {
            homeApkBannerData.appPackageName = "";
        }
        homeApkBannerData.mAdTemplateUniqueId = jSONObject.optString("mAdTemplateUniqueId");
        if (jSONObject.opt("mAdTemplateUniqueId") == JSONObject.NULL) {
            homeApkBannerData.mAdTemplateUniqueId = "";
        }
        homeApkBannerData.mDownloadFilePath = jSONObject.optString("mDownloadFilePath");
        if (jSONObject.opt("mDownloadFilePath") == JSONObject.NULL) {
            homeApkBannerData.mDownloadFilePath = "";
        }
        homeApkBannerData.mTimeStamp = jSONObject.optLong("mTimeStamp");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(HomeApkBannerData homeApkBannerData, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "appPackageName", homeApkBannerData.appPackageName);
        com.kwad.sdk.utils.t.a(jSONObject, "mAdTemplateUniqueId", homeApkBannerData.mAdTemplateUniqueId);
        com.kwad.sdk.utils.t.a(jSONObject, "mDownloadFilePath", homeApkBannerData.mDownloadFilePath);
        com.kwad.sdk.utils.t.a(jSONObject, "mTimeStamp", homeApkBannerData.mTimeStamp);
        return jSONObject;
    }
}
