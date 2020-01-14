package com.google.android.exoplayer2.extractor.f;

import java.util.Arrays;
/* loaded from: classes5.dex */
final class o {
    private boolean mmw;
    private final int mnD;
    private boolean mnE;
    public byte[] mnF;
    public int mnG;

    public o(int i, int i2) {
        this.mnD = i;
        this.mnF = new byte[i2 + 3];
        this.mnF[2] = 1;
    }

    public void reset() {
        this.mmw = false;
        this.mnE = false;
    }

    public boolean aW() {
        return this.mnE;
    }

    public void JU(int i) {
        com.google.android.exoplayer2.util.a.checkState(!this.mmw);
        this.mmw = i == this.mnD;
        if (this.mmw) {
            this.mnG = 3;
            this.mnE = false;
        }
    }

    public void s(byte[] bArr, int i, int i2) {
        if (this.mmw) {
            int i3 = i2 - i;
            if (this.mnF.length < this.mnG + i3) {
                this.mnF = Arrays.copyOf(this.mnF, (this.mnG + i3) * 2);
            }
            System.arraycopy(bArr, i, this.mnF, this.mnG, i3);
            this.mnG = i3 + this.mnG;
        }
    }

    public boolean JV(int i) {
        if (this.mmw) {
            this.mnG -= i;
            this.mmw = false;
            this.mnE = true;
            return true;
        }
        return false;
    }
}
