package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdInfo;
import com.qq.e.comm.constants.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f implements com.kwad.sdk.core.d<AdInfo.AdBaseInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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
    public void a(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        adBaseInfo.creativeId = jSONObject.optLong("creativeId");
        adBaseInfo.adSourceType = jSONObject.optInt("adSourceType");
        adBaseInfo.viewCount = jSONObject.optLong("viewCount");
        adBaseInfo.industryFirstLevelId = jSONObject.optInt("industryFirstLevelId");
        adBaseInfo.adDescription = jSONObject.optString("adDescription");
        adBaseInfo.installAppLabel = jSONObject.optString("installAppLabel");
        adBaseInfo.openAppLabel = jSONObject.optString("openAppLabel");
        adBaseInfo.adMarkIcon = jSONObject.optString("adMarkIcon");
        adBaseInfo.adGrayMarkIcon = jSONObject.optString("adGrayMarkIcon");
        adBaseInfo.adSourceDescription = jSONObject.optString("adSourceDescription");
        adBaseInfo.adOperationType = jSONObject.optInt("adOperationType");
        adBaseInfo.adActionDescription = jSONObject.optString("adActionDescription");
        adBaseInfo.adActionBarColor = jSONObject.optString("adActionBarColor");
        adBaseInfo.adShowDuration = jSONObject.optInt("adShowDuration");
        adBaseInfo.appName = jSONObject.optString("appName");
        adBaseInfo.appIconUrl = jSONObject.optString("appIconUrl");
        adBaseInfo.appPackageName = jSONObject.optString("appPackageName");
        adBaseInfo.appScore = jSONObject.optInt("appScore");
        adBaseInfo.appDownloadCountDesc = jSONObject.optString("appDownloadCountDesc");
        adBaseInfo.appCategory = jSONObject.optString("appCategory");
        adBaseInfo.appVersion = jSONObject.optString("appVersion");
        adBaseInfo.corporationName = jSONObject.optString("corporationName");
        adBaseInfo.packageSize = jSONObject.optLong("packageSize");
        adBaseInfo.appImageUrl = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("appImageUrl");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                adBaseInfo.appImageUrl.add((String) optJSONArray.opt(i2));
            }
        }
        AdInfo.MaterialSize materialSize = new AdInfo.MaterialSize();
        adBaseInfo.appImageSize = materialSize;
        materialSize.parseJson(jSONObject.optJSONObject("appImageSize"));
        adBaseInfo.appDescription = jSONObject.optString("appDescription");
        adBaseInfo.enableSkipAd = jSONObject.optInt("enableSkipAd");
        adBaseInfo.skipSecond = jSONObject.optInt("skipSecond");
        adBaseInfo.ecpm = jSONObject.optInt("ecpm");
        adBaseInfo.videoPlayedNS = jSONObject.optString("videoPlayedNS");
        adBaseInfo.productName = jSONObject.optString("productName");
        ABParams aBParams = new ABParams();
        adBaseInfo.mABParams = aBParams;
        try {
            aBParams.parseJson(new JSONObject(jSONObject.optString("expParam")));
        } catch (Exception unused) {
        }
        adBaseInfo.showUrl = jSONObject.optString("showUrl");
        adBaseInfo.clickUrl = jSONObject.optString(Constants.KEYS.EXPOSED_CLICK_URL_KEY);
        adBaseInfo.convUrl = jSONObject.optString("convUrl");
        adBaseInfo.adAttributeType = jSONObject.optInt("adAttributeType");
        AdInfo.H5Config h5Config = new AdInfo.H5Config();
        adBaseInfo.apiExpParam = h5Config;
        h5Config.parseJson(jSONObject.optJSONObject("apiExpParam"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, adBaseInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "creativeId", adBaseInfo.creativeId);
            com.kwad.sdk.utils.q.a(jSONObject, "adSourceType", adBaseInfo.adSourceType);
            com.kwad.sdk.utils.q.a(jSONObject, "viewCount", adBaseInfo.viewCount);
            com.kwad.sdk.utils.q.a(jSONObject, "industryFirstLevelId", adBaseInfo.industryFirstLevelId);
            com.kwad.sdk.utils.q.a(jSONObject, "adDescription", adBaseInfo.adDescription);
            com.kwad.sdk.utils.q.a(jSONObject, "installAppLabel", adBaseInfo.installAppLabel);
            com.kwad.sdk.utils.q.a(jSONObject, "openAppLabel", adBaseInfo.openAppLabel);
            com.kwad.sdk.utils.q.a(jSONObject, "adMarkIcon", adBaseInfo.adMarkIcon);
            com.kwad.sdk.utils.q.a(jSONObject, "adGrayMarkIcon", adBaseInfo.adGrayMarkIcon);
            com.kwad.sdk.utils.q.a(jSONObject, "adSourceDescription", adBaseInfo.adSourceDescription);
            com.kwad.sdk.utils.q.a(jSONObject, "adOperationType", adBaseInfo.adOperationType);
            com.kwad.sdk.utils.q.a(jSONObject, "adActionDescription", adBaseInfo.adActionDescription);
            com.kwad.sdk.utils.q.a(jSONObject, "adActionBarColor", adBaseInfo.adActionBarColor);
            com.kwad.sdk.utils.q.a(jSONObject, "adShowDuration", adBaseInfo.adShowDuration);
            com.kwad.sdk.utils.q.a(jSONObject, "appName", adBaseInfo.appName);
            com.kwad.sdk.utils.q.a(jSONObject, "appIconUrl", adBaseInfo.appIconUrl);
            com.kwad.sdk.utils.q.a(jSONObject, "appPackageName", adBaseInfo.appPackageName);
            com.kwad.sdk.utils.q.a(jSONObject, "appScore", adBaseInfo.appScore);
            com.kwad.sdk.utils.q.a(jSONObject, "appDownloadCountDesc", adBaseInfo.appDownloadCountDesc);
            com.kwad.sdk.utils.q.a(jSONObject, "appCategory", adBaseInfo.appCategory);
            com.kwad.sdk.utils.q.a(jSONObject, "appVersion", adBaseInfo.appVersion);
            com.kwad.sdk.utils.q.a(jSONObject, "corporationName", adBaseInfo.corporationName);
            com.kwad.sdk.utils.q.a(jSONObject, "packageSize", adBaseInfo.packageSize);
            com.kwad.sdk.utils.q.a(jSONObject, "appImageUrl", adBaseInfo.appImageUrl);
            com.kwad.sdk.utils.q.a(jSONObject, "appImageSize", adBaseInfo.appImageSize);
            com.kwad.sdk.utils.q.a(jSONObject, "appDescription", adBaseInfo.appDescription);
            com.kwad.sdk.utils.q.a(jSONObject, "enableSkipAd", adBaseInfo.enableSkipAd);
            com.kwad.sdk.utils.q.a(jSONObject, "skipSecond", adBaseInfo.skipSecond);
            com.kwad.sdk.utils.q.a(jSONObject, "ecpm", adBaseInfo.ecpm);
            com.kwad.sdk.utils.q.a(jSONObject, "videoPlayedNS", adBaseInfo.videoPlayedNS);
            com.kwad.sdk.utils.q.a(jSONObject, "productName", adBaseInfo.productName);
            com.kwad.sdk.utils.q.a(jSONObject, "expParam", adBaseInfo.mABParams.toJson().toString());
            com.kwad.sdk.utils.q.a(jSONObject, "showUrl", adBaseInfo.showUrl);
            com.kwad.sdk.utils.q.a(jSONObject, Constants.KEYS.EXPOSED_CLICK_URL_KEY, adBaseInfo.clickUrl);
            com.kwad.sdk.utils.q.a(jSONObject, "convUrl", adBaseInfo.convUrl);
            com.kwad.sdk.utils.q.a(jSONObject, "adAttributeType", adBaseInfo.adAttributeType);
            com.kwad.sdk.utils.q.a(jSONObject, "apiExpParam", adBaseInfo.apiExpParam);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
