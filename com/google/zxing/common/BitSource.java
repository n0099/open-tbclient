package com.google.zxing.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
        }
        return invokeV.intValue;
    }

    public int getBitOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.bitOffset;
        }
        return invokeV.intValue;
    }

    public int getByteOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.byteOffset;
        }
        return invokeV.intValue;
    }

    public int readBits(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i > 0 && i <= 32 && i <= available()) {
                int i3 = this.bitOffset;
                int i4 = 0;
                if (i3 > 0) {
                    int i5 = 8 - i3;
                    if (i < i5) {
                        i2 = i;
                    } else {
                        i2 = i5;
                    }
                    int i6 = i5 - i2;
                    byte[] bArr = this.bytes;
                    int i7 = this.byteOffset;
                    int i8 = (((255 >> (8 - i2)) << i6) & bArr[i7]) >> i6;
                    i -= i2;
                    int i9 = this.bitOffset + i2;
                    this.bitOffset = i9;
                    if (i9 == 8) {
                        this.bitOffset = 0;
                        this.byteOffset = i7 + 1;
                    }
                    i4 = i8;
                }
                if (i > 0) {
                    while (i >= 8) {
                        int i10 = i4 << 8;
                        byte[] bArr2 = this.bytes;
                        int i11 = this.byteOffset;
                        i4 = (bArr2[i11] & 255) | i10;
                        this.byteOffset = i11 + 1;
                        i -= 8;
                    }
                    if (i > 0) {
                        int i12 = 8 - i;
                        int i13 = (i4 << i) | ((((255 >> i12) << i12) & this.bytes[this.byteOffset]) >> i12);
                        this.bitOffset += i;
                        return i13;
                    }
                    return i4;
                }
                return i4;
            }
            throw new IllegalArgumentException(String.valueOf(i));
        }
        return invokeI.intValue;
    }
}
