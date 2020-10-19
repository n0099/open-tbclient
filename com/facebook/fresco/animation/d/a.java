package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes14.dex */
public class a implements b {
    private final d nQB;
    private long nRt = -1;

    public a(d dVar) {
        this.nQB = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int J(long j, long j2) {
        if (!dZl() && j / dZk() >= this.nQB.getLoopCount()) {
            return -1;
        }
        return hc(j % dZk());
    }

    public long dZk() {
        if (this.nRt != -1) {
            return this.nRt;
        }
        this.nRt = 0L;
        int frameCount = this.nQB.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.nRt += this.nQB.MF(i);
        }
        return this.nRt;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long hb(long j) {
        long j2 = 0;
        long dZk = dZk();
        if (dZk == 0) {
            return -1L;
        }
        if (dZl() || j / dZk() < this.nQB.getLoopCount()) {
            long j3 = j % dZk;
            int frameCount = this.nQB.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.nQB.MF(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dZl() {
        return this.nQB.getLoopCount() == 0;
    }

    int hc(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.nQB.MF(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
