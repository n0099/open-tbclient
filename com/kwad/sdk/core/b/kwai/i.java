package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.deeplink.DeepLinkItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i implements com.kwad.sdk.core.d<AdInfo.AdConversionInfo> {
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
    public void a(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adConversionInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        adConversionInfo.h5Url = jSONObject.optString("h5Url");
        if (jSONObject.opt("h5Url") == JSONObject.NULL) {
            adConversionInfo.h5Url = "";
        }
        adConversionInfo.h5Type = jSONObject.optInt("h5Type");
        adConversionInfo.deeplinkUrl = jSONObject.optString("deeplinkUrl");
        if (jSONObject.opt("deeplinkUrl") == JSONObject.NULL) {
            adConversionInfo.deeplinkUrl = "";
        }
        adConversionInfo.appDownloadUrl = jSONObject.optString("appDownloadUrl");
        if (jSONObject.opt("appDownloadUrl") == JSONObject.NULL) {
            adConversionInfo.appDownloadUrl = "";
        }
        adConversionInfo.marketUrl = jSONObject.optString(DeepLinkItem.DEEPLINK_MARKETURL_KEY);
        if (jSONObject.opt(DeepLinkItem.DEEPLINK_MARKETURL_KEY) == JSONObject.NULL) {
            adConversionInfo.marketUrl = "";
        }
        adConversionInfo.supportThirdDownload = jSONObject.optInt("supportThirdDownload");
        adConversionInfo.retryH5TimeStep = jSONObject.optInt("retryH5TimeStep", new Integer("2000").intValue());
        adConversionInfo.playableUrl = jSONObject.optString("playableUrl");
        if (jSONObject.opt("playableUrl") == JSONObject.NULL) {
            adConversionInfo.playableUrl = "";
        }
        AdInfo.PlayableStyleInfo playableStyleInfo = new AdInfo.PlayableStyleInfo();
        adConversionInfo.playableStyleInfo = playableStyleInfo;
        playableStyleInfo.parseJson(jSONObject.optJSONObject("playableStyleInfo"));
        adConversionInfo.callbackUrl = jSONObject.optString("callbackUrl");
        if (jSONObject.opt("callbackUrl") == JSONObject.NULL) {
            adConversionInfo.callbackUrl = "";
        }
        adConversionInfo.callbackUrlInfo = jSONObject.optString("callbackUrlInfo");
        if (jSONObject.opt("callbackUrlInfo") == JSONObject.NULL) {
            adConversionInfo.callbackUrlInfo = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, adConversionInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "h5Url", adConversionInfo.h5Url);
            com.kwad.sdk.utils.t.a(jSONObject, "h5Type", adConversionInfo.h5Type);
            com.kwad.sdk.utils.t.a(jSONObject, "deeplinkUrl", adConversionInfo.deeplinkUrl);
            com.kwad.sdk.utils.t.a(jSONObject, "appDownloadUrl", adConversionInfo.appDownloadUrl);
            com.kwad.sdk.utils.t.a(jSONObject, DeepLinkItem.DEEPLINK_MARKETURL_KEY, adConversionInfo.marketUrl);
            com.kwad.sdk.utils.t.a(jSONObject, "supportThirdDownload", adConversionInfo.supportThirdDownload);
            com.kwad.sdk.utils.t.a(jSONObject, "retryH5TimeStep", adConversionInfo.retryH5TimeStep);
            com.kwad.sdk.utils.t.a(jSONObject, "playableUrl", adConversionInfo.playableUrl);
            com.kwad.sdk.utils.t.a(jSONObject, "playableStyleInfo", adConversionInfo.playableStyleInfo);
            com.kwad.sdk.utils.t.a(jSONObject, "callbackUrl", adConversionInfo.callbackUrl);
            com.kwad.sdk.utils.t.a(jSONObject, "callbackUrlInfo", adConversionInfo.callbackUrlInfo);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
