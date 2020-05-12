package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements b {
    private final d lXM;
    private long lYE = -1;

    public a(d dVar) {
        this.lXM = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int I(long j, long j2) {
        if (!dpV() && j / dpU() >= this.lXM.getLoopCount()) {
            return -1;
        }
        return fP(j % dpU());
    }

    public long dpU() {
        if (this.lYE != -1) {
            return this.lYE;
        }
        this.lYE = 0L;
        int frameCount = this.lXM.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.lYE += this.lXM.GA(i);
        }
        return this.lYE;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long fO(long j) {
        long j2 = 0;
        long dpU = dpU();
        if (dpU == 0) {
            return -1L;
        }
        if (dpV() || j / dpU() < this.lXM.getLoopCount()) {
            long j3 = j % dpU;
            int frameCount = this.lXM.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.lXM.GA(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dpV() {
        return this.lXM.getLoopCount() == 0;
    }

    int fP(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.lXM.GA(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
