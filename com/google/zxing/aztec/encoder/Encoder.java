package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
/* loaded from: classes6.dex */
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
        int i3;
        BitArray bitArray;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int size = ((encode.getSize() * i) / 100) + 11;
        int size2 = encode.getSize() + size;
        if (i2 != 0) {
            boolean z2 = i2 < 0;
            int abs = Math.abs(i2);
            if (abs > (z2 ? 4 : 32)) {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i2)));
            }
            int i8 = totalBitsInLayer(abs, z2);
            int i9 = WORD_SIZE[abs];
            int i10 = i8 - (i8 % i9);
            BitArray stuffBits = stuffBits(encode, i9);
            if (stuffBits.getSize() + size > i10) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
            if (z2 && stuffBits.getSize() > (i9 << 6)) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
            i3 = i9;
            i5 = i8;
            i4 = abs;
            z = z2;
            bitArray = stuffBits;
        } else {
            i3 = 0;
            bitArray = null;
            int i11 = 0;
            while (i11 <= 32) {
                boolean z3 = i11 <= 3;
                int i12 = z3 ? i11 + 1 : i11;
                int i13 = totalBitsInLayer(i12, z3);
                if (size2 <= i13) {
                    if (i3 != WORD_SIZE[i12]) {
                        i3 = WORD_SIZE[i12];
                        bitArray = stuffBits(encode, i3);
                    }
                    int i14 = i13 - (i13 % i3);
                    if ((!z3 || bitArray.getSize() <= (i3 << 6)) && bitArray.getSize() + size <= i14) {
                        i4 = i12;
                        i5 = i13;
                        z = z3;
                    }
                }
                i11++;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        BitArray generateCheckWords = generateCheckWords(bitArray, i5, i3);
        int size3 = bitArray.getSize() / i3;
        BitArray generateModeMessage = generateModeMessage(z, i4, size3);
        int i15 = (i4 << 2) + (z ? 11 : 14);
        int[] iArr = new int[i15];
        if (z) {
            for (int i16 = 0; i16 < iArr.length; i16++) {
                iArr[i16] = i16;
            }
            i6 = i15;
        } else {
            i6 = i15 + 1 + ((((i15 / 2) - 1) / 15) * 2);
            int i17 = i15 / 2;
            int i18 = i6 / 2;
            for (int i19 = 0; i19 < i17; i19++) {
                iArr[(i17 - i19) - 1] = (i18 - i7) - 1;
                iArr[i17 + i19] = (i19 / 15) + i19 + i18 + 1;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i6);
        int i20 = 0;
        for (int i21 = 0; i21 < i4; i21++) {
            int i22 = ((i4 - i21) << 2) + (z ? 9 : 12);
            for (int i23 = 0; i23 < i22; i23++) {
                int i24 = i23 << 1;
                for (int i25 = 0; i25 < 2; i25++) {
                    if (generateCheckWords.get(i20 + i24 + i25)) {
                        bitMatrix.set(iArr[(i21 << 1) + i25], iArr[(i21 << 1) + i23]);
                    }
                    if (generateCheckWords.get((i22 << 1) + i20 + i24 + i25)) {
                        bitMatrix.set(iArr[(i21 << 1) + i23], iArr[((i15 - 1) - (i21 << 1)) - i25]);
                    }
                    if (generateCheckWords.get((i22 << 2) + i20 + i24 + i25)) {
                        bitMatrix.set(iArr[((i15 - 1) - (i21 << 1)) - i25], iArr[((i15 - 1) - (i21 << 1)) - i23]);
                    }
                    if (generateCheckWords.get((i22 * 6) + i20 + i24 + i25)) {
                        bitMatrix.set(iArr[((i15 - 1) - (i21 << 1)) - i23], iArr[(i21 << 1) + i25]);
                    }
                }
            }
            i20 = (i22 << 3) + i20;
        }
        drawModeMessage(bitMatrix, z, i6, generateModeMessage);
        if (z) {
            drawBullsEye(bitMatrix, i6 / 2, 5);
        } else {
            drawBullsEye(bitMatrix, i6 / 2, 7);
            int i26 = 0;
            int i27 = 0;
            while (i26 < (i15 / 2) - 1) {
                for (int i28 = (i6 / 2) & 1; i28 < i6; i28 += 2) {
                    bitMatrix.set((i6 / 2) - i27, i28);
                    bitMatrix.set((i6 / 2) + i27, i28);
                    bitMatrix.set(i28, (i6 / 2) - i27);
                    bitMatrix.set(i28, (i6 / 2) + i27);
                }
                i26 += 15;
                i27 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z);
        aztecCode.setSize(i6);
        aztecCode.setLayers(i4);
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
