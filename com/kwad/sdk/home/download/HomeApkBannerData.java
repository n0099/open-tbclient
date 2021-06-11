package com.kwad.sdk.home.download;

import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class HomeApkBannerData extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static final long serialVersionUID = -3305476346070314287L;
    public String appPackageName;
    public String mAdTemplateUniqueId;
    public String mDownloadFilePath;
    public long mTimeStamp;

    public static HomeApkBannerData convertAdTemplateToHomeApkBannerData(AdTemplate adTemplate) {
        if (adTemplate == null || !c.c(adTemplate)) {
            return null;
        }
        HomeApkBannerData homeApkBannerData = new HomeApkBannerData();
        homeApkBannerData.mTimeStamp = System.currentTimeMillis();
        homeApkBannerData.mAdTemplateUniqueId = adTemplate.mUniqueId;
        homeApkBannerData.mDownloadFilePath = c.j(adTemplate).downloadFilePath;
        homeApkBannerData.appPackageName = com.kwad.sdk.core.response.b.a.s(c.j(adTemplate));
        return homeApkBannerData;
    }
}
