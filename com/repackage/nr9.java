package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class nr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public nr9() {
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

    public static void a(nr9 nr9Var, hr9 hr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, nr9Var, hr9Var) == null) {
            int length = nr9Var.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                nr9Var.c[i2] = i;
                kr9.n(nr9Var.a, nr9Var.b, i, hr9Var);
                i += 1080;
            }
        }
    }

    public static void b(nr9 nr9Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, nr9Var, i, i2) == null) {
            nr9Var.a = i;
            nr9Var.b = new int[i2 * 1080];
            nr9Var.c = new int[i2];
        }
    }
}
