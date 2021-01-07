package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes6.dex */
public class a implements b {
    private long pzU = -1;
    private final d pzc;

    public a(d dVar) {
        this.pzc = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int O(long j, long j2) {
        if (!ewS() && j / ewR() >= this.pzc.getLoopCount()) {
            return -1;
        }
        return iK(j % ewR());
    }

    public long ewR() {
        if (this.pzU != -1) {
            return this.pzU;
        }
        this.pzU = 0L;
        int frameCount = this.pzc.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.pzU += this.pzc.QE(i);
        }
        return this.pzU;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long iJ(long j) {
        long j2 = 0;
        long ewR = ewR();
        if (ewR == 0) {
            return -1L;
        }
        if (ewS() || j / ewR() < this.pzc.getLoopCount()) {
            long j3 = j % ewR;
            int frameCount = this.pzc.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.pzc.QE(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean ewS() {
        return this.pzc.getLoopCount() == 0;
    }

    int iK(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.pzc.QE(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
