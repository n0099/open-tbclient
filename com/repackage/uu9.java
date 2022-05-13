package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class uu9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public uu9() {
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

    public static void a(uu9 uu9Var, ou9 ou9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, uu9Var, ou9Var) == null) {
            int length = uu9Var.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                uu9Var.c[i2] = i;
                ru9.n(uu9Var.a, uu9Var.b, i, ou9Var);
                i += 1080;
            }
        }
    }

    public static void b(uu9 uu9Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, uu9Var, i, i2) == null) {
            uu9Var.a = i;
            uu9Var.b = new int[i2 * 1080];
            uu9Var.c = new int[i2];
        }
    }
}
