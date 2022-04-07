package com.google.android.exoplayer2.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void assertValidOffset() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            int i2 = this.byteOffset;
            Assertions.checkState(i2 >= 0 && (i2 < (i = this.byteLimit) || (i2 == i && this.bitOffset == 0)));
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

    public int readBits(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i == 0) {
                return 0;
            }
            this.bitOffset += i;
            int i3 = 0;
            while (true) {
                i2 = this.bitOffset;
                if (i2 <= 8) {
                    break;
                }
                int i4 = i2 - 8;
                this.bitOffset = i4;
                byte[] bArr = this.data;
                int i5 = this.byteOffset;
                this.byteOffset = i5 + 1;
                i3 |= (bArr[i5] & 255) << i4;
            }
            byte[] bArr2 = this.data;
            int i6 = this.byteOffset;
            int i7 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i6] & 255) >> (8 - i2)));
            if (i2 == 8) {
                this.bitOffset = 0;
                this.byteOffset = i6 + 1;
            }
            assertValidOffset();
            return i7;
        }
        return invokeI.intValue;
    }

    public void readBytes(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, bArr, i, i2) == null) {
            Assertions.checkState(this.bitOffset == 0);
            System.arraycopy(this.data, this.byteOffset, bArr, i, i2);
            this.byteOffset += i2;
            assertValidOffset();
        }
    }

    public void reset(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bArr) == null) {
            reset(bArr, bArr.length);
        }
    }

    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            int i2 = i / 8;
            this.byteOffset = i2;
            this.bitOffset = i - (i2 * 8);
            assertValidOffset();
        }
    }

    public void skipBit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int i = this.bitOffset + 1;
            this.bitOffset = i;
            if (i == 8) {
                this.bitOffset = 0;
                this.byteOffset++;
            }
            assertValidOffset();
        }
    }

    public void skipBits(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
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

    public void skipBytes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            Assertions.checkState(this.bitOffset == 0);
            this.byteOffset += i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public ParsableBitArray(byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.data = bArr;
        this.byteLimit = i;
    }

    public void reset(byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, bArr, i) == null) {
            this.data = bArr;
            this.byteOffset = 0;
            this.bitOffset = 0;
            this.byteLimit = i;
        }
    }

    public void readBits(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i, i2) == null) {
            int i3 = (i2 >> 3) + i;
            while (i < i3) {
                byte[] bArr2 = this.data;
                int i4 = this.byteOffset;
                int i5 = i4 + 1;
                this.byteOffset = i5;
                byte b = bArr2[i4];
                int i6 = this.bitOffset;
                bArr[i] = (byte) (b << i6);
                bArr[i] = (byte) (((255 & bArr2[i5]) >> (8 - i6)) | bArr[i]);
                i++;
            }
            int i7 = i2 & 7;
            if (i7 == 0) {
                return;
            }
            bArr[i3] = (byte) (bArr[i3] & (255 >> i7));
            int i8 = this.bitOffset;
            if (i8 + i7 > 8) {
                byte b2 = bArr[i3];
                byte[] bArr3 = this.data;
                int i9 = this.byteOffset;
                this.byteOffset = i9 + 1;
                bArr[i3] = (byte) (b2 | ((byte) ((bArr3[i9] & 255) << i8)));
                this.bitOffset = i8 - 8;
            }
            int i10 = this.bitOffset + i7;
            this.bitOffset = i10;
            byte[] bArr4 = this.data;
            int i11 = this.byteOffset;
            bArr[i3] = (byte) (((byte) (((255 & bArr4[i11]) >> (8 - i10)) << (8 - i7))) | bArr[i3]);
            if (i10 == 8) {
                this.bitOffset = 0;
                this.byteOffset = i11 + 1;
            }
            assertValidOffset();
        }
    }
}
