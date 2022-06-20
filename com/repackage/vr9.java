package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class vr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public vr9() {
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

    public static void a(vr9 vr9Var, pr9 pr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, vr9Var, pr9Var) == null) {
            int length = vr9Var.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                vr9Var.c[i2] = i;
                sr9.n(vr9Var.a, vr9Var.b, i, pr9Var);
                i += 1080;
            }
        }
    }

    public static void b(vr9 vr9Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, vr9Var, i, i2) == null) {
            vr9Var.a = i;
            vr9Var.b = new int[i2 * 1080];
            vr9Var.c = new int[i2];
        }
    }
}
