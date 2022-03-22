package com.google.zxing.oned;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes7.dex */
public final class Code128Reader extends OneDReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CODE_CODE_A = 101;
    public static final int CODE_CODE_B = 100;
    public static final int CODE_CODE_C = 99;
    public static final int CODE_FNC_1 = 102;
    public static final int CODE_FNC_2 = 97;
    public static final int CODE_FNC_3 = 96;
    public static final int CODE_FNC_4_A = 101;
    public static final int CODE_FNC_4_B = 100;
    public static final int[][] CODE_PATTERNS;
    public static final int CODE_SHIFT = 98;
    public static final int CODE_START_A = 103;
    public static final int CODE_START_B = 104;
    public static final int CODE_START_C = 105;
    public static final int CODE_STOP = 106;
    public static final float MAX_AVG_VARIANCE = 0.25f;
    public static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(943519992, "Lcom/google/zxing/oned/Code128Reader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(943519992, "Lcom/google/zxing/oned/Code128Reader;");
                return;
            }
        }
        CODE_PATTERNS = new int[][]{new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    }

    public Code128Reader() {
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

    public static int decodeCode(BitArray bitArray, int[] iArr, int i) throws NotFoundException {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, bitArray, iArr, i)) == null) {
            OneDReader.recordPattern(bitArray, i, iArr);
            float f2 = 0.25f;
            int i2 = -1;
            int i3 = 0;
            while (true) {
                int[][] iArr2 = CODE_PATTERNS;
                if (i3 >= iArr2.length) {
                    break;
                }
                float patternMatchVariance = OneDReader.patternMatchVariance(iArr, iArr2[i3], 0.7f);
                if (patternMatchVariance < f2) {
                    i2 = i3;
                    f2 = patternMatchVariance;
                }
                i3++;
            }
            if (i2 >= 0) {
                return i2;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return invokeLLI.intValue;
    }

    public static int[] findStartPattern(BitArray bitArray) throws NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bitArray)) == null) {
            int size = bitArray.getSize();
            int nextSet = bitArray.getNextSet(0);
            int[] iArr = new int[6];
            int i = nextSet;
            boolean z = false;
            int i2 = 0;
            while (nextSet < size) {
                if (bitArray.get(nextSet) ^ z) {
                    iArr[i2] = iArr[i2] + 1;
                } else {
                    if (i2 == 5) {
                        float f2 = 0.25f;
                        int i3 = -1;
                        for (int i4 = 103; i4 <= 105; i4++) {
                            float patternMatchVariance = OneDReader.patternMatchVariance(iArr, CODE_PATTERNS[i4], 0.7f);
                            if (patternMatchVariance < f2) {
                                i3 = i4;
                                f2 = patternMatchVariance;
                            }
                        }
                        if (i3 >= 0 && bitArray.isRange(Math.max(0, i - ((nextSet - i) / 2)), i, false)) {
                            return new int[]{i, nextSet, i3};
                        }
                        i += iArr[0] + iArr[1];
                        System.arraycopy(iArr, 2, iArr, 0, 4);
                        iArr[4] = 0;
                        iArr[5] = 0;
                        i2--;
                    } else {
                        i2++;
                    }
                    iArr[i2] = 1;
                    z = !z;
                }
                nextSet++;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (int[]) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e5, code lost:
        if (r9 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x012b, code lost:
        if (r9 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x012d, code lost:
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0132 A[PHI: r17 
      PHI: (r17v10 boolean) = (r17v6 boolean), (r17v17 boolean) binds: [B:69:0x010b, B:45:0x00c5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x013e A[PHI: r16 r17 
      PHI: (r16v4 boolean) = (r16v1 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean), (r16v3 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean) binds: [B:69:0x010b, B:71:0x010f, B:75:0x011b, B:74:0x0117, B:87:0x013c, B:45:0x00c5, B:47:0x00ca, B:51:0x00d7, B:50:0x00d2] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r17v9 boolean) = (r17v6 boolean), (r17v6 boolean), (r17v6 boolean), (r17v6 boolean), (r17v8 boolean), (r17v17 boolean), (r17v17 boolean), (r17v17 boolean), (r17v17 boolean) binds: [B:69:0x010b, B:71:0x010f, B:75:0x011b, B:74:0x0117, B:87:0x013c, B:45:0x00c5, B:47:0x00ca, B:51:0x00d7, B:50:0x00d2] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.zxing.oned.OneDReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        InterceptResult invokeILL;
        char c2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i, bitArray, map)) == null) {
            boolean z2 = false;
            boolean z3 = map != null && map.containsKey(DecodeHintType.ASSUME_GS1);
            int[] findStartPattern = findStartPattern(bitArray);
            int i2 = findStartPattern[2];
            ArrayList arrayList = new ArrayList(20);
            arrayList.add(Byte.valueOf((byte) i2));
            switch (i2) {
                case 103:
                    c2 = 'e';
                    break;
                case 104:
                    c2 = 'd';
                    break;
                case 105:
                    c2 = 'c';
                    break;
                default:
                    throw FormatException.getFormatInstance();
            }
            StringBuilder sb = new StringBuilder(20);
            int i3 = 6;
            int[] iArr = new int[6];
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = true;
            boolean z7 = false;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            char c3 = c2;
            int i7 = findStartPattern[0];
            int i8 = findStartPattern[1];
            char c4 = c3;
            while (!z5) {
                int decodeCode = decodeCode(bitArray, iArr, i8);
                arrayList.add(Byte.valueOf((byte) decodeCode));
                if (decodeCode != 106) {
                    z6 = true;
                }
                if (decodeCode != 106) {
                    i5++;
                    i2 += i5 * decodeCode;
                }
                int i9 = i8;
                for (int i10 = 0; i10 < i3; i10++) {
                    i9 += iArr[i10];
                }
                switch (decodeCode) {
                    case 103:
                    case 104:
                    case 105:
                        throw FormatException.getFormatInstance();
                    default:
                        switch (c4) {
                            case 'c':
                                if (decodeCode >= 100) {
                                    if (decodeCode != 106) {
                                        z6 = false;
                                    }
                                    if (decodeCode != 106) {
                                        switch (decodeCode) {
                                            case 100:
                                                z = false;
                                                c4 = 'd';
                                                break;
                                            case 101:
                                                z = false;
                                                c4 = 'e';
                                                break;
                                            case 102:
                                                if (z3) {
                                                    if (sb.length() == 0) {
                                                        sb.append("]C1");
                                                    } else {
                                                        sb.append(DecodedBitStreamParser.GS);
                                                    }
                                                }
                                            default:
                                                z = false;
                                                break;
                                        }
                                    } else {
                                        z = false;
                                        z5 = true;
                                        break;
                                    }
                                } else {
                                    if (decodeCode < 10) {
                                        sb.append('0');
                                    }
                                    sb.append(decodeCode);
                                }
                                z = false;
                            case 'd':
                                if (decodeCode < 96) {
                                    if (z4 == z2) {
                                        sb.append((char) (decodeCode + 32));
                                    } else {
                                        sb.append((char) (decodeCode + 32 + 128));
                                    }
                                    z = false;
                                    z4 = false;
                                    break;
                                } else {
                                    if (decodeCode != 106) {
                                        z6 = false;
                                    }
                                    if (decodeCode != 106) {
                                        switch (decodeCode) {
                                            case 96:
                                            case 97:
                                            default:
                                                z = false;
                                                break;
                                            case 98:
                                                z = true;
                                                c4 = 'e';
                                                break;
                                            case 99:
                                                z = false;
                                                c4 = 'c';
                                                break;
                                            case 100:
                                                if (z2 || !z4) {
                                                    if (z2) {
                                                    }
                                                    z = false;
                                                    z4 = true;
                                                    break;
                                                }
                                                z2 = true;
                                                z = false;
                                                z4 = false;
                                                break;
                                            case 101:
                                                z = false;
                                                c4 = 'e';
                                                break;
                                            case 102:
                                                if (z3) {
                                                    if (sb.length() == 0) {
                                                        sb.append("]C1");
                                                    } else {
                                                        sb.append(DecodedBitStreamParser.GS);
                                                    }
                                                }
                                                z = false;
                                                break;
                                        }
                                    }
                                    z5 = true;
                                    z = false;
                                }
                                break;
                            case 'e':
                                if (decodeCode < 64) {
                                    if (z4 == z2) {
                                        sb.append((char) (decodeCode + 32));
                                    } else {
                                        sb.append((char) (decodeCode + 32 + 128));
                                    }
                                } else if (decodeCode >= 96) {
                                    if (decodeCode != 106) {
                                        z6 = false;
                                    }
                                    if (decodeCode != 106) {
                                        switch (decodeCode) {
                                            case 98:
                                                z = true;
                                                c4 = 'd';
                                                break;
                                            case 100:
                                                z = false;
                                                c4 = 'd';
                                                break;
                                            case 101:
                                                if (z2 || !z4) {
                                                    if (z2) {
                                                    }
                                                    z = false;
                                                    z4 = true;
                                                    break;
                                                }
                                                z2 = true;
                                                break;
                                            case 102:
                                                if (z3) {
                                                    if (sb.length() == 0) {
                                                        sb.append("]C1");
                                                    } else {
                                                        sb.append(DecodedBitStreamParser.GS);
                                                    }
                                                }
                                                z = false;
                                                break;
                                        }
                                    }
                                    z5 = true;
                                    z = false;
                                } else if (z4 == z2) {
                                    sb.append((char) (decodeCode - 64));
                                } else {
                                    sb.append((char) (decodeCode + 64));
                                }
                                z = false;
                                z4 = false;
                                break;
                            default:
                                z = false;
                                break;
                        }
                        if (z7) {
                            c4 = c4 == 'e' ? 'd' : 'e';
                        }
                        z7 = z;
                        i3 = 6;
                        i7 = i8;
                        i8 = i9;
                        i6 = i4;
                        i4 = decodeCode;
                        break;
                }
            }
            int i11 = i8 - i7;
            int nextUnset = bitArray.getNextUnset(i8);
            if (bitArray.isRange(nextUnset, Math.min(bitArray.getSize(), ((nextUnset - i7) / 2) + nextUnset), false)) {
                int i12 = i6;
                if ((i2 - (i5 * i12)) % 103 == i12) {
                    int length = sb.length();
                    if (length != 0) {
                        if (length > 0 && z6) {
                            if (c4 == 'c') {
                                sb.delete(length - 2, length);
                            } else {
                                sb.delete(length - 1, length);
                            }
                        }
                        float f2 = (findStartPattern[1] + findStartPattern[0]) / 2.0f;
                        float f3 = i7 + (i11 / 2.0f);
                        int size = arrayList.size();
                        byte[] bArr = new byte[size];
                        for (int i13 = 0; i13 < size; i13++) {
                            bArr[i13] = ((Byte) arrayList.get(i13)).byteValue();
                        }
                        float f4 = i;
                        return new Result(sb.toString(), bArr, new ResultPoint[]{new ResultPoint(f2, f4), new ResultPoint(f3, f4)}, BarcodeFormat.CODE_128);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw ChecksumException.getChecksumInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (Result) invokeILL.objValue;
    }
}
