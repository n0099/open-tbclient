package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
/* loaded from: classes6.dex */
final class BitMatrixParser {
    private final BitMatrix bitMatrix;
    private boolean mirror;
    private FormatInformation parsedFormatInfo;
    private Version parsedVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 21 || (height & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.bitMatrix = bitMatrix;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FormatInformation readFormatInformation() throws FormatException {
        int i = 0;
        if (this.parsedFormatInfo != null) {
            return this.parsedFormatInfo;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 = copyBit(i3, 8, i2);
        }
        int copyBit = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, i2)));
        for (int i4 = 5; i4 >= 0; i4--) {
            copyBit = copyBit(8, i4, copyBit);
        }
        int height = this.bitMatrix.getHeight();
        int i5 = height - 7;
        for (int i6 = height - 1; i6 >= i5; i6--) {
            i = copyBit(8, i6, i);
        }
        for (int i7 = height - 8; i7 < height; i7++) {
            i = copyBit(i7, 8, i);
        }
        this.parsedFormatInfo = FormatInformation.decodeFormatInformation(copyBit, i);
        if (this.parsedFormatInfo != null) {
            return this.parsedFormatInfo;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Version readVersion() throws FormatException {
        int i = 0;
        if (this.parsedVersion != null) {
            return this.parsedVersion;
        }
        int height = this.bitMatrix.getHeight();
        int i2 = (height - 17) / 4;
        if (i2 <= 6) {
            return Version.getVersionForNumber(i2);
        }
        int i3 = height - 11;
        int i4 = 0;
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = height - 9; i6 >= i3; i6--) {
                i4 = copyBit(i6, i5, i4);
            }
        }
        Version decodeVersionInformation = Version.decodeVersionInformation(i4);
        if (decodeVersionInformation != null && decodeVersionInformation.getDimensionForVersion() == height) {
            this.parsedVersion = decodeVersionInformation;
            return decodeVersionInformation;
        }
        for (int i7 = 5; i7 >= 0; i7--) {
            for (int i8 = height - 9; i8 >= i3; i8--) {
                i = copyBit(i7, i8, i);
            }
        }
        Version decodeVersionInformation2 = Version.decodeVersionInformation(i);
        if (decodeVersionInformation2 != null && decodeVersionInformation2.getDimensionForVersion() == height) {
            this.parsedVersion = decodeVersionInformation2;
            return decodeVersionInformation2;
        }
        throw FormatException.getFormatInstance();
    }

    private int copyBit(int i, int i2, int i3) {
        return this.mirror ? this.bitMatrix.get(i2, i) : this.bitMatrix.get(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] readCodewords() throws FormatException {
        int i;
        FormatInformation readFormatInformation = readFormatInformation();
        Version readVersion = readVersion();
        DataMask dataMask = DataMask.values()[readFormatInformation.getDataMask()];
        int height = this.bitMatrix.getHeight();
        dataMask.unmaskBitMatrix(this.bitMatrix, height);
        BitMatrix buildFunctionPattern = readVersion.buildFunctionPattern();
        byte[] bArr = new byte[readVersion.getTotalCodewords()];
        int i2 = height - 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        boolean z = true;
        while (i2 > 0) {
            if (i2 == 6) {
                i2--;
            }
            for (int i6 = 0; i6 < height; i6++) {
                int i7 = z ? (height - 1) - i6 : i6;
                int i8 = 0;
                while (i8 < 2) {
                    if (!buildFunctionPattern.get(i2 - i8, i7)) {
                        i3++;
                        i4 <<= 1;
                        if (this.bitMatrix.get(i2 - i8, i7)) {
                            i4 |= 1;
                        }
                        if (i3 == 8) {
                            i = i5 + 1;
                            bArr[i5] = (byte) i4;
                            i3 = 0;
                            i4 = 0;
                            i8++;
                            i5 = i;
                        }
                    }
                    i = i5;
                    i8++;
                    i5 = i;
                }
            }
            i2 -= 2;
            z = !z;
        }
        if (i5 != readVersion.getTotalCodewords()) {
            throw FormatException.getFormatInstance();
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remask() {
        if (this.parsedFormatInfo != null) {
            DataMask.values()[this.parsedFormatInfo.getDataMask()].unmaskBitMatrix(this.bitMatrix, this.bitMatrix.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMirror(boolean z) {
        this.parsedVersion = null;
        this.parsedFormatInfo = null;
        this.mirror = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mirror() {
        for (int i = 0; i < this.bitMatrix.getWidth(); i++) {
            for (int i2 = i + 1; i2 < this.bitMatrix.getHeight(); i2++) {
                if (this.bitMatrix.get(i, i2) != this.bitMatrix.get(i2, i)) {
                    this.bitMatrix.flip(i2, i);
                    this.bitMatrix.flip(i, i2);
                }
            }
        }
    }
}
