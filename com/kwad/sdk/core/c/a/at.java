package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.home.download.HomeApkBannerData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class at implements com.kwad.sdk.core.d<HomeApkBannerData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public at() {
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
    @Override // com.kwad.sdk.core.d
    public void a(HomeApkBannerData homeApkBannerData, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, homeApkBannerData, jSONObject) == null) || jSONObject == null) {
            return;
        }
        homeApkBannerData.appPackageName = jSONObject.optString("appPackageName");
        homeApkBannerData.mAdTemplateUniqueId = jSONObject.optString("mAdTemplateUniqueId");
        homeApkBannerData.mDownloadFilePath = jSONObject.optString("mDownloadFilePath");
        homeApkBannerData.mTimeStamp = jSONObject.optLong("mTimeStamp");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(HomeApkBannerData homeApkBannerData, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, homeApkBannerData, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "appPackageName", homeApkBannerData.appPackageName);
            com.kwad.sdk.utils.q.a(jSONObject, "mAdTemplateUniqueId", homeApkBannerData.mAdTemplateUniqueId);
            com.kwad.sdk.utils.q.a(jSONObject, "mDownloadFilePath", homeApkBannerData.mDownloadFilePath);
            com.kwad.sdk.utils.q.a(jSONObject, "mTimeStamp", homeApkBannerData.mTimeStamp);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
