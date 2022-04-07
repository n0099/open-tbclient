package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class v00 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z00[] a;

    public v00() {
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
        this.a = new z00[]{new a10(8, 0), new b10(0, 1), new b10(1, 1), new a10(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        y00 y00Var = new y00();
        byte[] b = w00.b(bArr, bArr.length + ((this.a.length + 1) * y00.b));
        w00.a(b, y00Var.b(), bArr.length);
        int i = 0;
        while (true) {
            z00[] z00VarArr = this.a;
            if (i >= z00VarArr.length) {
                return Arrays.copyOf(y00Var.b(), y00.b);
            }
            z00 z00Var = z00VarArr[i];
            i++;
            int length = bArr.length + (y00.b * i);
            y00Var.a(z00Var.b(b, 0, length), z00Var.d(), z00Var.a(), z00Var.c());
            w00.a(b, y00Var.b(), length);
        }
    }
}
