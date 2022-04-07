package com.google.zxing.oned;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;
/* loaded from: classes5.dex */
public final class ITFReader extends OneDReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] DEFAULT_ALLOWED_LENGTHS;
    public static final int[] END_PATTERN_REVERSED;
    public static final float MAX_AVG_VARIANCE = 0.38f;
    public static final float MAX_INDIVIDUAL_VARIANCE = 0.78f;
    public static final int N = 1;
    public static final int[][] PATTERNS;
    public static final int[] START_PATTERN;
    public static final int W = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public int narrowLineWidth;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(235955559, "Lcom/google/zxing/oned/ITFReader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(235955559, "Lcom/google/zxing/oned/ITFReader;");
                return;
            }
        }
        DEFAULT_ALLOWED_LENGTHS = new int[]{6, 8, 10, 12, 14};
        START_PATTERN = new int[]{1, 1, 1, 1};
        END_PATTERN_REVERSED = new int[]{1, 1, 3};
        PATTERNS = new int[][]{new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    }

    public ITFReader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.narrowLineWidth = -1;
    }

    public static int decodeDigit(int[] iArr) throws NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iArr)) == null) {
            int length = PATTERNS.length;
            float f = 0.38f;
            int i = -1;
            for (int i2 = 0; i2 < length; i2++) {
                float patternMatchVariance = OneDReader.patternMatchVariance(iArr, PATTERNS[i2], 0.78f);
                if (patternMatchVariance < f) {
                    i = i2;
                    f = patternMatchVariance;
                }
            }
            if (i >= 0) {
                return i;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return invokeL.intValue;
    }

    private int[] decodeEnd(BitArray bitArray) throws NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, bitArray)) == null) {
            bitArray.reverse();
            try {
                int[] findGuardPattern = findGuardPattern(bitArray, skipWhiteSpace(bitArray), END_PATTERN_REVERSED);
                validateQuietZone(bitArray, findGuardPattern[0]);
                int i = findGuardPattern[0];
                findGuardPattern[0] = bitArray.getSize() - findGuardPattern[1];
                findGuardPattern[1] = bitArray.getSize() - i;
                return findGuardPattern;
            } finally {
                bitArray.reverse();
            }
        }
        return (int[]) invokeL.objValue;
    }

    public static void decodeMiddle(BitArray bitArray, int i, int i2, StringBuilder sb) throws NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bitArray, Integer.valueOf(i), Integer.valueOf(i2), sb}) == null) {
            int[] iArr = new int[10];
            int[] iArr2 = new int[5];
            int[] iArr3 = new int[5];
            while (i < i2) {
                OneDReader.recordPattern(bitArray, i, iArr);
                for (int i3 = 0; i3 < 5; i3++) {
                    int i4 = i3 * 2;
                    iArr2[i3] = iArr[i4];
                    iArr3[i3] = iArr[i4 + 1];
                }
                sb.append((char) (decodeDigit(iArr2) + 48));
                sb.append((char) (decodeDigit(iArr3) + 48));
                for (int i5 = 0; i5 < 10; i5++) {
                    i += iArr[i5];
                }
            }
        }
    }

    private int[] decodeStart(BitArray bitArray) throws NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, bitArray)) == null) {
            int[] findGuardPattern = findGuardPattern(bitArray, skipWhiteSpace(bitArray), START_PATTERN);
            this.narrowLineWidth = (findGuardPattern[1] - findGuardPattern[0]) / 4;
            validateQuietZone(bitArray, findGuardPattern[0]);
            return findGuardPattern;
        }
        return (int[]) invokeL.objValue;
    }

    public static int[] findGuardPattern(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65542, null, bitArray, i, iArr)) == null) {
            int length = iArr.length;
            int[] iArr2 = new int[length];
            int size = bitArray.getSize();
            int i2 = i;
            boolean z = false;
            int i3 = 0;
            while (i < size) {
                if (bitArray.get(i) ^ z) {
                    iArr2[i3] = iArr2[i3] + 1;
                } else {
                    int i4 = length - 1;
                    if (i3 != i4) {
                        i3++;
                    } else if (OneDReader.patternMatchVariance(iArr2, iArr, 0.78f) < 0.38f) {
                        return new int[]{i2, i};
                    } else {
                        i2 += iArr2[0] + iArr2[1];
                        int i5 = length - 2;
                        System.arraycopy(iArr2, 2, iArr2, 0, i5);
                        iArr2[i5] = 0;
                        iArr2[i4] = 0;
                        i3--;
                    }
                    iArr2[i3] = 1;
                    z = !z;
                }
                i++;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (int[]) invokeLIL.objValue;
    }

    public static int skipWhiteSpace(BitArray bitArray) throws NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bitArray)) == null) {
            int size = bitArray.getSize();
            int nextSet = bitArray.getNextSet(0);
            if (nextSet != size) {
                return nextSet;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void validateQuietZone(BitArray bitArray, int i) throws NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, this, bitArray, i) == null) {
            int i2 = this.narrowLineWidth * 10;
            if (i2 >= i) {
                i2 = i;
            }
            for (int i3 = i - 1; i2 > 0 && i3 >= 0 && !bitArray.get(i3); i3--) {
                i2--;
            }
            throw NotFoundException.getNotFoundInstance();
        }
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws FormatException, NotFoundException {
        InterceptResult invokeILL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i, bitArray, map)) == null) {
            int[] decodeStart = decodeStart(bitArray);
            int[] decodeEnd = decodeEnd(bitArray);
            StringBuilder sb = new StringBuilder(20);
            decodeMiddle(bitArray, decodeStart[1], decodeEnd[0], sb);
            String sb2 = sb.toString();
            int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
            if (iArr == null) {
                iArr = DEFAULT_ALLOWED_LENGTHS;
            }
            int length = sb2.length();
            int length2 = iArr.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= length2) {
                    z = false;
                    break;
                }
                int i4 = iArr[i2];
                if (length == i4) {
                    z = true;
                    break;
                }
                if (i4 > i3) {
                    i3 = i4;
                }
                i2++;
            }
            if (!z && length > i3) {
                z = true;
            }
            if (z) {
                float f = i;
                return new Result(sb2, null, new ResultPoint[]{new ResultPoint(decodeStart[1], f), new ResultPoint(decodeEnd[0], f)}, BarcodeFormat.ITF);
            }
            throw FormatException.getFormatInstance();
        }
        return (Result) invokeILL.objValue;
    }
}
