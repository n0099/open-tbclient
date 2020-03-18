package com.google.android.exoplayer2.util;

import android.os.SystemClock;
/* loaded from: classes6.dex */
public final class q implements h {
    private boolean jfl;
    private long mJE;
    private long mJF;
    private com.google.android.exoplayer2.q maC = com.google.android.exoplayer2.q.mbD;

    public void start() {
        if (!this.jfl) {
            this.mJF = SystemClock.elapsedRealtime();
            this.jfl = true;
        }
    }

    public void stop() {
        if (this.jfl) {
            gw(duJ());
            this.jfl = false;
        }
    }

    public void gw(long j) {
        this.mJE = j;
        if (this.jfl) {
            this.mJF = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.exoplayer2.util.h
    public long duJ() {
        long j = this.mJE;
        if (this.jfl) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.mJF;
            if (this.maC.speed == 1.0f) {
                return j + com.google.android.exoplayer2.b.fp(elapsedRealtime);
            }
            return j + this.maC.fA(elapsedRealtime);
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.util.h
    public com.google.android.exoplayer2.q d(com.google.android.exoplayer2.q qVar) {
        if (this.jfl) {
            gw(duJ());
        }
        this.maC = qVar;
        return qVar;
    }

    @Override // com.google.android.exoplayer2.util.h
    public com.google.android.exoplayer2.q dtt() {
        return this.maC;
    }
}
