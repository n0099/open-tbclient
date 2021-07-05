package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.emotion.model.CDNUrl;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j implements com.kwad.sdk.core.c<CDNUrl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j() {
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
    public JSONObject a(CDNUrl cDNUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cDNUrl)) == null) {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "cdn", cDNUrl.cdn);
            com.kwad.sdk.utils.o.a(jSONObject, "url", cDNUrl.url);
            com.kwad.sdk.utils.o.a(jSONObject, "ip", cDNUrl.ip);
            com.kwad.sdk.utils.o.a(jSONObject, "urlPattern", cDNUrl.urlPattern);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(CDNUrl cDNUrl, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, cDNUrl, jSONObject) == null) || jSONObject == null) {
            return;
        }
        cDNUrl.cdn = jSONObject.optString("cdn");
        cDNUrl.url = jSONObject.optString("url");
        cDNUrl.ip = jSONObject.optString("ip");
        cDNUrl.urlPattern = jSONObject.optString("urlPattern");
    }
}
