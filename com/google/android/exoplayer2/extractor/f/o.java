package com.google.android.exoplayer2.extractor.f;

import java.util.Arrays;
/* loaded from: classes6.dex */
final class o {
    private boolean mnc;
    private final int moj;
    private boolean mok;
    public byte[] mol;
    public int mom;

    public o(int i, int i2) {
        this.moj = i;
        this.mol = new byte[i2 + 3];
        this.mol[2] = 1;
    }

    public void reset() {
        this.mnc = false;
        this.mok = false;
    }

    public boolean aW() {
        return this.mok;
    }

    public void JZ(int i) {
        com.google.android.exoplayer2.util.a.checkState(!this.mnc);
        this.mnc = i == this.moj;
        if (this.mnc) {
            this.mom = 3;
            this.mok = false;
        }
    }

    public void w(byte[] bArr, int i, int i2) {
        if (this.mnc) {
            int i3 = i2 - i;
            if (this.mol.length < this.mom + i3) {
                this.mol = Arrays.copyOf(this.mol, (this.mom + i3) * 2);
            }
            System.arraycopy(bArr, i, this.mol, this.mom, i3);
            this.mom = i3 + this.mom;
        }
    }

    public boolean Ka(int i) {
        if (this.mnc) {
            this.mom -= i;
            this.mnc = false;
            this.mok = true;
            return true;
        }
        return false;
    }
}
