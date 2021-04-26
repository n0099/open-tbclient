package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;
/* loaded from: classes6.dex */
public class Code93Writer extends OneDimensionalCodeWriter {
    public static int appendPattern(boolean[] zArr, int i2, int[] iArr, boolean z) {
        int length = iArr.length;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i2 + 1;
            zArr[i2] = iArr[i3] != 0;
            i3++;
            i2 = i4;
        }
        return 9;
    }

    public static int computeChecksumIndex(String str, int i2) {
        int i3 = 0;
        int i4 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i3 += Code93Reader.ALPHABET_STRING.indexOf(str.charAt(length)) * i4;
            i4++;
            if (i4 > i2) {
                i4 = 1;
            }
        }
        return i3 % 47;
    }

    public static void toIntArray(int i2, int[] iArr) {
        for (int i3 = 0; i3 < 9; i3++) {
            int i4 = 1;
            if (((1 << (8 - i3)) & i2) == 0) {
                i4 = 0;
            }
            iArr[i3] = i4;
        }
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.encode(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            boolean[] zArr = new boolean[((str.length() + 2 + 2) * 9) + 1];
            toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], iArr);
            int appendPattern = appendPattern(zArr, 0, iArr, true);
            for (int i2 = 0; i2 < length; i2++) {
                toIntArray(Code93Reader.CHARACTER_ENCODINGS[Code93Reader.ALPHABET_STRING.indexOf(str.charAt(i2))], iArr);
                appendPattern += appendPattern(zArr, appendPattern, iArr, true);
            }
            int computeChecksumIndex = computeChecksumIndex(str, 20);
            toIntArray(Code93Reader.CHARACTER_ENCODINGS[computeChecksumIndex], iArr);
            int appendPattern2 = appendPattern + appendPattern(zArr, appendPattern, iArr, true);
            toIntArray(Code93Reader.CHARACTER_ENCODINGS[computeChecksumIndex(str + Code93Reader.ALPHABET_STRING.charAt(computeChecksumIndex), 15)], iArr);
            int appendPattern3 = appendPattern2 + appendPattern(zArr, appendPattern2, iArr, true);
            toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], iArr);
            zArr[appendPattern3 + appendPattern(zArr, appendPattern3, iArr, true)] = true;
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }
}
