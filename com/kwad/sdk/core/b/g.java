package com.kwad.sdk.core.b;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.m;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g() {
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

    @Override // com.kwad.sdk.core.b.i
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                return new String(c.a().a(h.a(str.getBytes(), m.a(1))), "UTF-8");
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.b.i
    public void a(String str, Map<String, String> map, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, jSONObject) == null) {
        }
    }

    @Override // com.kwad.sdk.core.b.i
    public void a(@NonNull Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
        }
    }

    @Override // com.kwad.sdk.core.b.i
    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                return h.b(c.b().a(str.getBytes()), m.a(2));
            } catch (Exception unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }
}
