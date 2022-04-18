package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.api.SwanApi$$ModulesProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Singleton
@Service
/* loaded from: classes7.dex */
public class wm5 implements yl3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public wm5() {
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

    @Override // com.repackage.am3
    public void a(g13 g13Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, g13Var) == null) || g13Var == null) {
            return;
        }
        g13Var.b(new ym5(g13Var));
        g13Var.b(new rm5(g13Var));
        g13Var.b(new yh3(g13Var));
        g13Var.b(new ai3(g13Var));
        g13Var.b(new ci3(g13Var));
        g13Var.b(new x23(g13Var));
        g13Var.b(new y23(g13Var));
        g13Var.b(new y43(g13Var));
        g13Var.b(new di3(g13Var));
        g13Var.b(new bn1(g13Var));
        g13Var.b(new vm5(g13Var));
    }

    @Override // com.repackage.am3
    @Nullable
    public Map<String, Object> b(@NonNull ko1 ko1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ko1Var)) == null) ? SwanApi$$ModulesProvider.getV8ApiModules(ko1Var) : (Map) invokeL.objValue;
    }

    @Override // com.repackage.am3
    @Nullable
    public Map<String, Object> c(@NonNull ko1 ko1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ko1Var)) == null) ? SwanApi$$ModulesProvider.getWebviewApiModules(ko1Var) : (Map) invokeL.objValue;
    }
}
