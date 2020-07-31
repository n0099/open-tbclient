package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes18.dex */
public class a implements b {
    private long mXT = -1;
    private final d mXb;

    public a(d dVar) {
        this.mXb = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int M(long j, long j2) {
        if (!dFt() && j / dFs() >= this.mXb.getLoopCount()) {
            return -1;
        }
        return gh(j % dFs());
    }

    public long dFs() {
        if (this.mXT != -1) {
            return this.mXT;
        }
        this.mXT = 0L;
        int frameCount = this.mXb.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.mXT += this.mXb.IQ(i);
        }
        return this.mXT;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long gg(long j) {
        long j2 = 0;
        long dFs = dFs();
        if (dFs == 0) {
            return -1L;
        }
        if (dFt() || j / dFs() < this.mXb.getLoopCount()) {
            long j3 = j % dFs;
            int frameCount = this.mXb.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.mXb.IQ(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dFt() {
        return this.mXb.getLoopCount() == 0;
    }

    int gh(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.mXb.IQ(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
