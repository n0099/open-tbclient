package com.kwad.components.core.video;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public final class e {
    public volatile boolean Kx;
    public long Ky;
    public a Kz = new a();

    /* loaded from: classes9.dex */
    public static class a {
        public long KA = 0;
        public int KB = 0;

        public final void accumulate(long j) {
            this.KA += j;
            this.KB++;
        }

        public final int pl() {
            return this.KB;
        }

        public final long pm() {
            return this.KA;
        }
    }

    public final void pg() {
        if (this.Kx) {
            return;
        }
        this.Kx = true;
        this.Ky = SystemClock.elapsedRealtime();
    }

    public final void ph() {
        if (this.Kx) {
            this.Kz.accumulate(SystemClock.elapsedRealtime() - this.Ky);
            this.Kx = false;
        }
    }

    public final boolean pi() {
        return this.Kx;
    }

    @NonNull
    public final a pj() {
        if (this.Kx) {
            this.Kz.accumulate(SystemClock.elapsedRealtime() - this.Ky);
            this.Kx = false;
        }
        return this.Kz;
    }

    public final long pk() {
        return this.Ky;
    }
}
