package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class or9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public or9() {
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

    public static void a(or9 or9Var, ir9 ir9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, or9Var, ir9Var) == null) {
            int length = or9Var.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                or9Var.c[i2] = i;
                lr9.n(or9Var.a, or9Var.b, i, ir9Var);
                i += 1080;
            }
        }
    }

    public static void b(or9 or9Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, or9Var, i, i2) == null) {
            or9Var.a = i;
            or9Var.b = new int[i2 * 1080];
            or9Var.c = new int[i2];
        }
    }
}
