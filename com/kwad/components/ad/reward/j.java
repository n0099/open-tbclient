package com.kwad.components.ad.reward;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public final class j extends com.kwad.sdk.core.network.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        putBody("callbackUrlInfo", com.kwad.sdk.core.response.a.a.be(com.kwad.sdk.core.response.a.d.bQ(adTemplate)));
        com.kwad.components.core.k.kwai.b bVar = new com.kwad.components.core.k.kwai.b(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        com.kwad.sdk.utils.r.putValue(jSONArray, bVar.toJson());
        putBody("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwad.sdk.b.qQ() : (String) invokeV.objValue;
    }
}
