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
public class qn5 implements wl3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public qn5() {
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
        if (!(interceptable == null || interceptable.invokeL(1048576, this, e13Var) == null) || e13Var == null) {
            return;
        }
        e13Var.b(new sn5(e13Var));
        e13Var.b(new ln5(e13Var));
        e13Var.b(new wh3(e13Var));
        e13Var.b(new yh3(e13Var));
        e13Var.b(new ai3(e13Var));
        e13Var.b(new v23(e13Var));
        e13Var.b(new w23(e13Var));
        e13Var.b(new w43(e13Var));
        e13Var.b(new bi3(e13Var));
        e13Var.b(new zm1(e13Var));
        e13Var.b(new pn5(e13Var));
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
