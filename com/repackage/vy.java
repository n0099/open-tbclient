package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class vy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zy[] a;

    public vy() {
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
        this.a = new zy[]{new az(8, 0), new bz(0, 1), new bz(1, 1), new az(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        yy yyVar = new yy();
        byte[] b = wy.b(bArr, bArr.length + ((this.a.length + 1) * yy.b));
        wy.a(b, yyVar.b(), bArr.length);
        int i = 0;
        while (true) {
            zy[] zyVarArr = this.a;
            if (i >= zyVarArr.length) {
                return Arrays.copyOf(yyVar.b(), yy.b);
            }
            zy zyVar = zyVarArr[i];
            i++;
            int length = bArr.length + (yy.b * i);
            yyVar.a(zyVar.b(b, 0, length), zyVar.d(), zyVar.a(), zyVar.c());
            wy.a(b, yyVar.b(), length);
        }
    }
}
