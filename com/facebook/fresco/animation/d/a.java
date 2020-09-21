package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes5.dex */
public class a implements b {
    private final d nBi;
    private long nCa = -1;

    public a(d dVar) {
        this.nBi = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int J(long j, long j2) {
        if (!dVA() && j / dVz() >= this.nBi.getLoopCount()) {
            return -1;
        }
        return gK(j % dVz());
    }

    public long dVz() {
        if (this.nCa != -1) {
            return this.nCa;
        }
        this.nCa = 0L;
        int frameCount = this.nBi.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.nCa += this.nBi.LZ(i);
        }
        return this.nCa;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long gJ(long j) {
        long j2 = 0;
        long dVz = dVz();
        if (dVz == 0) {
            return -1L;
        }
        if (dVA() || j / dVz() < this.nBi.getLoopCount()) {
            long j3 = j % dVz;
            int frameCount = this.nBi.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.nBi.LZ(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dVA() {
        return this.nBi.getLoopCount() == 0;
    }

    int gK(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.nBi.LZ(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
