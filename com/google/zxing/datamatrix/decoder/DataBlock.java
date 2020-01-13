package com.google.zxing.datamatrix.decoder;

import com.google.zxing.datamatrix.decoder.Version;
/* loaded from: classes8.dex */
final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DataBlock[] getDataBlocks(byte[] bArr, Version version) {
        Version.ECBlocks eCBlocks = version.getECBlocks();
        Version.ECB[] eCBlocks2 = eCBlocks.getECBlocks();
        int i = 0;
        for (Version.ECB ecb : eCBlocks2) {
            i += ecb.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[i];
        int length = eCBlocks2.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Version.ECB ecb2 = eCBlocks2[i2];
            int i4 = i3;
            int i5 = 0;
            while (i5 < ecb2.getCount()) {
                int dataCodewords = ecb2.getDataCodewords();
                dataBlockArr[i4] = new DataBlock(dataCodewords, new byte[eCBlocks.getECCodewords() + dataCodewords]);
                i5++;
                i4++;
            }
            i2++;
            i3 = i4;
        }
        int length2 = dataBlockArr[0].codewords.length - eCBlocks.getECCodewords();
        int i6 = length2 - 1;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            int i9 = 0;
            while (i9 < i3) {
                dataBlockArr[i9].codewords[i8] = bArr[i7];
                i9++;
                i7++;
            }
        }
        boolean z = version.getVersionNumber() == 24;
        int i10 = z ? 8 : i3;
        int i11 = 0;
        while (i11 < i10) {
            dataBlockArr[i11].codewords[length2 - 1] = bArr[i7];
            i11++;
            i7++;
        }
        int length3 = dataBlockArr[0].codewords.length;
        int i12 = i7;
        while (length2 < length3) {
            int i13 = 0;
            int i14 = i12;
            while (i13 < i3) {
                int i15 = z ? (i13 + 8) % i3 : i13;
                dataBlockArr[i15].codewords[(!z || i15 <= 7) ? length2 : length2 - 1] = bArr[i14];
                i13++;
                i14++;
            }
            length2++;
            i12 = i14;
        }
        if (i12 != bArr.length) {
            throw new IllegalArgumentException();
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
