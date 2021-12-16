package com.google.zxing.oned.rss;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
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
/* loaded from: classes3.dex */
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
        OUTSIDE_GSUM = new int[]{0, 161, 961, SpeedStatsStampTable.INIT_VERSION_STAMP_KEY, 2715};
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    private void adjustOddEvenCounts(boolean z, int i2) throws NotFoundException {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65539, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) != null) {
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
            i3 = (sum + sum2) - i2;
            boolean z7 = (sum & 1) != z;
            boolean z8 = (sum2 & 1) == 1;
            if (i3 != 1) {
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
            } else if (i3 == -1) {
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
            } else if (i3 != 0) {
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
        i3 = (sum + sum2) - i2;
        if ((sum & 1) != z) {
        }
        if ((sum2 & 1) == 1) {
        }
        if (i3 != 1) {
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
            int i2 = 0;
            for (int i3 = 0; i3 < 13; i3++) {
                int charAt = sb.charAt(i3) - '0';
                if ((i3 & 1) == 0) {
                    charAt *= 3;
                }
                i2 += charAt;
            }
            int i4 = 10 - (i2 % 10);
            if (i4 == 10) {
                i4 = 0;
            }
            sb.append(i4);
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
                int i2 = 0;
                for (int length = dataCharacterCounters.length - 1; i2 < length; length--) {
                    int i3 = dataCharacterCounters[i2];
                    dataCharacterCounters[i2] = dataCharacterCounters[length];
                    dataCharacterCounters[length] = i3;
                    i2++;
                }
            }
            int i4 = z ? 16 : 15;
            float sum = MathUtils.sum(dataCharacterCounters) / i4;
            int[] oddCounts = getOddCounts();
            int[] evenCounts = getEvenCounts();
            float[] oddRoundingErrors = getOddRoundingErrors();
            float[] evenRoundingErrors = getEvenRoundingErrors();
            for (int i5 = 0; i5 < dataCharacterCounters.length; i5++) {
                float f2 = dataCharacterCounters[i5] / sum;
                int i6 = (int) (0.5f + f2);
                if (i6 <= 0) {
                    i6 = 1;
                } else if (i6 > 8) {
                    i6 = 8;
                }
                int i7 = i5 / 2;
                if ((i5 & 1) == 0) {
                    oddCounts[i7] = i6;
                    oddRoundingErrors[i7] = f2 - i6;
                } else {
                    evenCounts[i7] = i6;
                    evenRoundingErrors[i7] = f2 - i6;
                }
            }
            adjustOddEvenCounts(z, i4);
            int i8 = 0;
            int i9 = 0;
            for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
                i8 = (i8 * 9) + oddCounts[length2];
                i9 += oddCounts[length2];
            }
            int i10 = 0;
            int i11 = 0;
            for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
                i10 = (i10 * 9) + evenCounts[length3];
                i11 += evenCounts[length3];
            }
            int i12 = i8 + (i10 * 3);
            if (!z) {
                if ((i11 & 1) == 0 && i11 <= 10 && i11 >= 4) {
                    int i13 = (10 - i11) / 2;
                    int i14 = INSIDE_ODD_WIDEST[i13];
                    return new DataCharacter((RSSUtils.getRSSvalue(evenCounts, 9 - i14, false) * INSIDE_ODD_TOTAL_SUBSET[i13]) + RSSUtils.getRSSvalue(oddCounts, i14, true) + INSIDE_GSUM[i13], i12);
                }
                throw NotFoundException.getNotFoundInstance();
            } else if ((i9 & 1) == 0 && i9 <= 12 && i9 >= 4) {
                int i15 = (12 - i9) / 2;
                int i16 = OUTSIDE_ODD_WIDEST[i15];
                return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i16, false) * OUTSIDE_EVEN_TOTAL_SUBSET[i15]) + RSSUtils.getRSSvalue(evenCounts, 9 - i16, true) + OUTSIDE_GSUM[i15], i12);
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        return (DataCharacter) invokeLLZ.objValue;
    }

    private Pair decodePair(BitArray bitArray, boolean z, int i2, Map<DecodeHintType, ?> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{bitArray, Boolean.valueOf(z), Integer.valueOf(i2), map})) == null) {
            try {
                int[] findFinderPattern = findFinderPattern(bitArray, 0, z);
                FinderPattern parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i2, z, findFinderPattern);
                ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                if (resultPointCallback != null) {
                    float f2 = (findFinderPattern[0] + findFinderPattern[1]) / 2.0f;
                    if (z) {
                        f2 = (bitArray.getSize() - 1) - f2;
                    }
                    resultPointCallback.foundPossibleResultPoint(new ResultPoint(f2, i2));
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

    private int[] findFinderPattern(BitArray bitArray, int i2, boolean z) throws NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, this, new Object[]{bitArray, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int[] decodeFinderCounters = getDecodeFinderCounters();
            decodeFinderCounters[0] = 0;
            decodeFinderCounters[1] = 0;
            decodeFinderCounters[2] = 0;
            decodeFinderCounters[3] = 0;
            int size = bitArray.getSize();
            boolean z2 = false;
            while (i2 < size) {
                z2 = !bitArray.get(i2);
                if (z == z2) {
                    break;
                }
                i2++;
            }
            int i3 = i2;
            int i4 = 0;
            while (i2 < size) {
                if (bitArray.get(i2) ^ z2) {
                    decodeFinderCounters[i4] = decodeFinderCounters[i4] + 1;
                } else {
                    if (i4 != 3) {
                        i4++;
                    } else if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                        return new int[]{i3, i2};
                    } else {
                        i3 += decodeFinderCounters[0] + decodeFinderCounters[1];
                        decodeFinderCounters[0] = decodeFinderCounters[2];
                        decodeFinderCounters[1] = decodeFinderCounters[3];
                        decodeFinderCounters[2] = 0;
                        decodeFinderCounters[3] = 0;
                        i4--;
                    }
                    decodeFinderCounters[i4] = 1;
                    z2 = !z2;
                }
                i2++;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (int[]) invokeCommon.objValue;
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i2, boolean z, int[] iArr) throws NotFoundException {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, this, new Object[]{bitArray, Integer.valueOf(i2), Boolean.valueOf(z), iArr})) == null) {
            boolean z2 = bitArray.get(iArr[0]);
            int i5 = iArr[0] - 1;
            while (i5 >= 0 && (bitArray.get(i5) ^ z2)) {
                i5--;
            }
            int i6 = i5 + 1;
            int[] decodeFinderCounters = getDecodeFinderCounters();
            System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
            decodeFinderCounters[0] = iArr[0] - i6;
            int parseFinderValue = AbstractRSSReader.parseFinderValue(decodeFinderCounters, FINDER_PATTERNS);
            int i7 = iArr[1];
            if (z) {
                i3 = (bitArray.getSize() - 1) - i7;
                i4 = (bitArray.getSize() - 1) - i6;
            } else {
                i3 = i7;
                i4 = i6;
            }
            return new FinderPattern(parseFinderValue, new int[]{i6, iArr[1]}, i4, i3, i2);
        }
        return (FinderPattern) invokeCommon.objValue;
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, bitArray, map)) == null) {
            addOrTally(this.possibleLeftPairs, decodePair(bitArray, false, i2, map));
            bitArray.reverse();
            addOrTally(this.possibleRightPairs, decodePair(bitArray, true, i2, map));
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
