package com.google.zxing.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public final class BitSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int bitOffset;
    public int byteOffset;
    public final byte[] bytes;

    public BitSource(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.bytes = bArr;
    }

    public int available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset : invokeV.intValue;
    }

    public int getBitOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bitOffset : invokeV.intValue;
    }

    public int getByteOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.byteOffset : invokeV.intValue;
    }

    public int readBits(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 > 0 && i2 <= 32 && i2 <= available()) {
                int i3 = this.bitOffset;
                int i4 = 0;
                if (i3 > 0) {
                    int i5 = 8 - i3;
                    int i6 = i2 < i5 ? i2 : i5;
                    int i7 = i5 - i6;
                    byte[] bArr = this.bytes;
                    int i8 = this.byteOffset;
                    int i9 = (((255 >> (8 - i6)) << i7) & bArr[i8]) >> i7;
                    i2 -= i6;
                    int i10 = this.bitOffset + i6;
                    this.bitOffset = i10;
                    if (i10 == 8) {
                        this.bitOffset = 0;
                        this.byteOffset = i8 + 1;
                    }
                    i4 = i9;
                }
                if (i2 > 0) {
                    while (i2 >= 8) {
                        int i11 = i4 << 8;
                        byte[] bArr2 = this.bytes;
                        int i12 = this.byteOffset;
                        i4 = (bArr2[i12] & 255) | i11;
                        this.byteOffset = i12 + 1;
                        i2 -= 8;
                    }
                    if (i2 > 0) {
                        int i13 = 8 - i2;
                        int i14 = (i4 << i2) | ((((255 >> i13) << i13) & this.bytes[this.byteOffset]) >> i13);
                        this.bitOffset += i2;
                        return i14;
                    }
                    return i4;
                }
                return i4;
            }
            throw new IllegalArgumentException(String.valueOf(i2));
        }
        return invokeI.intValue;
    }
}
