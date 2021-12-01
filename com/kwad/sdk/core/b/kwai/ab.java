package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.request.model.g;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ab implements com.kwad.sdk.core.d<g.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ab() {
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
    public void a(g.a aVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("streamType");
        aVar.f57796b = jSONObject.optInt("maxVolume");
        aVar.f57797c = jSONObject.optInt("minVolume");
        aVar.f57798d = jSONObject.optInt("currentVolume");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(g.a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "streamType", aVar.a);
            com.kwad.sdk.utils.t.a(jSONObject, "maxVolume", aVar.f57796b);
            com.kwad.sdk.utils.t.a(jSONObject, "minVolume", aVar.f57797c);
            com.kwad.sdk.utils.t.a(jSONObject, "currentVolume", aVar.f57798d);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
