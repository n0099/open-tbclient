package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class so9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public so9() {
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

    public static void a(so9 so9Var, mo9 mo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, so9Var, mo9Var) == null) {
            int length = so9Var.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                so9Var.c[i2] = i;
                po9.n(so9Var.a, so9Var.b, i, mo9Var);
                i += 1080;
            }
        }
    }

    public static void b(so9 so9Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, so9Var, i, i2) == null) {
            so9Var.a = i;
            so9Var.b = new int[i2 * 1080];
            so9Var.c = new int[i2];
        }
    }
}
