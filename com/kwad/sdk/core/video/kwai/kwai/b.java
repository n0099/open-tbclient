package com.kwad.sdk.core.video.kwai.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.request.model.e;
import com.kwad.sdk.core.request.model.h;
import com.kwad.sdk.d;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends com.kwad.sdk.core.network.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b(List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a("actionList", list);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.g() : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.b
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b("protocolVersion", "2.0");
            b("SDKVersion", "3.3.17.4");
            a("SDKVersionCode", 3031704);
            b("sdkApiVersion", KsAdSDKImpl.get().getApiVersion());
            a("sdkApiVersionCode", KsAdSDKImpl.get().getApiVersionCode());
            a("sdkType", 1);
            a(DI.APP_INFO_NAME, com.kwad.sdk.core.request.model.b.a());
            a(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, com.kwad.sdk.core.request.model.d.a(false));
            a("networkInfo", h.a());
            a("geoInfo", e.a());
        }
    }
}
