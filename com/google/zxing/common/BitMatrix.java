package com.google.zxing.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class BitMatrix implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] bits;
    public final int height;
    public final int rowSize;
    public final int width;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BitMatrix(int i) {
        this(i, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void xor(BitMatrix bitMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bitMatrix) == null) {
            if (this.width == bitMatrix.getWidth() && this.height == bitMatrix.getHeight() && this.rowSize == bitMatrix.getRowSize()) {
                BitArray bitArray = new BitArray((this.width / 32) + 1);
                for (int i = 0; i < this.height; i++) {
                    int i2 = this.rowSize * i;
                    int[] bitArray2 = bitMatrix.getRow(i, bitArray).getBitArray();
                    for (int i3 = 0; i3 < this.rowSize; i3++) {
                        int[] iArr = this.bits;
                        int i4 = i2 + i3;
                        iArr[i4] = iArr[i4] ^ bitArray2[i3];
                    }
                }
                return;
            }
            throw new IllegalArgumentException("input matrix dimensions do not match");
        }
    }

    public BitMatrix(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i > 0 && i2 > 0) {
            this.width = i;
            this.height = i2;
            int i5 = (i + 31) / 32;
            this.rowSize = i5;
            this.bits = new int[i5 * i2];
            return;
        }
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    public BitMatrix(int i, int i2, int i3, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.width = i;
        this.height = i2;
        this.rowSize = i3;
        this.bits = iArr;
    }

    public void setRegion(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048592, this, i, i2, i3, i4) == null) {
            if (i2 >= 0 && i >= 0) {
                if (i4 > 0 && i3 > 0) {
                    int i5 = i3 + i;
                    int i6 = i4 + i2;
                    if (i6 <= this.height && i5 <= this.width) {
                        while (i2 < i6) {
                            int i7 = this.rowSize * i2;
                            for (int i8 = i; i8 < i5; i8++) {
                                int[] iArr = this.bits;
                                int i9 = (i8 / 32) + i7;
                                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                            }
                            i2++;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("The region must fit inside the matrix");
                }
                throw new IllegalArgumentException("Height and width must be at least 1");
            }
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
    }

    private String buildToString(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, str, str2, str3)) == null) {
            StringBuilder sb = new StringBuilder(this.height * (this.width + 1));
            for (int i = 0; i < this.height; i++) {
                for (int i2 = 0; i2 < this.width; i2++) {
                    if (get(i2, i)) {
                        str4 = str;
                    } else {
                        str4 = str2;
                    }
                    sb.append(str4);
                }
                sb.append(str3);
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static BitMatrix parse(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3)) == null) {
            if (str != null) {
                boolean[] zArr = new boolean[str.length()];
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = -1;
                int i5 = 0;
                while (i < str.length()) {
                    if (str.charAt(i) != '\n' && str.charAt(i) != '\r') {
                        if (str.substring(i, str2.length() + i).equals(str2)) {
                            i += str2.length();
                            zArr[i2] = true;
                        } else if (str.substring(i, str3.length() + i).equals(str3)) {
                            i += str3.length();
                            zArr[i2] = false;
                        } else {
                            throw new IllegalArgumentException("illegal character encountered: " + str.substring(i));
                        }
                        i2++;
                    } else {
                        if (i2 > i3) {
                            if (i4 == -1) {
                                i4 = i2 - i3;
                            } else if (i2 - i3 != i4) {
                                throw new IllegalArgumentException("row lengths do not match");
                            }
                            i5++;
                            i3 = i2;
                        }
                        i++;
                    }
                }
                if (i2 > i3) {
                    if (i4 == -1) {
                        i4 = i2 - i3;
                    } else if (i2 - i3 != i4) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i5++;
                }
                BitMatrix bitMatrix = new BitMatrix(i4, i5);
                for (int i6 = 0; i6 < i2; i6++) {
                    if (zArr[i6]) {
                        bitMatrix.set(i6 % i4, i6 / i4);
                    }
                }
                return bitMatrix;
            }
            throw new IllegalArgumentException();
        }
        return (BitMatrix) invokeLLL.objValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int length = this.bits.length;
            for (int i = 0; i < length; i++) {
                this.bits[i] = 0;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public BitMatrix m80clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone());
        }
        return (BitMatrix) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.height;
        }
        return invokeV.intValue;
    }

    public int getRowSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.rowSize;
        }
        return invokeV.intValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.width;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int i = this.width;
            return (((((((i * 31) + i) * 31) + this.height) * 31) + this.rowSize) * 31) + Arrays.hashCode(this.bits);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return toString("X ", GlideException.IndentedAppendable.INDENT);
        }
        return (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (!(obj instanceof BitMatrix)) {
                return false;
            }
            BitMatrix bitMatrix = (BitMatrix) obj;
            if (this.width != bitMatrix.width || this.height != bitMatrix.height || this.rowSize != bitMatrix.rowSize || !Arrays.equals(this.bits, bitMatrix.bits)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void flip(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            int i3 = (i2 * this.rowSize) + (i / 32);
            int[] iArr = this.bits;
            iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
        }
    }

    public boolean get(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i, i2)) == null) {
            if (((this.bits[(i2 * this.rowSize) + (i / 32)] >>> (i & 31)) & 1) != 0) {
                return true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public void set(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
            int i3 = (i2 * this.rowSize) + (i / 32);
            int[] iArr = this.bits;
            iArr[i3] = (1 << (i & 31)) | iArr[i3];
        }
    }

    public void setRow(int i, BitArray bitArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i, bitArray) == null) {
            int[] bitArray2 = bitArray.getBitArray();
            int[] iArr = this.bits;
            int i2 = this.rowSize;
            System.arraycopy(bitArray2, 0, iArr, i * i2, i2);
        }
    }

    public String toString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, str2)) == null) {
            return buildToString(str, str2, "\n");
        }
        return (String) invokeLL.objValue;
    }

    public void unset(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i, i2) == null) {
            int i3 = (i2 * this.rowSize) + (i / 32);
            int[] iArr = this.bits;
            iArr[i3] = (~(1 << (i & 31))) & iArr[i3];
        }
    }

    public int[] getBottomRightOnBit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int length = this.bits.length - 1;
            while (length >= 0 && this.bits[length] == 0) {
                length--;
            }
            if (length < 0) {
                return null;
            }
            int i = this.rowSize;
            int i2 = length / i;
            int i3 = (length % i) << 5;
            int i4 = 31;
            while ((this.bits[length] >>> i4) == 0) {
                i4--;
            }
            return new int[]{i3 + i4, i2};
        }
        return (int[]) invokeV.objValue;
    }

    public int[] getTopLeftOnBit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i = 0;
            while (true) {
                int[] iArr = this.bits;
                if (i >= iArr.length || iArr[i] != 0) {
                    break;
                }
                i++;
            }
            int[] iArr2 = this.bits;
            if (i == iArr2.length) {
                return null;
            }
            int i2 = this.rowSize;
            int i3 = i / i2;
            int i4 = (i % i2) << 5;
            int i5 = iArr2[i];
            int i6 = 0;
            while ((i5 << (31 - i6)) == 0) {
                i6++;
            }
            return new int[]{i4 + i6, i3};
        }
        return (int[]) invokeV.objValue;
    }

    public void rotate180() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            int width = getWidth();
            int height = getHeight();
            BitArray bitArray = new BitArray(width);
            BitArray bitArray2 = new BitArray(width);
            for (int i = 0; i < (height + 1) / 2; i++) {
                bitArray = getRow(i, bitArray);
                int i2 = (height - 1) - i;
                bitArray2 = getRow(i2, bitArray2);
                bitArray.reverse();
                bitArray2.reverse();
                setRow(i, bitArray2);
                setRow(i2, bitArray);
            }
        }
    }

    public int[] getEnclosingRectangle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = this.width;
            int i2 = this.height;
            int i3 = -1;
            int i4 = -1;
            for (int i5 = 0; i5 < this.height; i5++) {
                int i6 = 0;
                while (true) {
                    int i7 = this.rowSize;
                    if (i6 < i7) {
                        int i8 = this.bits[(i7 * i5) + i6];
                        if (i8 != 0) {
                            if (i5 < i2) {
                                i2 = i5;
                            }
                            if (i5 > i4) {
                                i4 = i5;
                            }
                            int i9 = i6 << 5;
                            if (i9 < i) {
                                int i10 = 0;
                                while ((i8 << (31 - i10)) == 0) {
                                    i10++;
                                }
                                int i11 = i10 + i9;
                                if (i11 < i) {
                                    i = i11;
                                }
                            }
                            if (i9 + 31 > i3) {
                                int i12 = 31;
                                while ((i8 >>> i12) == 0) {
                                    i12--;
                                }
                                int i13 = i9 + i12;
                                if (i13 > i3) {
                                    i3 = i13;
                                }
                            }
                        }
                        i6++;
                    }
                }
            }
            if (i3 < i || i4 < i2) {
                return null;
            }
            return new int[]{i, i2, (i3 - i) + 1, (i4 - i2) + 1};
        }
        return (int[]) invokeV.objValue;
    }

    public BitArray getRow(int i, BitArray bitArray) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, bitArray)) == null) {
            if (bitArray != null && bitArray.getSize() >= this.width) {
                bitArray.clear();
            } else {
                bitArray = new BitArray(this.width);
            }
            int i2 = i * this.rowSize;
            for (int i3 = 0; i3 < this.rowSize; i3++) {
                bitArray.setBulk(i3 << 5, this.bits[i2 + i3]);
            }
            return bitArray;
        }
        return (BitArray) invokeIL.objValue;
    }

    @Deprecated
    public String toString(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, str, str2, str3)) == null) {
            return buildToString(str, str2, str3);
        }
        return (String) invokeLLL.objValue;
    }
}
