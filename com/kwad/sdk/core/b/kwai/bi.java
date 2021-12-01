package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bi implements com.kwad.sdk.core.d<a.C2025a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bi() {
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
    public void a(a.C2025a c2025a, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, c2025a, jSONObject) == null) || jSONObject == null) {
            return;
        }
        c2025a.a = jSONObject.optInt("code");
        c2025a.f57652b = jSONObject.optString("msg");
        if (jSONObject.opt("msg") == JSONObject.NULL) {
            c2025a.f57652b = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(a.C2025a c2025a, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, c2025a, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "code", c2025a.a);
            com.kwad.sdk.utils.t.a(jSONObject, "msg", c2025a.f57652b);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
