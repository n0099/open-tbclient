package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i implements com.kwad.sdk.core.d<AdInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i() {
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
    public void a(AdInfo adInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adInfo, jSONObject) == null) || jSONObject == null) {
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
        AdStyleInfo adStyleInfo2 = new AdStyleInfo();
        adInfo.adStyleInfo2 = adStyleInfo2;
        adStyleInfo2.parseJson(jSONObject.optJSONObject("adStyleInfo2"));
        AdInfo.AdAggregateInfo adAggregateInfo = new AdInfo.AdAggregateInfo();
        adInfo.adAggregateInfo = adAggregateInfo;
        adAggregateInfo.parseJson(jSONObject.optJSONObject("adAggregateInfo"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdInfo adInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, adInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "adBaseInfo", adInfo.adBaseInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "advertiserInfo", adInfo.advertiserInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "adConversionInfo", adInfo.adConversionInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "adMaterialInfo", adInfo.adMaterialInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "adTrackInfo", adInfo.adTrackInfoList);
            com.kwad.sdk.utils.q.a(jSONObject, "downloadSafeInfo", adInfo.downloadSafeInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "status", adInfo.status);
            com.kwad.sdk.utils.q.a(jSONObject, "progress", adInfo.progress);
            com.kwad.sdk.utils.q.a(jSONObject, "soFarBytes", adInfo.soFarBytes);
            com.kwad.sdk.utils.q.a(jSONObject, "totalBytes", adInfo.totalBytes);
            com.kwad.sdk.utils.q.a(jSONObject, "downloadFilePath", adInfo.downloadFilePath);
            com.kwad.sdk.utils.q.a(jSONObject, "downloadId", adInfo.downloadId);
            com.kwad.sdk.utils.q.a(jSONObject, "adPreloadInfo", adInfo.adPreloadInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "adSplashInfo", adInfo.adSplashInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "adStyleInfo", adInfo.adStyleInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "adStyleInfo2", adInfo.adStyleInfo2);
            com.kwad.sdk.utils.q.a(jSONObject, "adAggregateInfo", adInfo.adAggregateInfo);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
