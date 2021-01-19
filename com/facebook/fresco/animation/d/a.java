package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes6.dex */
public class a implements b {
    private final d puC;
    private long pvu = -1;

    public a(d dVar) {
        this.puC = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int O(long j, long j2) {
        if (!eta() && j / esZ() >= this.puC.getLoopCount()) {
            return -1;
        }
        return iK(j % esZ());
    }

    public long esZ() {
        if (this.pvu != -1) {
            return this.pvu;
        }
        this.pvu = 0L;
        int frameCount = this.puC.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.pvu += this.puC.OX(i);
        }
        return this.pvu;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long iJ(long j) {
        long j2 = 0;
        long esZ = esZ();
        if (esZ == 0) {
            return -1L;
        }
        if (eta() || j / esZ() < this.puC.getLoopCount()) {
            long j3 = j % esZ;
            int frameCount = this.puC.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.puC.OX(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean eta() {
        return this.puC.getLoopCount() == 0;
    }

    int iK(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.puC.OX(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
