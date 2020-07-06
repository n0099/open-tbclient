package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements b {
    private final d mOR;
    private long mPL = -1;

    public a(d dVar) {
        this.mOR = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int K(long j, long j2) {
        if (!dCh() && j / dCg() >= this.mOR.getLoopCount()) {
            return -1;
        }
        return fU(j % dCg());
    }

    public long dCg() {
        if (this.mPL != -1) {
            return this.mPL;
        }
        this.mPL = 0L;
        int frameCount = this.mOR.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.mPL += this.mOR.Iv(i);
        }
        return this.mPL;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long fT(long j) {
        long j2 = 0;
        long dCg = dCg();
        if (dCg == 0) {
            return -1L;
        }
        if (dCh() || j / dCg() < this.mOR.getLoopCount()) {
            long j3 = j % dCg;
            int frameCount = this.mOR.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.mOR.Iv(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dCh() {
        return this.mOR.getLoopCount() == 0;
    }

    int fU(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.mOR.Iv(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
