package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements b {
    private final d lOk;
    private long lPc = -1;

    public a(d dVar) {
        this.lOk = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int K(long j, long j2) {
        if (!dnA() && j / dnz() >= this.lOk.getLoopCount()) {
            return -1;
        }
        return fi(j % dnz());
    }

    public long dnz() {
        if (this.lPc != -1) {
            return this.lPc;
        }
        this.lPc = 0L;
        int frameCount = this.lOk.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.lPc += this.lOk.HT(i);
        }
        return this.lPc;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long fh(long j) {
        long j2 = 0;
        long dnz = dnz();
        if (dnz == 0) {
            return -1L;
        }
        if (dnA() || j / dnz() < this.lOk.getLoopCount()) {
            long j3 = j % dnz;
            int frameCount = this.lOk.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.lOk.HT(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dnA() {
        return this.lOk.getLoopCount() == 0;
    }

    int fi(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.lOk.HT(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
