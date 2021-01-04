package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.Version;
/* loaded from: classes6.dex */
final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DataBlock[] getDataBlocks(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != version.getTotalCodewords()) {
            throw new IllegalArgumentException();
        }
        Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
        Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
        int i = 0;
        for (Version.ECB ecb : eCBlocks) {
            i += ecb.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[i];
        int i2 = 0;
        for (Version.ECB ecb2 : eCBlocks) {
            int i3 = 0;
            while (i3 < ecb2.getCount()) {
                int dataCodewords = ecb2.getDataCodewords();
                dataBlockArr[i2] = new DataBlock(dataCodewords, new byte[eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords]);
                i3++;
                i2++;
            }
        }
        int length = dataBlockArr[0].codewords.length;
        int length2 = dataBlockArr.length - 1;
        while (length2 >= 0 && dataBlockArr[length2].codewords.length != length) {
            length2--;
        }
        int i4 = length2 + 1;
        int eCCodewordsPerBlock = length - eCBlocksForLevel.getECCodewordsPerBlock();
        int i5 = 0;
        int i6 = 0;
        while (i5 < eCCodewordsPerBlock) {
            int i7 = 0;
            int i8 = i6;
            while (i7 < i2) {
                dataBlockArr[i7].codewords[i5] = bArr[i8];
                i7++;
                i8++;
            }
            i5++;
            i6 = i8;
        }
        int i9 = i4;
        while (i9 < i2) {
            dataBlockArr[i9].codewords[eCCodewordsPerBlock] = bArr[i6];
            i9++;
            i6++;
        }
        int length3 = dataBlockArr[0].codewords.length;
        while (eCCodewordsPerBlock < length3) {
            int i10 = 0;
            int i11 = i6;
            while (i10 < i2) {
                dataBlockArr[i10].codewords[i10 < i4 ? eCCodewordsPerBlock : eCCodewordsPerBlock + 1] = bArr[i11];
                i10++;
                i11++;
            }
            eCCodewordsPerBlock++;
            i6 = i11;
        }
        return dataBlockArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNumDataCodewords() {
        return this.numDataCodewords;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getCodewords() {
        return this.codewords;
    }
}
