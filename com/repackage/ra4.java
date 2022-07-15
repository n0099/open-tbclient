package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.o94;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ra4 extends oa4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ra4() {
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
            qa4.b(str, map, map2, jSONObject, new p94(aVar));
        }
    }

    @Override // com.repackage.o94
    public void z(String str, Map<String, String> map, Map<String, String> map2, o94.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, map2, aVar) == null) {
            qa4.a(str, map, map2, new p94(aVar));
        }
    }
}
