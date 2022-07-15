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
import com.repackage.o94;
import java.util.Map;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes7.dex */
public class sl3 implements pa4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sl3() {
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

    @Override // com.repackage.o94
    public void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, o94.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
            if (PMSConstants.a(q74.b())) {
                i94.b(str, map, map2, jSONObject, new jj3(aVar));
            } else {
                i94.b(str, map, map2, jSONObject, new p94(aVar));
            }
        }
    }

    @Override // com.repackage.pa4
    public ba4 c(String str, int i) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) ? z94.a(str, i) : (ba4) invokeLI.objValue;
    }

    @Override // com.repackage.o94
    public void z(String str, Map<String, String> map, Map<String, String> map2, o94.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, map, map2, aVar) == null) {
            if (PMSConstants.a(q74.b())) {
                i94.a(str, map, map2, new jj3(aVar));
            } else {
                i94.a(str, map, map2, new p94(aVar));
            }
        }
    }
}
