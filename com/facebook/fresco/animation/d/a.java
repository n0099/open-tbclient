package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements b {
    private final d lOx;
    private long lPp = -1;

    public a(d dVar) {
        this.lOx = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int K(long j, long j2) {
        if (!dnD() && j / dnC() >= this.lOx.getLoopCount()) {
            return -1;
        }
        return fi(j % dnC());
    }

    public long dnC() {
        if (this.lPp != -1) {
            return this.lPp;
        }
        this.lPp = 0L;
        int frameCount = this.lOx.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.lPp += this.lOx.HT(i);
        }
        return this.lPp;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long fh(long j) {
        long j2 = 0;
        long dnC = dnC();
        if (dnC == 0) {
            return -1L;
        }
        if (dnD() || j / dnC() < this.lOx.getLoopCount()) {
            long j3 = j % dnC;
            int frameCount = this.lOx.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.lOx.HT(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dnD() {
        return this.lOx.getLoopCount() == 0;
    }

    int fi(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.lOx.HT(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
