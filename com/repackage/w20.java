package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class w20 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z20[] a;

    public w20() {
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
        this.a = new z20[]{new a30(8, 0), new b30(0, 1), new b30(1, 1), new a30(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        y20 y20Var = new y20();
        byte[] b = x20.b(bArr, bArr.length + ((this.a.length + 1) * y20.b));
        x20.a(b, y20Var.b(), bArr.length);
        int i = 0;
        while (true) {
            z20[] z20VarArr = this.a;
            if (i >= z20VarArr.length) {
                return Arrays.copyOf(y20Var.b(), y20.b);
            }
            z20 z20Var = z20VarArr[i];
            i++;
            int length = bArr.length + (y20.b * i);
            y20Var.a(z20Var.b(b, 0, length), z20Var.a(), z20Var.c(), z20Var.d());
            x20.a(b, y20Var.b(), length);
        }
    }
}
