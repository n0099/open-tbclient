package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class pr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;
    public int[] b;

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

    public static void a(pr9 pr9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, pr9Var, i) == null) {
            for (int i2 = 0; i2 < i; i2++) {
                int[] iArr = pr9Var.b;
                byte[] bArr = pr9Var.a;
                int i3 = i2 * 4;
                iArr[i2] = ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
            }
        }
    }

    public static void b(pr9 pr9Var, byte[] bArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, pr9Var, bArr, iArr) == null) {
            pr9Var.a = bArr;
            pr9Var.b = iArr;
        }
    }
}
