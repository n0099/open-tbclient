package com.kwad.components.ad.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.d;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public final class b extends com.kwad.sdk.core.network.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b(String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        putBody("adxId", str);
        putBody("materialIds", new JSONArray((Collection) list));
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            putBody("protocolVersion", "2.0");
            putBody("SDKVersion", BuildConfig.VERSION_NAME);
            putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
            putBody("sdkApiVersion", ((d) ServiceProvider.a(d.class)).e());
            putBody("sdkApiVersionCode", ((d) ServiceProvider.a(d.class)).f());
            putBody("sdkType", 1);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.b.e() : (String) invokeV.objValue;
    }
}
