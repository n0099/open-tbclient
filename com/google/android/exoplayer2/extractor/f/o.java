package com.google.android.exoplayer2.extractor.f;

import java.util.Arrays;
/* loaded from: classes6.dex */
final class o {
    private boolean moW;
    private final int mqd;
    private boolean mqe;
    public byte[] mqf;
    public int mqg;

    public o(int i, int i2) {
        this.mqd = i;
        this.mqf = new byte[i2 + 3];
        this.mqf[2] = 1;
    }

    public void reset() {
        this.moW = false;
        this.mqe = false;
    }

    public boolean aW() {
        return this.mqe;
    }

    public void Kf(int i) {
        com.google.android.exoplayer2.util.a.checkState(!this.moW);
        this.moW = i == this.mqd;
        if (this.moW) {
            this.mqg = 3;
            this.mqe = false;
        }
    }

    public void w(byte[] bArr, int i, int i2) {
        if (this.moW) {
            int i3 = i2 - i;
            if (this.mqf.length < this.mqg + i3) {
                this.mqf = Arrays.copyOf(this.mqf, (this.mqg + i3) * 2);
            }
            System.arraycopy(bArr, i, this.mqf, this.mqg, i3);
            this.mqg = i3 + this.mqg;
        }
    }

    public boolean Kg(int i) {
        if (this.moW) {
            this.mqg -= i;
            this.moW = false;
            this.mqe = true;
            return true;
        }
        return false;
    }
}
