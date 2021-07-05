package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d implements com.kwad.sdk.core.c<AdInfo.AdConversionInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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
    public JSONObject a(AdInfo.AdConversionInfo adConversionInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adConversionInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "h5Url", adConversionInfo.h5Url);
            com.kwad.sdk.utils.o.a(jSONObject, "h5Type", adConversionInfo.h5Type);
            com.kwad.sdk.utils.o.a(jSONObject, BaiduAppJsBridgeHandler.INPUT_PARAM_DEEP_LINK_URL, adConversionInfo.deeplinkUrl);
            com.kwad.sdk.utils.o.a(jSONObject, "appDownloadUrl", adConversionInfo.appDownloadUrl);
            com.kwad.sdk.utils.o.a(jSONObject, "marketUrl", adConversionInfo.marketUrl);
            com.kwad.sdk.utils.o.a(jSONObject, "retryH5TimeStep", adConversionInfo.retryH5TimeStep);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, adConversionInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        adConversionInfo.h5Url = jSONObject.optString("h5Url");
        adConversionInfo.h5Type = jSONObject.optInt("h5Type");
        adConversionInfo.deeplinkUrl = jSONObject.optString(BaiduAppJsBridgeHandler.INPUT_PARAM_DEEP_LINK_URL);
        adConversionInfo.appDownloadUrl = jSONObject.optString("appDownloadUrl");
        adConversionInfo.marketUrl = jSONObject.optString("marketUrl");
        adConversionInfo.retryH5TimeStep = jSONObject.optInt("retryH5TimeStep", new Integer("2000").intValue());
    }
}
