package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class bv implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bv() {
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
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.response.model.b bVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        bVar.f35104a = jSONObject.optLong("posId");
        bVar.f35105b = jSONObject.optInt("adPhotoCountForMedia");
        bVar.f35106c = jSONObject.optBoolean("enablePreload");
        bVar.f35107d = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        bVar.f35108e = jSONObject.optInt("adLoadStrategy");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.response.model.b bVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "posId", bVar.f35104a);
            com.kwad.sdk.utils.q.a(jSONObject, "adPhotoCountForMedia", bVar.f35105b);
            com.kwad.sdk.utils.q.a(jSONObject, "enablePreload", bVar.f35106c);
            com.kwad.sdk.utils.q.a(jSONObject, "increaseAdLoadTime", bVar.f35107d);
            com.kwad.sdk.utils.q.a(jSONObject, "adLoadStrategy", bVar.f35108e);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
