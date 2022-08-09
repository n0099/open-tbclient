package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class yy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cz[] a;

    public yy() {
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
        this.a = new cz[]{new dz(8, 0), new ez(0, 1), new ez(1, 1), new dz(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        bz bzVar = new bz();
        byte[] b = zy.b(bArr, bArr.length + ((this.a.length + 1) * bz.b));
        zy.a(b, bzVar.b(), bArr.length);
        int i = 0;
        while (true) {
            cz[] czVarArr = this.a;
            if (i >= czVarArr.length) {
                return Arrays.copyOf(bzVar.b(), bz.b);
            }
            cz czVar = czVarArr[i];
            i++;
            int length = bArr.length + (bz.b * i);
            bzVar.a(czVar.b(b, 0, length), czVar.d(), czVar.a(), czVar.c());
            zy.a(b, bzVar.b(), length);
        }
    }
}
