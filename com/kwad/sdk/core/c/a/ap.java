package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ap implements com.kwad.sdk.core.d<a.C1910a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ap() {
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
    public void a(a.C1910a c1910a, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, c1910a, jSONObject) == null) || jSONObject == null) {
            return;
        }
        c1910a.f64978a = jSONObject.optInt("code");
        c1910a.f64979b = jSONObject.optString("msg");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(a.C1910a c1910a, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, c1910a, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "code", c1910a.f64978a);
            com.kwad.sdk.utils.q.a(jSONObject, "msg", c1910a.f64979b);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
