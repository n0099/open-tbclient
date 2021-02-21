package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes5.dex */
public class a implements b {
    private final d pFk;
    private long pGc = -1;

    public a(d dVar) {
        this.pFk = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int S(long j, long j2) {
        if (!evA() && j / evz() >= this.pFk.getLoopCount()) {
            return -1;
        }
        return iN(j % evz());
    }

    public long evz() {
        if (this.pGc != -1) {
            return this.pGc;
        }
        this.pGc = 0L;
        int frameCount = this.pFk.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.pGc += this.pFk.Pt(i);
        }
        return this.pGc;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long iM(long j) {
        long j2 = 0;
        long evz = evz();
        if (evz == 0) {
            return -1L;
        }
        if (evA() || j / evz() < this.pFk.getLoopCount()) {
            long j3 = j % evz;
            int frameCount = this.pFk.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.pFk.Pt(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean evA() {
        return this.pFk.getLoopCount() == 0;
    }

    int iN(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.pFk.Pt(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
