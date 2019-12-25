package com.google.android.exoplayer2.extractor.d;
/* loaded from: classes4.dex */
final class i {
    private int bitOffset;
    private int byteOffset;
    private final byte[] data;
    private final int mhl;

    public i(byte[] bArr) {
        this.data = bArr;
        this.mhl = bArr.length;
    }

    public boolean dsM() {
        boolean z = (((this.data[this.byteOffset] & 255) >> this.bitOffset) & 1) == 1;
        JG(1);
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
        JG(i);
        return i5;
    }

    public void JG(int i) {
        int i2 = i / 8;
        this.byteOffset += i2;
        this.bitOffset = (i - (i2 * 8)) + this.bitOffset;
        if (this.bitOffset > 7) {
            this.byteOffset++;
            this.bitOffset -= 8;
        }
        dsN();
    }

    public int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    private void dsN() {
        com.google.android.exoplayer2.util.a.checkState(this.byteOffset >= 0 && (this.byteOffset < this.mhl || (this.byteOffset == this.mhl && this.bitOffset == 0)));
    }
}
