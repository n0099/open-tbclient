package com.kwad.sdk.home.download;

import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class HomeApkBannerData extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static final long serialVersionUID = -3305476346070314287L;
    public String appPackageName;
    public String mAdTemplateUniqueId;
    public String mDownloadFilePath;
    public long mTimeStamp;

    public static HomeApkBannerData convertAdTemplateToHomeApkBannerData(AdTemplate adTemplate) {
        if (adTemplate == null || !c.a(adTemplate)) {
            return null;
        }
        HomeApkBannerData homeApkBannerData = new HomeApkBannerData();
        homeApkBannerData.mTimeStamp = System.currentTimeMillis();
        homeApkBannerData.mAdTemplateUniqueId = adTemplate.mUniqueId;
        homeApkBannerData.mDownloadFilePath = c.g(adTemplate).downloadFilePath;
        homeApkBannerData.appPackageName = com.kwad.sdk.core.response.b.a.q(c.g(adTemplate));
        return homeApkBannerData;
    }
}
