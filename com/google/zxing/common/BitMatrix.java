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
/* loaded from: classes3.dex */
public final class BitMatrix implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] bits;
    public final int height;
    public final int rowSize;
    public final int width;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BitMatrix(int i2) {
        this(i2, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private String buildToString(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, str, str2, str3)) == null) {
            StringBuilder sb = new StringBuilder(this.height * (this.width + 1));
            for (int i2 = 0; i2 < this.height; i2++) {
                for (int i3 = 0; i3 < this.width; i3++) {
                    sb.append(get(i3, i2) ? str : str2);
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
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = -1;
                int i6 = 0;
                while (i2 < str.length()) {
                    if (str.charAt(i2) == '\n' || str.charAt(i2) == '\r') {
                        if (i3 > i4) {
                            if (i5 == -1) {
                                i5 = i3 - i4;
                            } else if (i3 - i4 != i5) {
                                throw new IllegalArgumentException("row lengths do not match");
                            }
                            i6++;
                            i4 = i3;
                        }
                        i2++;
                    } else {
                        if (str.substring(i2, str2.length() + i2).equals(str2)) {
                            i2 += str2.length();
                            zArr[i3] = true;
                        } else if (str.substring(i2, str3.length() + i2).equals(str3)) {
                            i2 += str3.length();
                            zArr[i3] = false;
                        } else {
                            throw new IllegalArgumentException("illegal character encountered: " + str.substring(i2));
                        }
                        i3++;
                    }
                }
                if (i3 > i4) {
                    if (i5 == -1) {
                        i5 = i3 - i4;
                    } else if (i3 - i4 != i5) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i6++;
                }
                BitMatrix bitMatrix = new BitMatrix(i5, i6);
                for (int i7 = 0; i7 < i3; i7++) {
                    if (zArr[i7]) {
                        bitMatrix.set(i7 % i5, i7 / i5);
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
            for (int i2 = 0; i2 < length; i2++) {
                this.bits[i2] = 0;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (obj instanceof BitMatrix) {
                BitMatrix bitMatrix = (BitMatrix) obj;
                return this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && Arrays.equals(this.bits, bitMatrix.bits);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void flip(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            int i4 = (i3 * this.rowSize) + (i2 / 32);
            int[] iArr = this.bits;
            iArr[i4] = (1 << (i2 & 31)) ^ iArr[i4];
        }
    }

    public boolean get(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) ? ((this.bits[(i3 * this.rowSize) + (i2 / 32)] >>> (i2 & 31)) & 1) != 0 : invokeII.booleanValue;
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
            int i2 = this.rowSize;
            int i3 = length / i2;
            int i4 = (length % i2) << 5;
            int i5 = 31;
            while ((this.bits[length] >>> i5) == 0) {
                i5--;
            }
            return new int[]{i4 + i5, i3};
        }
        return (int[]) invokeV.objValue;
    }

    public int[] getEnclosingRectangle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.width;
            int i3 = this.height;
            int i4 = -1;
            int i5 = -1;
            for (int i6 = 0; i6 < this.height; i6++) {
                int i7 = 0;
                while (true) {
                    int i8 = this.rowSize;
                    if (i7 < i8) {
                        int i9 = this.bits[(i8 * i6) + i7];
                        if (i9 != 0) {
                            if (i6 < i3) {
                                i3 = i6;
                            }
                            if (i6 > i5) {
                                i5 = i6;
                            }
                            int i10 = i7 << 5;
                            if (i10 < i2) {
                                int i11 = 0;
                                while ((i9 << (31 - i11)) == 0) {
                                    i11++;
                                }
                                int i12 = i11 + i10;
                                if (i12 < i2) {
                                    i2 = i12;
                                }
                            }
                            if (i10 + 31 > i4) {
                                int i13 = 31;
                                while ((i9 >>> i13) == 0) {
                                    i13--;
                                }
                                int i14 = i10 + i13;
                                if (i14 > i4) {
                                    i4 = i14;
                                }
                            }
                        }
                        i7++;
                    }
                }
            }
            if (i4 < i2 || i5 < i3) {
                return null;
            }
            return new int[]{i2, i3, (i4 - i2) + 1, (i5 - i3) + 1};
        }
        return (int[]) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.height : invokeV.intValue;
    }

    public BitArray getRow(int i2, BitArray bitArray) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, bitArray)) == null) {
            if (bitArray != null && bitArray.getSize() >= this.width) {
                bitArray.clear();
            } else {
                bitArray = new BitArray(this.width);
            }
            int i3 = i2 * this.rowSize;
            for (int i4 = 0; i4 < this.rowSize; i4++) {
                bitArray.setBulk(i4 << 5, this.bits[i3 + i4]);
            }
            return bitArray;
        }
        return (BitArray) invokeIL.objValue;
    }

    public int getRowSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.rowSize : invokeV.intValue;
    }

    public int[] getTopLeftOnBit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.bits;
                if (i2 >= iArr.length || iArr[i2] != 0) {
                    break;
                }
                i2++;
            }
            int[] iArr2 = this.bits;
            if (i2 == iArr2.length) {
                return null;
            }
            int i3 = this.rowSize;
            int i4 = i2 / i3;
            int i5 = (i2 % i3) << 5;
            int i6 = iArr2[i2];
            int i7 = 0;
            while ((i6 << (31 - i7)) == 0) {
                i7++;
            }
            return new int[]{i5 + i7, i4};
        }
        return (int[]) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.width : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int i2 = this.width;
            return (((((((i2 * 31) + i2) * 31) + this.height) * 31) + this.rowSize) * 31) + Arrays.hashCode(this.bits);
        }
        return invokeV.intValue;
    }

    public void rotate180() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            int width = getWidth();
            int height = getHeight();
            BitArray bitArray = new BitArray(width);
            BitArray bitArray2 = new BitArray(width);
            for (int i2 = 0; i2 < (height + 1) / 2; i2++) {
                bitArray = getRow(i2, bitArray);
                int i3 = (height - 1) - i2;
                bitArray2 = getRow(i3, bitArray2);
                bitArray.reverse();
                bitArray2.reverse();
                setRow(i2, bitArray2);
                setRow(i3, bitArray);
            }
        }
    }

    public void set(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
            int i4 = (i3 * this.rowSize) + (i2 / 32);
            int[] iArr = this.bits;
            iArr[i4] = (1 << (i2 & 31)) | iArr[i4];
        }
    }

    public void setRegion(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048592, this, i2, i3, i4, i5) == null) {
            if (i3 < 0 || i2 < 0) {
                throw new IllegalArgumentException("Left and top must be nonnegative");
            }
            if (i5 > 0 && i4 > 0) {
                int i6 = i4 + i2;
                int i7 = i5 + i3;
                if (i7 > this.height || i6 > this.width) {
                    throw new IllegalArgumentException("The region must fit inside the matrix");
                }
                while (i3 < i7) {
                    int i8 = this.rowSize * i3;
                    for (int i9 = i2; i9 < i6; i9++) {
                        int[] iArr = this.bits;
                        int i10 = (i9 / 32) + i8;
                        iArr[i10] = iArr[i10] | (1 << (i9 & 31));
                    }
                    i3++;
                }
                return;
            }
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
    }

    public void setRow(int i2, BitArray bitArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i2, bitArray) == null) {
            int[] bitArray2 = bitArray.getBitArray();
            int[] iArr = this.bits;
            int i3 = this.rowSize;
            System.arraycopy(bitArray2, 0, iArr, i2 * i3, i3);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? toString("X ", GlideException.IndentedAppendable.INDENT) : (String) invokeV.objValue;
    }

    public void unset(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i2, i3) == null) {
            int i4 = (i3 * this.rowSize) + (i2 / 32);
            int[] iArr = this.bits;
            iArr[i4] = (~(1 << (i2 & 31))) & iArr[i4];
        }
    }

    public void xor(BitMatrix bitMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bitMatrix) == null) {
            if (this.width == bitMatrix.getWidth() && this.height == bitMatrix.getHeight() && this.rowSize == bitMatrix.getRowSize()) {
                BitArray bitArray = new BitArray((this.width / 32) + 1);
                for (int i2 = 0; i2 < this.height; i2++) {
                    int i3 = this.rowSize * i2;
                    int[] bitArray2 = bitMatrix.getRow(i2, bitArray).getBitArray();
                    for (int i4 = 0; i4 < this.rowSize; i4++) {
                        int[] iArr = this.bits;
                        int i5 = i3 + i4;
                        iArr[i5] = iArr[i5] ^ bitArray2[i4];
                    }
                }
                return;
            }
            throw new IllegalArgumentException("input matrix dimensions do not match");
        }
    }

    public BitMatrix(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i2 > 0 && i3 > 0) {
            this.width = i2;
            this.height = i3;
            int i6 = (i2 + 31) / 32;
            this.rowSize = i6;
            this.bits = new int[i6 * i3];
            return;
        }
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public BitMatrix m121clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone()) : (BitMatrix) invokeV.objValue;
    }

    public String toString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, str2)) == null) ? buildToString(str, str2, org.apache.commons.lang3.StringUtils.LF) : (String) invokeLL.objValue;
    }

    @Deprecated
    public String toString(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, str, str2, str3)) == null) ? buildToString(str, str2, str3) : (String) invokeLLL.objValue;
    }

    public BitMatrix(int i2, int i3, int i4, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.width = i2;
        this.height = i3;
        this.rowSize = i4;
        this.bits = iArr;
    }
}
