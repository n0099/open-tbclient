package com.kwad.sdk.ec.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.d.a;
import com.kwad.sdk.core.network.BaseRealData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class EcKwaiInfo extends BaseRealData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_PULLNEW = "https://promotion-partner.kuaishou.com/rest/n/promotion/p?adid=7348&imei=__IMEI2__&idfa=__IDFA2__&oaid=__OAID__&ip=__IP__&mac=__MAC2__&androidId=__ANDROIDID2__&callback=__CALLBACK__&siteSet=XXX";
    public transient /* synthetic */ FieldHolder $fh;
    public String appDescription;
    public String appDownloadUrlAdr;
    public String appIconUrl;
    public String appName;
    public String appPackageName;
    public String pullNewUrl;

    public EcKwaiInfo() {
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

    public static EcKwaiInfo fromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            EcKwaiInfo ecKwaiInfo = new EcKwaiInfo();
            ecKwaiInfo.parseData(jSONObject);
            return ecKwaiInfo;
        }
        return (EcKwaiInfo) invokeL.objValue;
    }

    @NonNull
    public static String getPullNewUrl(EcKwaiInfo ecKwaiInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ecKwaiInfo)) == null) ? ecKwaiInfo == null ? DEFAULT_PULLNEW : ecKwaiInfo.getPullNewUrl() : (String) invokeL.objValue;
    }

    public AdTemplate generateAdTemplate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = this.appDownloadUrlAdr;
            AdTemplate adTemplate = new AdTemplate();
            AdInfo adInfo = new AdInfo();
            AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
            adConversionInfo.deeplinkUrl = str;
            adConversionInfo.appDownloadUrl = str2;
            adConversionInfo.marketUrl = "";
            adConversionInfo.h5Url = "";
            adInfo.downloadId = aa.a(str2);
            adInfo.adBaseInfo.appName = getAppName();
            AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
            adBaseInfo.appPackageName = this.appPackageName;
            adBaseInfo.appIconUrl = this.appIconUrl;
            adBaseInfo.adDescription = this.appDescription;
            adTemplate.adInfoList.add(adInfo);
            adTemplate.llsid = this.llsid;
            adTemplate.mUniqueId = adInfo.downloadId;
            return adTemplate;
        }
        return (AdTemplate) invokeL.objValue;
    }

    public String getAppDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.appDescription : (String) invokeV.objValue;
    }

    public String getAppDownloadUrlAdr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.appDownloadUrlAdr : (String) invokeV.objValue;
    }

    public String getAppIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.appIconUrl : (String) invokeV.objValue;
    }

    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.appName : (String) invokeV.objValue;
    }

    public String getAppPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.appPackageName : (String) invokeV.objValue;
    }

    public String getPullNewUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? TextUtils.isEmpty(this.pullNewUrl) ? DEFAULT_PULLNEW : this.pullNewUrl : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.BaseRealData
    public void parseData(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            this.appDownloadUrlAdr = jSONObject.optString("appDownloadUrlAdr", "");
            this.appIconUrl = jSONObject.optString("appIconUrl", "");
            this.appDescription = jSONObject.optString("appDescription", "");
            this.appName = jSONObject.optString("appName", "");
            this.appPackageName = jSONObject.optString("appPackageName", "");
            this.pullNewUrl = jSONObject.optString("pullNewUrl", DEFAULT_PULLNEW);
        }
    }

    public void setAppDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.appDescription = str;
        }
    }

    public void setAppDownloadUrlAdr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.appDownloadUrlAdr = str;
        }
    }

    public void setAppIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.appIconUrl = str;
        }
    }

    public void setAppName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.appName = str;
        }
    }

    public void setAppPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.appPackageName = str;
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            JSONObject json = super.toJson();
            try {
                json.put("appDownloadUrlAdr", this.appDownloadUrlAdr);
                json.put("appIconUrl", this.appIconUrl);
                json.put("appDescription", this.appDescription);
                json.put("appName", this.appName);
                json.put("appPackageName", this.appPackageName);
                json.put("pullNewUrl", this.pullNewUrl);
            } catch (JSONException e2) {
                a.a(e2);
            }
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return "{\"appDownloadUrlAdr\":\"" + this.appDownloadUrlAdr + "\",\"appIconUrl\":\"" + this.appIconUrl + "\",\"appDescription\":\"" + this.appDescription + "\",\"appName\":\"" + this.appName + "\",\"pullNewUrl\":\"" + this.pullNewUrl + "\",\"appPackageName\":\"" + this.appPackageName + "\"}";
        }
        return (String) invokeV.objValue;
    }
}
