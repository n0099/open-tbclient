package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
/* loaded from: classes9.dex */
public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    public static final int MAX_NB_BITS = 32;
    public static final int MAX_NB_BITS_COMPACT = 4;
    public static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    public static int[] bitsToWords(BitArray bitArray, int i, int i2) {
        int i3;
        int[] iArr = new int[i2];
        int size = bitArray.getSize() / i;
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                if (bitArray.get((i4 * i) + i6)) {
                    i3 = 1 << ((i - i6) - 1);
                } else {
                    i3 = 0;
                }
                i5 |= i3;
            }
            iArr[i4] = i5;
        }
        return iArr;
    }

    public static BitArray generateCheckWords(BitArray bitArray, int i, int i2) {
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

    public static BitArray generateModeMessage(boolean z, int i, int i2) {
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

    public static void drawBullsEye(BitMatrix bitMatrix, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 <= i6) {
                    bitMatrix.set(i5, i4);
                    bitMatrix.set(i5, i6);
                    bitMatrix.set(i4, i5);
                    bitMatrix.set(i6, i5);
                    i5++;
                }
            }
        }
        int i7 = i - i2;
        bitMatrix.set(i7, i7);
        int i8 = i7 + 1;
        bitMatrix.set(i8, i7);
        bitMatrix.set(i7, i8);
        int i9 = i + i2;
        bitMatrix.set(i9, i7);
        bitMatrix.set(i9, i8);
        bitMatrix.set(i9, i9 - 1);
    }

    public static void drawModeMessage(BitMatrix bitMatrix, boolean z, int i, BitArray bitArray) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (bitArray.get(i3)) {
                    bitMatrix.set(i4, i2 - 5);
                }
                if (bitArray.get(i3 + 7)) {
                    bitMatrix.set(i2 + 5, i4);
                }
                if (bitArray.get(20 - i3)) {
                    bitMatrix.set(i4, i2 + 5);
                }
                if (bitArray.get(27 - i3)) {
                    bitMatrix.set(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (bitArray.get(i3)) {
                bitMatrix.set(i5, i2 - 7);
            }
            if (bitArray.get(i3 + 10)) {
                bitMatrix.set(i2 + 7, i5);
            }
            if (bitArray.get(29 - i3)) {
                bitMatrix.set(i5, i2 + 7);
            }
            if (bitArray.get(39 - i3)) {
                bitMatrix.set(i2 - 7, i5);
            }
            i3++;
        }
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    public static AztecCode encode(byte[] bArr, int i, int i2) {
        boolean z;
        int i3;
        BitArray bitArray;
        int i4;
        boolean z2;
        int i5;
        int i6;
        int i7;
        int i8;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int i9 = 11;
        int size = ((encode.getSize() * i) / 100) + 11;
        int size2 = encode.getSize() + size;
        int i10 = 32;
        int i11 = 0;
        int i12 = 1;
        if (i2 != 0) {
            if (i2 < 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            i5 = Math.abs(i2);
            if (z2) {
                i10 = 4;
            }
            if (i5 <= i10) {
                i6 = totalBitsInLayer(i5, z2);
                i4 = WORD_SIZE[i5];
                int i13 = i6 - (i6 % i4);
                bitArray = stuffBits(encode, i4);
                if (bitArray.getSize() + size <= i13) {
                    if (z2 && bitArray.getSize() > (i4 << 6)) {
                        throw new IllegalArgumentException("Data to large for user specified layer");
                    }
                } else {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i2)));
            }
        } else {
            BitArray bitArray2 = null;
            int i14 = 0;
            int i15 = 0;
            while (i14 <= 32) {
                if (i14 <= 3) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    i3 = i14 + 1;
                } else {
                    i3 = i14;
                }
                int i16 = totalBitsInLayer(i3, z);
                if (size2 <= i16) {
                    int[] iArr = WORD_SIZE;
                    if (i15 != iArr[i3]) {
                        int i17 = iArr[i3];
                        i15 = i17;
                        bitArray2 = stuffBits(encode, i17);
                    }
                    int i18 = i16 - (i16 % i15);
                    if ((!z || bitArray2.getSize() <= (i15 << 6)) && bitArray2.getSize() + size <= i18) {
                        bitArray = bitArray2;
                        i4 = i15;
                        z2 = z;
                        i5 = i3;
                        i6 = i16;
                    }
                }
                i14++;
                i11 = 0;
                i12 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        BitArray generateCheckWords = generateCheckWords(bitArray, i6, i4);
        int size3 = bitArray.getSize() / i4;
        BitArray generateModeMessage = generateModeMessage(z2, i5, size3);
        if (!z2) {
            i9 = 14;
        }
        int i19 = i9 + (i5 << 2);
        int[] iArr2 = new int[i19];
        int i20 = 2;
        if (z2) {
            for (int i21 = 0; i21 < i19; i21++) {
                iArr2[i21] = i21;
            }
            i7 = i19;
        } else {
            int i22 = i19 / 2;
            i7 = i19 + 1 + (((i22 - 1) / 15) * 2);
            int i23 = i7 / 2;
            for (int i24 = 0; i24 < i22; i24++) {
                int i25 = (i24 / 15) + i24;
                iArr2[(i22 - i24) - i12] = (i23 - i25) - 1;
                iArr2[i22 + i24] = i25 + i23 + i12;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i7);
        int i26 = 0;
        int i27 = 0;
        while (i26 < i5) {
            int i28 = (i5 - i26) << i20;
            if (z2) {
                i8 = 9;
            } else {
                i8 = 12;
            }
            int i29 = i28 + i8;
            int i30 = 0;
            while (i30 < i29) {
                int i31 = i30 << 1;
                while (i11 < i20) {
                    if (generateCheckWords.get(i27 + i31 + i11)) {
                        int i32 = i26 << 1;
                        bitMatrix.set(iArr2[i32 + i11], iArr2[i32 + i30]);
                    }
                    if (generateCheckWords.get((i29 << 1) + i27 + i31 + i11)) {
                        int i33 = i26 << 1;
                        bitMatrix.set(iArr2[i33 + i30], iArr2[((i19 - 1) - i33) - i11]);
                    }
                    if (generateCheckWords.get((i29 << 2) + i27 + i31 + i11)) {
                        int i34 = (i19 - 1) - (i26 << 1);
                        bitMatrix.set(iArr2[i34 - i11], iArr2[i34 - i30]);
                    }
                    if (generateCheckWords.get((i29 * 6) + i27 + i31 + i11)) {
                        int i35 = i26 << 1;
                        bitMatrix.set(iArr2[((i19 - 1) - i35) - i30], iArr2[i35 + i11]);
                    }
                    i11++;
                    i20 = 2;
                }
                i30++;
                i11 = 0;
                i20 = 2;
            }
            i27 += i29 << 3;
            i26++;
            i11 = 0;
            i20 = 2;
        }
        drawModeMessage(bitMatrix, z2, i7, generateModeMessage);
        if (z2) {
            drawBullsEye(bitMatrix, i7 / 2, 5);
        } else {
            int i36 = i7 / 2;
            drawBullsEye(bitMatrix, i36, 7);
            int i37 = 0;
            int i38 = 0;
            while (i38 < (i19 / 2) - 1) {
                for (int i39 = i36 & 1; i39 < i7; i39 += 2) {
                    int i40 = i36 - i37;
                    bitMatrix.set(i40, i39);
                    int i41 = i36 + i37;
                    bitMatrix.set(i41, i39);
                    bitMatrix.set(i39, i40);
                    bitMatrix.set(i39, i41);
                }
                i38 += 15;
                i37 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z2);
        aztecCode.setSize(i7);
        aztecCode.setLayers(i5);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }

    public static GenericGF getGF(int i) {
        if (i != 4) {
            if (i != 6) {
                if (i != 8) {
                    if (i != 10) {
                        if (i == 12) {
                            return GenericGF.AZTEC_DATA_12;
                        }
                        throw new IllegalArgumentException("Unsupported word size " + i);
                    }
                    return GenericGF.AZTEC_DATA_10;
                }
                return GenericGF.AZTEC_DATA_8;
            }
            return GenericGF.AZTEC_DATA_6;
        }
        return GenericGF.AZTEC_PARAM;
    }

    public static BitArray stuffBits(BitArray bitArray, int i) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < size) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= size || bitArray.get(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                bitArray2.appendBits(i7, i);
            } else if (i7 == 0) {
                bitArray2.appendBits(i4 | 1, i);
            } else {
                bitArray2.appendBits(i4, i);
                i3 += i;
            }
            i3--;
            i3 += i;
        }
        return bitArray2;
    }
}
