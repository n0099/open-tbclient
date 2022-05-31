package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.o84;
import java.util.Map;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes7.dex */
public class sk3 implements p94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sk3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.o84
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, o84.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
            if (PMSConstants.a(q64.b())) {
                i84.b(str, map, map2, jSONObject, new ji3(aVar));
            } else {
                i84.b(str, map, map2, jSONObject, new p84(aVar));
            }
        }
    }

    @Override // com.repackage.p94
    public b94 b(String str, int i) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) ? z84.a(str, i) : (b94) invokeLI.objValue;
    }

    @Override // com.repackage.o84
    public void j(String str, Map<String, String> map, Map<String, String> map2, o84.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, map, map2, aVar) == null) {
            if (PMSConstants.a(q64.b())) {
                i84.a(str, map, map2, new ji3(aVar));
            } else {
                i84.a(str, map, map2, new p84(aVar));
            }
        }
    }
}
