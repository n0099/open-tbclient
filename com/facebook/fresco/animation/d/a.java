package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes4.dex */
public class a implements b {
    private final d pHp;
    private long pIh = -1;

    public a(d dVar) {
        this.pHp = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int S(long j, long j2) {
        if (!evJ() && j / evI() >= this.pHp.getLoopCount()) {
            return -1;
        }
        return iN(j % evI());
    }

    public long evI() {
        if (this.pIh != -1) {
            return this.pIh;
        }
        this.pIh = 0L;
        int frameCount = this.pHp.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.pIh += this.pHp.Px(i);
        }
        return this.pIh;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long iM(long j) {
        long j2 = 0;
        long evI = evI();
        if (evI == 0) {
            return -1L;
        }
        if (evJ() || j / evI() < this.pHp.getLoopCount()) {
            long j3 = j % evI;
            int frameCount = this.pHp.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.pHp.Px(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean evJ() {
        return this.pHp.getLoopCount() == 0;
    }

    int iN(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.pHp.Px(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
