package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class ry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vy[] a;

    public ry() {
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
        this.a = new vy[]{new wy(8, 0), new xy(0, 1), new xy(1, 1), new wy(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        uy uyVar = new uy();
        byte[] b = sy.b(bArr, bArr.length + ((this.a.length + 1) * uy.b));
        sy.a(b, uyVar.b(), bArr.length);
        int i = 0;
        while (true) {
            vy[] vyVarArr = this.a;
            if (i >= vyVarArr.length) {
                return Arrays.copyOf(uyVar.b(), uy.b);
            }
            vy vyVar = vyVarArr[i];
            i++;
            int length = bArr.length + (uy.b * i);
            uyVar.a(vyVar.b(b, 0, length), vyVar.d(), vyVar.a(), vyVar.c());
            sy.a(b, uyVar.b(), length);
        }
    }
}
