package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gk1 implements wm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gk1() {
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

    @Override // com.repackage.wm1
    public void a(Context context, sf3<Boolean> sf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, sf3Var) == null) || sf3Var == null) {
            return;
        }
        sf3Var.a(null);
    }

    @Override // com.repackage.wm1
    public void b(boolean z, sf3<String> sf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, sf3Var) == null) || sf3Var == null) {
            return;
        }
        sf3Var.a(null);
    }

    @Override // com.repackage.wm1
    public void c(Context context, sf3<String> sf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, sf3Var) == null) || sf3Var == null) {
            return;
        }
        sf3Var.a(null);
    }

    @Override // com.repackage.wm1
    public void d(sf3<Integer> sf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, sf3Var) == null) || sf3Var == null) {
            return;
        }
        sf3Var.a(null);
    }
}
