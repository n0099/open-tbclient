package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements b {
    private long lQV = -1;
    private final d lQd;

    public a(d dVar) {
        this.lQd = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int K(long j, long j2) {
        if (!doa() && j / dnZ() >= this.lQd.getLoopCount()) {
            return -1;
        }
        return fj(j % dnZ());
    }

    public long dnZ() {
        if (this.lQV != -1) {
            return this.lQV;
        }
        this.lQV = 0L;
        int frameCount = this.lQd.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.lQV += this.lQd.HZ(i);
        }
        return this.lQV;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long fi(long j) {
        long j2 = 0;
        long dnZ = dnZ();
        if (dnZ == 0) {
            return -1L;
        }
        if (doa() || j / dnZ() < this.lQd.getLoopCount()) {
            long j3 = j % dnZ;
            int frameCount = this.lQd.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.lQd.HZ(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean doa() {
        return this.lQd.getLoopCount() == 0;
    }

    int fj(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.lQd.HZ(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
