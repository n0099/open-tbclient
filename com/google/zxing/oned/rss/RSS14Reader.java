package com.google.zxing.oned.rss;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class RSS14Reader extends AbstractRSSReader {
    public static /* synthetic */ Interceptable $ic;
    public static final int[][] FINDER_PATTERNS;
    public static final int[] INSIDE_GSUM;
    public static final int[] INSIDE_ODD_TOTAL_SUBSET;
    public static final int[] INSIDE_ODD_WIDEST;
    public static final int[] OUTSIDE_EVEN_TOTAL_SUBSET;
    public static final int[] OUTSIDE_GSUM;
    public static final int[] OUTSIDE_ODD_WIDEST;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Pair> possibleLeftPairs;
    public final List<Pair> possibleRightPairs;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1230952982, "Lcom/google/zxing/oned/rss/RSS14Reader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1230952982, "Lcom/google/zxing/oned/rss/RSS14Reader;");
                return;
            }
        }
        OUTSIDE_EVEN_TOTAL_SUBSET = new int[]{1, 10, 34, 70, 126};
        INSIDE_ODD_TOTAL_SUBSET = new int[]{4, 20, 48, 81};
        OUTSIDE_GSUM = new int[]{0, 161, 961, 2015, 2715};
        INSIDE_GSUM = new int[]{0, 336, 1036, 1516};
        OUTSIDE_ODD_WIDEST = new int[]{8, 6, 4, 3, 1};
        INSIDE_ODD_WIDEST = new int[]{2, 4, 6, 8};
        FINDER_PATTERNS = new int[][]{new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    }

    public RSS14Reader() {
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
        this.possibleLeftPairs = new ArrayList();
        this.possibleRightPairs = new ArrayList();
    }

    public static void addOrTally(Collection<Pair> collection, Pair pair) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, collection, pair) == null) || pair == null) {
            return;
        }
        boolean z = false;
        Iterator<Pair> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Pair next = it.next();
            if (next.getValue() == pair.getValue()) {
                next.incrementCount();
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        collection.add(pair);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
        if (r1 < 4) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:
        if (r1 < 4) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0043, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0045, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
        r5 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void adjustOddEvenCounts(boolean z, int i) throws NotFoundException {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65539, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) != null) {
            return;
        }
        int sum = MathUtils.sum(getOddCounts());
        int sum2 = MathUtils.sum(getEvenCounts());
        boolean z6 = true;
        if (z) {
            if (sum > 12) {
                z2 = false;
                z3 = true;
            } else {
                z2 = sum < 4;
                z3 = false;
            }
            if (sum2 <= 12) {
            }
            z4 = false;
            z5 = true;
            i2 = (sum + sum2) - i;
            boolean z7 = (sum & 1) != z;
            boolean z8 = (sum2 & 1) == 1;
            if (i2 != 1) {
                if (z7) {
                    if (z8) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z6 = z2;
                    z3 = true;
                } else if (!z8) {
                    throw NotFoundException.getNotFoundInstance();
                } else {
                    z6 = z2;
                    z5 = true;
                }
            } else if (i2 == -1) {
                if (z7) {
                    if (z8) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else if (!z8) {
                    throw NotFoundException.getNotFoundInstance();
                } else {
                    z6 = z2;
                    z4 = true;
                }
            } else if (i2 != 0) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                if (z7) {
                    if (!z8) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    if (sum >= sum2) {
                        z6 = z2;
                        z4 = true;
                        z3 = true;
                    }
                    z5 = true;
                } else if (z8) {
                    throw NotFoundException.getNotFoundInstance();
                } else {
                    z6 = z2;
                }
            }
            if (z6) {
                if (!z3) {
                    AbstractRSSReader.increment(getOddCounts(), getOddRoundingErrors());
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if (z3) {
                AbstractRSSReader.decrement(getOddCounts(), getOddRoundingErrors());
            }
            if (z4) {
                if (!z5) {
                    AbstractRSSReader.increment(getEvenCounts(), getOddRoundingErrors());
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if (z5) {
                return;
            }
            AbstractRSSReader.decrement(getEvenCounts(), getEvenRoundingErrors());
            return;
        }
        if (sum > 11) {
            z2 = false;
            z3 = true;
        } else {
            z2 = sum < 5;
            z3 = false;
        }
        if (sum2 <= 10) {
        }
        z4 = false;
        z5 = true;
        i2 = (sum + sum2) - i;
        if ((sum & 1) != z) {
        }
        if ((sum2 & 1) == 1) {
        }
        if (i2 != 1) {
        }
        if (z6) {
        }
        if (z3) {
        }
        if (z4) {
        }
        if (z5) {
        }
    }

    public static boolean checkChecksum(Pair pair, Pair pair2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pair, pair2)) == null) {
            int checksumPortion = (pair.getChecksumPortion() + (pair2.getChecksumPortion() * 16)) % 79;
            int value = (pair.getFinderPattern().getValue() * 9) + pair2.getFinderPattern().getValue();
            if (value > 72) {
                value--;
            }
            if (value > 8) {
                value--;
            }
            return checksumPortion == value;
        }
        return invokeLL.booleanValue;
    }

    public static Result constructResult(Pair pair, Pair pair2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, pair, pair2)) == null) {
            String valueOf = String.valueOf((pair.getValue() * 4537077) + pair2.getValue());
            StringBuilder sb = new StringBuilder(14);
            for (int length = 13 - valueOf.length(); length > 0; length--) {
                sb.append('0');
            }
            sb.append(valueOf);
            int i = 0;
            for (int i2 = 0; i2 < 13; i2++) {
                int charAt = sb.charAt(i2) - '0';
                if ((i2 & 1) == 0) {
                    charAt *= 3;
                }
                i += charAt;
            }
            int i3 = 10 - (i % 10);
            if (i3 == 10) {
                i3 = 0;
            }
            sb.append(i3);
            ResultPoint[] resultPoints = pair.getFinderPattern().getResultPoints();
            ResultPoint[] resultPoints2 = pair2.getFinderPattern().getResultPoints();
            return new Result(String.valueOf(sb.toString()), null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_14);
        }
        return (Result) invokeLL.objValue;
    }

    private DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z) throws NotFoundException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, this, bitArray, finderPattern, z)) == null) {
            int[] dataCharacterCounters = getDataCharacterCounters();
            dataCharacterCounters[0] = 0;
            dataCharacterCounters[1] = 0;
            dataCharacterCounters[2] = 0;
            dataCharacterCounters[3] = 0;
            dataCharacterCounters[4] = 0;
            dataCharacterCounters[5] = 0;
            dataCharacterCounters[6] = 0;
            dataCharacterCounters[7] = 0;
            if (z) {
                OneDReader.recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
            } else {
                OneDReader.recordPattern(bitArray, finderPattern.getStartEnd()[1] + 1, dataCharacterCounters);
                int i = 0;
                for (int length = dataCharacterCounters.length - 1; i < length; length--) {
                    int i2 = dataCharacterCounters[i];
                    dataCharacterCounters[i] = dataCharacterCounters[length];
                    dataCharacterCounters[length] = i2;
                    i++;
                }
            }
            int i3 = z ? 16 : 15;
            float sum = MathUtils.sum(dataCharacterCounters) / i3;
            int[] oddCounts = getOddCounts();
            int[] evenCounts = getEvenCounts();
            float[] oddRoundingErrors = getOddRoundingErrors();
            float[] evenRoundingErrors = getEvenRoundingErrors();
            for (int i4 = 0; i4 < dataCharacterCounters.length; i4++) {
                float f2 = dataCharacterCounters[i4] / sum;
                int i5 = (int) (0.5f + f2);
                if (i5 <= 0) {
                    i5 = 1;
                } else if (i5 > 8) {
                    i5 = 8;
                }
                int i6 = i4 / 2;
                if ((i4 & 1) == 0) {
                    oddCounts[i6] = i5;
                    oddRoundingErrors[i6] = f2 - i5;
                } else {
                    evenCounts[i6] = i5;
                    evenRoundingErrors[i6] = f2 - i5;
                }
            }
            adjustOddEvenCounts(z, i3);
            int i7 = 0;
            int i8 = 0;
            for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
                i7 = (i7 * 9) + oddCounts[length2];
                i8 += oddCounts[length2];
            }
            int i9 = 0;
            int i10 = 0;
            for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
                i9 = (i9 * 9) + evenCounts[length3];
                i10 += evenCounts[length3];
            }
            int i11 = i7 + (i9 * 3);
            if (!z) {
                if ((i10 & 1) == 0 && i10 <= 10 && i10 >= 4) {
                    int i12 = (10 - i10) / 2;
                    int i13 = INSIDE_ODD_WIDEST[i12];
                    return new DataCharacter((RSSUtils.getRSSvalue(evenCounts, 9 - i13, false) * INSIDE_ODD_TOTAL_SUBSET[i12]) + RSSUtils.getRSSvalue(oddCounts, i13, true) + INSIDE_GSUM[i12], i11);
                }
                throw NotFoundException.getNotFoundInstance();
            } else if ((i8 & 1) == 0 && i8 <= 12 && i8 >= 4) {
                int i14 = (12 - i8) / 2;
                int i15 = OUTSIDE_ODD_WIDEST[i14];
                return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i15, false) * OUTSIDE_EVEN_TOTAL_SUBSET[i14]) + RSSUtils.getRSSvalue(evenCounts, 9 - i15, true) + OUTSIDE_GSUM[i14], i11);
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        return (DataCharacter) invokeLLZ.objValue;
    }

    private Pair decodePair(BitArray bitArray, boolean z, int i, Map<DecodeHintType, ?> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{bitArray, Boolean.valueOf(z), Integer.valueOf(i), map})) == null) {
            try {
                int[] findFinderPattern = findFinderPattern(bitArray, 0, z);
                FinderPattern parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i, z, findFinderPattern);
                ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                if (resultPointCallback != null) {
                    float f2 = (findFinderPattern[0] + findFinderPattern[1]) / 2.0f;
                    if (z) {
                        f2 = (bitArray.getSize() - 1) - f2;
                    }
                    resultPointCallback.foundPossibleResultPoint(new ResultPoint(f2, i));
                }
                DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, true);
                DataCharacter decodeDataCharacter2 = decodeDataCharacter(bitArray, parseFoundFinderPattern, false);
                return new Pair((decodeDataCharacter.getValue() * 1597) + decodeDataCharacter2.getValue(), decodeDataCharacter.getChecksumPortion() + (decodeDataCharacter2.getChecksumPortion() * 4), parseFoundFinderPattern);
            } catch (NotFoundException unused) {
                return null;
            }
        }
        return (Pair) invokeCommon.objValue;
    }

    private int[] findFinderPattern(BitArray bitArray, int i, boolean z) throws NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, this, new Object[]{bitArray, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            int[] decodeFinderCounters = getDecodeFinderCounters();
            decodeFinderCounters[0] = 0;
            decodeFinderCounters[1] = 0;
            decodeFinderCounters[2] = 0;
            decodeFinderCounters[3] = 0;
            int size = bitArray.getSize();
            boolean z2 = false;
            while (i < size) {
                z2 = !bitArray.get(i);
                if (z == z2) {
                    break;
                }
                i++;
            }
            int i2 = i;
            int i3 = 0;
            while (i < size) {
                if (bitArray.get(i) ^ z2) {
                    decodeFinderCounters[i3] = decodeFinderCounters[i3] + 1;
                } else {
                    if (i3 != 3) {
                        i3++;
                    } else if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                        return new int[]{i2, i};
                    } else {
                        i2 += decodeFinderCounters[0] + decodeFinderCounters[1];
                        decodeFinderCounters[0] = decodeFinderCounters[2];
                        decodeFinderCounters[1] = decodeFinderCounters[3];
                        decodeFinderCounters[2] = 0;
                        decodeFinderCounters[3] = 0;
                        i3--;
                    }
                    decodeFinderCounters[i3] = 1;
                    z2 = !z2;
                }
                i++;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (int[]) invokeCommon.objValue;
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z, int[] iArr) throws NotFoundException {
        InterceptResult invokeCommon;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, this, new Object[]{bitArray, Integer.valueOf(i), Boolean.valueOf(z), iArr})) == null) {
            boolean z2 = bitArray.get(iArr[0]);
            int i4 = iArr[0] - 1;
            while (i4 >= 0 && (bitArray.get(i4) ^ z2)) {
                i4--;
            }
            int i5 = i4 + 1;
            int[] decodeFinderCounters = getDecodeFinderCounters();
            System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
            decodeFinderCounters[0] = iArr[0] - i5;
            int parseFinderValue = AbstractRSSReader.parseFinderValue(decodeFinderCounters, FINDER_PATTERNS);
            int i6 = iArr[1];
            if (z) {
                i2 = (bitArray.getSize() - 1) - i6;
                i3 = (bitArray.getSize() - 1) - i5;
            } else {
                i2 = i6;
                i3 = i5;
            }
            return new FinderPattern(parseFinderValue, new int[]{i5, iArr[1]}, i3, i2, i);
        }
        return (FinderPattern) invokeCommon.objValue;
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i, bitArray, map)) == null) {
            addOrTally(this.possibleLeftPairs, decodePair(bitArray, false, i, map));
            bitArray.reverse();
            addOrTally(this.possibleRightPairs, decodePair(bitArray, true, i, map));
            bitArray.reverse();
            for (Pair pair : this.possibleLeftPairs) {
                if (pair.getCount() > 1) {
                    for (Pair pair2 : this.possibleRightPairs) {
                        if (pair2.getCount() > 1 && checkChecksum(pair, pair2)) {
                            return constructResult(pair, pair2);
                        }
                    }
                    continue;
                }
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (Result) invokeILL.objValue;
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.possibleLeftPairs.clear();
            this.possibleRightPairs.clear();
        }
    }
}
