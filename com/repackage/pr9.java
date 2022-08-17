package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class pr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public pr9() {
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

    public static void a(pr9 pr9Var, jr9 jr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, pr9Var, jr9Var) == null) {
            int length = pr9Var.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                pr9Var.c[i2] = i;
                mr9.n(pr9Var.a, pr9Var.b, i, jr9Var);
                i += 1080;
            }
        }
    }

    public static void b(pr9 pr9Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, pr9Var, i, i2) == null) {
            pr9Var.a = i;
            pr9Var.b = new int[i2 * 1080];
            pr9Var.c = new int[i2];
        }
    }
}
