package com.kwad.components.core.video;

import android.os.SystemClock;
import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class i {
    public volatile boolean UI;
    public long UJ;
    public a UK = new a();

    /* loaded from: classes10.dex */
    public static class a {
        public long UL = 0;
        public int UM = 0;

        public final int rJ() {
            return this.UM;
        }

        public final long rK() {
            return this.UL;
        }

        public final void reset() {
            this.UL = 0L;
            this.UM = 0;
        }

        public final void accumulate(long j) {
            this.UL += j;
            this.UM++;
        }
    }

    public final void rE() {
        if (this.UI) {
            return;
        }
        this.UI = true;
        this.UJ = SystemClock.elapsedRealtime();
        com.kwad.sdk.core.video.a.a.a.ea("videoStartBlock");
    }

    public final void rF() {
        if (this.UI) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.UJ;
            this.UK.accumulate(elapsedRealtime);
            this.UI = false;
            com.kwad.sdk.core.video.a.a.a.ea("videoEndBlock");
            com.kwad.sdk.core.video.a.a.a.ea("videoBlockTime_" + elapsedRealtime);
        }
    }

    public final boolean rG() {
        return this.UI;
    }

    @NonNull
    public final a rH() {
        if (this.UI) {
            this.UK.accumulate(SystemClock.elapsedRealtime() - this.UJ);
            this.UI = false;
        }
        return this.UK;
    }

    public final long rI() {
        return this.UJ;
    }

    public final void reset() {
        this.UI = false;
        this.UJ = 0L;
        this.UK.reset();
    }
}
