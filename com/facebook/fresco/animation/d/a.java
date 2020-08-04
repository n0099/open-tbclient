package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes18.dex */
public class a implements b {
    private long mXV = -1;
    private final d mXd;

    public a(d dVar) {
        this.mXd = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int M(long j, long j2) {
        if (!dFu() && j / dFt() >= this.mXd.getLoopCount()) {
            return -1;
        }
        return gh(j % dFt());
    }

    public long dFt() {
        if (this.mXV != -1) {
            return this.mXV;
        }
        this.mXV = 0L;
        int frameCount = this.mXd.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.mXV += this.mXd.IQ(i);
        }
        return this.mXV;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long gg(long j) {
        long j2 = 0;
        long dFt = dFt();
        if (dFt == 0) {
            return -1L;
        }
        if (dFu() || j / dFt() < this.mXd.getLoopCount()) {
            long j3 = j % dFt;
            int frameCount = this.mXd.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.mXd.IQ(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dFu() {
        return this.mXd.getLoopCount() == 0;
    }

    int gh(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.mXd.IQ(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
