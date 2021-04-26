package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;
/* loaded from: classes6.dex */
public final class ITFWriter extends OneDimensionalCodeWriter {
    public static final int[] START_PATTERN = {1, 1, 1, 1};
    public static final int[] END_PATTERN = {3, 1, 1};

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.ITF) {
            return super.encode(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length % 2 == 0) {
            if (length <= 80) {
                boolean[] zArr = new boolean[(length * 9) + 9];
                int appendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, START_PATTERN, true);
                for (int i2 = 0; i2 < length; i2 += 2) {
                    int digit = Character.digit(str.charAt(i2), 10);
                    int digit2 = Character.digit(str.charAt(i2 + 1), 10);
                    int[] iArr = new int[18];
                    for (int i3 = 0; i3 < 5; i3++) {
                        int i4 = i3 * 2;
                        int[][] iArr2 = ITFReader.PATTERNS;
                        iArr[i4] = iArr2[digit][i3];
                        iArr[i4 + 1] = iArr2[digit2][i3];
                    }
                    appendPattern += OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, iArr, true);
                }
                OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, END_PATTERN, true);
                return zArr;
            }
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        throw new IllegalArgumentException("The length of the input should be even");
    }
}
