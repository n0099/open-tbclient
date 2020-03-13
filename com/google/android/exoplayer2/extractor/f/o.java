package com.google.android.exoplayer2.extractor.f;

import java.util.Arrays;
/* loaded from: classes6.dex */
final class o {
    private boolean mnp;
    public int moA;
    private final int mox;
    private boolean moy;
    public byte[] moz;

    public o(int i, int i2) {
        this.mox = i;
        this.moz = new byte[i2 + 3];
        this.moz[2] = 1;
    }

    public void reset() {
        this.mnp = false;
        this.moy = false;
    }

    public boolean aW() {
        return this.moy;
    }

    public void JZ(int i) {
        com.google.android.exoplayer2.util.a.checkState(!this.mnp);
        this.mnp = i == this.mox;
        if (this.mnp) {
            this.moA = 3;
            this.moy = false;
        }
    }

    public void w(byte[] bArr, int i, int i2) {
        if (this.mnp) {
            int i3 = i2 - i;
            if (this.moz.length < this.moA + i3) {
                this.moz = Arrays.copyOf(this.moz, (this.moA + i3) * 2);
            }
            System.arraycopy(bArr, i, this.moz, this.moA, i3);
            this.moA = i3 + this.moA;
        }
    }

    public boolean Ka(int i) {
        if (this.mnp) {
            this.moA -= i;
            this.mnp = false;
            this.moy = true;
            return true;
        }
        return false;
    }
}
