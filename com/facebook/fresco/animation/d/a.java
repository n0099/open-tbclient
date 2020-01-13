package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes12.dex */
public class a implements b {
    private final d lNy;
    private long lOq = -1;

    public a(d dVar) {
        this.lNy = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int L(long j, long j2) {
        if (!dml() && j / dmk() >= this.lNy.getLoopCount()) {
            return -1;
        }
        return fk(j % dmk());
    }

    public long dmk() {
        if (this.lOq != -1) {
            return this.lOq;
        }
        this.lOq = 0L;
        int frameCount = this.lNy.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.lOq += this.lNy.HO(i);
        }
        return this.lOq;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long fj(long j) {
        long j2 = 0;
        long dmk = dmk();
        if (dmk == 0) {
            return -1L;
        }
        if (dml() || j / dmk() < this.lNy.getLoopCount()) {
            long j3 = j % dmk;
            int frameCount = this.lNy.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.lNy.HO(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dml() {
        return this.lNy.getLoopCount() == 0;
    }

    int fk(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.lNy.HO(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
