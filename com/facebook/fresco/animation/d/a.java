package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes14.dex */
public class a implements b {
    private final d oRm;
    private long oSe = -1;

    public a(d dVar) {
        this.oRm = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int L(long j, long j2) {
        if (!emY() && j / emX() >= this.oRm.getLoopCount()) {
            return -1;
        }
        return hO(j % emX());
    }

    public long emX() {
        if (this.oSe != -1) {
            return this.oSe;
        }
        this.oSe = 0L;
        int frameCount = this.oRm.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.oSe += this.oRm.OR(i);
        }
        return this.oSe;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long hN(long j) {
        long j2 = 0;
        long emX = emX();
        if (emX == 0) {
            return -1L;
        }
        if (emY() || j / emX() < this.oRm.getLoopCount()) {
            long j3 = j % emX;
            int frameCount = this.oRm.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.oRm.OR(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean emY() {
        return this.oRm.getLoopCount() == 0;
    }

    int hO(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.oRm.OR(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
