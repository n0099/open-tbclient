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
/* loaded from: classes6.dex */
public class nm5 implements hl3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public nm5() {
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

    @Override // com.repackage.jl3
    public void a(p03 p03Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, p03Var) == null) || p03Var == null) {
            return;
        }
        p03Var.b(new pm5(p03Var));
        p03Var.b(new im5(p03Var));
        p03Var.b(new hh3(p03Var));
        p03Var.b(new jh3(p03Var));
        p03Var.b(new lh3(p03Var));
        p03Var.b(new g23(p03Var));
        p03Var.b(new h23(p03Var));
        p03Var.b(new h43(p03Var));
        p03Var.b(new mh3(p03Var));
        p03Var.b(new km1(p03Var));
        p03Var.b(new mm5(p03Var));
    }

    @Override // com.repackage.jl3
    @Nullable
    public Map<String, Object> b(@NonNull tn1 tn1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tn1Var)) == null) ? SwanApi$$ModulesProvider.getV8ApiModules(tn1Var) : (Map) invokeL.objValue;
    }

    @Override // com.repackage.jl3
    @Nullable
    public Map<String, Object> c(@NonNull tn1 tn1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tn1Var)) == null) ? SwanApi$$ModulesProvider.getWebviewApiModules(tn1Var) : (Map) invokeL.objValue;
    }
}
