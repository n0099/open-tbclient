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
/* loaded from: classes7.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = this.position;
            return (char) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
        }
        return invokeV.charValue;
    }

    public int peekUnsignedByte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.data[this.position] & 255 : invokeV.intValue;
    }

    public void readBytes(ParsableBitArray parsableBitArray, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, parsableBitArray, i2) == null) {
            readBytes(parsableBitArray.data, 0, i2);
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
            int i2 = this.position;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = i3 + 1;
            this.position = i4;
            int i5 = ((bArr[i2] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i6 = i4 + 1;
            this.position = i6;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            this.position = i6 + 1;
            return (bArr[i6] & 255) | i7;
        }
        return invokeV.intValue;
    }

    public int readInt24() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            byte[] bArr = this.data;
            int i2 = this.position;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = i3 + 1;
            this.position = i4;
            int i5 = (((bArr[i2] & 255) << 24) >> 8) | ((bArr[i3] & 255) << 8);
            this.position = i4 + 1;
            return (bArr[i4] & 255) | i5;
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
            int i2 = this.position;
            while (i2 < this.limit && !Util.isLinebreak(this.data[i2])) {
                i2++;
            }
            int i3 = this.position;
            if (i2 - i3 >= 3) {
                byte[] bArr = this.data;
                if (bArr[i3] == -17 && bArr[i3 + 1] == -69 && bArr[i3 + 2] == -65) {
                    this.position = i3 + 3;
                }
            }
            byte[] bArr2 = this.data;
            int i4 = this.position;
            String str = new String(bArr2, i4, i2 - i4);
            this.position = i2;
            int i5 = this.limit;
            if (i2 == i5) {
                return str;
            }
            if (this.data[i2] == 13) {
                int i6 = i2 + 1;
                this.position = i6;
                if (i6 == i5) {
                    return str;
                }
            }
            byte[] bArr3 = this.data;
            int i7 = this.position;
            if (bArr3[i7] == 10) {
                this.position = i7 + 1;
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
            int i2 = this.position;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = i3 + 1;
            this.position = i4;
            int i5 = (bArr[i2] & 255) | ((bArr[i3] & 255) << 8);
            int i6 = i4 + 1;
            this.position = i6;
            int i7 = i5 | ((bArr[i4] & 255) << 16);
            this.position = i6 + 1;
            return ((bArr[i6] & 255) << 24) | i7;
        }
        return invokeV.intValue;
    }

    public int readLittleEndianInt24() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            byte[] bArr = this.data;
            int i2 = this.position;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = i3 + 1;
            this.position = i4;
            int i5 = (bArr[i2] & 255) | ((bArr[i3] & 255) << 8);
            this.position = i4 + 1;
            return ((bArr[i4] & 255) << 16) | i5;
        }
        return invokeV.intValue;
    }

    public long readLittleEndianLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            byte[] bArr = this.data;
            int i2 = this.position;
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
            int i9 = i8 + 1;
            this.position = i9;
            this.position = i9 + 1;
            return (bArr[i2] & 255) | ((bArr[i3] & 255) << 8) | ((bArr[i4] & 255) << 16) | ((bArr[i5] & 255) << 24) | ((bArr[i6] & 255) << 32) | ((bArr[i7] & 255) << 40) | ((bArr[i8] & 255) << 48) | ((bArr[i9] & 255) << 56);
        }
        return invokeV.longValue;
    }

    public short readLittleEndianShort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            byte[] bArr = this.data;
            int i2 = this.position;
            int i3 = i2 + 1;
            this.position = i3;
            this.position = i3 + 1;
            return (short) (((bArr[i3] & 255) << 8) | (bArr[i2] & 255));
        }
        return invokeV.shortValue;
    }

    public long readLittleEndianUnsignedInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            byte[] bArr = this.data;
            int i2 = this.position;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = i3 + 1;
            this.position = i4;
            int i5 = i4 + 1;
            this.position = i5;
            this.position = i5 + 1;
            return (bArr[i2] & 255) | ((bArr[i3] & 255) << 8) | ((bArr[i4] & 255) << 16) | ((bArr[i5] & 255) << 24);
        }
        return invokeV.longValue;
    }

    public int readLittleEndianUnsignedInt24() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            byte[] bArr = this.data;
            int i2 = this.position;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = i3 + 1;
            this.position = i4;
            int i5 = (bArr[i2] & 255) | ((bArr[i3] & 255) << 8);
            this.position = i4 + 1;
            return ((bArr[i4] & 255) << 16) | i5;
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
            int i2 = this.position;
            int i3 = i2 + 1;
            this.position = i3;
            this.position = i3 + 1;
            return ((bArr[i3] & 255) << 8) | (bArr[i2] & 255);
        }
        return invokeV.intValue;
    }

    public long readLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            byte[] bArr = this.data;
            int i2 = this.position;
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
            int i9 = i8 + 1;
            this.position = i9;
            this.position = i9 + 1;
            return ((bArr[i2] & 255) << 56) | ((bArr[i3] & 255) << 48) | ((bArr[i4] & 255) << 40) | ((bArr[i5] & 255) << 32) | ((bArr[i6] & 255) << 24) | ((bArr[i7] & 255) << 16) | ((bArr[i8] & 255) << 8) | (bArr[i9] & 255);
        }
        return invokeV.longValue;
    }

    public String readNullTerminatedString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            if (i2 == 0) {
                return "";
            }
            int i3 = (this.position + i2) - 1;
            String str = new String(this.data, this.position, (i3 >= this.limit || this.data[i3] != 0) ? i2 : i2 - 1);
            this.position += i2;
            return str;
        }
        return (String) invokeI.objValue;
    }

    public short readShort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            byte[] bArr = this.data;
            int i2 = this.position;
            int i3 = i2 + 1;
            this.position = i3;
            this.position = i3 + 1;
            return (short) ((bArr[i3] & 255) | ((bArr[i2] & 255) << 8));
        }
        return invokeV.shortValue;
    }

    public String readString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) ? readString(i2, Charset.forName("UTF-8")) : (String) invokeI.objValue;
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
            int i2 = this.position;
            this.position = i2 + 1;
            return bArr[i2] & 255;
        }
        return invokeV.intValue;
    }

    public int readUnsignedFixedPoint1616() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            byte[] bArr = this.data;
            int i2 = this.position;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = i3 + 1;
            this.position = i4;
            int i5 = (bArr[i3] & 255) | ((bArr[i2] & 255) << 8);
            this.position = i4 + 2;
            return i5;
        }
        return invokeV.intValue;
    }

    public long readUnsignedInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            byte[] bArr = this.data;
            int i2 = this.position;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = i3 + 1;
            this.position = i4;
            int i5 = i4 + 1;
            this.position = i5;
            this.position = i5 + 1;
            return ((bArr[i2] & 255) << 24) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
        }
        return invokeV.longValue;
    }

    public int readUnsignedInt24() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            byte[] bArr = this.data;
            int i2 = this.position;
            int i3 = i2 + 1;
            this.position = i3;
            int i4 = i3 + 1;
            this.position = i4;
            int i5 = ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
            this.position = i4 + 1;
            return (bArr[i4] & 255) | i5;
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
            int i2 = this.position;
            int i3 = i2 + 1;
            this.position = i3;
            this.position = i3 + 1;
            return (bArr[i3] & 255) | ((bArr[i2] & 255) << 8);
        }
        return invokeV.intValue;
    }

    public long readUtf8EncodedLong() {
        InterceptResult invokeV;
        int i2;
        int i3;
        byte b2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            long j2 = this.data[this.position];
            int i5 = 7;
            while (true) {
                if (i5 < 0) {
                    break;
                }
                if (((1 << i5) & j2) != 0) {
                    i5--;
                } else if (i5 < 6) {
                    j2 &= i4 - 1;
                    i3 = 7 - i5;
                } else if (i5 == 7) {
                    i3 = 1;
                }
            }
            i3 = 0;
            if (i3 != 0) {
                for (i2 = 1; i2 < i3; i2++) {
                    if ((this.data[this.position + i2] & 192) != 128) {
                        throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j2);
                    }
                    j2 = (j2 << 6) | (b2 & 63);
                }
                this.position += i3;
                return j2;
            }
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j2);
        }
        return invokeV.longValue;
    }

    public void reset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            reset(capacity() < i2 ? new byte[i2] : this.data, i2);
        }
    }

    public void setLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            Assertions.checkArgument(i2 >= 0 && i2 <= this.data.length);
            this.limit = i2;
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            Assertions.checkArgument(i2 >= 0 && i2 <= this.limit);
            this.position = i2;
        }
    }

    public void skipBytes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            setPosition(this.position + i2);
        }
    }

    public ParsableByteArray(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.data = new byte[i2];
        this.limit = i2;
    }

    public String readString(int i2, Charset charset) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048603, this, i2, charset)) == null) {
            String str = new String(this.data, this.position, i2, charset);
            this.position += i2;
            return str;
        }
        return (String) invokeIL.objValue;
    }

    public void reset(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048615, this, bArr, i2) == null) {
            this.data = bArr;
            this.limit = i2;
            this.position = 0;
        }
    }

    public void readBytes(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3) == null) {
            System.arraycopy(this.data, this.position, bArr, i2, i3);
            this.position += i3;
        }
    }

    public ParsableByteArray(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
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
        this.limit = bArr.length;
    }

    public void readBytes(ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, byteBuffer, i2) == null) {
            byteBuffer.put(this.data, this.position, i2);
            this.position += i2;
        }
    }

    public String readNullTerminatedString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (bytesLeft() == 0) {
                return null;
            }
            int i2 = this.position;
            while (i2 < this.limit && this.data[i2] != 0) {
                i2++;
            }
            byte[] bArr = this.data;
            int i3 = this.position;
            String str = new String(bArr, i3, i2 - i3);
            this.position = i2;
            if (i2 < this.limit) {
                this.position = i2 + 1;
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

    public ParsableByteArray(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.data = bArr;
        this.limit = i2;
    }
}
