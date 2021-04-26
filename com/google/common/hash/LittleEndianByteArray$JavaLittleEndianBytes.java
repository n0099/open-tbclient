package com.google.common.hash;

import com.google.common.primitives.Longs;
/* loaded from: classes6.dex */
public enum LittleEndianByteArray$JavaLittleEndianBytes {
    INSTANCE { // from class: com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes.1
        @Override // com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes
        public long getLongLittleEndian(byte[] bArr, int i2) {
            return Longs.d(bArr[i2 + 7], bArr[i2 + 6], bArr[i2 + 5], bArr[i2 + 4], bArr[i2 + 3], bArr[i2 + 2], bArr[i2 + 1], bArr[i2]);
        }

        @Override // com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes
        public void putLongLittleEndian(byte[] bArr, int i2, long j) {
            long j2 = 255;
            for (int i3 = 0; i3 < 8; i3++) {
                bArr[i2 + i3] = (byte) ((j & j2) >> (i3 * 8));
                j2 <<= 8;
            }
        }
    };

    public abstract /* synthetic */ long getLongLittleEndian(byte[] bArr, int i2);

    public abstract /* synthetic */ void putLongLittleEndian(byte[] bArr, int i2, long j);
}
