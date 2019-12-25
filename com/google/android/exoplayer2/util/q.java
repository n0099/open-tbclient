package com.google.android.exoplayer2.util;

import android.os.SystemClock;
/* loaded from: classes4.dex */
public final class q implements h {
    private boolean iYU;
    private com.google.android.exoplayer2.q lUe = com.google.android.exoplayer2.q.lVf;
    private long mDh;
    private long mDi;

    public void start() {
        if (!this.iYU) {
            this.mDi = SystemClock.elapsedRealtime();
            this.iYU = true;
        }
    }

    public void stop() {
        if (this.iYU) {
            gs(drK());
            this.iYU = false;
        }
    }

    public void gs(long j) {
        this.mDh = j;
        if (this.iYU) {
            this.mDi = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.exoplayer2.util.h
    public long drK() {
        long j = this.mDh;
        if (this.iYU) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.mDi;
            if (this.lUe.speed == 1.0f) {
                return j + com.google.android.exoplayer2.b.fl(elapsedRealtime);
            }
            return j + this.lUe.fw(elapsedRealtime);
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.util.h
    public com.google.android.exoplayer2.q d(com.google.android.exoplayer2.q qVar) {
        if (this.iYU) {
            gs(drK());
        }
        this.lUe = qVar;
        return qVar;
    }

    @Override // com.google.android.exoplayer2.util.h
    public com.google.android.exoplayer2.q dqt() {
        return this.lUe;
    }
}
