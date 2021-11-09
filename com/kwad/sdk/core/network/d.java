package com.kwad.sdk.core.network;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.g.a.m;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class d extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d() {
        this(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, com.kwad.sdk.core.g.a.d.a(i(), i2));
    }

    @Override // com.kwad.sdk.core.network.b
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String a2 = a();
            if (!com.kwad.sdk.b.f63999b.booleanValue() || a2 == null || a2.contains(com.kwad.sdk.d.c())) {
                return;
            }
            DevelopMangerPlugin.DevelopValue a3 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_AD_UNIVERSE");
            if (a3 == null) {
                a("trace-context", "{\"laneId\":\"ad_test.universe\"}");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("laneId", a3.getValue().toString());
                a("trace-context", jSONObject.toString());
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b("protocolVersion", "2.0");
            b("SDKVersion", "3.3.11.4");
            a("SDKVersionCode", 3031104);
            b("sdkApiVersion", KsAdSDKImpl.get().getApiVersion());
            a("sdkApiVersionCode", KsAdSDKImpl.get().getApiVersionCode());
            a("sdkType", com.kwad.sdk.d.f65520a);
            a(DI.APP_INFO_NAME, com.kwad.sdk.core.g.a.b.a());
            a("networkInfo", com.kwad.sdk.core.g.a.i.a());
            a("geoInfo", com.kwad.sdk.core.g.a.e.a());
            a("ext", com.kwad.sdk.core.g.a.j.a());
            a("userInfo", m.a());
            a("statusInfo", h());
            com.kwad.sdk.core.g.a.g a2 = com.kwad.sdk.core.g.a.g.a();
            if (a2 != null) {
                a("localConfig", a2);
            }
        }
    }

    public com.kwad.sdk.core.g.a.k h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new com.kwad.sdk.core.g.a.k() : (com.kwad.sdk.core.g.a.k) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
