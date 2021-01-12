package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes6.dex */
public class a implements b {
    private final d puB;
    private long pvt = -1;

    public a(d dVar) {
        this.puB = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int O(long j, long j2) {
        if (!eta() && j / esZ() >= this.puB.getLoopCount()) {
            return -1;
        }
        return iK(j % esZ());
    }

    public long esZ() {
        if (this.pvt != -1) {
            return this.pvt;
        }
        this.pvt = 0L;
        int frameCount = this.puB.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.pvt += this.puB.OX(i);
        }
        return this.pvt;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long iJ(long j) {
        long j2 = 0;
        long esZ = esZ();
        if (esZ == 0) {
            return -1L;
        }
        if (eta() || j / esZ() < this.puB.getLoopCount()) {
            long j3 = j % esZ;
            int frameCount = this.puB.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.puB.OX(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean eta() {
        return this.puB.getLoopCount() == 0;
    }

    int iK(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.puB.OX(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
