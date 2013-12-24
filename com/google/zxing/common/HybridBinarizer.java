package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import java.lang.reflect.Array;
/* loaded from: classes.dex */
public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private static final int MIN_DYNAMIC_RANGE = 24;
    private BitMatrix matrix;

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() {
        if (this.matrix != null) {
            return this.matrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width >= MINIMUM_DIMENSION && height >= MINIMUM_DIMENSION) {
            byte[] matrix = luminanceSource.getMatrix();
            int i = width >> 3;
            if ((width & 7) != 0) {
                i++;
            }
            int i2 = height >> 3;
            if ((height & 7) != 0) {
                i2++;
            }
            int[][] calculateBlackPoints = calculateBlackPoints(matrix, i, i2, width, height);
            BitMatrix bitMatrix = new BitMatrix(width, height);
            calculateThresholdForBlock(matrix, i, i2, width, height, calculateBlackPoints, bitMatrix);
            this.matrix = bitMatrix;
        } else {
            this.matrix = super.getBlackMatrix();
        }
        return this.matrix;
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    private static void calculateThresholdForBlock(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, BitMatrix bitMatrix) {
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i5 << 3;
            int i7 = i4 - 8;
            if (i6 <= i7) {
                i7 = i6;
            }
            for (int i8 = 0; i8 < i; i8++) {
                int i9 = i8 << 3;
                int i10 = i3 - 8;
                if (i9 <= i10) {
                    i10 = i9;
                }
                int cap = cap(i8, 2, i - 3);
                int cap2 = cap(i5, 2, i2 - 3);
                int i11 = 0;
                for (int i12 = -2; i12 <= 2; i12++) {
                    int[] iArr2 = iArr[cap2 + i12];
                    i11 += iArr2[cap + 2] + iArr2[cap - 2] + iArr2[cap - 1] + iArr2[cap] + iArr2[cap + 1];
                }
                thresholdBlock(bArr, i10, i7, i11 / 25, i3, bitMatrix);
            }
        }
    }

    private static int cap(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private static void thresholdBlock(byte[] bArr, int i, int i2, int i3, int i4, BitMatrix bitMatrix) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    bitMatrix.set(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    private static int[][] calculateBlackPoints(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, i2, i);
        for (int i8 = 0; i8 < i2; i8++) {
            int i9 = i8 << 3;
            int i10 = i4 - 8;
            if (i9 <= i10) {
                i10 = i9;
            }
            for (int i11 = 0; i11 < i; i11++) {
                int i12 = i11 << 3;
                int i13 = i3 - 8;
                if (i12 <= i13) {
                    i13 = i12;
                }
                int i14 = 0;
                int i15 = 255;
                int i16 = 0;
                int i17 = 0;
                int i18 = (i10 * i3) + i13;
                while (i17 < 8) {
                    int i19 = 0;
                    while (i19 < 8) {
                        int i20 = bArr[i18 + i19] & 255;
                        int i21 = i14 + i20;
                        int i22 = i20 < i15 ? i20 : i15;
                        if (i20 <= i16) {
                            i20 = i16;
                        }
                        i19++;
                        i15 = i22;
                        i16 = i20;
                        i14 = i21;
                    }
                    if (i16 - i15 > 24) {
                        i5 = i18 + i3;
                        i6 = i17 + 1;
                        while (true) {
                            i7 = i14;
                            if (i6 >= 8) {
                                break;
                            }
                            i14 = i7;
                            for (int i23 = 0; i23 < 8; i23++) {
                                i14 += bArr[i5 + i23] & 255;
                            }
                            i6++;
                            i5 += i3;
                        }
                    } else {
                        i5 = i18;
                        i6 = i17;
                        i7 = i14;
                    }
                    int i24 = i6 + 1;
                    i18 = i5 + i3;
                    i14 = i7;
                    i17 = i24;
                }
                int i25 = i14 >> 6;
                if (i16 - i15 <= 24) {
                    int i26 = i15 >> 1;
                    if (i8 <= 0 || i11 <= 0 || i15 >= (i25 = ((iArr[i8 - 1][i11] + (iArr[i8][i11 - 1] * 2)) + iArr[i8 - 1][i11 - 1]) >> 2)) {
                        i25 = i26;
                    }
                }
                iArr[i8][i11] = i25;
            }
        }
        return iArr;
    }
}
