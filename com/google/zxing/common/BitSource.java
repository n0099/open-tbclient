package com.google.zxing.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public int readBits(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i > 0 && i <= 32 && i <= available()) {
                int i2 = this.bitOffset;
                int i3 = 0;
                if (i2 > 0) {
                    int i4 = 8 - i2;
                    int i5 = i < i4 ? i : i4;
                    int i6 = i4 - i5;
                    byte[] bArr = this.bytes;
                    int i7 = this.byteOffset;
                    int i8 = (((255 >> (8 - i5)) << i6) & bArr[i7]) >> i6;
                    i -= i5;
                    int i9 = this.bitOffset + i5;
                    this.bitOffset = i9;
                    if (i9 == 8) {
                        this.bitOffset = 0;
                        this.byteOffset = i7 + 1;
                    }
                    i3 = i8;
                }
                if (i > 0) {
                    while (i >= 8) {
                        int i10 = i3 << 8;
                        byte[] bArr2 = this.bytes;
                        int i11 = this.byteOffset;
                        i3 = (bArr2[i11] & 255) | i10;
                        this.byteOffset = i11 + 1;
                        i -= 8;
                    }
                    if (i > 0) {
                        int i12 = 8 - i;
                        int i13 = (i3 << i) | ((((255 >> i12) << i12) & this.bytes[this.byteOffset]) >> i12);
                        this.bitOffset += i;
                        return i13;
                    }
                    return i3;
                }
                return i3;
            }
            throw new IllegalArgumentException(String.valueOf(i));
        }
        return invokeI.intValue;
    }
}
