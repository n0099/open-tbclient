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
/* loaded from: classes6.dex */
public class fg3 implements xl3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fg3() {
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

    @Override // com.repackage.yl3
    public void a(e13 e13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, e13Var) == null) {
            e13Var.b(new wh3(e13Var));
            e13Var.b(new ai3(e13Var));
            e13Var.b(new ui3(e13Var));
            e13Var.b(new ti3(e13Var));
            e13Var.b(new ji3(e13Var));
            e13Var.b(new bi3(e13Var));
            e13Var.b(new yh3(e13Var));
            e13Var.b(new hi3(e13Var));
            e13Var.b(new xh3(e13Var));
            e13Var.b(new vh3(e13Var));
            e13Var.b(new uh3(e13Var));
            e13Var.b(new zh3(e13Var));
            e13Var.b(new yi3(e13Var));
        }
    }

    @Override // com.repackage.yl3
    @Nullable
    public Map<String, Object> b(@NonNull io1 io1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, io1Var)) == null) ? SwanApi$$ModulesProvider.getV8ApiModules(io1Var) : (Map) invokeL.objValue;
    }

    @Override // com.repackage.yl3
    @Nullable
    public Map<String, Object> c(@NonNull io1 io1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, io1Var)) == null) ? SwanApi$$ModulesProvider.getWebviewApiModules(io1Var) : (Map) invokeL.objValue;
    }
}
