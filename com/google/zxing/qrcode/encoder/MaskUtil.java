package com.google.zxing.qrcode.encoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int applyMaskPenaltyRule1(ByteMatrix byteMatrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, byteMatrix)) == null) {
            return applyMaskPenaltyRule1Internal(byteMatrix, true) + applyMaskPenaltyRule1Internal(byteMatrix, false);
        }
        return invokeL.intValue;
    }

    public static int applyMaskPenaltyRule1Internal(ByteMatrix byteMatrix, boolean z) {
        InterceptResult invokeLZ;
        int width;
        int height;
        byte b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, byteMatrix, z)) == null) {
            if (z) {
                width = byteMatrix.getHeight();
            } else {
                width = byteMatrix.getWidth();
            }
            if (z) {
                height = byteMatrix.getWidth();
            } else {
                height = byteMatrix.getHeight();
            }
            byte[][] array = byteMatrix.getArray();
            int i = 0;
            for (int i2 = 0; i2 < width; i2++) {
                byte b2 = -1;
                int i3 = 0;
                for (int i4 = 0; i4 < height; i4++) {
                    if (z) {
                        b = array[i2][i4];
                    } else {
                        b = array[i4][i2];
                    }
                    if (b == b2) {
                        i3++;
                    } else {
                        if (i3 >= 5) {
                            i += (i3 - 5) + 3;
                        }
                        b2 = b;
                        i3 = 1;
                    }
                }
                if (i3 >= 5) {
                    i += (i3 - 5) + 3;
                }
            }
            return i;
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
            int i = 0;
            for (int i2 = 0; i2 < height - 1; i2++) {
                int i3 = 0;
                while (i3 < width - 1) {
                    byte b = array[i2][i3];
                    int i4 = i3 + 1;
                    if (b == array[i2][i4]) {
                        int i5 = i2 + 1;
                        if (b == array[i5][i3] && b == array[i5][i4]) {
                            i++;
                        }
                    }
                    i3 = i4;
                }
            }
            return i * 3;
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
            int i = 0;
            for (int i2 = 0; i2 < height; i2++) {
                byte[] bArr = array[i2];
                for (int i3 = 0; i3 < width; i3++) {
                    if (bArr[i3] == 1) {
                        i++;
                    }
                }
            }
            int height2 = byteMatrix.getHeight() * byteMatrix.getWidth();
            return ((Math.abs((i << 1) - height2) * 10) / height2) * 10;
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
            int i = 0;
            for (int i2 = 0; i2 < height; i2++) {
                for (int i3 = 0; i3 < width; i3++) {
                    byte[] bArr = array[i2];
                    int i4 = i3 + 6;
                    if (i4 < width && bArr[i3] == 1 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 1 && bArr[i3 + 3] == 1 && bArr[i3 + 4] == 1 && bArr[i3 + 5] == 0 && bArr[i4] == 1 && (isWhiteHorizontal(bArr, i3 - 4, i3) || isWhiteHorizontal(bArr, i3 + 7, i3 + 11))) {
                        i++;
                    }
                    int i5 = i2 + 6;
                    if (i5 < height && array[i2][i3] == 1 && array[i2 + 1][i3] == 0 && array[i2 + 2][i3] == 1 && array[i2 + 3][i3] == 1 && array[i2 + 4][i3] == 1 && array[i2 + 5][i3] == 0 && array[i5][i3] == 1 && (isWhiteVertical(array, i3, i2 - 4, i2) || isWhiteVertical(array, i3, i2 + 7, i2 + 11))) {
                        i++;
                    }
                }
            }
            return i * 40;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean getDataMaskBit(int i, int i2, int i3) {
        InterceptResult invokeIII;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65542, null, i, i2, i3)) == null) {
            switch (i) {
                case 0:
                    i3 += i2;
                    i4 = i3 & 1;
                    break;
                case 1:
                    i4 = i3 & 1;
                    break;
                case 2:
                    i4 = i2 % 3;
                    break;
                case 3:
                    i4 = (i3 + i2) % 3;
                    break;
                case 4:
                    i3 /= 2;
                    i2 /= 3;
                    i3 += i2;
                    i4 = i3 & 1;
                    break;
                case 5:
                    int i6 = i3 * i2;
                    i4 = (i6 & 1) + (i6 % 3);
                    break;
                case 6:
                    int i7 = i3 * i2;
                    i5 = (i7 & 1) + (i7 % 3);
                    i4 = i5 & 1;
                    break;
                case 7:
                    i5 = ((i3 * i2) % 3) + ((i3 + i2) & 1);
                    i4 = i5 & 1;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid mask pattern: " + i);
            }
            if (i4 == 0) {
                return true;
            }
            return false;
        }
        return invokeIII.booleanValue;
    }

    public static boolean isWhiteHorizontal(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, bArr, i, i2)) == null) {
            int min = Math.min(i2, bArr.length);
            for (int max = Math.max(i, 0); max < min; max++) {
                if (bArr[max] == 1) {
                    return false;
                }
            }
            return true;
        }
        return invokeLII.booleanValue;
    }

    public static boolean isWhiteVertical(byte[][] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65544, null, bArr, i, i2, i3)) == null) {
            int min = Math.min(i3, bArr.length);
            for (int max = Math.max(i2, 0); max < min; max++) {
                if (bArr[max][i] == 1) {
                    return false;
                }
            }
            return true;
        }
        return invokeLIII.booleanValue;
    }
}
