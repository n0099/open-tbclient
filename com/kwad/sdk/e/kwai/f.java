package com.kwad.sdk.e.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.network.TKErrorInner;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f implements com.kwad.sdk.e.e<TKErrorInner> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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
    @Override // com.kwad.sdk.e.e
    public void a(TKErrorInner tKErrorInner, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tKErrorInner, jSONObject) == null) || jSONObject == null) {
            return;
        }
        tKErrorInner.name = jSONObject.optString("name");
        tKErrorInner.code = jSONObject.optInt("code");
        tKErrorInner.msg = jSONObject.optString("msg");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public JSONObject b(TKErrorInner tKErrorInner, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, tKErrorInner, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.e.f.a(jSONObject, "name", tKErrorInner.name);
            com.kwad.sdk.e.f.a(jSONObject, "code", tKErrorInner.code);
            com.kwad.sdk.e.f.a(jSONObject, "msg", tKErrorInner.msg);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
