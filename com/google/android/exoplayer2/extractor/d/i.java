package com.google.android.exoplayer2.extractor.d;
/* loaded from: classes5.dex */
final class i {
    private int bitOffset;
    private int byteOffset;
    private final byte[] data;
    private final int mlc;

    public i(byte[] bArr) {
        this.data = bArr;
        this.mlc = bArr.length;
    }

    public boolean dtY() {
        boolean z = (((this.data[this.byteOffset] & 255) >> this.bitOffset) & 1) == 1;
        JP(1);
        return z;
    }

    public int readBits(int i) {
        int i2 = this.byteOffset;
        int min = Math.min(i, 8 - this.bitOffset);
        int i3 = i2 + 1;
        int i4 = ((this.data[i2] & 255) >> this.bitOffset) & (255 >> (8 - min));
        while (min < i) {
            i4 |= (this.data[i3] & 255) << min;
            min += 8;
            i3++;
        }
        int i5 = i4 & ((-1) >>> (32 - i));
        JP(i);
        return i5;
    }

    public void JP(int i) {
        int i2 = i / 8;
        this.byteOffset += i2;
        this.bitOffset = (i - (i2 * 8)) + this.bitOffset;
        if (this.bitOffset > 7) {
            this.byteOffset++;
            this.bitOffset -= 8;
        }
        dtZ();
    }

    public int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    private void dtZ() {
        com.google.android.exoplayer2.util.a.checkState(this.byteOffset >= 0 && (this.byteOffset < this.mlc || (this.byteOffset == this.mlc && this.bitOffset == 0)));
    }
}
