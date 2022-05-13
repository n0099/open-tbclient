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
import com.repackage.ba4;
import java.util.Map;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes6.dex */
public class fm3 implements cb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fm3() {
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

    @Override // com.repackage.ba4
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, ba4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
            if (PMSConstants.a(d84.b())) {
                v94.b(str, map, map2, jSONObject, new wj3(aVar));
            } else {
                v94.b(str, map, map2, jSONObject, new ca4(aVar));
            }
        }
    }

    @Override // com.repackage.cb4
    public oa4 b(String str, int i) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) ? ma4.a(str, i) : (oa4) invokeLI.objValue;
    }

    @Override // com.repackage.ba4
    public void j(String str, Map<String, String> map, Map<String, String> map2, ba4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, map, map2, aVar) == null) {
            if (PMSConstants.a(d84.b())) {
                v94.a(str, map, map2, new wj3(aVar));
            } else {
                v94.a(str, map, map2, new ca4(aVar));
            }
        }
    }
}
