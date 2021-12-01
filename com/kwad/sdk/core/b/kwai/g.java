package com.kwad.sdk.core.b.kwai;

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
public class g implements com.kwad.sdk.core.d<AdInfo.AdBaseInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g() {
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
        adBaseInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (jSONObject.opt("sdkExtraData") == JSONObject.NULL) {
            adBaseInfo.sdkExtraData = "";
        }
        adBaseInfo.adDescription = jSONObject.optString("adDescription");
        if (jSONObject.opt("adDescription") == JSONObject.NULL) {
            adBaseInfo.adDescription = "";
        }
        adBaseInfo.installAppLabel = jSONObject.optString("installAppLabel");
        if (jSONObject.opt("installAppLabel") == JSONObject.NULL) {
            adBaseInfo.installAppLabel = "";
        }
        adBaseInfo.openAppLabel = jSONObject.optString("openAppLabel");
        if (jSONObject.opt("openAppLabel") == JSONObject.NULL) {
            adBaseInfo.openAppLabel = "";
        }
        adBaseInfo.adMarkIcon = jSONObject.optString("adMarkIcon");
        if (jSONObject.opt("adMarkIcon") == JSONObject.NULL) {
            adBaseInfo.adMarkIcon = "";
        }
        adBaseInfo.adGrayMarkIcon = jSONObject.optString("adGrayMarkIcon");
        if (jSONObject.opt("adGrayMarkIcon") == JSONObject.NULL) {
            adBaseInfo.adGrayMarkIcon = "";
        }
        adBaseInfo.adSourceDescription = jSONObject.optString("adSourceDescription");
        if (jSONObject.opt("adSourceDescription") == JSONObject.NULL) {
            adBaseInfo.adSourceDescription = "";
        }
        adBaseInfo.adOperationType = jSONObject.optInt("adOperationType");
        adBaseInfo.adActionDescription = jSONObject.optString("adActionDescription");
        if (jSONObject.opt("adActionDescription") == JSONObject.NULL) {
            adBaseInfo.adActionDescription = "";
        }
        adBaseInfo.adActionBarColor = jSONObject.optString("adActionBarColor");
        if (jSONObject.opt("adActionBarColor") == JSONObject.NULL) {
            adBaseInfo.adActionBarColor = "";
        }
        adBaseInfo.adShowDuration = jSONObject.optInt("adShowDuration");
        adBaseInfo.appName = jSONObject.optString("appName");
        if (jSONObject.opt("appName") == JSONObject.NULL) {
            adBaseInfo.appName = "";
        }
        adBaseInfo.appIconUrl = jSONObject.optString("appIconUrl");
        if (jSONObject.opt("appIconUrl") == JSONObject.NULL) {
            adBaseInfo.appIconUrl = "";
        }
        adBaseInfo.appPackageName = jSONObject.optString("appPackageName");
        if (jSONObject.opt("appPackageName") == JSONObject.NULL) {
            adBaseInfo.appPackageName = "";
        }
        adBaseInfo.appScore = jSONObject.optInt("appScore");
        adBaseInfo.appDownloadCountDesc = jSONObject.optString("appDownloadCountDesc");
        if (jSONObject.opt("appDownloadCountDesc") == JSONObject.NULL) {
            adBaseInfo.appDownloadCountDesc = "";
        }
        adBaseInfo.appCategory = jSONObject.optString("appCategory");
        if (jSONObject.opt("appCategory") == JSONObject.NULL) {
            adBaseInfo.appCategory = "";
        }
        adBaseInfo.appVersion = jSONObject.optString("appVersion");
        if (jSONObject.opt("appVersion") == JSONObject.NULL) {
            adBaseInfo.appVersion = "";
        }
        adBaseInfo.corporationName = jSONObject.optString("corporationName");
        if (jSONObject.opt("corporationName") == JSONObject.NULL) {
            adBaseInfo.corporationName = "";
        }
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
        if (jSONObject.opt("appDescription") == JSONObject.NULL) {
            adBaseInfo.appDescription = "";
        }
        adBaseInfo.enableSkipAd = jSONObject.optInt("enableSkipAd");
        adBaseInfo.adCacheSwitch = jSONObject.optInt("adCacheSwitch");
        adBaseInfo.adCacheSecond = jSONObject.optLong("adCacheSecond", new Long("1800").longValue());
        adBaseInfo.skipSecond = jSONObject.optInt("skipSecond");
        adBaseInfo.ecpm = jSONObject.optInt("ecpm");
        adBaseInfo.videoPlayedNS = jSONObject.optString("videoPlayedNS");
        if (jSONObject.opt("videoPlayedNS") == JSONObject.NULL) {
            adBaseInfo.videoPlayedNS = "";
        }
        adBaseInfo.productName = jSONObject.optString("productName");
        if (jSONObject.opt("productName") == JSONObject.NULL) {
            adBaseInfo.productName = "";
        }
        ABParams aBParams = new ABParams();
        adBaseInfo.mABParams = aBParams;
        try {
            aBParams.parseJson(new JSONObject(jSONObject.optString("expParam")));
        } catch (Exception unused) {
        }
        adBaseInfo.showUrl = jSONObject.optString("showUrl");
        if (jSONObject.opt("showUrl") == JSONObject.NULL) {
            adBaseInfo.showUrl = "";
        }
        adBaseInfo.clickUrl = jSONObject.optString(Constants.KEYS.EXPOSED_CLICK_URL_KEY);
        if (jSONObject.opt(Constants.KEYS.EXPOSED_CLICK_URL_KEY) == JSONObject.NULL) {
            adBaseInfo.clickUrl = "";
        }
        adBaseInfo.convUrl = jSONObject.optString("convUrl");
        if (jSONObject.opt("convUrl") == JSONObject.NULL) {
            adBaseInfo.convUrl = "";
        }
        adBaseInfo.adAttributeType = jSONObject.optInt("adAttributeType");
        AdInfo.H5Config h5Config = new AdInfo.H5Config();
        adBaseInfo.apiExpParam = h5Config;
        h5Config.parseJson(jSONObject.optJSONObject("apiExpParam"));
        adBaseInfo.taskType = jSONObject.optInt("taskType");
        adBaseInfo.campaignType = jSONObject.optInt("campaignType");
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
            com.kwad.sdk.utils.t.a(jSONObject, "creativeId", adBaseInfo.creativeId);
            com.kwad.sdk.utils.t.a(jSONObject, "adSourceType", adBaseInfo.adSourceType);
            com.kwad.sdk.utils.t.a(jSONObject, "viewCount", adBaseInfo.viewCount);
            com.kwad.sdk.utils.t.a(jSONObject, "sdkExtraData", adBaseInfo.sdkExtraData);
            com.kwad.sdk.utils.t.a(jSONObject, "adDescription", adBaseInfo.adDescription);
            com.kwad.sdk.utils.t.a(jSONObject, "installAppLabel", adBaseInfo.installAppLabel);
            com.kwad.sdk.utils.t.a(jSONObject, "openAppLabel", adBaseInfo.openAppLabel);
            com.kwad.sdk.utils.t.a(jSONObject, "adMarkIcon", adBaseInfo.adMarkIcon);
            com.kwad.sdk.utils.t.a(jSONObject, "adGrayMarkIcon", adBaseInfo.adGrayMarkIcon);
            com.kwad.sdk.utils.t.a(jSONObject, "adSourceDescription", adBaseInfo.adSourceDescription);
            com.kwad.sdk.utils.t.a(jSONObject, "adOperationType", adBaseInfo.adOperationType);
            com.kwad.sdk.utils.t.a(jSONObject, "adActionDescription", adBaseInfo.adActionDescription);
            com.kwad.sdk.utils.t.a(jSONObject, "adActionBarColor", adBaseInfo.adActionBarColor);
            com.kwad.sdk.utils.t.a(jSONObject, "adShowDuration", adBaseInfo.adShowDuration);
            com.kwad.sdk.utils.t.a(jSONObject, "appName", adBaseInfo.appName);
            com.kwad.sdk.utils.t.a(jSONObject, "appIconUrl", adBaseInfo.appIconUrl);
            com.kwad.sdk.utils.t.a(jSONObject, "appPackageName", adBaseInfo.appPackageName);
            com.kwad.sdk.utils.t.a(jSONObject, "appScore", adBaseInfo.appScore);
            com.kwad.sdk.utils.t.a(jSONObject, "appDownloadCountDesc", adBaseInfo.appDownloadCountDesc);
            com.kwad.sdk.utils.t.a(jSONObject, "appCategory", adBaseInfo.appCategory);
            com.kwad.sdk.utils.t.a(jSONObject, "appVersion", adBaseInfo.appVersion);
            com.kwad.sdk.utils.t.a(jSONObject, "corporationName", adBaseInfo.corporationName);
            com.kwad.sdk.utils.t.a(jSONObject, "packageSize", adBaseInfo.packageSize);
            com.kwad.sdk.utils.t.a(jSONObject, "appImageUrl", adBaseInfo.appImageUrl);
            com.kwad.sdk.utils.t.a(jSONObject, "appImageSize", adBaseInfo.appImageSize);
            com.kwad.sdk.utils.t.a(jSONObject, "appDescription", adBaseInfo.appDescription);
            com.kwad.sdk.utils.t.a(jSONObject, "enableSkipAd", adBaseInfo.enableSkipAd);
            com.kwad.sdk.utils.t.a(jSONObject, "adCacheSwitch", adBaseInfo.adCacheSwitch);
            com.kwad.sdk.utils.t.a(jSONObject, "adCacheSecond", adBaseInfo.adCacheSecond);
            com.kwad.sdk.utils.t.a(jSONObject, "skipSecond", adBaseInfo.skipSecond);
            com.kwad.sdk.utils.t.a(jSONObject, "ecpm", adBaseInfo.ecpm);
            com.kwad.sdk.utils.t.a(jSONObject, "videoPlayedNS", adBaseInfo.videoPlayedNS);
            com.kwad.sdk.utils.t.a(jSONObject, "productName", adBaseInfo.productName);
            com.kwad.sdk.utils.t.a(jSONObject, "expParam", adBaseInfo.mABParams.toJson().toString());
            com.kwad.sdk.utils.t.a(jSONObject, "showUrl", adBaseInfo.showUrl);
            com.kwad.sdk.utils.t.a(jSONObject, Constants.KEYS.EXPOSED_CLICK_URL_KEY, adBaseInfo.clickUrl);
            com.kwad.sdk.utils.t.a(jSONObject, "convUrl", adBaseInfo.convUrl);
            com.kwad.sdk.utils.t.a(jSONObject, "adAttributeType", adBaseInfo.adAttributeType);
            com.kwad.sdk.utils.t.a(jSONObject, "apiExpParam", adBaseInfo.apiExpParam);
            com.kwad.sdk.utils.t.a(jSONObject, "taskType", adBaseInfo.taskType);
            com.kwad.sdk.utils.t.a(jSONObject, "campaignType", adBaseInfo.campaignType);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
