package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements b {
    private final d msR;
    private long mtJ = -1;

    public a(d dVar) {
        this.msR = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int J(long j, long j2) {
        if (!dxB() && j / dxA() >= this.msR.getLoopCount()) {
            return -1;
        }
        return fP(j % dxA());
    }

    public long dxA() {
        if (this.mtJ != -1) {
            return this.mtJ;
        }
        this.mtJ = 0L;
        int frameCount = this.msR.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.mtJ += this.msR.Ho(i);
        }
        return this.mtJ;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long fO(long j) {
        long j2 = 0;
        long dxA = dxA();
        if (dxA == 0) {
            return -1L;
        }
        if (dxB() || j / dxA() < this.msR.getLoopCount()) {
            long j3 = j % dxA;
            int frameCount = this.msR.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.msR.Ho(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dxB() {
        return this.msR.getLoopCount() == 0;
    }

    int fP(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.msR.Ho(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
