package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements b {
    private final d lOm;
    private long lPe = -1;

    public a(d dVar) {
        this.lOm = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int K(long j, long j2) {
        if (!dnC() && j / dnB() >= this.lOm.getLoopCount()) {
            return -1;
        }
        return fi(j % dnB());
    }

    public long dnB() {
        if (this.lPe != -1) {
            return this.lPe;
        }
        this.lPe = 0L;
        int frameCount = this.lOm.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.lPe += this.lOm.HT(i);
        }
        return this.lPe;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long fh(long j) {
        long j2 = 0;
        long dnB = dnB();
        if (dnB == 0) {
            return -1L;
        }
        if (dnC() || j / dnB() < this.lOm.getLoopCount()) {
            long j3 = j % dnB;
            int frameCount = this.lOm.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.lOm.HT(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dnC() {
        return this.lOm.getLoopCount() == 0;
    }

    int fi(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.lOm.HT(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
