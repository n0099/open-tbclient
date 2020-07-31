package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
/* loaded from: classes6.dex */
final class BitMatrixParser {
    private final BitMatrix mappingBitMatrix;
    private final BitMatrix readMappingMatrix;
    private final Version version;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 8 || height > 144 || (height & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        this.version = readVersion(bitMatrix);
        this.mappingBitMatrix = extractDataRegion(bitMatrix);
        this.readMappingMatrix = new BitMatrix(this.mappingBitMatrix.getWidth(), this.mappingBitMatrix.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Version getVersion() {
        return this.version;
    }

    private static Version readVersion(BitMatrix bitMatrix) throws FormatException {
        return Version.getVersionForDimensions(bitMatrix.getHeight(), bitMatrix.getWidth());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] readCodewords() throws FormatException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z = false;
        byte[] bArr = new byte[this.version.getTotalCodewords()];
        int height = this.mappingBitMatrix.getHeight();
        int width = this.mappingBitMatrix.getWidth();
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i7 = 0;
        int i8 = 4;
        int i9 = 0;
        while (true) {
            if (i8 == height && i7 == 0 && !z4) {
                bArr[i9] = (byte) readCorner1(height, width);
                int i10 = i7 + 2;
                i3 = i9 + 1;
                i5 = i8 - 2;
                i6 = i10;
                z4 = true;
            } else if (i8 == height - 2 && i7 == 0 && (width & 3) != 0 && !z3) {
                bArr[i9] = (byte) readCorner2(height, width);
                int i11 = i7 + 2;
                i3 = i9 + 1;
                i5 = i8 - 2;
                i6 = i11;
                z3 = true;
            } else if (i8 == height + 4 && i7 == 2 && (width & 7) == 0 && !z2) {
                bArr[i9] = (byte) readCorner3(height, width);
                int i12 = i7 + 2;
                i3 = i9 + 1;
                i5 = i8 - 2;
                i6 = i12;
                z2 = true;
            } else if (i8 == height - 2 && i7 == 0 && (width & 7) == 4 && !z) {
                bArr[i9] = (byte) readCorner4(height, width);
                int i13 = i7 + 2;
                i3 = i9 + 1;
                i5 = i8 - 2;
                i6 = i13;
                z = true;
            } else {
                int i14 = i7;
                int i15 = i8;
                int i16 = i9;
                int i17 = i15;
                while (true) {
                    if (i17 >= height || i14 < 0 || this.readMappingMatrix.get(i14, i17)) {
                        i = i16;
                    } else {
                        i = i16 + 1;
                        bArr[i16] = (byte) readUtah(i17, i14, height, width);
                    }
                    i17 -= 2;
                    i2 = i14 + 2;
                    if (i17 < 0 || i2 >= width) {
                        break;
                    }
                    i14 = i2;
                    i16 = i;
                }
                int i18 = i17 + 1;
                int i19 = i2 + 3;
                int i20 = i;
                while (true) {
                    if (i18 < 0 || i19 >= width || this.readMappingMatrix.get(i19, i18)) {
                        i3 = i20;
                    } else {
                        i3 = i20 + 1;
                        bArr[i20] = (byte) readUtah(i18, i19, height, width);
                    }
                    i18 += 2;
                    i4 = i19 - 2;
                    if (i18 >= height || i4 < 0) {
                        break;
                    }
                    i19 = i4;
                    i20 = i3;
                }
                i5 = i18 + 3;
                i6 = i4 + 1;
            }
            if (i5 >= height && i6 >= width) {
                break;
            }
            i9 = i3;
            i7 = i6;
            i8 = i5;
        }
        if (i3 != this.version.getTotalCodewords()) {
            throw FormatException.getFormatInstance();
        }
        return bArr;
    }

    private boolean readModule(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (i < 0) {
            i6 = i + i3;
            i5 = (4 - ((i3 + 4) & 7)) + i2;
        } else {
            i5 = i2;
            i6 = i;
        }
        if (i5 < 0) {
            i5 += i4;
            i6 += 4 - ((i4 + 4) & 7);
        }
        this.readMappingMatrix.set(i5, i6);
        return this.mappingBitMatrix.get(i5, i6);
    }

    private int readUtah(int i, int i2, int i3, int i4) {
        int i5 = 0;
        if (readModule(i - 2, i2 - 2, i3, i4)) {
            i5 = 1;
        }
        int i6 = i5 << 1;
        if (readModule(i - 2, i2 - 1, i3, i4)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (readModule(i - 1, i2 - 2, i3, i4)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (readModule(i - 1, i2 - 1, i3, i4)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (readModule(i - 1, i2, i3, i4)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (readModule(i, i2 - 2, i3, i4)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (readModule(i, i2 - 1, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (readModule(i, i2, i3, i4)) {
            return i12 | 1;
        }
        return i12;
    }

    private int readCorner1(int i, int i2) {
        int i3 = (readModule(i + (-1), 0, i, i2) ? 1 : 0) << 1;
        if (readModule(i - 1, 1, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (readModule(i - 1, 2, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (readModule(0, i2 - 1, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (readModule(1, i2 - 1, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (readModule(2, i2 - 1, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (readModule(3, i2 - 1, i, i2)) {
            return i9 | 1;
        }
        return i9;
    }

    private int readCorner2(int i, int i2) {
        int i3 = (readModule(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (readModule(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (readModule(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (readModule(0, i2 - 4, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (readModule(0, i2 - 3, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (readModule(0, i2 - 1, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (readModule(1, i2 - 1, i, i2)) {
            return i9 | 1;
        }
        return i9;
    }

    private int readCorner3(int i, int i2) {
        int i3 = (readModule(i + (-1), 0, i, i2) ? 1 : 0) << 1;
        if (readModule(i - 1, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (readModule(0, i2 - 3, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (readModule(0, i2 - 1, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (readModule(1, i2 - 3, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (readModule(1, i2 - 2, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (readModule(1, i2 - 1, i, i2)) {
            return i9 | 1;
        }
        return i9;
    }

    private int readCorner4(int i, int i2) {
        int i3 = (readModule(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (readModule(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (readModule(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (readModule(0, i2 - 1, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (readModule(1, i2 - 1, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (readModule(2, i2 - 1, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (readModule(3, i2 - 1, i, i2)) {
            return i9 | 1;
        }
        return i9;
    }

    private BitMatrix extractDataRegion(BitMatrix bitMatrix) {
        int symbolSizeRows = this.version.getSymbolSizeRows();
        int symbolSizeColumns = this.version.getSymbolSizeColumns();
        if (bitMatrix.getHeight() != symbolSizeRows) {
            throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
        }
        int dataRegionSizeRows = this.version.getDataRegionSizeRows();
        int dataRegionSizeColumns = this.version.getDataRegionSizeColumns();
        int i = symbolSizeRows / dataRegionSizeRows;
        int i2 = symbolSizeColumns / dataRegionSizeColumns;
        BitMatrix bitMatrix2 = new BitMatrix(i2 * dataRegionSizeColumns, i * dataRegionSizeRows);
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 * dataRegionSizeRows;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i5 * dataRegionSizeColumns;
                for (int i7 = 0; i7 < dataRegionSizeRows; i7++) {
                    int i8 = ((dataRegionSizeRows + 2) * i3) + 1 + i7;
                    int i9 = i4 + i7;
                    for (int i10 = 0; i10 < dataRegionSizeColumns; i10++) {
                        if (bitMatrix.get(((dataRegionSizeColumns + 2) * i5) + 1 + i10, i8)) {
                            bitMatrix2.set(i6 + i10, i9);
                        }
                    }
                }
            }
        }
        return bitMatrix2;
    }
}
