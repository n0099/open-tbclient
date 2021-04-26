package com.google.zxing.datamatrix.decoder;

import com.google.zxing.datamatrix.decoder.Version;
/* loaded from: classes6.dex */
public final class DataBlock {
    public final byte[] codewords;
    public final int numDataCodewords;

    public DataBlock(int i2, byte[] bArr) {
        this.numDataCodewords = i2;
        this.codewords = bArr;
    }

    public static DataBlock[] getDataBlocks(byte[] bArr, Version version) {
        Version.ECBlocks eCBlocks = version.getECBlocks();
        Version.ECB[] eCBlocks2 = eCBlocks.getECBlocks();
        int i2 = 0;
        for (Version.ECB ecb : eCBlocks2) {
            i2 += ecb.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[i2];
        int i3 = 0;
        for (Version.ECB ecb2 : eCBlocks2) {
            int i4 = 0;
            while (i4 < ecb2.getCount()) {
                int dataCodewords = ecb2.getDataCodewords();
                dataBlockArr[i3] = new DataBlock(dataCodewords, new byte[eCBlocks.getECCodewords() + dataCodewords]);
                i4++;
                i3++;
            }
        }
        int length = dataBlockArr[0].codewords.length - eCBlocks.getECCodewords();
        int i5 = length - 1;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = 0;
            while (i8 < i3) {
                dataBlockArr[i8].codewords[i7] = bArr[i6];
                i8++;
                i6++;
            }
        }
        boolean z = version.getVersionNumber() == 24;
        int i9 = z ? 8 : i3;
        int i10 = 0;
        while (i10 < i9) {
            dataBlockArr[i10].codewords[i5] = bArr[i6];
            i10++;
            i6++;
        }
        int length2 = dataBlockArr[0].codewords.length;
        while (length < length2) {
            int i11 = 0;
            while (i11 < i3) {
                int i12 = z ? (i11 + 8) % i3 : i11;
                dataBlockArr[i12].codewords[(!z || i12 <= 7) ? length : length - 1] = bArr[i6];
                i11++;
                i6++;
            }
            length++;
        }
        if (i6 == bArr.length) {
            return dataBlockArr;
        }
        throw new IllegalArgumentException();
    }

    public byte[] getCodewords() {
        return this.codewords;
    }

    public int getNumDataCodewords() {
        return this.numDataCodewords;
    }
}
