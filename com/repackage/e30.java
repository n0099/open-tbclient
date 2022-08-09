package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class e30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h30[] a;

    public e30() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new h30[]{new i30(8, 0), new j30(0, 1), new j30(1, 1), new i30(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        g30 g30Var = new g30();
        byte[] b = f30.b(bArr, bArr.length + ((this.a.length + 1) * g30.b));
        f30.a(b, g30Var.b(), bArr.length);
        int i = 0;
        while (true) {
            h30[] h30VarArr = this.a;
            if (i >= h30VarArr.length) {
                return Arrays.copyOf(g30Var.b(), g30.b);
            }
            h30 h30Var = h30VarArr[i];
            i++;
            int length = bArr.length + (g30.b * i);
            g30Var.a(h30Var.b(b, 0, length), h30Var.a(), h30Var.c(), h30Var.d());
            f30.a(b, g30Var.b(), length);
        }
    }
}
