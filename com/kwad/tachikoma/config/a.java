package com.kwad.tachikoma.config;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.f;
/* loaded from: classes5.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b("tkVersion", str);
        b("jsVersion", str2);
        b(CommandMessage.SDK_VERSION, "3.3.17.4");
        b("sdkApiVersion", KsAdSDKImpl.get().getApiVersion());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            DevelopMangerPlugin.DevelopValue a = ((DevelopMangerPlugin) f.a(DevelopMangerPlugin.class)).a("KEY_HOST_ENCRYPT_DISABLE");
            return (a == null || !((Boolean) a.getValue()).booleanValue()) ? com.kwad.sdk.d.k() : com.kwad.sdk.d.j();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.d
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
