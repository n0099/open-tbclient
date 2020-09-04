package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes6.dex */
public class a implements b {
    private final d nrk;
    private long nsc = -1;

    public a(d dVar) {
        this.nrk = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int M(long j, long j2) {
        if (!dRC() && j / dRB() >= this.nrk.getLoopCount()) {
            return -1;
        }
        return gw(j % dRB());
    }

    public long dRB() {
        if (this.nsc != -1) {
            return this.nsc;
        }
        this.nsc = 0L;
        int frameCount = this.nrk.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.nsc += this.nrk.Lu(i);
        }
        return this.nsc;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long gv(long j) {
        long j2 = 0;
        long dRB = dRB();
        if (dRB == 0) {
            return -1L;
        }
        if (dRC() || j / dRB() < this.nrk.getLoopCount()) {
            long j3 = j % dRB;
            int frameCount = this.nrk.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.nrk.Lu(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dRC() {
        return this.nrk.getLoopCount() == 0;
    }

    int gw(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.nrk.Lu(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
