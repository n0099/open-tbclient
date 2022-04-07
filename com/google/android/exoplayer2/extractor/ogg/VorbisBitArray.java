package com.google.android.exoplayer2.extractor.ogg;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Assertions;
/* loaded from: classes4.dex */
public final class VorbisBitArray {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int bitOffset;
    public final int byteLimit;
    public int byteOffset;
    public final byte[] data;

    public VorbisBitArray(byte[] bArr) {
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
        this.data = bArr;
        this.byteLimit = bArr.length;
    }

    private void assertValidOffset() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            int i2 = this.byteOffset;
            Assertions.checkState(i2 >= 0 && (i2 < (i = this.byteLimit) || (i2 == i && this.bitOffset == 0)));
        }
    }

    public int bitsLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((this.byteLimit - this.byteOffset) * 8) - this.bitOffset : invokeV.intValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.byteOffset * 8) + this.bitOffset : invokeV.intValue;
    }

    public boolean readBit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            boolean z = (((this.data[this.byteOffset] & 255) >> this.bitOffset) & 1) == 1;
            skipBits(1);
            return z;
        }
        return invokeV.booleanValue;
    }

    public int readBits(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            int i2 = this.byteOffset;
            int min = Math.min(i, 8 - this.bitOffset);
            int i3 = i2 + 1;
            int i4 = ((this.data[i2] & 255) >> this.bitOffset) & (255 >> (8 - min));
            while (min < i) {
                i4 |= (this.data[i3] & 255) << min;
                min += 8;
                i3++;
            }
            int i5 = i4 & ((-1) >>> (32 - i));
            skipBits(i);
            return i5;
        }
        return invokeI.intValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.byteOffset = 0;
            this.bitOffset = 0;
        }
    }

    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            int i2 = i / 8;
            this.byteOffset = i2;
            this.bitOffset = i - (i2 * 8);
            assertValidOffset();
        }
    }

    public void skipBits(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            int i2 = i / 8;
            int i3 = this.byteOffset + i2;
            this.byteOffset = i3;
            int i4 = this.bitOffset + (i - (i2 * 8));
            this.bitOffset = i4;
            if (i4 > 7) {
                this.byteOffset = i3 + 1;
                this.bitOffset = i4 - 8;
            }
            assertValidOffset();
        }
    }
}
