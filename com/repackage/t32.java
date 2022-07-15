package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.o94;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class t32 extends r32 implements o94 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755341762, "Lcom/repackage/t32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755341762, "Lcom/repackage/t32;");
                return;
            }
        }
        oj2.g0().getSwitch("swan_pms_http_request_retry_use_default_net_lib", false);
        b = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t32(g03 g03Var) {
        super(g03Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g03Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((g03) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @NonNull
    public static pa4 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b ? oj2.r0() : new ra4() : (pa4) invokeV.objValue;
    }

    @Override // com.repackage.r32, com.repackage.o94
    public void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, o94.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
            K().b(str, map, map2, jSONObject, aVar);
        }
    }

    @Override // com.repackage.r32, com.repackage.o94
    public void z(String str, Map<String, String> map, Map<String, String> map2, o94.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, map2, aVar) == null) {
            String b2 = hu2.b();
            if (b2 != null) {
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("launchid", b2);
            }
            K().z(str, map, map2, aVar);
        }
    }
}
