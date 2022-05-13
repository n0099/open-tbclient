package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class e00 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i00[] a;

    public e00() {
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
        this.a = new i00[]{new j00(8, 0), new k00(0, 1), new k00(1, 1), new j00(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        h00 h00Var = new h00();
        byte[] b = f00.b(bArr, bArr.length + ((this.a.length + 1) * h00.b));
        f00.a(b, h00Var.b(), bArr.length);
        int i = 0;
        while (true) {
            i00[] i00VarArr = this.a;
            if (i >= i00VarArr.length) {
                return Arrays.copyOf(h00Var.b(), h00.b);
            }
            i00 i00Var = i00VarArr[i];
            i++;
            int length = bArr.length + (h00.b * i);
            h00Var.a(i00Var.b(b, 0, length), i00Var.d(), i00Var.a(), i00Var.c());
            f00.a(b, h00Var.b(), length);
        }
    }
}
