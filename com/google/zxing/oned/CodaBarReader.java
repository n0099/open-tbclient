package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes10.dex */
public final class CodaBarReader extends OneDReader {
    public static final float MAX_ACCEPTABLE = 2.0f;
    public static final int MIN_CHARACTER_LENGTH = 3;
    public static final float PADDING = 1.5f;
    public static final String ALPHABET_STRING = "0123456789-$:/.+ABCD";
    public static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    public static final int[] CHARACTER_ENCODINGS = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    public static final char[] STARTEND_ENCODING = {'A', 'B', 'C', 'D'};
    public final StringBuilder decodeRowResult = new StringBuilder(20);
    public int[] counters = new int[80];
    public int counterLength = 0;

    public static boolean arrayContains(char[] cArr, char c) {
        if (cArr != null) {
            for (char c2 : cArr) {
                if (c2 == c) {
                    return true;
                }
            }
        }
        return false;
    }

    private void counterAppend(int i) {
        int[] iArr = this.counters;
        int i2 = this.counterLength;
        iArr[i2] = i;
        int i3 = i2 + 1;
        this.counterLength = i3;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[i3 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.counters = iArr2;
        }
    }

    private void setCounters(BitArray bitArray) throws NotFoundException {
        int i = 0;
        this.counterLength = 0;
        int nextUnset = bitArray.getNextUnset(0);
        int size = bitArray.getSize();
        if (nextUnset < size) {
            boolean z = true;
            while (nextUnset < size) {
                if (bitArray.get(nextUnset) ^ z) {
                    i++;
                } else {
                    counterAppend(i);
                    z = !z;
                    i = 1;
                }
                nextUnset++;
            }
            counterAppend(i);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int findStartPattern() throws NotFoundException {
        for (int i = 1; i < this.counterLength; i += 2) {
            int narrowWidePattern = toNarrowWidePattern(i);
            if (narrowWidePattern != -1 && arrayContains(STARTEND_ENCODING, ALPHABET[narrowWidePattern])) {
                int i2 = 0;
                for (int i3 = i; i3 < i + 7; i3++) {
                    i2 += this.counters[i3];
                }
                if (i == 1 || this.counters[i - 1] >= i2 / 2) {
                    return i;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int toNarrowWidePattern(int i) {
        int i2;
        int i3 = i + 7;
        if (i3 >= this.counterLength) {
            return -1;
        }
        int[] iArr = this.counters;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        for (int i8 = i; i8 < i3; i8 += 2) {
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
        for (int i12 = i + 1; i12 < i3; i12 += 2) {
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
            if ((i17 & 1) == 0) {
                i2 = i10;
            } else {
                i2 = i14;
            }
            i15 >>= 1;
            if (iArr[i + i17] > i2) {
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

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ae, code lost:
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void validatePattern(int i) throws NotFoundException {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.decodeRowResult.length() - 1;
        int i2 = 0;
        int i3 = i;
        int i4 = 0;
        while (true) {
            int i5 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i4)];
            for (int i6 = 6; i6 >= 0; i6--) {
                int i7 = (i6 & 1) + ((i5 & 1) << 1);
                iArr[i7] = iArr[i7] + this.counters[i3 + i6];
                iArr2[i7] = iArr2[i7] + 1;
                i5 >>= 1;
            }
            if (i4 >= length) {
                break;
            }
            i3 += 8;
            i4++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i8 = 0; i8 < 2; i8++) {
            fArr2[i8] = 0.0f;
            int i9 = i8 + 2;
            fArr2[i9] = ((iArr[i8] / iArr2[i8]) + (iArr[i9] / iArr2[i9])) / 2.0f;
            fArr[i8] = fArr2[i9];
            fArr[i9] = ((iArr[i9] * 2.0f) + 1.5f) / iArr2[i9];
        }
        loop3: while (true) {
            int i10 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i2)];
            for (int i11 = 6; i11 >= 0; i11--) {
                int i12 = (i11 & 1) + ((i10 & 1) << 1);
                float f = this.counters[i + i11];
                if (f < fArr2[i12] || f > fArr[i12]) {
                    break loop3;
                }
                i10 >>= 1;
            }
            if (i2 < length) {
                i += 8;
                i2++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        Arrays.fill(this.counters, 0);
        setCounters(bitArray);
        int findStartPattern = findStartPattern();
        this.decodeRowResult.setLength(0);
        int i2 = findStartPattern;
        do {
            int narrowWidePattern = toNarrowWidePattern(i2);
            if (narrowWidePattern != -1) {
                this.decodeRowResult.append((char) narrowWidePattern);
                i2 += 8;
                if (this.decodeRowResult.length() > 1 && arrayContains(STARTEND_ENCODING, ALPHABET[narrowWidePattern])) {
                    break;
                }
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        } while (i2 < this.counterLength);
        int i3 = i2 - 1;
        int i4 = this.counters[i3];
        int i5 = 0;
        for (int i6 = -8; i6 < -1; i6++) {
            i5 += this.counters[i2 + i6];
        }
        if (i2 < this.counterLength && i4 < i5 / 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        validatePattern(findStartPattern);
        for (int i7 = 0; i7 < this.decodeRowResult.length(); i7++) {
            StringBuilder sb = this.decodeRowResult;
            sb.setCharAt(i7, ALPHABET[sb.charAt(i7)]);
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
                    int i8 = 0;
                    for (int i9 = 0; i9 < findStartPattern; i9++) {
                        i8 += this.counters[i9];
                    }
                    float f = i8;
                    while (findStartPattern < i3) {
                        i8 += this.counters[findStartPattern];
                        findStartPattern++;
                    }
                    float f2 = i;
                    return new Result(this.decodeRowResult.toString(), null, new ResultPoint[]{new ResultPoint(f, f2), new ResultPoint(i8, f2)}, BarcodeFormat.CODABAR);
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
