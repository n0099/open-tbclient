package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes11.dex */
public class a implements b {
    private final d phN;
    private long piI = -1;

    public a(d dVar) {
        this.phN = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int K(long j, long j2) {
        if (!esI() && j / esH() >= this.phN.getLoopCount()) {
            return -1;
        }
        return iw(j % esH());
    }

    public long esH() {
        if (this.piI != -1) {
            return this.piI;
        }
        this.piI = 0L;
        int frameCount = this.phN.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.piI += this.phN.Qq(i);
        }
        return this.piI;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long iv(long j) {
        long j2 = 0;
        long esH = esH();
        if (esH == 0) {
            return -1L;
        }
        if (esI() || j / esH() < this.phN.getLoopCount()) {
            long j3 = j % esH;
            int frameCount = this.phN.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.phN.Qq(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean esI() {
        return this.phN.getLoopCount() == 0;
    }

    int iw(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.phN.Qq(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
