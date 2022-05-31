package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.crypto.ShortBufferException;
/* loaded from: classes6.dex */
public final class kz implements lz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public kz(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
    }

    @Override // com.repackage.lz
    public int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int i2 = this.a;
            return i2 - (i % i2);
        }
        return invokeI.intValue;
    }

    @Override // com.repackage.lz
    public int a(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i, i2)) == null) {
            if (bArr == null || i2 == 0) {
                return 0;
            }
            int i4 = i2 + i;
            int i5 = bArr[i4 - 1];
            int i6 = i5 & 255;
            if (i6 < 1 || i6 > this.a || (i3 = i4 - i6) < i) {
                return -1;
            }
            for (int i7 = 0; i7 < i6; i7++) {
                if (bArr[i3 + i7] != i5) {
                    return -1;
                }
            }
            return i3;
        }
        return invokeLII.intValue;
    }

    @Override // com.repackage.lz
    public void b(byte[] bArr, int i, int i2) throws ShortBufferException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i, i2) == null) || bArr == null) {
            return;
        }
        if (i + i2 > bArr.length) {
            throw new ShortBufferException("Buffer too small to hold padding");
        }
        byte b = (byte) (i2 & 255);
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3 + i] = b;
        }
    }
}
