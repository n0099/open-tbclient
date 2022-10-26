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

    public ParsableNalUnitBitArray(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        reset(bArr, i, i2);
    }

    private void assertValidOffset() {
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            int i2 = this.byteOffset;
            if (i2 >= 0 && (i2 < (i = this.byteLimit) || (i2 == i && this.bitOffset == 0))) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
        }
    }

    private int readExpGolombCodeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int i = 0;
            int i2 = 0;
            while (!readBit()) {
                i2++;
            }
            int i3 = (1 << i2) - 1;
            if (i2 > 0) {
                i = readBits(i2);
            }
            return i3 + i;
        }
        return invokeV.intValue;
    }

    public boolean readBit() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if ((this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0) {
                z = true;
            } else {
                z = false;
            }
            skipBit();
            return z;
        }
        return invokeV.booleanValue;
    }

    public int readSignedExpGolombCodedInt() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int readExpGolombCodeNum = readExpGolombCodeNum();
            if (readExpGolombCodeNum % 2 == 0) {
                i = -1;
            } else {
                i = 1;
            }
            return i * ((readExpGolombCodeNum + 1) / 2);
        }
        return invokeV.intValue;
    }

    public int readUnsignedExpGolombCodedInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return readExpGolombCodeNum();
        }
        return invokeV.intValue;
    }

    public void skipBit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i = 1;
            int i2 = this.bitOffset + 1;
            this.bitOffset = i2;
            if (i2 == 8) {
                this.bitOffset = 0;
                int i3 = this.byteOffset;
                if (shouldSkipByte(i3 + 1)) {
                    i = 2;
                }
                this.byteOffset = i3 + i;
            }
            assertValidOffset();
        }
    }

    private boolean shouldSkipByte(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) {
            if (2 <= i && i < this.byteLimit) {
                byte[] bArr = this.data;
                if (bArr[i] == 3 && bArr[i - 2] == 0 && bArr[i - 1] == 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean canReadBits(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int i2 = this.byteOffset;
            int i3 = i / 8;
            int i4 = i2 + i3;
            int i5 = (this.bitOffset + i) - (i3 * 8);
            if (i5 > 7) {
                i4++;
                i5 -= 8;
            }
            while (true) {
                i2++;
                if (i2 > i4 || i4 >= this.byteLimit) {
                    break;
                } else if (shouldSkipByte(i2)) {
                    i4++;
                    i2 += 2;
                }
            }
            int i6 = this.byteLimit;
            if (i4 < i6) {
                return true;
            }
            if (i4 == i6 && i5 == 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void skipBits(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            int i2 = this.byteOffset;
            int i3 = i / 8;
            int i4 = i2 + i3;
            this.byteOffset = i4;
            int i5 = this.bitOffset + (i - (i3 * 8));
            this.bitOffset = i5;
            if (i5 > 7) {
                this.byteOffset = i4 + 1;
                this.bitOffset = i5 - 8;
            }
            while (true) {
                i2++;
                if (i2 <= this.byteOffset) {
                    if (shouldSkipByte(i2)) {
                        this.byteOffset++;
                        i2 += 2;
                    }
                } else {
                    assertValidOffset();
                    return;
                }
            }
        }
    }

    public boolean canReadExpGolombCodedNum() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = this.byteOffset;
            int i2 = this.bitOffset;
            int i3 = 0;
            while (this.byteOffset < this.byteLimit && !readBit()) {
                i3++;
            }
            if (this.byteOffset == this.byteLimit) {
                z = true;
            } else {
                z = false;
            }
            this.byteOffset = i;
            this.bitOffset = i2;
            if (z || !canReadBits((i3 * 2) + 1)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int readBits(int i) {
        InterceptResult invokeI;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.bitOffset += i;
            int i4 = 0;
            while (true) {
                i2 = this.bitOffset;
                i3 = 2;
                if (i2 <= 8) {
                    break;
                }
                int i5 = i2 - 8;
                this.bitOffset = i5;
                byte[] bArr = this.data;
                int i6 = this.byteOffset;
                i4 |= (bArr[i6] & 255) << i5;
                if (!shouldSkipByte(i6 + 1)) {
                    i3 = 1;
                }
                this.byteOffset = i6 + i3;
            }
            byte[] bArr2 = this.data;
            int i7 = this.byteOffset;
            int i8 = ((-1) >>> (32 - i)) & (i4 | ((bArr2[i7] & 255) >> (8 - i2)));
            if (i2 == 8) {
                this.bitOffset = 0;
                if (!shouldSkipByte(i7 + 1)) {
                    i3 = 1;
                }
                this.byteOffset = i7 + i3;
            }
            assertValidOffset();
            return i8;
        }
        return invokeI.intValue;
    }

    public void reset(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i, i2) == null) {
            this.data = bArr;
            this.byteOffset = i;
            this.byteLimit = i2;
            this.bitOffset = 0;
            assertValidOffset();
        }
    }
}
