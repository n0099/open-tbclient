package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.swan.bdprivate.api.SwanApi$$ModulesProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Service
/* loaded from: classes5.dex */
public class ff3 implements xk3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ff3() {
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

    @Override // com.repackage.yk3
    public void a(e03 e03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, e03Var) == null) {
            e03Var.b(new wg3(e03Var));
            e03Var.b(new ah3(e03Var));
            e03Var.b(new uh3(e03Var));
            e03Var.b(new th3(e03Var));
            e03Var.b(new jh3(e03Var));
            e03Var.b(new bh3(e03Var));
            e03Var.b(new yg3(e03Var));
            e03Var.b(new hh3(e03Var));
            e03Var.b(new xg3(e03Var));
            e03Var.b(new vg3(e03Var));
            e03Var.b(new ug3(e03Var));
            e03Var.b(new zg3(e03Var));
            e03Var.b(new yh3(e03Var));
        }
    }

    @Override // com.repackage.yk3
    @Nullable
    public Map<String, Object> b(@NonNull in1 in1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, in1Var)) == null) ? SwanApi$$ModulesProvider.getV8ApiModules(in1Var) : (Map) invokeL.objValue;
    }

    @Override // com.repackage.yk3
    @Nullable
    public Map<String, Object> c(@NonNull in1 in1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, in1Var)) == null) ? SwanApi$$ModulesProvider.getWebviewApiModules(in1Var) : (Map) invokeL.objValue;
    }
}
