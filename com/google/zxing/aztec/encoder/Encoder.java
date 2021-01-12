package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
/* loaded from: classes5.dex */
public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private Encoder() {
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    public static AztecCode encode(byte[] bArr, int i, int i2) {
        boolean z;
        int i3;
        BitArray bitArray;
        int i4;
        int i5;
        int i6;
        int i7;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int size = ((encode.getSize() * i) / 100) + 11;
        int size2 = encode.getSize() + size;
        if (i2 != 0) {
            boolean z2 = i2 < 0;
            i5 = Math.abs(i2);
            if (i5 > (z2 ? 4 : 32)) {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i2)));
            }
            i3 = totalBitsInLayer(i5, z2);
            int i8 = WORD_SIZE[i5];
            int i9 = i3 - (i3 % i8);
            BitArray stuffBits = stuffBits(encode, i8);
            if (stuffBits.getSize() + size > i9) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
            if (z2 && stuffBits.getSize() > (i8 << 6)) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
            bitArray = stuffBits;
            i4 = i8;
            z = z2;
        } else {
            int i10 = 0;
            BitArray bitArray2 = null;
            int i11 = 0;
            while (i11 <= 32) {
                z = i11 <= 3;
                int i12 = z ? i11 + 1 : i11;
                i3 = totalBitsInLayer(i12, z);
                if (size2 <= i3) {
                    if (i10 != WORD_SIZE[i12]) {
                        i10 = WORD_SIZE[i12];
                        bitArray2 = stuffBits(encode, i10);
                    }
                    int i13 = i3 - (i3 % i10);
                    if ((!z || bitArray2.getSize() <= (i10 << 6)) && bitArray2.getSize() + size <= i13) {
                        bitArray = bitArray2;
                        i4 = i10;
                        i5 = i12;
                    }
                }
                i11++;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        BitArray generateCheckWords = generateCheckWords(bitArray, i3, i4);
        int size3 = bitArray.getSize() / i4;
        BitArray generateModeMessage = generateModeMessage(z, i5, size3);
        int i14 = (i5 << 2) + (z ? 11 : 14);
        int[] iArr = new int[i14];
        if (z) {
            for (int i15 = 0; i15 < iArr.length; i15++) {
                iArr[i15] = i15;
            }
            i6 = i14;
        } else {
            i6 = i14 + 1 + ((((i14 / 2) - 1) / 15) * 2);
            int i16 = i14 / 2;
            int i17 = i6 / 2;
            for (int i18 = 0; i18 < i16; i18++) {
                iArr[(i16 - i18) - 1] = (i17 - i7) - 1;
                iArr[i16 + i18] = (i18 / 15) + i18 + i17 + 1;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i6);
        int i19 = 0;
        for (int i20 = 0; i20 < i5; i20++) {
            int i21 = ((i5 - i20) << 2) + (z ? 9 : 12);
            for (int i22 = 0; i22 < i21; i22++) {
                int i23 = i22 << 1;
                for (int i24 = 0; i24 < 2; i24++) {
                    if (generateCheckWords.get(i19 + i23 + i24)) {
                        bitMatrix.set(iArr[(i20 << 1) + i24], iArr[(i20 << 1) + i22]);
                    }
                    if (generateCheckWords.get((i21 << 1) + i19 + i23 + i24)) {
                        bitMatrix.set(iArr[(i20 << 1) + i22], iArr[((i14 - 1) - (i20 << 1)) - i24]);
                    }
                    if (generateCheckWords.get((i21 << 2) + i19 + i23 + i24)) {
                        bitMatrix.set(iArr[((i14 - 1) - (i20 << 1)) - i24], iArr[((i14 - 1) - (i20 << 1)) - i22]);
                    }
                    if (generateCheckWords.get((i21 * 6) + i19 + i23 + i24)) {
                        bitMatrix.set(iArr[((i14 - 1) - (i20 << 1)) - i22], iArr[(i20 << 1) + i24]);
                    }
                }
            }
            i19 = (i21 << 3) + i19;
        }
        drawModeMessage(bitMatrix, z, i6, generateModeMessage);
        if (z) {
            drawBullsEye(bitMatrix, i6 / 2, 5);
        } else {
            drawBullsEye(bitMatrix, i6 / 2, 7);
            int i25 = 0;
            int i26 = 0;
            while (i25 < (i14 / 2) - 1) {
                for (int i27 = (i6 / 2) & 1; i27 < i6; i27 += 2) {
                    bitMatrix.set((i6 / 2) - i26, i27);
                    bitMatrix.set((i6 / 2) + i26, i27);
                    bitMatrix.set(i27, (i6 / 2) - i26);
                    bitMatrix.set(i27, (i6 / 2) + i26);
                }
                i25 += 15;
                i26 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z);
        aztecCode.setSize(i6);
        aztecCode.setLayers(i5);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            for (int i4 = i - i3; i4 <= i + i3; i4++) {
                bitMatrix.set(i4, i - i3);
                bitMatrix.set(i4, i + i3);
                bitMatrix.set(i - i3, i4);
                bitMatrix.set(i + i3, i4);
            }
        }
        bitMatrix.set(i - i2, i - i2);
        bitMatrix.set((i - i2) + 1, i - i2);
        bitMatrix.set(i - i2, (i - i2) + 1);
        bitMatrix.set(i + i2, i - i2);
        bitMatrix.set(i + i2, (i - i2) + 1);
        bitMatrix.set(i + i2, (i + i2) - 1);
    }

    static BitArray generateModeMessage(boolean z, int i, int i2) {
        BitArray bitArray = new BitArray();
        if (z) {
            bitArray.appendBits(i - 1, 2);
            bitArray.appendBits(i2 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i - 1, 5);
        bitArray.appendBits(i2 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z, int i, BitArray bitArray) {
        int i2 = 0;
        int i3 = i / 2;
        if (z) {
            while (i2 < 7) {
                int i4 = (i3 - 3) + i2;
                if (bitArray.get(i2)) {
                    bitMatrix.set(i4, i3 - 5);
                }
                if (bitArray.get(i2 + 7)) {
                    bitMatrix.set(i3 + 5, i4);
                }
                if (bitArray.get(20 - i2)) {
                    bitMatrix.set(i4, i3 + 5);
                }
                if (bitArray.get(27 - i2)) {
                    bitMatrix.set(i3 - 5, i4);
                }
                i2++;
            }
            return;
        }
        while (i2 < 10) {
            int i5 = (i3 - 5) + i2 + (i2 / 5);
            if (bitArray.get(i2)) {
                bitMatrix.set(i5, i3 - 7);
            }
            if (bitArray.get(i2 + 10)) {
                bitMatrix.set(i3 + 7, i5);
            }
            if (bitArray.get(29 - i2)) {
                bitMatrix.set(i5, i3 + 7);
            }
            if (bitArray.get(39 - i2)) {
                bitMatrix.set(i3 - 7, i5);
            }
            i2++;
        }
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i, int i2) {
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i2));
        int i3 = i / i2;
        int[] bitsToWords = bitsToWords(bitArray, i2, i3);
        reedSolomonEncoder.encode(bitsToWords, i3 - (bitArray.getSize() / i2));
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i % i2);
        for (int i4 : bitsToWords) {
            bitArray2.appendBits(i4, i2);
        }
        return bitArray2;
    }

    private static int[] bitsToWords(BitArray bitArray, int i, int i2) {
        int[] iArr = new int[i2];
        int size = bitArray.getSize() / i;
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= bitArray.get((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    private static GenericGF getGF(int i) {
        switch (i) {
            case 4:
                return GenericGF.AZTEC_PARAM;
            case 5:
            case 7:
            case 9:
            case 11:
            default:
                throw new IllegalArgumentException("Unsupported word size " + i);
            case 6:
                return GenericGF.AZTEC_DATA_6;
            case 8:
                return GenericGF.AZTEC_DATA_8;
            case 10:
                return GenericGF.AZTEC_DATA_10;
            case 12:
                return GenericGF.AZTEC_DATA_12;
        }
    }

    static BitArray stuffBits(BitArray bitArray, int i) {
        int i2;
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i3 = (1 << i) - 2;
        int i4 = 0;
        while (i4 < size) {
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                if (i4 + i6 >= size || bitArray.get(i4 + i6)) {
                    i5 |= 1 << ((i - 1) - i6);
                }
            }
            if ((i5 & i3) == i3) {
                bitArray2.appendBits(i5 & i3, i);
                i2 = i4 - 1;
            } else if ((i5 & i3) == 0) {
                bitArray2.appendBits(i5 | 1, i);
                i2 = i4 - 1;
            } else {
                bitArray2.appendBits(i5, i);
                i2 = i4;
            }
            i4 = i2 + i;
        }
        return bitArray2;
    }

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }
}
