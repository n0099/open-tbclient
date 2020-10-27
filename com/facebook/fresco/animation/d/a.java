package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes14.dex */
public class a implements b {
    private final d oHT;
    private long oIL = -1;

    public a(d dVar) {
        this.oHT = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int K(long j, long j2) {
        if (!ejj() && j / eji() >= this.oHT.getLoopCount()) {
            return -1;
        }
        return hs(j % eji());
    }

    public long eji() {
        if (this.oIL != -1) {
            return this.oIL;
        }
        this.oIL = 0L;
        int frameCount = this.oHT.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.oIL += this.oHT.Ow(i);
        }
        return this.oIL;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long hr(long j) {
        long j2 = 0;
        long eji = eji();
        if (eji == 0) {
            return -1L;
        }
        if (ejj() || j / eji() < this.oHT.getLoopCount()) {
            long j3 = j % eji;
            int frameCount = this.oHT.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.oHT.Ow(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean ejj() {
        return this.oHT.getLoopCount() == 0;
    }

    int hs(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.oHT.Ow(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
