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
import com.repackage.ga4;
import java.util.Map;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes6.dex */
public class km3 implements hb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public km3() {
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

    @Override // com.repackage.ga4
    public void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, ga4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
            if (PMSConstants.a(i84.b())) {
                aa4.b(str, map, map2, jSONObject, new bk3(aVar));
            } else {
                aa4.b(str, map, map2, jSONObject, new ha4(aVar));
            }
        }
    }

    @Override // com.repackage.hb4
    public ta4 c(String str, int i) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) ? ra4.a(str, i) : (ta4) invokeLI.objValue;
    }

    @Override // com.repackage.ga4
    public void z(String str, Map<String, String> map, Map<String, String> map2, ga4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, map, map2, aVar) == null) {
            if (PMSConstants.a(i84.b())) {
                aa4.a(str, map, map2, new bk3(aVar));
            } else {
                aa4.a(str, map, map2, new ha4(aVar));
            }
        }
    }
}
