package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes11.dex */
public class a implements b {
    private final d phL;
    private long piG = -1;

    public a(d dVar) {
        this.phL = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int K(long j, long j2) {
        if (!esH() && j / esG() >= this.phL.getLoopCount()) {
            return -1;
        }
        return iw(j % esG());
    }

    public long esG() {
        if (this.piG != -1) {
            return this.piG;
        }
        this.piG = 0L;
        int frameCount = this.phL.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.piG += this.phL.Qq(i);
        }
        return this.piG;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long iv(long j) {
        long j2 = 0;
        long esG = esG();
        if (esG == 0) {
            return -1L;
        }
        if (esH() || j / esG() < this.phL.getLoopCount()) {
            long j3 = j % esG;
            int frameCount = this.phL.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.phL.Qq(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean esH() {
        return this.phL.getLoopCount() == 0;
    }

    int iw(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.phL.Qq(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
