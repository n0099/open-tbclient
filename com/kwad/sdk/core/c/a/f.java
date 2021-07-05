package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f implements com.kwad.sdk.core.c<AdInfo.AdPreloadInfo> {
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
    @Override // com.kwad.sdk.core.c
    public JSONObject a(AdInfo.AdPreloadInfo adPreloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adPreloadInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "preloadId", adPreloadInfo.preloadId);
            com.kwad.sdk.utils.o.a(jSONObject, "preloadType", adPreloadInfo.preloadType);
            com.kwad.sdk.utils.o.a(jSONObject, "preloadTips", adPreloadInfo.preloadTips);
            com.kwad.sdk.utils.o.a(jSONObject, "validityPeriod", adPreloadInfo.validityPeriod);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, adPreloadInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        adPreloadInfo.preloadId = jSONObject.optString("preloadId");
        adPreloadInfo.preloadType = jSONObject.optInt("preloadType");
        adPreloadInfo.preloadTips = jSONObject.optString("preloadTips", new String("已提前加载"));
        adPreloadInfo.validityPeriod = jSONObject.optInt("validityPeriod", new Integer("604800").intValue());
    }
}
