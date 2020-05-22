package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements b {
    private final d mrG;
    private long msz = -1;

    public a(d dVar) {
        this.mrG = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int J(long j, long j2) {
        if (!dxn() && j / dxm() >= this.mrG.getLoopCount()) {
            return -1;
        }
        return fP(j % dxm());
    }

    public long dxm() {
        if (this.msz != -1) {
            return this.msz;
        }
        this.msz = 0L;
        int frameCount = this.mrG.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.msz += this.mrG.Hm(i);
        }
        return this.msz;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long fO(long j) {
        long j2 = 0;
        long dxm = dxm();
        if (dxm == 0) {
            return -1L;
        }
        if (dxn() || j / dxm() < this.mrG.getLoopCount()) {
            long j3 = j % dxm;
            int frameCount = this.mrG.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.mrG.Hm(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dxn() {
        return this.mrG.getLoopCount() == 0;
    }

    int fP(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.mrG.Hm(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
