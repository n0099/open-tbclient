package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements b {
    private final d mOO;
    private long mPI = -1;

    public a(d dVar) {
        this.mOO = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int K(long j, long j2) {
        if (!dCd() && j / dCc() >= this.mOO.getLoopCount()) {
            return -1;
        }
        return fU(j % dCc());
    }

    public long dCc() {
        if (this.mPI != -1) {
            return this.mPI;
        }
        this.mPI = 0L;
        int frameCount = this.mOO.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.mPI += this.mOO.Iv(i);
        }
        return this.mPI;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long fT(long j) {
        long j2 = 0;
        long dCc = dCc();
        if (dCc == 0) {
            return -1L;
        }
        if (dCd() || j / dCc() < this.mOO.getLoopCount()) {
            long j3 = j % dCc;
            int frameCount = this.mOO.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.mOO.Iv(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dCd() {
        return this.mOO.getLoopCount() == 0;
    }

    int fU(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.mOO.Iv(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
