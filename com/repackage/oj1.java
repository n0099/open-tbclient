package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class oj1 implements em1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public oj1() {
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

    @Override // com.repackage.em1
    public void a(Context context, af3<Boolean> af3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, af3Var) == null) || af3Var == null) {
            return;
        }
        af3Var.a(null);
    }

    @Override // com.repackage.em1
    public void b(boolean z, af3<String> af3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, af3Var) == null) || af3Var == null) {
            return;
        }
        af3Var.a(null);
    }

    @Override // com.repackage.em1
    public void c(Context context, af3<String> af3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, af3Var) == null) || af3Var == null) {
            return;
        }
        af3Var.a(null);
    }

    @Override // com.repackage.em1
    public void d(af3<Integer> af3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, af3Var) == null) || af3Var == null) {
            return;
        }
        af3Var.a(null);
    }
}
