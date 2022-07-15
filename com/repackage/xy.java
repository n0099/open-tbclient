package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class xy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bz[] a;

    public xy() {
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
        this.a = new bz[]{new cz(8, 0), new dz(0, 1), new dz(1, 1), new cz(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        az azVar = new az();
        byte[] b = yy.b(bArr, bArr.length + ((this.a.length + 1) * az.b));
        yy.a(b, azVar.b(), bArr.length);
        int i = 0;
        while (true) {
            bz[] bzVarArr = this.a;
            if (i >= bzVarArr.length) {
                return Arrays.copyOf(azVar.b(), az.b);
            }
            bz bzVar = bzVarArr[i];
            i++;
            int length = bArr.length + (az.b * i);
            azVar.a(bzVar.b(b, 0, length), bzVar.d(), bzVar.a(), bzVar.c());
            yy.a(b, azVar.b(), length);
        }
    }
}
