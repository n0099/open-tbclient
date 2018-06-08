package com.google.zxing.oned.rss.expanded;

import com.baidu.location.BDLocation;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpStatus;
/* loaded from: classes3.dex */
public final class RSSExpandedReader extends AbstractRSSReader {
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int MAX_PAIRS = 11;
    private final List<ExpandedPair> pairs = new ArrayList(11);
    private final List<ExpandedRow> rows = new ArrayList();
    private final int[] startEnd = new int[2];
    private boolean startFromEven;
    private static final int[] SYMBOL_WIDEST = {7, 5, 4, 3, 1};
    private static final int[] EVEN_TOTAL_SUBSET = {4, 20, 52, 104, HttpStatus.SC_NO_CONTENT};
    private static final int[] GSUM = {0, 348, 1388, 2948, 3988};
    private static final int[][] FINDER_PATTERNS = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] WEIGHTS = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, SubsamplingScaleImageView.ORIENTATION_180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, HttpStatus.SC_RESET_CONTENT}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{BaseActivity.SHOW_SOFT_KEYBOARD_DELAY, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 187, 139, HttpStatus.SC_PARTIAL_CONTENT, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, SapiAccountManager.VERSION_CODE, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, HttpStatus.SC_NO_CONTENT, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, BDLocation.TypeServerError}, new int[]{79, 26, 78, 23, 69, HttpStatus.SC_MULTI_STATUS, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{BDLocation.TypeNetWorkLocation, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    private static final int[][] FINDER_PATTERN_SEQUENCES = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.pairs.clear();
        this.startFromEven = false;
        try {
            return constructResult(decodeRow2pairs(i, bitArray));
        } catch (NotFoundException e) {
            this.pairs.clear();
            this.startFromEven = true;
            return constructResult(decodeRow2pairs(i, bitArray));
        }
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.pairs.clear();
        this.rows.clear();
    }

    List<ExpandedPair> decodeRow2pairs(int i, BitArray bitArray) throws NotFoundException {
        while (true) {
            try {
                this.pairs.add(retrieveNextPair(bitArray, this.pairs, i));
            } catch (NotFoundException e) {
                if (this.pairs.isEmpty()) {
                    throw e;
                }
                if (checkChecksum()) {
                    return this.pairs;
                }
                boolean z = !this.rows.isEmpty();
                storeRow(i, false);
                if (z) {
                    List<ExpandedPair> checkRows = checkRows(false);
                    if (checkRows == null) {
                        List<ExpandedPair> checkRows2 = checkRows(true);
                        if (checkRows2 != null) {
                            return checkRows2;
                        }
                    } else {
                        return checkRows;
                    }
                }
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    private List<ExpandedPair> checkRows(boolean z) {
        List<ExpandedPair> list = null;
        if (this.rows.size() > 25) {
            this.rows.clear();
        } else {
            this.pairs.clear();
            if (z) {
                Collections.reverse(this.rows);
            }
            try {
                list = checkRows(new ArrayList(), 0);
            } catch (NotFoundException e) {
            }
            if (z) {
                Collections.reverse(this.rows);
            }
        }
        return list;
    }

    private List<ExpandedPair> checkRows(List<ExpandedRow> list, int i) throws NotFoundException {
        while (i < this.rows.size()) {
            ExpandedRow expandedRow = this.rows.get(i);
            this.pairs.clear();
            for (ExpandedRow expandedRow2 : list) {
                this.pairs.addAll(expandedRow2.getPairs());
            }
            this.pairs.addAll(expandedRow.getPairs());
            if (isValidSequence(this.pairs)) {
                if (checkChecksum()) {
                    return this.pairs;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(expandedRow);
                try {
                    return checkRows(arrayList, i + 1);
                } catch (NotFoundException e) {
                }
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static boolean isValidSequence(List<ExpandedPair> list) {
        int[][] iArr;
        boolean z;
        for (int[] iArr2 : FINDER_PATTERN_SEQUENCES) {
            if (list.size() <= iArr2.length) {
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        z = true;
                        break;
                    } else if (list.get(i).getFinderPattern().getValue() != iArr2[i]) {
                        z = false;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private void storeRow(int i, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.rows.size()) {
                break;
            }
            ExpandedRow expandedRow = this.rows.get(i2);
            if (expandedRow.getRowNumber() > i) {
                z2 = expandedRow.isEquivalent(this.pairs);
                break;
            }
            i2++;
            z3 = expandedRow.isEquivalent(this.pairs);
        }
        if (!z2 && !z3 && !isPartialRow(this.pairs, this.rows)) {
            this.rows.add(i2, new ExpandedRow(this.pairs, i, z));
            removePartialRows(this.pairs, this.rows);
        }
    }

    private static void removePartialRows(List<ExpandedPair> list, List<ExpandedRow> list2) {
        boolean z;
        boolean z2;
        Iterator<ExpandedRow> it = list2.iterator();
        while (it.hasNext()) {
            ExpandedRow next = it.next();
            if (next.getPairs().size() != list.size()) {
                Iterator<ExpandedPair> it2 = next.getPairs().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = true;
                        break;
                    }
                    ExpandedPair next2 = it2.next();
                    Iterator<ExpandedPair> it3 = list.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z2 = false;
                            continue;
                            break;
                        } else if (next2.equals(it3.next())) {
                            z2 = true;
                            continue;
                            break;
                        }
                    }
                    if (!z2) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    it.remove();
                }
            }
        }
    }

    private static boolean isPartialRow(Iterable<ExpandedPair> iterable, Iterable<ExpandedRow> iterable2) {
        boolean z;
        boolean z2;
        for (ExpandedRow expandedRow : iterable2) {
            Iterator<ExpandedPair> it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    continue;
                    break;
                }
                ExpandedPair next = it.next();
                Iterator<ExpandedPair> it2 = expandedRow.getPairs().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (next.equals(it2.next())) {
                            z2 = true;
                            continue;
                            break;
                        }
                    } else {
                        z2 = false;
                        continue;
                        break;
                    }
                }
                if (!z2) {
                    z = false;
                    continue;
                    break;
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    List<ExpandedRow> getRows() {
        return this.rows;
    }

    static Result constructResult(List<ExpandedPair> list) throws NotFoundException, FormatException {
        String parseInformation = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(list)).parseInformation();
        ResultPoint[] resultPoints = list.get(0).getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = list.get(list.size() - 1).getFinderPattern().getResultPoints();
        return new Result(parseInformation, null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private boolean checkChecksum() {
        ExpandedPair expandedPair = this.pairs.get(0);
        DataCharacter leftChar = expandedPair.getLeftChar();
        DataCharacter rightChar = expandedPair.getRightChar();
        if (rightChar == null) {
            return false;
        }
        int i = 2;
        int checksumPortion = rightChar.getChecksumPortion();
        for (int i2 = 1; i2 < this.pairs.size(); i2++) {
            ExpandedPair expandedPair2 = this.pairs.get(i2);
            checksumPortion += expandedPair2.getLeftChar().getChecksumPortion();
            i++;
            DataCharacter rightChar2 = expandedPair2.getRightChar();
            if (rightChar2 != null) {
                checksumPortion += rightChar2.getChecksumPortion();
                i++;
            }
        }
        return (checksumPortion % 211) + ((i + (-4)) * 211) == leftChar.getValue();
    }

    private static int getNextSecondBar(BitArray bitArray, int i) {
        if (bitArray.get(i)) {
            return bitArray.getNextSet(bitArray.getNextUnset(i));
        }
        return bitArray.getNextUnset(bitArray.getNextSet(i));
    }

    ExpandedPair retrieveNextPair(BitArray bitArray, List<ExpandedPair> list, int i) throws NotFoundException {
        boolean z;
        FinderPattern parseFoundFinderPattern;
        DataCharacter dataCharacter;
        boolean z2 = list.size() % 2 == 0;
        if (this.startFromEven) {
            z = !z2;
        } else {
            z = z2;
        }
        int i2 = -1;
        boolean z3 = true;
        do {
            findNextPair(bitArray, list, i2);
            parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i, z);
            if (parseFoundFinderPattern == null) {
                i2 = getNextSecondBar(bitArray, this.startEnd[0]);
                continue;
            } else {
                z3 = false;
                continue;
            }
        } while (z3);
        DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z, true);
        if (!list.isEmpty() && list.get(list.size() - 1).mustBeLast()) {
            throw NotFoundException.getNotFoundInstance();
        }
        try {
            dataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z, false);
        } catch (NotFoundException e) {
            dataCharacter = null;
        }
        return new ExpandedPair(decodeDataCharacter, dataCharacter, parseFoundFinderPattern, true);
    }

    private void findNextPair(BitArray bitArray, List<ExpandedPair> list, int i) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        if (i < 0) {
            if (list.isEmpty()) {
                i = 0;
            } else {
                i = list.get(list.size() - 1).getFinderPattern().getStartEnd()[1];
            }
        }
        boolean z = list.size() % 2 != 0;
        if (this.startFromEven) {
            z = !z;
        }
        boolean z2 = false;
        int i2 = i;
        while (i2 < size) {
            z2 = !bitArray.get(i2);
            if (!z2) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        boolean z3 = z2;
        int i5 = i3;
        for (int i6 = i2; i6 < size; i6++) {
            if (bitArray.get(i6) ^ z3) {
                decodeFinderCounters[i4] = decodeFinderCounters[i4] + 1;
            } else {
                if (i4 == 3) {
                    if (z) {
                        reverseCounters(decodeFinderCounters);
                    }
                    if (isFinderPattern(decodeFinderCounters)) {
                        this.startEnd[0] = i5;
                        this.startEnd[1] = i6;
                        return;
                    }
                    if (z) {
                        reverseCounters(decodeFinderCounters);
                    }
                    i5 += decodeFinderCounters[0] + decodeFinderCounters[1];
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

    private static void reverseCounters(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(length - i) - 1];
            iArr[(length - i) - 1] = i2;
        }
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z) {
        int i2;
        int nextUnset;
        int i3;
        if (z) {
            int i4 = this.startEnd[0] - 1;
            while (i4 >= 0 && !bitArray.get(i4)) {
                i4--;
            }
            i2 = i4 + 1;
            i3 = this.startEnd[0] - i2;
            nextUnset = this.startEnd[1];
        } else {
            i2 = this.startEnd[0];
            nextUnset = bitArray.getNextUnset(this.startEnd[1] + 1);
            i3 = nextUnset - this.startEnd[1];
        }
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i3;
        try {
            return new FinderPattern(parseFinderValue(decodeFinderCounters, FINDER_PATTERNS), new int[]{i2, nextUnset}, i2, nextUnset, i);
        } catch (NotFoundException e) {
            return null;
        }
    }

    DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z, boolean z2) throws NotFoundException {
        int[] dataCharacterCounters = getDataCharacterCounters();
        dataCharacterCounters[0] = 0;
        dataCharacterCounters[1] = 0;
        dataCharacterCounters[2] = 0;
        dataCharacterCounters[3] = 0;
        dataCharacterCounters[4] = 0;
        dataCharacterCounters[5] = 0;
        dataCharacterCounters[6] = 0;
        dataCharacterCounters[7] = 0;
        if (z2) {
            recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            recordPattern(bitArray, finderPattern.getStartEnd()[1], dataCharacterCounters);
            int i = 0;
            for (int length = dataCharacterCounters.length - 1; i < length; length--) {
                int i2 = dataCharacterCounters[i];
                dataCharacterCounters[i] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i2;
                i++;
            }
        }
        float sum = MathUtils.sum(dataCharacterCounters) / 17.0f;
        float f = (finderPattern.getStartEnd()[1] - finderPattern.getStartEnd()[0]) / 15.0f;
        if (Math.abs(sum - f) / f > 0.3f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        for (int i3 = 0; i3 < dataCharacterCounters.length; i3++) {
            float f2 = (1.0f * dataCharacterCounters[i3]) / sum;
            int i4 = (int) (0.5f + f2);
            if (i4 <= 0) {
                if (f2 < 0.3f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i4 = 1;
            } else if (i4 > 8) {
                if (f2 > 8.7f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i4 = 8;
            }
            int i5 = i3 / 2;
            if ((i3 & 1) == 0) {
                oddCounts[i5] = i4;
                oddRoundingErrors[i5] = f2 - i4;
            } else {
                evenCounts[i5] = i4;
                evenRoundingErrors[i5] = f2 - i4;
            }
        }
        adjustOddEvenCounts(17);
        int value = ((z2 ? 0 : 1) + ((finderPattern.getValue() * 4) + (z ? 0 : 2))) - 1;
        int i6 = 0;
        int length2 = oddCounts.length - 1;
        int i7 = 0;
        while (length2 >= 0) {
            if (isNotA1left(finderPattern, z, z2)) {
                i7 += WEIGHTS[value][length2 * 2] * oddCounts[length2];
            }
            length2--;
            i6 = oddCounts[length2] + i6;
        }
        int i8 = 0;
        for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
            if (isNotA1left(finderPattern, z, z2)) {
                i8 += WEIGHTS[value][(length3 * 2) + 1] * evenCounts[length3];
            }
        }
        int i9 = i7 + i8;
        if ((i6 & 1) != 0 || i6 > 13 || i6 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i10 = (13 - i6) / 2;
        int i11 = SYMBOL_WIDEST[i10];
        return new DataCharacter(GSUM[i10] + (RSSUtils.getRSSvalue(oddCounts, i11, true) * EVEN_TOTAL_SUBSET[i10]) + RSSUtils.getRSSvalue(evenCounts, 9 - i11, false), i9);
    }

    private static boolean isNotA1left(FinderPattern finderPattern, boolean z, boolean z2) {
        return (finderPattern.getValue() == 0 && z && z2) ? false : true;
    }

    private void adjustOddEvenCounts(int i) throws NotFoundException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = true;
        int sum = MathUtils.sum(getOddCounts());
        int sum2 = MathUtils.sum(getEvenCounts());
        if (sum > 13) {
            z = true;
            z2 = false;
        } else if (sum < 4) {
            z = false;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        if (sum2 > 13) {
            z3 = true;
            z4 = false;
        } else if (sum2 < 4) {
            z3 = false;
            z4 = true;
        } else {
            z3 = false;
            z4 = false;
        }
        int i2 = (sum + sum2) - i;
        boolean z8 = (sum & 1) == 1;
        boolean z9 = (sum2 & 1) == 0;
        if (i2 == 1) {
            if (z8) {
                if (z9) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z6 = z2;
                z7 = z4;
                z5 = true;
            } else if (!z9) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z3 = true;
                z7 = z4;
                z5 = z;
                z6 = z2;
            }
        } else if (i2 == -1) {
            if (z8) {
                if (z9) {
                    throw NotFoundException.getNotFoundInstance();
                }
                boolean z10 = z4;
                z5 = z;
                z6 = true;
                z7 = z10;
            } else if (!z9) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z5 = z;
                z6 = z2;
            }
        } else if (i2 == 0) {
            if (z8) {
                if (!z9) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (sum < sum2) {
                    z3 = true;
                    boolean z11 = z4;
                    z5 = z;
                    z6 = true;
                    z7 = z11;
                } else {
                    z5 = true;
                    z6 = z2;
                }
            } else if (z9) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z7 = z4;
                z5 = z;
                z6 = z2;
            }
        } else {
            throw NotFoundException.getNotFoundInstance();
        }
        if (z6) {
            if (z5) {
                throw NotFoundException.getNotFoundInstance();
            }
            increment(getOddCounts(), getOddRoundingErrors());
        }
        if (z5) {
            decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (z7) {
            if (z3) {
                throw NotFoundException.getNotFoundInstance();
            }
            increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (z3) {
            decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }
}
