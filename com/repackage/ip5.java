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
public class ip5 implements om3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ip5() {
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

    @Override // com.repackage.qm3
    public void a(w13 w13Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, w13Var) == null) || w13Var == null) {
            return;
        }
        w13Var.b(new kp5(w13Var));
        w13Var.b(new dp5(w13Var));
        w13Var.b(new oi3(w13Var));
        w13Var.b(new qi3(w13Var));
        w13Var.b(new si3(w13Var));
        w13Var.b(new n33(w13Var));
        w13Var.b(new o33(w13Var));
        w13Var.b(new o53(w13Var));
        w13Var.b(new ti3(w13Var));
        w13Var.b(new rn1(w13Var));
        w13Var.b(new hp5(w13Var));
    }

    @Override // com.repackage.qm3
    @Nullable
    public Map<String, Object> b(@NonNull ap1 ap1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ap1Var)) == null) ? SwanApi$$ModulesProvider.getV8ApiModules(ap1Var) : (Map) invokeL.objValue;
    }

    @Override // com.repackage.qm3
    @Nullable
    public Map<String, Object> c(@NonNull ap1 ap1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ap1Var)) == null) ? SwanApi$$ModulesProvider.getWebviewApiModules(ap1Var) : (Map) invokeL.objValue;
    }
}
