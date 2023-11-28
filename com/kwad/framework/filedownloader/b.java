package com.kwad.framework.filedownloader;

import android.os.SystemClock;
import com.kwad.framework.filedownloader.s;
/* loaded from: classes10.dex */
public final class b implements s.a, s.b {
    public long adu;
    public long adv;
    public long adw;
    public int adx;
    public int ady = 1000;
    public long mStartTime;

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.adx;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void reset() {
        this.adx = 0;
        this.adu = 0L;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void J(long j) {
        if (this.ady <= 0) {
            return;
        }
        boolean z = true;
        if (this.adu != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.adu;
            if (uptimeMillis < this.ady && (this.adx != 0 || uptimeMillis <= 0)) {
                z = false;
            } else {
                int i = (int) ((j - this.adv) / uptimeMillis);
                this.adx = i;
                this.adx = Math.max(0, i);
            }
        }
        if (z) {
            this.adv = j;
            this.adu = SystemClock.uptimeMillis();
        }
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void end(long j) {
        if (this.mStartTime <= 0) {
            return;
        }
        long j2 = j - this.adw;
        this.adu = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.mStartTime;
        if (uptimeMillis <= 0) {
            this.adx = (int) j2;
        } else {
            this.adx = (int) (j2 / uptimeMillis);
        }
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void start(long j) {
        this.mStartTime = SystemClock.uptimeMillis();
        this.adw = j;
    }
}
