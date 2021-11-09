package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ao implements com.kwad.sdk.core.d<com.kwad.sdk.collector.a.d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ao() {
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
    public void a(com.kwad.sdk.collector.a.d dVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, dVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        dVar.f64134a = jSONObject.optInt("isRoot");
        dVar.f64135b = jSONObject.optInt("isXPosed");
        dVar.f64136c = jSONObject.optInt("isFrameworkHooked");
        dVar.f64137d = jSONObject.optInt("isVirtual");
        dVar.f64138e = jSONObject.optInt("isAdbEnabled");
        dVar.f64139f = jSONObject.optInt("isEmulator");
        dVar.f64140g = jSONObject.optInt("isGroupControl");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.collector.a.d dVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "isRoot", dVar.f64134a);
            com.kwad.sdk.utils.q.a(jSONObject, "isXPosed", dVar.f64135b);
            com.kwad.sdk.utils.q.a(jSONObject, "isFrameworkHooked", dVar.f64136c);
            com.kwad.sdk.utils.q.a(jSONObject, "isVirtual", dVar.f64137d);
            com.kwad.sdk.utils.q.a(jSONObject, "isAdbEnabled", dVar.f64138e);
            com.kwad.sdk.utils.q.a(jSONObject, "isEmulator", dVar.f64139f);
            com.kwad.sdk.utils.q.a(jSONObject, "isGroupControl", dVar.f64140g);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
