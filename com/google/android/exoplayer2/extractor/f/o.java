package com.google.android.exoplayer2.extractor.f;

import java.util.Arrays;
/* loaded from: classes4.dex */
final class o {
    private boolean miD;
    private final int mjK;
    private boolean mjL;
    public byte[] mjM;
    public int mjN;

    public o(int i, int i2) {
        this.mjK = i;
        this.mjM = new byte[i2 + 3];
        this.mjM[2] = 1;
    }

    public void reset() {
        this.miD = false;
        this.mjL = false;
    }

    public boolean aW() {
        return this.mjL;
    }

    public void JL(int i) {
        com.google.android.exoplayer2.util.a.checkState(!this.miD);
        this.miD = i == this.mjK;
        if (this.miD) {
            this.mjN = 3;
            this.mjL = false;
        }
    }

    public void t(byte[] bArr, int i, int i2) {
        if (this.miD) {
            int i3 = i2 - i;
            if (this.mjM.length < this.mjN + i3) {
                this.mjM = Arrays.copyOf(this.mjM, (this.mjN + i3) * 2);
            }
            System.arraycopy(bArr, i, this.mjM, this.mjN, i3);
            this.mjN = i3 + this.mjN;
        }
    }

    public boolean JM(int i) {
        if (this.miD) {
            this.mjN -= i;
            this.miD = false;
            this.mjL = true;
            return true;
        }
        return false;
    }
}
