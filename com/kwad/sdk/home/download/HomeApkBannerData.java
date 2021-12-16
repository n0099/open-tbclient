package com.kwad.sdk.home.download;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class HomeApkBannerData extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3305476346070314287L;
    public transient /* synthetic */ FieldHolder $fh;
    public String appPackageName;
    public String mAdTemplateUniqueId;
    public String mDownloadFilePath;
    public long mTimeStamp;

    public HomeApkBannerData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static HomeApkBannerData convertAdTemplateToHomeApkBannerData(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
            if (adTemplate == null || !d.c(adTemplate)) {
                return null;
            }
            HomeApkBannerData homeApkBannerData = new HomeApkBannerData();
            homeApkBannerData.mTimeStamp = System.currentTimeMillis();
            homeApkBannerData.mAdTemplateUniqueId = adTemplate.mUniqueId;
            homeApkBannerData.mDownloadFilePath = d.j(adTemplate).downloadFilePath;
            homeApkBannerData.appPackageName = com.kwad.sdk.core.response.a.a.v(d.j(adTemplate));
            return homeApkBannerData;
        }
        return (HomeApkBannerData) invokeL.objValue;
    }
}
