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
public class gg3 implements yl3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gg3() {
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

    @Override // com.repackage.zl3
    public void a(f13 f13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, f13Var) == null) {
            f13Var.b(new xh3(f13Var));
            f13Var.b(new bi3(f13Var));
            f13Var.b(new vi3(f13Var));
            f13Var.b(new ui3(f13Var));
            f13Var.b(new ki3(f13Var));
            f13Var.b(new ci3(f13Var));
            f13Var.b(new zh3(f13Var));
            f13Var.b(new ii3(f13Var));
            f13Var.b(new yh3(f13Var));
            f13Var.b(new wh3(f13Var));
            f13Var.b(new vh3(f13Var));
            f13Var.b(new ai3(f13Var));
            f13Var.b(new zi3(f13Var));
        }
    }

    @Override // com.repackage.zl3
    @Nullable
    public Map<String, Object> b(@NonNull jo1 jo1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jo1Var)) == null) ? SwanApi$$ModulesProvider.getV8ApiModules(jo1Var) : (Map) invokeL.objValue;
    }

    @Override // com.repackage.zl3
    @Nullable
    public Map<String, Object> c(@NonNull jo1 jo1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jo1Var)) == null) ? SwanApi$$ModulesProvider.getWebviewApiModules(jo1Var) : (Map) invokeL.objValue;
    }
}
