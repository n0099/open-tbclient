package com.google.zxing.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes3.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.size = 0;
        this.bits = new int[1];
    }

    private void ensureCapacity(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65539, this, i2) == null) || i2 <= (this.bits.length << 5)) {
            return;
        }
        int[] makeArray = makeArray(i2);
        int[] iArr = this.bits;
        System.arraycopy(iArr, 0, makeArray, 0, iArr.length);
        this.bits = makeArray;
    }

    public static int[] makeArray(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? new int[(i2 + 31) / 32] : (int[]) invokeI.objValue;
    }

    public void appendBit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            ensureCapacity(this.size + 1);
            if (z) {
                int[] iArr = this.bits;
                int i2 = this.size;
                int i3 = i2 / 32;
                iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
            }
            this.size++;
        }
    }

    public void appendBitArray(BitArray bitArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitArray) == null) {
            int i2 = bitArray.size;
            ensureCapacity(this.size + i2);
            for (int i3 = 0; i3 < i2; i3++) {
                appendBit(bitArray.get(i3));
            }
        }
    }

    public void appendBits(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            if (i3 >= 0 && i3 <= 32) {
                ensureCapacity(this.size + i3);
                while (i3 > 0) {
                    boolean z = true;
                    if (((i2 >> (i3 - 1)) & 1) != 1) {
                        z = false;
                    }
                    appendBit(z);
                    i3--;
                }
                return;
            }
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int length = this.bits.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.bits[i2] = 0;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof BitArray) {
                BitArray bitArray = (BitArray) obj;
                return this.size == bitArray.size && Arrays.equals(this.bits, bitArray.bits);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void flip(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            int[] iArr = this.bits;
            int i3 = i2 / 32;
            iArr[i3] = (1 << (i2 & 31)) ^ iArr[i3];
        }
    }

    public boolean get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? ((1 << (i2 & 31)) & this.bits[i2 / 32]) != 0 : invokeI.booleanValue;
    }

    public int[] getBitArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.bits : (int[]) invokeV.objValue;
    }

    public int getNextSet(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            int i3 = this.size;
            if (i2 >= i3) {
                return i3;
            }
            int i4 = i2 / 32;
            int i5 = (~((1 << (i2 & 31)) - 1)) & this.bits[i4];
            while (i5 == 0) {
                i4++;
                int[] iArr = this.bits;
                if (i4 == iArr.length) {
                    return this.size;
                }
                i5 = iArr[i4];
            }
            int numberOfTrailingZeros = (i4 << 5) + Integer.numberOfTrailingZeros(i5);
            int i6 = this.size;
            return numberOfTrailingZeros > i6 ? i6 : numberOfTrailingZeros;
        }
        return invokeI.intValue;
    }

    public int getNextUnset(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            int i3 = this.size;
            if (i2 >= i3) {
                return i3;
            }
            int i4 = i2 / 32;
            int i5 = (~((1 << (i2 & 31)) - 1)) & (~this.bits[i4]);
            while (i5 == 0) {
                i4++;
                int[] iArr = this.bits;
                if (i4 == iArr.length) {
                    return this.size;
                }
                i5 = ~iArr[i4];
            }
            int numberOfTrailingZeros = (i4 << 5) + Integer.numberOfTrailingZeros(i5);
            int i6 = this.size;
            return numberOfTrailingZeros > i6 ? i6 : numberOfTrailingZeros;
        }
        return invokeI.intValue;
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.size : invokeV.intValue;
    }

    public int getSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.size + 7) / 8 : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.size * 31) + Arrays.hashCode(this.bits) : invokeV.intValue;
    }

    public boolean isRange(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (i3 < i2 || i2 < 0 || i3 > this.size) {
                throw new IllegalArgumentException();
            }
            if (i3 == i2) {
                return true;
            }
            int i4 = i3 - 1;
            int i5 = i2 / 32;
            int i6 = i4 / 32;
            int i7 = i5;
            while (i7 <= i6) {
                int i8 = (2 << (i7 >= i6 ? 31 & i4 : 31)) - (1 << (i7 > i5 ? 0 : i2 & 31));
                int i9 = this.bits[i7] & i8;
                if (!z) {
                    i8 = 0;
                }
                if (i9 != i8) {
                    return false;
                }
                i7++;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void reverse() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int[] iArr = new int[this.bits.length];
            int i2 = (this.size - 1) / 32;
            int i3 = i2 + 1;
            for (int i4 = 0; i4 < i3; i4++) {
                long j2 = this.bits[i4];
                long j3 = ((j2 & 1431655765) << 1) | ((j2 >> 1) & 1431655765);
                long j4 = ((j3 & 858993459) << 2) | ((j3 >> 2) & 858993459);
                long j5 = ((j4 & 252645135) << 4) | ((j4 >> 4) & 252645135);
                long j6 = ((j5 & 16711935) << 8) | ((j5 >> 8) & 16711935);
                iArr[i2 - i4] = (int) (((j6 & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((j6 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
            }
            int i5 = this.size;
            int i6 = i3 << 5;
            if (i5 != i6) {
                int i7 = i6 - i5;
                int i8 = iArr[0] >>> i7;
                for (int i9 = 1; i9 < i3; i9++) {
                    int i10 = iArr[i9];
                    iArr[i9 - 1] = i8 | (i10 << (32 - i7));
                    i8 = i10 >>> i7;
                }
                iArr[i3 - 1] = i8;
            }
            this.bits = iArr;
        }
    }

    public void set(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            int[] iArr = this.bits;
            int i3 = i2 / 32;
            iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
        }
    }

    public void setBulk(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i2, i3) == null) {
            this.bits[i2 / 32] = i3;
        }
    }

    public void setRange(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i2, i3) == null) {
            if (i3 < i2 || i2 < 0 || i3 > this.size) {
                throw new IllegalArgumentException();
            }
            if (i3 == i2) {
                return;
            }
            int i4 = i3 - 1;
            int i5 = i2 / 32;
            int i6 = i4 / 32;
            int i7 = i5;
            while (i7 <= i6) {
                int i8 = 31;
                int i9 = i7 > i5 ? 0 : i2 & 31;
                if (i7 >= i6) {
                    i8 = 31 & i4;
                }
                int i10 = (2 << i8) - (1 << i9);
                int[] iArr = this.bits;
                iArr[i7] = i10 | iArr[i7];
                i7++;
            }
        }
    }

    public void toBytes(int i2, byte[] bArr, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = 0;
                for (int i7 = 0; i7 < 8; i7++) {
                    if (get(i2)) {
                        i6 |= 1 << (7 - i7);
                    }
                    i2++;
                }
                bArr[i3 + i5] = (byte) i6;
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder(this.size);
            for (int i2 = 0; i2 < this.size; i2++) {
                if ((i2 & 7) == 0) {
                    sb.append(' ');
                }
                sb.append(get(i2) ? 'X' : '.');
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void xor(BitArray bitArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048598, this, bitArray) != null) {
            return;
        }
        if (this.size != bitArray.size) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.bits;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = iArr[i2] ^ bitArray.bits[i2];
            i2++;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public BitArray m120clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new BitArray((int[]) this.bits.clone(), this.size) : (BitArray) invokeV.objValue;
    }

    public BitArray(int i2) {
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
        this.size = i2;
        this.bits = makeArray(i2);
    }

    public BitArray(int[] iArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iArr, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.bits = iArr;
        this.size = i2;
    }
}
