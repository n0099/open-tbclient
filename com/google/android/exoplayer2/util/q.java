package com.google.android.exoplayer2.util;

import android.os.SystemClock;
/* loaded from: classes5.dex */
public final class q implements h {
    private boolean jcx;
    private com.google.android.exoplayer2.q lXV = com.google.android.exoplayer2.q.lYW;
    private long mGX;
    private long mGY;

    public void start() {
        if (!this.jcx) {
            this.mGY = SystemClock.elapsedRealtime();
            this.jcx = true;
        }
    }

    public void stop() {
        if (this.jcx) {
            gx(dsW());
            this.jcx = false;
        }
    }

    public void gx(long j) {
        this.mGX = j;
        if (this.jcx) {
            this.mGY = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.exoplayer2.util.h
    public long dsW() {
        long j = this.mGX;
        if (this.jcx) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.mGY;
            if (this.lXV.speed == 1.0f) {
                return j + com.google.android.exoplayer2.b.fq(elapsedRealtime);
            }
            return j + this.lXV.fB(elapsedRealtime);
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.util.h
    public com.google.android.exoplayer2.q d(com.google.android.exoplayer2.q qVar) {
        if (this.jcx) {
            gx(dsW());
        }
        this.lXV = qVar;
        return qVar;
    }

    @Override // com.google.android.exoplayer2.util.h
    public com.google.android.exoplayer2.q drF() {
        return this.lXV;
    }
}
