package com.google.android.exoplayer2.util;

import android.os.SystemClock;
/* loaded from: classes6.dex */
public final class q implements h {
    private boolean jdA;
    private com.google.android.exoplayer2.q lYI = com.google.android.exoplayer2.q.lZJ;
    private long mHJ;
    private long mHK;

    public void start() {
        if (!this.jdA) {
            this.mHK = SystemClock.elapsedRealtime();
            this.jdA = true;
        }
    }

    public void stop() {
        if (this.jdA) {
            gv(dul());
            this.jdA = false;
        }
    }

    public void gv(long j) {
        this.mHJ = j;
        if (this.jdA) {
            this.mHK = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.exoplayer2.util.h
    public long dul() {
        long j = this.mHJ;
        if (this.jdA) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.mHK;
            if (this.lYI.speed == 1.0f) {
                return j + com.google.android.exoplayer2.b.fo(elapsedRealtime);
            }
            return j + this.lYI.fz(elapsedRealtime);
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.util.h
    public com.google.android.exoplayer2.q d(com.google.android.exoplayer2.q qVar) {
        if (this.jdA) {
            gv(dul());
        }
        this.lYI = qVar;
        return qVar;
    }

    @Override // com.google.android.exoplayer2.util.h
    public com.google.android.exoplayer2.q dsV() {
        return this.lYI;
    }
}
