package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes7.dex */
public class a implements b {
    private final d oSP;
    private long oTH = -1;

    public a(d dVar) {
        this.oSP = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int L(long j, long j2) {
        if (!emW() && j / emV() >= this.oSP.getLoopCount()) {
            return -1;
        }
        return hR(j % emV());
    }

    public long emV() {
        if (this.oTH != -1) {
            return this.oTH;
        }
        this.oTH = 0L;
        int frameCount = this.oSP.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.oTH += this.oSP.Pu(i);
        }
        return this.oTH;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long hQ(long j) {
        long j2 = 0;
        long emV = emV();
        if (emV == 0) {
            return -1L;
        }
        if (emW() || j / emV() < this.oSP.getLoopCount()) {
            long j3 = j % emV;
            int frameCount = this.oSP.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.oSP.Pu(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean emW() {
        return this.oSP.getLoopCount() == 0;
    }

    int hR(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.oSP.Pu(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
