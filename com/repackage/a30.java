package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class a30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d30[] a;

    public a30() {
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
        this.a = new d30[]{new e30(8, 0), new f30(0, 1), new f30(1, 1), new e30(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        c30 c30Var = new c30();
        byte[] b = b30.b(bArr, bArr.length + ((this.a.length + 1) * c30.b));
        b30.a(b, c30Var.b(), bArr.length);
        int i = 0;
        while (true) {
            d30[] d30VarArr = this.a;
            if (i >= d30VarArr.length) {
                return Arrays.copyOf(c30Var.b(), c30.b);
            }
            d30 d30Var = d30VarArr[i];
            i++;
            int length = bArr.length + (c30.b * i);
            c30Var.a(d30Var.b(b, 0, length), d30Var.a(), d30Var.c(), d30Var.d());
            b30.a(b, c30Var.b(), length);
        }
    }
}
