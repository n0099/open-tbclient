package com.google.zxing.qrcode.encoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class MaskUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int N1 = 3;
    public static final int N2 = 3;
    public static final int N3 = 40;
    public static final int N4 = 10;
    public transient /* synthetic */ FieldHolder $fh;

    public MaskUtil() {
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

    public static int applyMaskPenaltyRule1(ByteMatrix byteMatrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, byteMatrix)) == null) ? applyMaskPenaltyRule1Internal(byteMatrix, true) + applyMaskPenaltyRule1Internal(byteMatrix, false) : invokeL.intValue;
    }

    public static int applyMaskPenaltyRule1Internal(ByteMatrix byteMatrix, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, byteMatrix, z)) == null) {
            int height = z ? byteMatrix.getHeight() : byteMatrix.getWidth();
            int width = z ? byteMatrix.getWidth() : byteMatrix.getHeight();
            byte[][] array = byteMatrix.getArray();
            int i2 = 0;
            for (int i3 = 0; i3 < height; i3++) {
                byte b2 = -1;
                int i4 = 0;
                for (int i5 = 0; i5 < width; i5++) {
                    byte b3 = z ? array[i3][i5] : array[i5][i3];
                    if (b3 == b2) {
                        i4++;
                    } else {
                        if (i4 >= 5) {
                            i2 += (i4 - 5) + 3;
                        }
                        b2 = b3;
                        i4 = 1;
                    }
                }
                if (i4 >= 5) {
                    i2 += (i4 - 5) + 3;
                }
            }
            return i2;
        }
        return invokeLZ.intValue;
    }

    public static int applyMaskPenaltyRule2(ByteMatrix byteMatrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, byteMatrix)) == null) {
            byte[][] array = byteMatrix.getArray();
            int width = byteMatrix.getWidth();
            int height = byteMatrix.getHeight();
            int i2 = 0;
            for (int i3 = 0; i3 < height - 1; i3++) {
                int i4 = 0;
                while (i4 < width - 1) {
                    byte b2 = array[i3][i4];
                    int i5 = i4 + 1;
                    if (b2 == array[i3][i5]) {
                        int i6 = i3 + 1;
                        if (b2 == array[i6][i4] && b2 == array[i6][i5]) {
                            i2++;
                        }
                    }
                    i4 = i5;
                }
            }
            return i2 * 3;
        }
        return invokeL.intValue;
    }

    public static int applyMaskPenaltyRule3(ByteMatrix byteMatrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, byteMatrix)) == null) {
            byte[][] array = byteMatrix.getArray();
            int width = byteMatrix.getWidth();
            int height = byteMatrix.getHeight();
            int i2 = 0;
            for (int i3 = 0; i3 < height; i3++) {
                for (int i4 = 0; i4 < width; i4++) {
                    byte[] bArr = array[i3];
                    int i5 = i4 + 6;
                    if (i5 < width && bArr[i4] == 1 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 1 && bArr[i4 + 3] == 1 && bArr[i4 + 4] == 1 && bArr[i4 + 5] == 0 && bArr[i5] == 1 && (isWhiteHorizontal(bArr, i4 - 4, i4) || isWhiteHorizontal(bArr, i4 + 7, i4 + 11))) {
                        i2++;
                    }
                    int i6 = i3 + 6;
                    if (i6 < height && array[i3][i4] == 1 && array[i3 + 1][i4] == 0 && array[i3 + 2][i4] == 1 && array[i3 + 3][i4] == 1 && array[i3 + 4][i4] == 1 && array[i3 + 5][i4] == 0 && array[i6][i4] == 1 && (isWhiteVertical(array, i4, i3 - 4, i3) || isWhiteVertical(array, i4, i3 + 7, i3 + 11))) {
                        i2++;
                    }
                }
            }
            return i2 * 40;
        }
        return invokeL.intValue;
    }

    public static int applyMaskPenaltyRule4(ByteMatrix byteMatrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, byteMatrix)) == null) {
            byte[][] array = byteMatrix.getArray();
            int width = byteMatrix.getWidth();
            int height = byteMatrix.getHeight();
            int i2 = 0;
            for (int i3 = 0; i3 < height; i3++) {
                byte[] bArr = array[i3];
                for (int i4 = 0; i4 < width; i4++) {
                    if (bArr[i4] == 1) {
                        i2++;
                    }
                }
            }
            int height2 = byteMatrix.getHeight() * byteMatrix.getWidth();
            return ((Math.abs((i2 << 1) - height2) * 10) / height2) * 10;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean getDataMaskBit(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65542, null, i2, i3, i4)) == null) {
            switch (i2) {
                case 0:
                    i4 += i3;
                    i5 = i4 & 1;
                    break;
                case 1:
                    i5 = i4 & 1;
                    break;
                case 2:
                    i5 = i3 % 3;
                    break;
                case 3:
                    i5 = (i4 + i3) % 3;
                    break;
                case 4:
                    i4 /= 2;
                    i3 /= 3;
                    i4 += i3;
                    i5 = i4 & 1;
                    break;
                case 5:
                    int i7 = i4 * i3;
                    i5 = (i7 & 1) + (i7 % 3);
                    break;
                case 6:
                    int i8 = i4 * i3;
                    i6 = (i8 & 1) + (i8 % 3);
                    i5 = i6 & 1;
                    break;
                case 7:
                    i6 = ((i4 * i3) % 3) + ((i4 + i3) & 1);
                    i5 = i6 & 1;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid mask pattern: " + i2);
            }
            return i5 == 0;
        }
        return invokeIII.booleanValue;
    }

    public static boolean isWhiteHorizontal(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, bArr, i2, i3)) == null) {
            int min = Math.min(i3, bArr.length);
            for (int max = Math.max(i2, 0); max < min; max++) {
                if (bArr[max] == 1) {
                    return false;
                }
            }
            return true;
        }
        return invokeLII.booleanValue;
    }

    public static boolean isWhiteVertical(byte[][] bArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65544, null, bArr, i2, i3, i4)) == null) {
            int min = Math.min(i4, bArr.length);
            for (int max = Math.max(i3, 0); max < min; max++) {
                if (bArr[max][i2] == 1) {
                    return false;
                }
            }
            return true;
        }
        return invokeLIII.booleanValue;
    }
}
