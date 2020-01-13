package com.google.android.exoplayer2.extractor.f;

import java.util.Arrays;
/* loaded from: classes5.dex */
final class o {
    private boolean mmr;
    public byte[] mnA;
    public int mnB;
    private final int mny;
    private boolean mnz;

    public o(int i, int i2) {
        this.mny = i;
        this.mnA = new byte[i2 + 3];
        this.mnA[2] = 1;
    }

    public void reset() {
        this.mmr = false;
        this.mnz = false;
    }

    public boolean aW() {
        return this.mnz;
    }

    public void JU(int i) {
        com.google.android.exoplayer2.util.a.checkState(!this.mmr);
        this.mmr = i == this.mny;
        if (this.mmr) {
            this.mnB = 3;
            this.mnz = false;
        }
    }

    public void s(byte[] bArr, int i, int i2) {
        if (this.mmr) {
            int i3 = i2 - i;
            if (this.mnA.length < this.mnB + i3) {
                this.mnA = Arrays.copyOf(this.mnA, (this.mnB + i3) * 2);
            }
            System.arraycopy(bArr, i, this.mnA, this.mnB, i3);
            this.mnB = i3 + this.mnB;
        }
    }

    public boolean JV(int i) {
        if (this.mmr) {
            this.mnB -= i;
            this.mmr = false;
            this.mnz = true;
            return true;
        }
        return false;
    }
}
