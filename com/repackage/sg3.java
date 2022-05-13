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
/* loaded from: classes7.dex */
public class sg3 implements km3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sg3() {
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

    @Override // com.repackage.lm3
    public void a(r13 r13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, r13Var) == null) {
            r13Var.b(new ji3(r13Var));
            r13Var.b(new ni3(r13Var));
            r13Var.b(new hj3(r13Var));
            r13Var.b(new gj3(r13Var));
            r13Var.b(new wi3(r13Var));
            r13Var.b(new oi3(r13Var));
            r13Var.b(new li3(r13Var));
            r13Var.b(new ui3(r13Var));
            r13Var.b(new ki3(r13Var));
            r13Var.b(new ii3(r13Var));
            r13Var.b(new hi3(r13Var));
            r13Var.b(new mi3(r13Var));
            r13Var.b(new lj3(r13Var));
        }
    }

    @Override // com.repackage.lm3
    @Nullable
    public Map<String, Object> b(@NonNull vo1 vo1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vo1Var)) == null) ? SwanApi$$ModulesProvider.getV8ApiModules(vo1Var) : (Map) invokeL.objValue;
    }

    @Override // com.repackage.lm3
    @Nullable
    public Map<String, Object> c(@NonNull vo1 vo1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vo1Var)) == null) ? SwanApi$$ModulesProvider.getWebviewApiModules(vo1Var) : (Map) invokeL.objValue;
    }
}
