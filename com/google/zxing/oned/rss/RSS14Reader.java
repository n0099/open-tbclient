package com.google.zxing.oned.rss;

import com.alibaba.fastjson.asm.Opcodes;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public final class RSS14Reader extends AbstractRSSReader {
    private final List<Pair> possibleLeftPairs = new ArrayList();
    private final List<Pair> possibleRightPairs = new ArrayList();
    private static final int[] OUTSIDE_EVEN_TOTAL_SUBSET = {1, 10, 34, 70, Opcodes.IAND};
    private static final int[] INSIDE_ODD_TOTAL_SUBSET = {4, 20, 48, 81};
    private static final int[] OUTSIDE_GSUM = {0, 161, 961, 2015, 2715};
    private static final int[] INSIDE_GSUM = {0, 336, 1036, 1516};
    private static final int[] OUTSIDE_ODD_WIDEST = {8, 6, 4, 3, 1};
    private static final int[] INSIDE_ODD_WIDEST = {2, 4, 6, 8};
    private static final int[][] FINDER_PATTERNS = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
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

    private static void addOrTally(Collection<Pair> collection, Pair pair) {
        boolean z;
        if (pair != null) {
            Iterator<Pair> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                Pair next = it.next();
                if (next.getValue() == pair.getValue()) {
                    next.incrementCount();
                    z = true;
                    break;
                }
            }
            if (!z) {
                collection.add(pair);
            }
        }
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.possibleLeftPairs.clear();
        this.possibleRightPairs.clear();
    }

    private static Result constructResult(Pair pair, Pair pair2) {
        String valueOf = String.valueOf((4537077 * pair.getValue()) + pair2.getValue());
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

    private static boolean checkChecksum(Pair pair, Pair pair2) {
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

    private Pair decodePair(BitArray bitArray, boolean z, int i, Map<DecodeHintType, ?> map) {
        try {
            int[] findFinderPattern = findFinderPattern(bitArray, 0, z);
            FinderPattern parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i, z, findFinderPattern);
            ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (resultPointCallback != null) {
                float f = (findFinderPattern[0] + findFinderPattern[1]) / 2.0f;
                if (z) {
                    f = (bitArray.getSize() - 1) - f;
                }
                resultPointCallback.foundPossibleResultPoint(new ResultPoint(f, i));
            }
            DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, true);
            DataCharacter decodeDataCharacter2 = decodeDataCharacter(bitArray, parseFoundFinderPattern, false);
            return new Pair((decodeDataCharacter.getValue() * 1597) + decodeDataCharacter2.getValue(), decodeDataCharacter.getChecksumPortion() + (decodeDataCharacter2.getChecksumPortion() * 4), parseFoundFinderPattern);
        } catch (NotFoundException e) {
            return null;
        }
    }

    private DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z) throws NotFoundException {
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
            recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            recordPattern(bitArray, finderPattern.getStartEnd()[1] + 1, dataCharacterCounters);
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
            float f = dataCharacterCounters[i4] / sum;
            int i5 = (int) (0.5f + f);
            if (i5 <= 0) {
                i5 = 1;
            } else if (i5 > 8) {
                i5 = 8;
            }
            int i6 = i4 / 2;
            if ((i4 & 1) == 0) {
                oddCounts[i6] = i5;
                oddRoundingErrors[i6] = f - i5;
            } else {
                evenCounts[i6] = i5;
                evenRoundingErrors[i6] = f - i5;
            }
        }
        adjustOddEvenCounts(z, i3);
        int length2 = oddCounts.length - 1;
        int i7 = 0;
        int i8 = 0;
        while (length2 >= 0) {
            int i9 = (i7 * 9) + oddCounts[length2];
            length2--;
            i7 = i9;
            i8 = oddCounts[length2] + i8;
        }
        int i10 = 0;
        int i11 = 0;
        for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
            i10 = (i10 * 9) + evenCounts[length3];
            i11 += evenCounts[length3];
        }
        int i12 = i7 + (i10 * 3);
        if (z) {
            if ((i8 & 1) != 0 || i8 > 12 || i8 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i13 = (12 - i8) / 2;
            int i14 = OUTSIDE_ODD_WIDEST[i13];
            return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i14, false) * OUTSIDE_EVEN_TOTAL_SUBSET[i13]) + RSSUtils.getRSSvalue(evenCounts, 9 - i14, true) + OUTSIDE_GSUM[i13], i12);
        } else if ((i11 & 1) != 0 || i11 > 10 || i11 < 4) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            int i15 = (10 - i11) / 2;
            int i16 = INSIDE_ODD_WIDEST[i15];
            return new DataCharacter(RSSUtils.getRSSvalue(oddCounts, i16, true) + (RSSUtils.getRSSvalue(evenCounts, 9 - i16, false) * INSIDE_ODD_TOTAL_SUBSET[i15]) + INSIDE_GSUM[i15], i12);
        }
    }

    private int[] findFinderPattern(BitArray bitArray, int i, boolean z) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        boolean z2 = false;
        int i2 = i;
        while (i2 < size) {
            z2 = !bitArray.get(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        boolean z3 = z2;
        int i3 = i2;
        int i4 = 0;
        for (int i5 = i2; i5 < size; i5++) {
            if (bitArray.get(i5) ^ z3) {
                decodeFinderCounters[i4] = decodeFinderCounters[i4] + 1;
            } else {
                if (i4 == 3) {
                    if (isFinderPattern(decodeFinderCounters)) {
                        return new int[]{i3, i5};
                    }
                    i3 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i4--;
                } else {
                    i4++;
                }
                decodeFinderCounters[i4] = 1;
                z3 = !z3;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z, int[] iArr) throws NotFoundException {
        int i2;
        boolean z2 = bitArray.get(iArr[0]);
        int i3 = iArr[0] - 1;
        while (i3 >= 0 && (bitArray.get(i3) ^ z2)) {
            i3--;
        }
        int i4 = i3 + 1;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = iArr[0] - i4;
        int parseFinderValue = parseFinderValue(decodeFinderCounters, FINDER_PATTERNS);
        int i5 = iArr[1];
        if (z) {
            i2 = (bitArray.getSize() - 1) - i4;
            i5 = (bitArray.getSize() - 1) - i5;
        } else {
            i2 = i4;
        }
        return new FinderPattern(parseFinderValue, new int[]{i4, iArr[1]}, i2, i5, i);
    }

    private void adjustOddEvenCounts(boolean z, int i) throws NotFoundException {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8 = true;
        int sum = MathUtils.sum(getOddCounts());
        int sum2 = MathUtils.sum(getEvenCounts());
        if (z) {
            if (sum > 12) {
                z2 = true;
                z3 = false;
            } else if (sum < 4) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (sum2 > 12) {
                z4 = true;
                z5 = false;
            } else {
                if (sum2 < 4) {
                    z4 = false;
                    z5 = true;
                }
                z4 = false;
                z5 = false;
            }
        } else {
            if (sum > 11) {
                z2 = true;
                z3 = false;
            } else if (sum < 5) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (sum2 > 10) {
                z4 = true;
                z5 = false;
            } else {
                if (sum2 < 4) {
                    z4 = false;
                    z5 = true;
                }
                z4 = false;
                z5 = false;
            }
        }
        int i2 = (sum + sum2) - i;
        boolean z9 = (sum & 1) == (z ? 1 : 0);
        boolean z10 = (sum2 & 1) == 1;
        if (i2 == 1) {
            if (z9) {
                if (z10) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z7 = z3;
                z8 = z5;
                z6 = true;
            } else if (!z10) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z4 = true;
                z8 = z5;
                z6 = z2;
                z7 = z3;
            }
        } else if (i2 == -1) {
            if (z9) {
                if (z10) {
                    throw NotFoundException.getNotFoundInstance();
                }
                boolean z11 = z5;
                z6 = z2;
                z7 = true;
                z8 = z11;
            } else if (!z10) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z6 = z2;
                z7 = z3;
            }
        } else if (i2 == 0) {
            if (z9) {
                if (!z10) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (sum < sum2) {
                    z4 = true;
                    boolean z12 = z5;
                    z6 = z2;
                    z7 = true;
                    z8 = z12;
                } else {
                    z6 = true;
                    z7 = z3;
                }
            } else if (z10) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z8 = z5;
                z6 = z2;
                z7 = z3;
            }
        } else {
            throw NotFoundException.getNotFoundInstance();
        }
        if (z7) {
            if (z6) {
                throw NotFoundException.getNotFoundInstance();
            }
            increment(getOddCounts(), getOddRoundingErrors());
        }
        if (z6) {
            decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (z8) {
            if (z4) {
                throw NotFoundException.getNotFoundInstance();
            }
            increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (z4) {
            decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }
}
