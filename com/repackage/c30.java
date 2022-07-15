package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class c30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f30[] a;

    public c30() {
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
        this.a = new f30[]{new g30(8, 0), new h30(0, 1), new h30(1, 1), new g30(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        e30 e30Var = new e30();
        byte[] b = d30.b(bArr, bArr.length + ((this.a.length + 1) * e30.b));
        d30.a(b, e30Var.b(), bArr.length);
        int i = 0;
        while (true) {
            f30[] f30VarArr = this.a;
            if (i >= f30VarArr.length) {
                return Arrays.copyOf(e30Var.b(), e30.b);
            }
            f30 f30Var = f30VarArr[i];
            i++;
            int length = bArr.length + (e30.b * i);
            e30Var.a(f30Var.b(b, 0, length), f30Var.a(), f30Var.c(), f30Var.d());
            d30.a(b, e30Var.b(), length);
        }
    }
}
