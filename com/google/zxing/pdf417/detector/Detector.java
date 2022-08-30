package com.google.zxing.pdf417.detector;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class Detector {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BARCODE_MIN_HEIGHT = 10;
    public static final int[] INDEXES_START_PATTERN;
    public static final int[] INDEXES_STOP_PATTERN;
    public static final float MAX_AVG_VARIANCE = 0.42f;
    public static final float MAX_INDIVIDUAL_VARIANCE = 0.8f;
    public static final int MAX_PATTERN_DRIFT = 5;
    public static final int MAX_PIXEL_DRIFT = 3;
    public static final int ROW_STEP = 5;
    public static final int SKIPPED_ROW_COUNT_MAX = 25;
    public static final int[] START_PATTERN;
    public static final int[] STOP_PATTERN;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(879399852, "Lcom/google/zxing/pdf417/detector/Detector;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(879399852, "Lcom/google/zxing/pdf417/detector/Detector;");
                return;
            }
        }
        INDEXES_START_PATTERN = new int[]{0, 4, 1, 5};
        INDEXES_STOP_PATTERN = new int[]{6, 2, 7, 3};
        START_PATTERN = new int[]{8, 1, 1, 1, 1, 1, 1, 3};
        STOP_PATTERN = new int[]{7, 1, 1, 3, 1, 1, 1, 2, 1};
    }

    public Detector() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void copyToResult(ResultPoint[] resultPointArr, ResultPoint[] resultPointArr2, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, resultPointArr, resultPointArr2, iArr) == null) {
            for (int i = 0; i < iArr.length; i++) {
                resultPointArr[iArr[i]] = resultPointArr2[i];
            }
        }
    }

    public static PDF417DetectorResult detect(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, binaryBitmap, map, z)) == null) {
            BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
            List<ResultPoint[]> detect = detect(z, blackMatrix);
            if (detect.isEmpty()) {
                blackMatrix = blackMatrix.m80clone();
                blackMatrix.rotate180();
                detect = detect(z, blackMatrix);
            }
            return new PDF417DetectorResult(blackMatrix, detect);
        }
        return (PDF417DetectorResult) invokeLLZ.objValue;
    }

    public static int[] findGuardPattern(BitMatrix bitMatrix, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{bitMatrix, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), iArr, iArr2})) == null) {
            Arrays.fill(iArr2, 0, iArr2.length, 0);
            int i4 = 0;
            while (bitMatrix.get(i, i2) && i > 0) {
                int i5 = i4 + 1;
                if (i4 >= 3) {
                    break;
                }
                i--;
                i4 = i5;
            }
            int length = iArr.length;
            boolean z2 = z;
            int i6 = 0;
            int i7 = i;
            while (i < i3) {
                if (bitMatrix.get(i, i2) ^ z2) {
                    iArr2[i6] = iArr2[i6] + 1;
                } else {
                    int i8 = length - 1;
                    if (i6 != i8) {
                        i6++;
                    } else if (patternMatchVariance(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i7, i};
                    } else {
                        i7 += iArr2[0] + iArr2[1];
                        int i9 = length - 2;
                        System.arraycopy(iArr2, 2, iArr2, 0, i9);
                        iArr2[i9] = 0;
                        iArr2[i8] = 0;
                        i6--;
                    }
                    iArr2[i6] = 1;
                    z2 = !z2;
                }
                i++;
            }
            if (i6 != length - 1 || patternMatchVariance(iArr2, iArr, 0.8f) >= 0.42f) {
                return null;
            }
            return new int[]{i7, i - 1};
        }
        return (int[]) invokeCommon.objValue;
    }

    public static ResultPoint[] findRowsWithPattern(BitMatrix bitMatrix, int i, int i2, int i3, int i4, int[] iArr) {
        InterceptResult invokeCommon;
        int i5;
        boolean z;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{bitMatrix, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) {
            ResultPoint[] resultPointArr = new ResultPoint[4];
            int[] iArr2 = new int[iArr.length];
            int i9 = i3;
            while (true) {
                if (i9 >= i) {
                    z = false;
                    break;
                }
                int[] findGuardPattern = findGuardPattern(bitMatrix, i4, i9, i2, false, iArr, iArr2);
                if (findGuardPattern != null) {
                    int i10 = i9;
                    int[] iArr3 = findGuardPattern;
                    int i11 = i10;
                    while (true) {
                        if (i11 <= 0) {
                            i8 = i11;
                            break;
                        }
                        int i12 = i11 - 1;
                        int[] findGuardPattern2 = findGuardPattern(bitMatrix, i4, i12, i2, false, iArr, iArr2);
                        if (findGuardPattern2 == null) {
                            i8 = i12 + 1;
                            break;
                        }
                        iArr3 = findGuardPattern2;
                        i11 = i12;
                    }
                    float f = i8;
                    resultPointArr[0] = new ResultPoint(iArr3[0], f);
                    resultPointArr[1] = new ResultPoint(iArr3[1], f);
                    i9 = i8;
                    z = true;
                } else {
                    i9 += 5;
                }
            }
            int i13 = i9 + 1;
            if (z) {
                int[] iArr4 = {(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
                int i14 = i13;
                int i15 = 0;
                while (true) {
                    if (i14 >= i) {
                        i6 = i15;
                        i7 = i14;
                        break;
                    }
                    i6 = i15;
                    i7 = i14;
                    int[] findGuardPattern3 = findGuardPattern(bitMatrix, iArr4[0], i14, i2, false, iArr, iArr2);
                    if (findGuardPattern3 != null && Math.abs(iArr4[0] - findGuardPattern3[0]) < 5 && Math.abs(iArr4[1] - findGuardPattern3[1]) < 5) {
                        iArr4 = findGuardPattern3;
                        i15 = 0;
                    } else if (i6 > 25) {
                        break;
                    } else {
                        i15 = i6 + 1;
                    }
                    i14 = i7 + 1;
                }
                i13 = i7 - (i6 + 1);
                float f2 = i13;
                resultPointArr[2] = new ResultPoint(iArr4[0], f2);
                resultPointArr[3] = new ResultPoint(iArr4[1], f2);
            }
            if (i13 - i9 < 10) {
                for (i5 = 0; i5 < 4; i5++) {
                    resultPointArr[i5] = null;
                }
            }
            return resultPointArr;
        }
        return (ResultPoint[]) invokeCommon.objValue;
    }

    public static ResultPoint[] findVertices(BitMatrix bitMatrix, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, bitMatrix, i, i2)) == null) {
            int height = bitMatrix.getHeight();
            int width = bitMatrix.getWidth();
            ResultPoint[] resultPointArr = new ResultPoint[8];
            copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i, i2, START_PATTERN), INDEXES_START_PATTERN);
            if (resultPointArr[4] != null) {
                i2 = (int) resultPointArr[4].getX();
                i = (int) resultPointArr[4].getY();
            }
            copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i, i2, STOP_PATTERN), INDEXES_STOP_PATTERN);
            return resultPointArr;
        }
        return (ResultPoint[]) invokeLII.objValue;
    }

    public static float patternMatchVariance(int[] iArr, int[] iArr2, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{iArr, iArr2, Float.valueOf(f)})) == null) {
            int length = iArr.length;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                i += iArr[i3];
                i2 += iArr2[i3];
            }
            if (i < i2) {
                return Float.POSITIVE_INFINITY;
            }
            float f2 = i;
            float f3 = f2 / i2;
            float f4 = f * f3;
            float f5 = 0.0f;
            for (int i4 = 0; i4 < length; i4++) {
                float f6 = iArr2[i4] * f3;
                float f7 = iArr[i4];
                float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
                if (f8 > f4) {
                    return Float.POSITIVE_INFINITY;
                }
                f5 += f8;
            }
            return f5 / f2;
        }
        return invokeCommon.floatValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (r5 == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r4.hasNext() == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
        r5 = (com.google.zxing.ResultPoint[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r5[1] == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        r3 = (int) java.lang.Math.max(r3, r5[1].getY());
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
        if (r5[3] == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
        r3 = java.lang.Math.max(r3, (int) r5[3].getY());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<ResultPoint[]> detect(boolean z, BitMatrix bitMatrix) {
        InterceptResult invokeZL;
        int x;
        float y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(InputDeviceCompat.SOURCE_TRACKBALL, null, z, bitMatrix)) == null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            loop0: while (true) {
                int i2 = 0;
                boolean z2 = false;
                while (true) {
                    if (i >= bitMatrix.getHeight()) {
                        break loop0;
                    }
                    ResultPoint[] findVertices = findVertices(bitMatrix, i, i2);
                    if (findVertices[0] != null || findVertices[3] != null) {
                        arrayList.add(findVertices);
                        if (!z) {
                            break loop0;
                        }
                        if (findVertices[2] != null) {
                            x = (int) findVertices[2].getX();
                            y = findVertices[2].getY();
                        } else {
                            x = (int) findVertices[4].getX();
                            y = findVertices[4].getY();
                        }
                        i = (int) y;
                        i2 = x;
                        z2 = true;
                    } else {
                        break;
                    }
                }
                i += 5;
            }
            return arrayList;
        }
        return (List) invokeZL.objValue;
    }
}
