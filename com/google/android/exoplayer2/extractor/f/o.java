package com.google.android.exoplayer2.extractor.f;

import java.util.Arrays;
/* loaded from: classes6.dex */
final class o {
    private boolean mne;
    private final int mol;
    private boolean mom;
    public byte[] moo;
    public int mop;

    public o(int i, int i2) {
        this.mol = i;
        this.moo = new byte[i2 + 3];
        this.moo[2] = 1;
    }

    public void reset() {
        this.mne = false;
        this.mom = false;
    }

    public boolean aW() {
        return this.mom;
    }

    public void JZ(int i) {
        com.google.android.exoplayer2.util.a.checkState(!this.mne);
        this.mne = i == this.mol;
        if (this.mne) {
            this.mop = 3;
            this.mom = false;
        }
    }

    public void w(byte[] bArr, int i, int i2) {
        if (this.mne) {
            int i3 = i2 - i;
            if (this.moo.length < this.mop + i3) {
                this.moo = Arrays.copyOf(this.moo, (this.mop + i3) * 2);
            }
            System.arraycopy(bArr, i, this.moo, this.mop, i3);
            this.mop = i3 + this.mop;
        }
    }

    public boolean Ka(int i) {
        if (this.mne) {
            this.mop -= i;
            this.mne = false;
            this.mom = true;
            return true;
        }
        return false;
    }
}
