package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes10.dex */
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
        dVar.f71624a = jSONObject.optInt("isRoot");
        dVar.f71625b = jSONObject.optInt("isXPosed");
        dVar.f71626c = jSONObject.optInt("isFrameworkHooked");
        dVar.f71627d = jSONObject.optInt("isVirtual");
        dVar.f71628e = jSONObject.optInt("isAdbEnabled");
        dVar.f71629f = jSONObject.optInt("isEmulator");
        dVar.f71630g = jSONObject.optInt("isGroupControl");
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
            com.kwad.sdk.utils.q.a(jSONObject, "isRoot", dVar.f71624a);
            com.kwad.sdk.utils.q.a(jSONObject, "isXPosed", dVar.f71625b);
            com.kwad.sdk.utils.q.a(jSONObject, "isFrameworkHooked", dVar.f71626c);
            com.kwad.sdk.utils.q.a(jSONObject, "isVirtual", dVar.f71627d);
            com.kwad.sdk.utils.q.a(jSONObject, "isAdbEnabled", dVar.f71628e);
            com.kwad.sdk.utils.q.a(jSONObject, "isEmulator", dVar.f71629f);
            com.kwad.sdk.utils.q.a(jSONObject, "isGroupControl", dVar.f71630g);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
