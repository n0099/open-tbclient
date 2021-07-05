package com.kwad.sdk.core.network.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements AdHttpProxy<Response> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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
    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    /* renamed from: a */
    public c parseResponse(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, response)) == null) {
            c cVar = new c();
            if (response != null) {
                try {
                    cVar.f36355a = response.code();
                    cVar.f36356b = com.kwad.sdk.core.network.a.b.a(response);
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public c doGet(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map)) == null) ? parseResponse(com.kwad.sdk.core.network.a.b.a(str, map)) : (c) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, map, map2)) == null) ? parseResponse(com.kwad.sdk.core.network.a.b.a(str, map, map2)) : (c) invokeLLL.objValue;
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, map, jSONObject)) == null) ? parseResponse(com.kwad.sdk.core.network.a.b.a(str, map, jSONObject)) : (c) invokeLLL.objValue;
    }
}
