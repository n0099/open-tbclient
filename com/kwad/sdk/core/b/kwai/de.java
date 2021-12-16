package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class de implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public de() {
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
        bVar.a = jSONObject.optLong("posId");
        bVar.f58401b = jSONObject.optInt("adPhotoCountForMedia");
        bVar.f58402c = jSONObject.optBoolean("enablePreload");
        bVar.f58403d = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        bVar.f58404e = jSONObject.optInt("adLoadStrategy");
        bVar.f58405f = jSONObject.optInt("entryAutoPlay");
        bVar.f58406g = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
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
            com.kwad.sdk.utils.t.a(jSONObject, "posId", bVar.a);
            com.kwad.sdk.utils.t.a(jSONObject, "adPhotoCountForMedia", bVar.f58401b);
            com.kwad.sdk.utils.t.a(jSONObject, "enablePreload", bVar.f58402c);
            com.kwad.sdk.utils.t.a(jSONObject, "increaseAdLoadTime", bVar.f58403d);
            com.kwad.sdk.utils.t.a(jSONObject, "adLoadStrategy", bVar.f58404e);
            com.kwad.sdk.utils.t.a(jSONObject, "entryAutoPlay", bVar.f58405f);
            com.kwad.sdk.utils.t.a(jSONObject, "drawAdForcedWatchTimes", bVar.f58406g);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
