package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes12.dex */
public class a implements b {
    private final d lND;
    private long lOv = -1;

    public a(d dVar) {
        this.lND = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int L(long j, long j2) {
        if (!dmn() && j / dmm() >= this.lND.getLoopCount()) {
            return -1;
        }
        return fk(j % dmm());
    }

    public long dmm() {
        if (this.lOv != -1) {
            return this.lOv;
        }
        this.lOv = 0L;
        int frameCount = this.lND.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.lOv += this.lND.HO(i);
        }
        return this.lOv;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long fj(long j) {
        long j2 = 0;
        long dmm = dmm();
        if (dmm == 0) {
            return -1L;
        }
        if (dmn() || j / dmm() < this.lND.getLoopCount()) {
            long j3 = j % dmm;
            int frameCount = this.lND.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.lND.HO(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dmn() {
        return this.lND.getLoopCount() == 0;
    }

    int fk(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.lND.HO(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
