package com.google.android.exoplayer2.util;

import android.os.SystemClock;
/* loaded from: classes5.dex */
public final class q implements h {
    private boolean jcC;
    private com.google.android.exoplayer2.q lYa = com.google.android.exoplayer2.q.lZb;
    private long mHc;
    private long mHd;

    public void start() {
        if (!this.jcC) {
            this.mHd = SystemClock.elapsedRealtime();
            this.jcC = true;
        }
    }

    public void stop() {
        if (this.jcC) {
            gx(dsY());
            this.jcC = false;
        }
    }

    public void gx(long j) {
        this.mHc = j;
        if (this.jcC) {
            this.mHd = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.exoplayer2.util.h
    public long dsY() {
        long j = this.mHc;
        if (this.jcC) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.mHd;
            if (this.lYa.speed == 1.0f) {
                return j + com.google.android.exoplayer2.b.fq(elapsedRealtime);
            }
            return j + this.lYa.fB(elapsedRealtime);
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.util.h
    public com.google.android.exoplayer2.q d(com.google.android.exoplayer2.q qVar) {
        if (this.jcC) {
            gx(dsY());
        }
        this.lYa = qVar;
        return qVar;
    }

    @Override // com.google.android.exoplayer2.util.h
    public com.google.android.exoplayer2.q drH() {
        return this.lYa;
    }
}
