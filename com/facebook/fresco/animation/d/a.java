package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes5.dex */
public class a implements b {
    private final d pEK;
    private long pFC = -1;

    public a(d dVar) {
        this.pEK = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int S(long j, long j2) {
        if (!evs() && j / evr() >= this.pEK.getLoopCount()) {
            return -1;
        }
        return iN(j % evr());
    }

    public long evr() {
        if (this.pFC != -1) {
            return this.pFC;
        }
        this.pFC = 0L;
        int frameCount = this.pEK.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.pFC += this.pEK.Ps(i);
        }
        return this.pFC;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long iM(long j) {
        long j2 = 0;
        long evr = evr();
        if (evr == 0) {
            return -1L;
        }
        if (evs() || j / evr() < this.pEK.getLoopCount()) {
            long j3 = j % evr;
            int frameCount = this.pEK.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.pEK.Ps(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean evs() {
        return this.pEK.getLoopCount() == 0;
    }

    int iN(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.pEK.Ps(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
