package com.google.zxing.oned;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes6.dex */
public final class CodaBarReader extends OneDReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final char[] ALPHABET;
    public static final String ALPHABET_STRING = "0123456789-$:/.+ABCD";
    public static final int[] CHARACTER_ENCODINGS;
    public static final float MAX_ACCEPTABLE = 2.0f;
    public static final int MIN_CHARACTER_LENGTH = 3;
    public static final float PADDING = 1.5f;
    public static final char[] STARTEND_ENCODING;
    public transient /* synthetic */ FieldHolder $fh;
    public int counterLength;
    public int[] counters;
    public final StringBuilder decodeRowResult;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-551600968, "Lcom/google/zxing/oned/CodaBarReader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-551600968, "Lcom/google/zxing/oned/CodaBarReader;");
                return;
            }
        }
        ALPHABET = ALPHABET_STRING.toCharArray();
        CHARACTER_ENCODINGS = new int[]{3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
        STARTEND_ENCODING = new char[]{'A', 'B', 'C', 'D'};
    }

    public CodaBarReader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.decodeRowResult = new StringBuilder(20);
        this.counters = new int[80];
        this.counterLength = 0;
    }

    public static boolean arrayContains(char[] cArr, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{cArr, Character.valueOf(c2)})) == null) {
            if (cArr != null) {
                for (char c3 : cArr) {
                    if (c3 == c2) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private void counterAppend(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            int[] iArr = this.counters;
            int i3 = this.counterLength;
            iArr[i3] = i2;
            int i4 = i3 + 1;
            this.counterLength = i4;
            if (i4 >= iArr.length) {
                int[] iArr2 = new int[i4 << 1];
                System.arraycopy(iArr, 0, iArr2, 0, i4);
                this.counters = iArr2;
            }
        }
    }

    private int findStartPattern() throws NotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            for (int i2 = 1; i2 < this.counterLength; i2 += 2) {
                int narrowWidePattern = toNarrowWidePattern(i2);
                if (narrowWidePattern != -1 && arrayContains(STARTEND_ENCODING, ALPHABET[narrowWidePattern])) {
                    int i3 = 0;
                    for (int i4 = i2; i4 < i2 + 7; i4++) {
                        i3 += this.counters[i4];
                    }
                    if (i2 == 1 || this.counters[i2 - 1] >= i3 / 2) {
                        return i2;
                    }
                }
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return invokeV.intValue;
    }

    private void setCounters(BitArray bitArray) throws NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bitArray) == null) {
            int i2 = 0;
            this.counterLength = 0;
            int nextUnset = bitArray.getNextUnset(0);
            int size = bitArray.getSize();
            if (nextUnset < size) {
                boolean z = true;
                while (nextUnset < size) {
                    if (bitArray.get(nextUnset) ^ z) {
                        i2++;
                    } else {
                        counterAppend(i2);
                        z = !z;
                        i2 = 1;
                    }
                    nextUnset++;
                }
                counterAppend(i2);
                return;
            }
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private int toNarrowWidePattern(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2)) != null) {
            return invokeI.intValue;
        }
        int i3 = i2 + 7;
        if (i3 >= this.counterLength) {
            return -1;
        }
        int[] iArr = this.counters;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        for (int i8 = i2; i8 < i3; i8 += 2) {
            int i9 = iArr[i8];
            if (i9 < i6) {
                i6 = i9;
            }
            if (i9 > i7) {
                i7 = i9;
            }
        }
        int i10 = (i6 + i7) / 2;
        int i11 = 0;
        for (int i12 = i2 + 1; i12 < i3; i12 += 2) {
            int i13 = iArr[i12];
            if (i13 < i4) {
                i4 = i13;
            }
            if (i13 > i11) {
                i11 = i13;
            }
        }
        int i14 = (i4 + i11) / 2;
        int i15 = 128;
        int i16 = 0;
        for (int i17 = 0; i17 < 7; i17++) {
            i15 >>= 1;
            if (iArr[i2 + i17] > ((i17 & 1) == 0 ? i10 : i14)) {
                i16 |= i15;
            }
        }
        while (true) {
            int[] iArr2 = CHARACTER_ENCODINGS;
            if (i5 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i5] == i16) {
                return i5;
            }
            i5++;
        }
    }

    private void validatePattern(int i2) throws NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i2) == null) {
            int[] iArr = {0, 0, 0, 0};
            int[] iArr2 = {0, 0, 0, 0};
            int length = this.decodeRowResult.length() - 1;
            int i3 = 0;
            int i4 = i2;
            int i5 = 0;
            while (true) {
                int i6 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i5)];
                for (int i7 = 6; i7 >= 0; i7--) {
                    int i8 = (i7 & 1) + ((i6 & 1) << 1);
                    iArr[i8] = iArr[i8] + this.counters[i4 + i7];
                    iArr2[i8] = iArr2[i8] + 1;
                    i6 >>= 1;
                }
                if (i5 >= length) {
                    break;
                }
                i4 += 8;
                i5++;
            }
            float[] fArr = new float[4];
            float[] fArr2 = new float[4];
            for (int i9 = 0; i9 < 2; i9++) {
                fArr2[i9] = 0.0f;
                int i10 = i9 + 2;
                fArr2[i10] = ((iArr[i9] / iArr2[i9]) + (iArr[i10] / iArr2[i10])) / 2.0f;
                fArr[i9] = fArr2[i10];
                fArr[i10] = ((iArr[i10] * 2.0f) + 1.5f) / iArr2[i10];
            }
            loop3: while (true) {
                int i11 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i3)];
                for (int i12 = 6; i12 >= 0; i12--) {
                    int i13 = (i12 & 1) + ((i11 & 1) << 1);
                    float f2 = this.counters[i2 + i12];
                    if (f2 < fArr2[i13] || f2 > fArr[i13]) {
                        break loop3;
                    }
                    i11 >>= 1;
                }
                if (i3 >= length) {
                    return;
                }
                i2 += 8;
                i3++;
            }
            throw NotFoundException.getNotFoundInstance();
        }
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, bitArray, map)) == null) {
            Arrays.fill(this.counters, 0);
            setCounters(bitArray);
            int findStartPattern = findStartPattern();
            this.decodeRowResult.setLength(0);
            int i3 = findStartPattern;
            do {
                int narrowWidePattern = toNarrowWidePattern(i3);
                if (narrowWidePattern != -1) {
                    this.decodeRowResult.append((char) narrowWidePattern);
                    i3 += 8;
                    if (this.decodeRowResult.length() > 1 && arrayContains(STARTEND_ENCODING, ALPHABET[narrowWidePattern])) {
                        break;
                    }
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            } while (i3 < this.counterLength);
            int i4 = i3 - 1;
            int i5 = this.counters[i4];
            int i6 = 0;
            for (int i7 = -8; i7 < -1; i7++) {
                i6 += this.counters[i3 + i7];
            }
            if (i3 < this.counterLength && i5 < i6 / 2) {
                throw NotFoundException.getNotFoundInstance();
            }
            validatePattern(findStartPattern);
            for (int i8 = 0; i8 < this.decodeRowResult.length(); i8++) {
                StringBuilder sb = this.decodeRowResult;
                sb.setCharAt(i8, ALPHABET[sb.charAt(i8)]);
            }
            if (arrayContains(STARTEND_ENCODING, this.decodeRowResult.charAt(0))) {
                StringBuilder sb2 = this.decodeRowResult;
                if (arrayContains(STARTEND_ENCODING, sb2.charAt(sb2.length() - 1))) {
                    if (this.decodeRowResult.length() > 3) {
                        if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
                            StringBuilder sb3 = this.decodeRowResult;
                            sb3.deleteCharAt(sb3.length() - 1);
                            this.decodeRowResult.deleteCharAt(0);
                        }
                        int i9 = 0;
                        for (int i10 = 0; i10 < findStartPattern; i10++) {
                            i9 += this.counters[i10];
                        }
                        float f2 = i9;
                        while (findStartPattern < i4) {
                            i9 += this.counters[findStartPattern];
                            findStartPattern++;
                        }
                        float f3 = i2;
                        return new Result(this.decodeRowResult.toString(), null, new ResultPoint[]{new ResultPoint(f2, f3), new ResultPoint(i9, f3)}, BarcodeFormat.CODABAR);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (Result) invokeILL.objValue;
    }
}
