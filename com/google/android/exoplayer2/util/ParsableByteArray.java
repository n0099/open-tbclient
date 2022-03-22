package com.google.android.exoplayer2.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public final class ParsableByteArray {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] data;
    public int limit;
    public int position;

    public ParsableByteArray() {
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

    public int bytesLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.limit - this.position : invokeV.intValue;
    }

    public int capacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            byte[] bArr = this.data;
            if (bArr == null) {
                return 0;
            }
            return bArr.length;
        }
        return invokeV.intValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.position : invokeV.intValue;
    }

    public int limit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.limit : invokeV.intValue;
    }

    public char peekChar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            byte[] bArr = this.data;
            int i = this.position;
            return (char) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
        }
        return invokeV.charValue;
    }

    public int peekUnsignedByte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.data[this.position] & 255 : invokeV.intValue;
    }

    public void readBytes(ParsableBitArray parsableBitArray, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, parsableBitArray, i) == null) {
            readBytes(parsableBitArray.data, 0, i);
            parsableBitArray.setPosition(0);
        }
    }

    public double readDouble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Double.longBitsToDouble(readLong()) : invokeV.doubleValue;
    }

    public float readFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? Float.intBitsToFloat(readInt()) : invokeV.floatValue;
    }

    public int readInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            byte[] bArr = this.data;
            int i = this.position;
            int i2 = i + 1;
            this.position = i2;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16);
            int i5 = i3 + 1;
            this.position = i5;
            int i6 = i4 | ((bArr[i3] & 255) << 8);
            this.position = i5 + 1;
            return (bArr[i5] & 255) | i6;
        }
        return invokeV.intValue;
    }

    public int readInt24() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            byte[] bArr = this.data;
            int i = this.position;
            int i2 = i + 1;
            this.position = i2;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = (((bArr[i] & 255) << 24) >> 8) | ((bArr[i2] & 255) << 8);
            this.position = i3 + 1;
            return (bArr[i3] & 255) | i4;
        }
        return invokeV.intValue;
    }

    public String readLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (bytesLeft() == 0) {
                return null;
            }
            int i = this.position;
            while (i < this.limit && !Util.isLinebreak(this.data[i])) {
                i++;
            }
            int i2 = this.position;
            if (i - i2 >= 3) {
                byte[] bArr = this.data;
                if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                    this.position = i2 + 3;
                }
            }
            byte[] bArr2 = this.data;
            int i3 = this.position;
            String str = new String(bArr2, i3, i - i3);
            this.position = i;
            int i4 = this.limit;
            if (i == i4) {
                return str;
            }
            if (this.data[i] == 13) {
                int i5 = i + 1;
                this.position = i5;
                if (i5 == i4) {
                    return str;
                }
            }
            byte[] bArr3 = this.data;
            int i6 = this.position;
            if (bArr3[i6] == 10) {
                this.position = i6 + 1;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public int readLittleEndianInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            byte[] bArr = this.data;
            int i = this.position;
            int i2 = i + 1;
            this.position = i2;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
            int i5 = i3 + 1;
            this.position = i5;
            int i6 = i4 | ((bArr[i3] & 255) << 16);
            this.position = i5 + 1;
            return ((bArr[i5] & 255) << 24) | i6;
        }
        return invokeV.intValue;
    }

    public int readLittleEndianInt24() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            byte[] bArr = this.data;
            int i = this.position;
            int i2 = i + 1;
            this.position = i2;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
            this.position = i3 + 1;
            return ((bArr[i3] & 255) << 16) | i4;
        }
        return invokeV.intValue;
    }

    public long readLittleEndianLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            byte[] bArr = this.data;
            int i = this.position;
            int i2 = i + 1;
            this.position = i2;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = i3 + 1;
            this.position = i4;
            int i5 = i4 + 1;
            this.position = i5;
            int i6 = i5 + 1;
            this.position = i6;
            int i7 = i6 + 1;
            this.position = i7;
            int i8 = i7 + 1;
            this.position = i8;
            this.position = i8 + 1;
            return (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 24) | ((bArr[i5] & 255) << 32) | ((bArr[i6] & 255) << 40) | ((bArr[i7] & 255) << 48) | ((bArr[i8] & 255) << 56);
        }
        return invokeV.longValue;
    }

    public short readLittleEndianShort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            byte[] bArr = this.data;
            int i = this.position;
            int i2 = i + 1;
            this.position = i2;
            this.position = i2 + 1;
            return (short) (((bArr[i2] & 255) << 8) | (bArr[i] & 255));
        }
        return invokeV.shortValue;
    }

    public long readLittleEndianUnsignedInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            byte[] bArr = this.data;
            int i = this.position;
            int i2 = i + 1;
            this.position = i2;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = i3 + 1;
            this.position = i4;
            this.position = i4 + 1;
            return (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 24);
        }
        return invokeV.longValue;
    }

    public int readLittleEndianUnsignedInt24() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            byte[] bArr = this.data;
            int i = this.position;
            int i2 = i + 1;
            this.position = i2;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
            this.position = i3 + 1;
            return ((bArr[i3] & 255) << 16) | i4;
        }
        return invokeV.intValue;
    }

    public int readLittleEndianUnsignedIntToInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int readLittleEndianInt = readLittleEndianInt();
            if (readLittleEndianInt >= 0) {
                return readLittleEndianInt;
            }
            throw new IllegalStateException("Top bit not zero: " + readLittleEndianInt);
        }
        return invokeV.intValue;
    }

    public int readLittleEndianUnsignedShort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            byte[] bArr = this.data;
            int i = this.position;
            int i2 = i + 1;
            this.position = i2;
            this.position = i2 + 1;
            return ((bArr[i2] & 255) << 8) | (bArr[i] & 255);
        }
        return invokeV.intValue;
    }

    public long readLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            byte[] bArr = this.data;
            int i = this.position;
            int i2 = i + 1;
            this.position = i2;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = i3 + 1;
            this.position = i4;
            int i5 = i4 + 1;
            this.position = i5;
            int i6 = i5 + 1;
            this.position = i6;
            int i7 = i6 + 1;
            this.position = i7;
            int i8 = i7 + 1;
            this.position = i8;
            this.position = i8 + 1;
            return ((bArr[i] & 255) << 56) | ((bArr[i2] & 255) << 48) | ((bArr[i3] & 255) << 40) | ((bArr[i4] & 255) << 32) | ((bArr[i5] & 255) << 24) | ((bArr[i6] & 255) << 16) | ((bArr[i7] & 255) << 8) | (bArr[i8] & 255);
        }
        return invokeV.longValue;
    }

    public String readNullTerminatedString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            if (i == 0) {
                return "";
            }
            int i2 = (this.position + i) - 1;
            String str = new String(this.data, this.position, (i2 >= this.limit || this.data[i2] != 0) ? i : i - 1);
            this.position += i;
            return str;
        }
        return (String) invokeI.objValue;
    }

    public short readShort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            byte[] bArr = this.data;
            int i = this.position;
            int i2 = i + 1;
            this.position = i2;
            this.position = i2 + 1;
            return (short) ((bArr[i2] & 255) | ((bArr[i] & 255) << 8));
        }
        return invokeV.shortValue;
    }

    public String readString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) ? readString(i, Charset.forName("UTF-8")) : (String) invokeI.objValue;
    }

    public int readSynchSafeInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? (readUnsignedByte() << 21) | (readUnsignedByte() << 14) | (readUnsignedByte() << 7) | readUnsignedByte() : invokeV.intValue;
    }

    public int readUnsignedByte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            byte[] bArr = this.data;
            int i = this.position;
            this.position = i + 1;
            return bArr[i] & 255;
        }
        return invokeV.intValue;
    }

    public int readUnsignedFixedPoint1616() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            byte[] bArr = this.data;
            int i = this.position;
            int i2 = i + 1;
            this.position = i2;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
            this.position = i3 + 2;
            return i4;
        }
        return invokeV.intValue;
    }

    public long readUnsignedInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            byte[] bArr = this.data;
            int i = this.position;
            int i2 = i + 1;
            this.position = i2;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = i3 + 1;
            this.position = i4;
            this.position = i4 + 1;
            return ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8) | (bArr[i4] & 255);
        }
        return invokeV.longValue;
    }

    public int readUnsignedInt24() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            byte[] bArr = this.data;
            int i = this.position;
            int i2 = i + 1;
            this.position = i2;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = ((bArr[i] & 255) << 16) | ((bArr[i2] & 255) << 8);
            this.position = i3 + 1;
            return (bArr[i3] & 255) | i4;
        }
        return invokeV.intValue;
    }

    public int readUnsignedIntToInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            int readInt = readInt();
            if (readInt >= 0) {
                return readInt;
            }
            throw new IllegalStateException("Top bit not zero: " + readInt);
        }
        return invokeV.intValue;
    }

    public long readUnsignedLongToLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            long readLong = readLong();
            if (readLong >= 0) {
                return readLong;
            }
            throw new IllegalStateException("Top bit not zero: " + readLong);
        }
        return invokeV.longValue;
    }

    public int readUnsignedShort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            byte[] bArr = this.data;
            int i = this.position;
            int i2 = i + 1;
            this.position = i2;
            this.position = i2 + 1;
            return (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
        }
        return invokeV.intValue;
    }

    public long readUtf8EncodedLong() {
        InterceptResult invokeV;
        int i;
        int i2;
        byte b2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            long j = this.data[this.position];
            int i4 = 7;
            while (true) {
                if (i4 < 0) {
                    break;
                }
                if (((1 << i4) & j) != 0) {
                    i4--;
                } else if (i4 < 6) {
                    j &= i3 - 1;
                    i2 = 7 - i4;
                } else if (i4 == 7) {
                    i2 = 1;
                }
            }
            i2 = 0;
            if (i2 != 0) {
                for (i = 1; i < i2; i++) {
                    if ((this.data[this.position + i] & 192) != 128) {
                        throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
                    }
                    j = (j << 6) | (b2 & 63);
                }
                this.position += i2;
                return j;
            }
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
        }
        return invokeV.longValue;
    }

    public void reset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            reset(capacity() < i ? new byte[i] : this.data, i);
        }
    }

    public void setLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            Assertions.checkArgument(i >= 0 && i <= this.data.length);
            this.limit = i;
        }
    }

    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            Assertions.checkArgument(i >= 0 && i <= this.limit);
            this.position = i;
        }
    }

    public void skipBytes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            setPosition(this.position + i);
        }
    }

    public ParsableByteArray(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.data = new byte[i];
        this.limit = i;
    }

    public String readString(int i, Charset charset) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048603, this, i, charset)) == null) {
            String str = new String(this.data, this.position, i, charset);
            this.position += i;
            return str;
        }
        return (String) invokeIL.objValue;
    }

    public void reset(byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048615, this, bArr, i) == null) {
            this.data = bArr;
            this.limit = i;
            this.position = 0;
        }
    }

    public void readBytes(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i, i2) == null) {
            System.arraycopy(this.data, this.position, bArr, i, i2);
            this.position += i2;
        }
    }

    public ParsableByteArray(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.data = bArr;
        this.limit = bArr.length;
    }

    public void readBytes(ByteBuffer byteBuffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, byteBuffer, i) == null) {
            byteBuffer.put(this.data, this.position, i);
            this.position += i;
        }
    }

    public String readNullTerminatedString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (bytesLeft() == 0) {
                return null;
            }
            int i = this.position;
            while (i < this.limit && this.data[i] != 0) {
                i++;
            }
            byte[] bArr = this.data;
            int i2 = this.position;
            String str = new String(bArr, i2, i - i2);
            this.position = i;
            if (i < this.limit) {
                this.position = i + 1;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.position = 0;
            this.limit = 0;
        }
    }

    public ParsableByteArray(byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.data = bArr;
        this.limit = i;
    }
}
