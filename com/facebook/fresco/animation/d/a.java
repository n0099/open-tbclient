package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements b {
    private final d lXI;
    private long lYA = -1;

    public a(d dVar) {
        this.lXI = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int I(long j, long j2) {
        if (!dpX() && j / dpW() >= this.lXI.getLoopCount()) {
            return -1;
        }
        return fP(j % dpW());
    }

    public long dpW() {
        if (this.lYA != -1) {
            return this.lYA;
        }
        this.lYA = 0L;
        int frameCount = this.lXI.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.lYA += this.lXI.GA(i);
        }
        return this.lYA;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long fO(long j) {
        long j2 = 0;
        long dpW = dpW();
        if (dpW == 0) {
            return -1L;
        }
        if (dpX() || j / dpW() < this.lXI.getLoopCount()) {
            long j3 = j % dpW;
            int frameCount = this.lXI.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.lXI.GA(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dpX() {
        return this.lXI.getLoopCount() == 0;
    }

    int fP(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.lXI.GA(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
