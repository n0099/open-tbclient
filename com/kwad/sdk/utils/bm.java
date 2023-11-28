package com.kwad.sdk.utils;

import android.os.SystemClock;
/* loaded from: classes10.dex */
public final class bm {
    public long aPp;
    public long aPq;
    public boolean aPr;

    public bm() {
        reset();
    }

    private void reset() {
        this.aPp = 0L;
        this.aPq = -1L;
    }

    public final void LM() {
        if (this.aPr && this.aPq < 0) {
            this.aPq = SystemClock.elapsedRealtime();
        }
    }

    public final void LN() {
        if (this.aPr && this.aPq > 0) {
            this.aPp += SystemClock.elapsedRealtime() - this.aPq;
            this.aPq = -1L;
        }
    }

    public final long LO() {
        if (!this.aPr) {
            return 0L;
        }
        this.aPr = false;
        if (this.aPq > 0) {
            this.aPp += SystemClock.elapsedRealtime() - this.aPq;
            this.aPq = -1L;
        }
        return this.aPp;
    }

    public final long getTime() {
        if (this.aPq > 0) {
            return (this.aPp + SystemClock.elapsedRealtime()) - this.aPq;
        }
        return this.aPp;
    }

    public final void startTiming() {
        reset();
        this.aPr = true;
        this.aPq = SystemClock.elapsedRealtime();
    }
}
