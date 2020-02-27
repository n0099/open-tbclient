package com.google.android.exoplayer2.util;

import android.os.SystemClock;
/* loaded from: classes6.dex */
public final class q implements h {
    private boolean jdy;
    private com.google.android.exoplayer2.q lYG = com.google.android.exoplayer2.q.lZH;
    private long mHH;
    private long mHI;

    public void start() {
        if (!this.jdy) {
            this.mHI = SystemClock.elapsedRealtime();
            this.jdy = true;
        }
    }

    public void stop() {
        if (this.jdy) {
            gv(duj());
            this.jdy = false;
        }
    }

    public void gv(long j) {
        this.mHH = j;
        if (this.jdy) {
            this.mHI = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.exoplayer2.util.h
    public long duj() {
        long j = this.mHH;
        if (this.jdy) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.mHI;
            if (this.lYG.speed == 1.0f) {
                return j + com.google.android.exoplayer2.b.fo(elapsedRealtime);
            }
            return j + this.lYG.fz(elapsedRealtime);
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.util.h
    public com.google.android.exoplayer2.q d(com.google.android.exoplayer2.q qVar) {
        if (this.jdy) {
            gv(duj());
        }
        this.lYG = qVar;
        return qVar;
    }

    @Override // com.google.android.exoplayer2.util.h
    public com.google.android.exoplayer2.q dsT() {
        return this.lYG;
    }
}
