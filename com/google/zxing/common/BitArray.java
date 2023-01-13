package com.google.zxing.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes8.dex */
public final class BitArray implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] bits;
    public int size;

    public BitArray() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.size = 0;
        this.bits = new int[1];
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int length = this.bits.length;
            for (int i = 0; i < length; i++) {
                this.bits[i] = 0;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public BitArray m84clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new BitArray((int[]) this.bits.clone(), this.size);
        }
        return (BitArray) invokeV.objValue;
    }

    public int[] getBitArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.bits;
        }
        return (int[]) invokeV.objValue;
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.size;
        }
        return invokeV.intValue;
    }

    public int getSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return (this.size + 7) / 8;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return (this.size * 31) + Arrays.hashCode(this.bits);
        }
        return invokeV.intValue;
    }

    public BitArray(int i) {
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
        this.size = i;
        this.bits = makeArray(i);
    }

    public int getNextSet(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            int i2 = this.size;
            if (i >= i2) {
                return i2;
            }
            int i3 = i / 32;
            int i4 = (~((1 << (i & 31)) - 1)) & this.bits[i3];
            while (i4 == 0) {
                i3++;
                int[] iArr = this.bits;
                if (i3 == iArr.length) {
                    return this.size;
                }
                i4 = iArr[i3];
            }
            int numberOfTrailingZeros = (i3 << 5) + Integer.numberOfTrailingZeros(i4);
            int i5 = this.size;
            if (numberOfTrailingZeros > i5) {
                return i5;
            }
            return numberOfTrailingZeros;
        }
        return invokeI.intValue;
    }

    public int getNextUnset(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            int i2 = this.size;
            if (i >= i2) {
                return i2;
            }
            int i3 = i / 32;
            int i4 = (~((1 << (i & 31)) - 1)) & (~this.bits[i3]);
            while (i4 == 0) {
                i3++;
                int[] iArr = this.bits;
                if (i3 == iArr.length) {
                    return this.size;
                }
                i4 = ~iArr[i3];
            }
            int numberOfTrailingZeros = (i3 << 5) + Integer.numberOfTrailingZeros(i4);
            int i5 = this.size;
            if (numberOfTrailingZeros > i5) {
                return i5;
            }
            return numberOfTrailingZeros;
        }
        return invokeI.intValue;
    }

    public BitArray(int[] iArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iArr, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.bits = iArr;
        this.size = i;
    }

    public void appendBits(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            if (i2 >= 0 && i2 <= 32) {
                ensureCapacity(this.size + i2);
                while (i2 > 0) {
                    boolean z = true;
                    if (((i >> (i2 - 1)) & 1) != 1) {
                        z = false;
                    }
                    appendBit(z);
                    i2--;
                }
                return;
            }
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
    }

    private void ensureCapacity(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65539, this, i) == null) && i > (this.bits.length << 5)) {
            int[] makeArray = makeArray(i);
            int[] iArr = this.bits;
            System.arraycopy(iArr, 0, makeArray, 0, iArr.length);
            this.bits = makeArray;
        }
    }

    public static int[] makeArray(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            return new int[(i + 31) / 32];
        }
        return (int[]) invokeI.objValue;
    }

    public void appendBit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            ensureCapacity(this.size + 1);
            if (z) {
                int[] iArr = this.bits;
                int i = this.size;
                int i2 = i / 32;
                iArr[i2] = (1 << (i & 31)) | iArr[i2];
            }
            this.size++;
        }
    }

    public void appendBitArray(BitArray bitArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitArray) == null) {
            int i = bitArray.size;
            ensureCapacity(this.size + i);
            for (int i2 = 0; i2 < i; i2++) {
                appendBit(bitArray.get(i2));
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (!(obj instanceof BitArray)) {
                return false;
            }
            BitArray bitArray = (BitArray) obj;
            if (this.size != bitArray.size || !Arrays.equals(this.bits, bitArray.bits)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void flip(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            int[] iArr = this.bits;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) ^ iArr[i2];
        }
    }

    public boolean get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (((1 << (i & 31)) & this.bits[i / 32]) != 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void set(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            int[] iArr = this.bits;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
    }

    public void xor(BitArray bitArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bitArray) == null) {
            if (this.size == bitArray.size) {
                int i = 0;
                while (true) {
                    int[] iArr = this.bits;
                    if (i < iArr.length) {
                        iArr[i] = iArr[i] ^ bitArray.bits[i];
                        i++;
                    } else {
                        return;
                    }
                }
            } else {
                throw new IllegalArgumentException("Sizes don't match");
            }
        }
    }

    public boolean isRange(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 >= i && i >= 0 && i2 <= this.size) {
                if (i2 == i) {
                    return true;
                }
                int i4 = i2 - 1;
                int i5 = i / 32;
                int i6 = i4 / 32;
                for (int i7 = i5; i7 <= i6; i7++) {
                    int i8 = 31;
                    if (i7 > i5) {
                        i3 = 0;
                    } else {
                        i3 = i & 31;
                    }
                    if (i7 >= i6) {
                        i8 = 31 & i4;
                    }
                    int i9 = (2 << i8) - (1 << i3);
                    int i10 = this.bits[i7] & i9;
                    if (!z) {
                        i9 = 0;
                    }
                    if (i10 != i9) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
        return invokeCommon.booleanValue;
    }

    public void reverse() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int[] iArr = new int[this.bits.length];
            int i = (this.size - 1) / 32;
            int i2 = i + 1;
            for (int i3 = 0; i3 < i2; i3++) {
                long j = this.bits[i3];
                long j2 = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
                long j3 = ((j2 & 858993459) << 2) | ((j2 >> 2) & 858993459);
                long j4 = ((j3 & 252645135) << 4) | ((j3 >> 4) & 252645135);
                long j5 = ((j4 & 16711935) << 8) | ((j4 >> 8) & 16711935);
                iArr[i - i3] = (int) (((j5 & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((j5 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
            }
            int i4 = this.size;
            int i5 = i2 << 5;
            if (i4 != i5) {
                int i6 = i5 - i4;
                int i7 = iArr[0] >>> i6;
                for (int i8 = 1; i8 < i2; i8++) {
                    int i9 = iArr[i8];
                    iArr[i8 - 1] = i7 | (i9 << (32 - i6));
                    i7 = i9 >>> i6;
                }
                iArr[i2 - 1] = i7;
            }
            this.bits = iArr;
        }
    }

    public void setBulk(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i, i2) == null) {
            this.bits[i / 32] = i2;
        }
    }

    public void setRange(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i, i2) == null) {
            if (i2 >= i && i >= 0 && i2 <= this.size) {
                if (i2 == i) {
                    return;
                }
                int i4 = i2 - 1;
                int i5 = i / 32;
                int i6 = i4 / 32;
                for (int i7 = i5; i7 <= i6; i7++) {
                    int i8 = 31;
                    if (i7 > i5) {
                        i3 = 0;
                    } else {
                        i3 = i & 31;
                    }
                    if (i7 >= i6) {
                        i8 = 31 & i4;
                    }
                    int i9 = (2 << i8) - (1 << i3);
                    int[] iArr = this.bits;
                    iArr[i7] = i9 | iArr[i7];
                }
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public void toBytes(int i, byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), bArr, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = 0;
                for (int i6 = 0; i6 < 8; i6++) {
                    if (get(i)) {
                        i5 |= 1 << (7 - i6);
                    }
                    i++;
                }
                bArr[i2 + i4] = (byte) i5;
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder(this.size);
            for (int i = 0; i < this.size; i++) {
                if ((i & 7) == 0) {
                    sb.append(WebvttCueParser.CHAR_SPACE);
                }
                if (get(i)) {
                    c = 'X';
                } else {
                    c = IStringUtil.EXTENSION_SEPARATOR;
                }
                sb.append(c);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
