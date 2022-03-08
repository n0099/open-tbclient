package com.google.android.exoplayer2.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class ParsableNalUnitBitArray {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int bitOffset;
    public int byteLimit;
    public int byteOffset;
    public byte[] data;

    public ParsableNalUnitBitArray(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        reset(bArr, i2, i3);
    }

    private void assertValidOffset() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            int i3 = this.byteOffset;
            Assertions.checkState(i3 >= 0 && (i3 < (i2 = this.byteLimit) || (i3 == i2 && this.bitOffset == 0)));
        }
    }

    private int readExpGolombCodeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int i2 = 0;
            while (!readBit()) {
                i2++;
            }
            return ((1 << i2) - 1) + (i2 > 0 ? readBits(i2) : 0);
        }
        return invokeV.intValue;
    }

    private boolean shouldSkipByte(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) {
            if (2 <= i2 && i2 < this.byteLimit) {
                byte[] bArr = this.data;
                if (bArr[i2] == 3 && bArr[i2 - 2] == 0 && bArr[i2 - 1] == 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean canReadBits(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = this.byteOffset;
            int i4 = i2 / 8;
            int i5 = i3 + i4;
            int i6 = (this.bitOffset + i2) - (i4 * 8);
            if (i6 > 7) {
                i5++;
                i6 -= 8;
            }
            while (true) {
                i3++;
                if (i3 > i5 || i5 >= this.byteLimit) {
                    break;
                } else if (shouldSkipByte(i3)) {
                    i5++;
                    i3 += 2;
                }
            }
            int i7 = this.byteLimit;
            if (i5 >= i7) {
                return i5 == i7 && i6 == 0;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean canReadExpGolombCodedNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.byteOffset;
            int i3 = this.bitOffset;
            int i4 = 0;
            while (this.byteOffset < this.byteLimit && !readBit()) {
                i4++;
            }
            boolean z = this.byteOffset == this.byteLimit;
            this.byteOffset = i2;
            this.bitOffset = i3;
            return !z && canReadBits((i4 * 2) + 1);
        }
        return invokeV.booleanValue;
    }

    public boolean readBit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            boolean z = (this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0;
            skipBit();
            return z;
        }
        return invokeV.booleanValue;
    }

    public int readBits(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            this.bitOffset += i2;
            int i4 = 0;
            while (true) {
                i3 = this.bitOffset;
                if (i3 <= 8) {
                    break;
                }
                int i5 = i3 - 8;
                this.bitOffset = i5;
                byte[] bArr = this.data;
                int i6 = this.byteOffset;
                i4 |= (bArr[i6] & 255) << i5;
                if (!shouldSkipByte(i6 + 1)) {
                    r3 = 1;
                }
                this.byteOffset = i6 + r3;
            }
            byte[] bArr2 = this.data;
            int i7 = this.byteOffset;
            int i8 = ((-1) >>> (32 - i2)) & (i4 | ((bArr2[i7] & 255) >> (8 - i3)));
            if (i3 == 8) {
                this.bitOffset = 0;
                this.byteOffset = i7 + (shouldSkipByte(i7 + 1) ? 2 : 1);
            }
            assertValidOffset();
            return i8;
        }
        return invokeI.intValue;
    }

    public int readSignedExpGolombCodedInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int readExpGolombCodeNum = readExpGolombCodeNum();
            return (readExpGolombCodeNum % 2 == 0 ? -1 : 1) * ((readExpGolombCodeNum + 1) / 2);
        }
        return invokeV.intValue;
    }

    public int readUnsignedExpGolombCodedInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? readExpGolombCodeNum() : invokeV.intValue;
    }

    public void reset(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            this.data = bArr;
            this.byteOffset = i2;
            this.byteLimit = i3;
            this.bitOffset = 0;
            assertValidOffset();
        }
    }

    public void skipBit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i2 = this.bitOffset + 1;
            this.bitOffset = i2;
            if (i2 == 8) {
                this.bitOffset = 0;
                int i3 = this.byteOffset;
                this.byteOffset = i3 + (shouldSkipByte(i3 + 1) ? 2 : 1);
            }
            assertValidOffset();
        }
    }

    public void skipBits(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) != null) {
            return;
        }
        int i3 = this.byteOffset;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        this.byteOffset = i5;
        int i6 = this.bitOffset + (i2 - (i4 * 8));
        this.bitOffset = i6;
        if (i6 > 7) {
            this.byteOffset = i5 + 1;
            this.bitOffset = i6 - 8;
        }
        while (true) {
            i3++;
            if (i3 <= this.byteOffset) {
                if (shouldSkipByte(i3)) {
                    this.byteOffset++;
                    i3 += 2;
                }
            } else {
                assertValidOffset();
                return;
            }
        }
    }
}
