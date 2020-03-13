package com.google.android.exoplayer2.util;

import android.os.SystemClock;
/* loaded from: classes6.dex */
public final class q implements h {
    private boolean jdM;
    private com.google.android.exoplayer2.q lYT = com.google.android.exoplayer2.q.lZU;
    private long mHU;
    private long mHV;

    public void start() {
        if (!this.jdM) {
            this.mHV = SystemClock.elapsedRealtime();
            this.jdM = true;
        }
    }

    public void stop() {
        if (this.jdM) {
            gv(dum());
            this.jdM = false;
        }
    }

    public void gv(long j) {
        this.mHU = j;
        if (this.jdM) {
            this.mHV = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.exoplayer2.util.h
    public long dum() {
        long j = this.mHU;
        if (this.jdM) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.mHV;
            if (this.lYT.speed == 1.0f) {
                return j + com.google.android.exoplayer2.b.fo(elapsedRealtime);
            }
            return j + this.lYT.fz(elapsedRealtime);
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.util.h
    public com.google.android.exoplayer2.q d(com.google.android.exoplayer2.q qVar) {
        if (this.jdM) {
            gv(dum());
        }
        this.lYT = qVar;
        return qVar;
    }

    @Override // com.google.android.exoplayer2.util.h
    public com.google.android.exoplayer2.q dsW() {
        return this.lYT;
    }
}
