package com.kwad.components.core.j;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.r;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class d extends com.kwad.sdk.core.network.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        JSONArray jSONArray = new JSONArray();
        r.a(jSONArray, new JSONObject());
        putBody("impInfo", jSONArray);
        putBody("appTag", as.e());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwad.sdk.b.g() : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.d
    public final boolean isAddAppPackageNameParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
