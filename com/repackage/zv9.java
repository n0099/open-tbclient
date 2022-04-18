package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class zv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public zv9() {
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

    public static void a(zv9 zv9Var, tv9 tv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, zv9Var, tv9Var) == null) {
            int length = zv9Var.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                zv9Var.c[i2] = i;
                wv9.n(zv9Var.a, zv9Var.b, i, tv9Var);
                i += 1080;
            }
        }
    }

    public static void b(zv9 zv9Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, zv9Var, i, i2) == null) {
            zv9Var.a = i;
            zv9Var.b = new int[i2 * 1080];
            zv9Var.c = new int[i2];
        }
    }
}
