package com.google.android.exoplayer2.util;

import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes6.dex */
public final class s {
    private long mJG;
    private volatile long mJH = -9223372036854775807L;
    private long moj;

    public s(long j) {
        gI(j);
    }

    public synchronized void gI(long j) {
        a.checkState(this.mJH == -9223372036854775807L);
        this.moj = j;
    }

    public long dAn() {
        return this.moj;
    }

    public long dAo() {
        if (this.mJH != -9223372036854775807L) {
            return this.mJH;
        }
        if (this.moj != Format.OFFSET_SAMPLE_RELATIVE) {
            return this.moj;
        }
        return -9223372036854775807L;
    }

    public long dAp() {
        if (this.moj == Format.OFFSET_SAMPLE_RELATIVE) {
            return 0L;
        }
        if (this.mJH != -9223372036854775807L) {
            return this.mJG;
        }
        return -9223372036854775807L;
    }

    public void reset() {
        this.mJH = -9223372036854775807L;
    }

    public long gJ(long j) {
        long j2;
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.mJH != -9223372036854775807L) {
            long gM = gM(this.mJH);
            long j3 = (4294967296L + gM) / IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
            j2 = ((j3 - 1) * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j;
            long j4 = (j3 * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j;
            if (Math.abs(j2 - gM) >= Math.abs(j4 - gM)) {
                j2 = j4;
            }
        } else {
            j2 = j;
        }
        return gK(gL(j2));
    }

    public long gK(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.mJH != -9223372036854775807L) {
            this.mJH = j;
        } else {
            if (this.moj != Format.OFFSET_SAMPLE_RELATIVE) {
                this.mJG = this.moj - j;
            }
            synchronized (this) {
                this.mJH = j;
                notifyAll();
            }
        }
        return this.mJG + j;
    }

    public synchronized void dAq() throws InterruptedException {
        while (this.mJH == -9223372036854775807L) {
            wait();
        }
    }

    public static long gL(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / SapiWebView.DEFAULT_TIMEOUT_MILLIS;
    }

    public static long gM(long j) {
        return (SapiWebView.DEFAULT_TIMEOUT_MILLIS * j) / TimeUtils.NANOS_PER_MS;
    }
}
