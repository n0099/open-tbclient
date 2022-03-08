package com.google.android.exoplayer2.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class ParsableBitArray {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int bitOffset;
    public int byteLimit;
    public int byteOffset;
    public byte[] data;

    public ParsableBitArray() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void assertValidOffset() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            int i3 = this.byteOffset;
            Assertions.checkState(i3 >= 0 && (i3 < (i2 = this.byteLimit) || (i3 == i2 && this.bitOffset == 0)));
        }
    }

    public int bitsLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((this.byteLimit - this.byteOffset) * 8) - this.bitOffset : invokeV.intValue;
    }

    public void byteAlign() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.bitOffset == 0) {
            return;
        }
        this.bitOffset = 0;
        this.byteOffset++;
        assertValidOffset();
    }

    public int getBytePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Assertions.checkState(this.bitOffset == 0);
            return this.byteOffset;
        }
        return invokeV.intValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.byteOffset * 8) + this.bitOffset : invokeV.intValue;
    }

    public boolean readBit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 == 0) {
                return 0;
            }
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
                this.byteOffset = i6 + 1;
                i4 |= (bArr[i6] & 255) << i5;
            }
            byte[] bArr2 = this.data;
            int i7 = this.byteOffset;
            int i8 = ((-1) >>> (32 - i2)) & (i4 | ((bArr2[i7] & 255) >> (8 - i3)));
            if (i3 == 8) {
                this.bitOffset = 0;
                this.byteOffset = i7 + 1;
            }
            assertValidOffset();
            return i8;
        }
        return invokeI.intValue;
    }

    public void readBytes(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, bArr, i2, i3) == null) {
            Assertions.checkState(this.bitOffset == 0);
            System.arraycopy(this.data, this.byteOffset, bArr, i2, i3);
            this.byteOffset += i3;
            assertValidOffset();
        }
    }

    public void reset(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bArr) == null) {
            reset(bArr, bArr.length);
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            int i3 = i2 / 8;
            this.byteOffset = i3;
            this.bitOffset = i2 - (i3 * 8);
            assertValidOffset();
        }
    }

    public void skipBit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int i2 = this.bitOffset + 1;
            this.bitOffset = i2;
            if (i2 == 8) {
                this.bitOffset = 0;
                this.byteOffset++;
            }
            assertValidOffset();
        }
    }

    public void skipBits(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            int i3 = i2 / 8;
            int i4 = this.byteOffset + i3;
            this.byteOffset = i4;
            int i5 = this.bitOffset + (i2 - (i3 * 8));
            this.bitOffset = i5;
            if (i5 > 7) {
                this.byteOffset = i4 + 1;
                this.bitOffset = i5 - 8;
            }
            assertValidOffset();
        }
    }

    public void skipBytes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            Assertions.checkState(this.bitOffset == 0);
            this.byteOffset += i2;
            assertValidOffset();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ParsableBitArray(byte[] bArr) {
        this(bArr, bArr.length);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((byte[]) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void reset(ParsableByteArray parsableByteArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, parsableByteArray) == null) {
            reset(parsableByteArray.data, parsableByteArray.limit());
            setPosition(parsableByteArray.getPosition() * 8);
        }
    }

    public ParsableBitArray(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.data = bArr;
        this.byteLimit = i2;
    }

    public void reset(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, bArr, i2) == null) {
            this.data = bArr;
            this.byteOffset = 0;
            this.bitOffset = 0;
            this.byteLimit = i2;
        }
    }

    public void readBits(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            int i4 = (i3 >> 3) + i2;
            while (i2 < i4) {
                byte[] bArr2 = this.data;
                int i5 = this.byteOffset;
                int i6 = i5 + 1;
                this.byteOffset = i6;
                byte b2 = bArr2[i5];
                int i7 = this.bitOffset;
                bArr[i2] = (byte) (b2 << i7);
                bArr[i2] = (byte) (((255 & bArr2[i6]) >> (8 - i7)) | bArr[i2]);
                i2++;
            }
            int i8 = i3 & 7;
            if (i8 == 0) {
                return;
            }
            bArr[i4] = (byte) (bArr[i4] & (255 >> i8));
            int i9 = this.bitOffset;
            if (i9 + i8 > 8) {
                byte b3 = bArr[i4];
                byte[] bArr3 = this.data;
                int i10 = this.byteOffset;
                this.byteOffset = i10 + 1;
                bArr[i4] = (byte) (b3 | ((byte) ((bArr3[i10] & 255) << i9)));
                this.bitOffset = i9 - 8;
            }
            int i11 = this.bitOffset + i8;
            this.bitOffset = i11;
            byte[] bArr4 = this.data;
            int i12 = this.byteOffset;
            bArr[i4] = (byte) (((byte) (((255 & bArr4[i12]) >> (8 - i11)) << (8 - i8))) | bArr[i4]);
            if (i11 == 8) {
                this.bitOffset = 0;
                this.byteOffset = i12 + 1;
            }
            assertValidOffset();
        }
    }
}
