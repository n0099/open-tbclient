package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.home.download.HomeApkBannerData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class t implements com.kwad.sdk.core.c<HomeApkBannerData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(HomeApkBannerData homeApkBannerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, homeApkBannerData)) == null) {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "appPackageName", homeApkBannerData.appPackageName);
            com.kwad.sdk.utils.o.a(jSONObject, "mAdTemplateUniqueId", homeApkBannerData.mAdTemplateUniqueId);
            com.kwad.sdk.utils.o.a(jSONObject, "mDownloadFilePath", homeApkBannerData.mDownloadFilePath);
            com.kwad.sdk.utils.o.a(jSONObject, "mTimeStamp", homeApkBannerData.mTimeStamp);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(HomeApkBannerData homeApkBannerData, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, homeApkBannerData, jSONObject) == null) || jSONObject == null) {
            return;
        }
        homeApkBannerData.appPackageName = jSONObject.optString("appPackageName");
        homeApkBannerData.mAdTemplateUniqueId = jSONObject.optString("mAdTemplateUniqueId");
        homeApkBannerData.mDownloadFilePath = jSONObject.optString("mDownloadFilePath");
        homeApkBannerData.mTimeStamp = jSONObject.optLong("mTimeStamp");
    }
}
