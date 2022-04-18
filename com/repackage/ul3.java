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
import com.repackage.q94;
import java.util.Map;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes7.dex */
public class ul3 implements ra4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ul3() {
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

    @Override // com.repackage.q94
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, q94.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
            if (PMSConstants.a(s74.b())) {
                k94.b(str, map, map2, jSONObject, new lj3(aVar));
            } else {
                k94.b(str, map, map2, jSONObject, new r94(aVar));
            }
        }
    }

    @Override // com.repackage.ra4
    public da4 b(String str, int i) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) ? ba4.a(str, i) : (da4) invokeLI.objValue;
    }

    @Override // com.repackage.q94
    public void j(String str, Map<String, String> map, Map<String, String> map2, q94.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, map, map2, aVar) == null) {
            if (PMSConstants.a(s74.b())) {
                k94.a(str, map, map2, new lj3(aVar));
            } else {
                k94.a(str, map, map2, new r94(aVar));
            }
        }
    }
}
