package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes6.dex */
public class a implements b {
    private final d nqS;
    private long nrK = -1;

    public a(d dVar) {
        this.nqS = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int M(long j, long j2) {
        if (!dRt() && j / dRs() >= this.nqS.getLoopCount()) {
            return -1;
        }
        return gu(j % dRs());
    }

    public long dRs() {
        if (this.nrK != -1) {
            return this.nrK;
        }
        this.nrK = 0L;
        int frameCount = this.nqS.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.nrK += this.nqS.Lu(i);
        }
        return this.nrK;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long gt(long j) {
        long j2 = 0;
        long dRs = dRs();
        if (dRs == 0) {
            return -1L;
        }
        if (dRt() || j / dRs() < this.nqS.getLoopCount()) {
            long j3 = j % dRs;
            int frameCount = this.nqS.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.nqS.Lu(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dRt() {
        return this.nqS.getLoopCount() == 0;
    }

    int gu(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.nqS.Lu(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
