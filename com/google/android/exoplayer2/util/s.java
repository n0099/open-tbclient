package com.google.android.exoplayer2.util;

import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes5.dex */
public final class s {
    private long mGZ;
    private volatile long mHa = -9223372036854775807L;
    private long mlF;

    public s(long j) {
        gJ(j);
    }

    public synchronized void gJ(long j) {
        a.checkState(this.mHa == -9223372036854775807L);
        this.mlF = j;
    }

    public long dyB() {
        return this.mlF;
    }

    public long dyC() {
        if (this.mHa != -9223372036854775807L) {
            return this.mHa;
        }
        if (this.mlF != Format.OFFSET_SAMPLE_RELATIVE) {
            return this.mlF;
        }
        return -9223372036854775807L;
    }

    public long dyD() {
        if (this.mlF == Format.OFFSET_SAMPLE_RELATIVE) {
            return 0L;
        }
        if (this.mHa != -9223372036854775807L) {
            return this.mGZ;
        }
        return -9223372036854775807L;
    }

    public void reset() {
        this.mHa = -9223372036854775807L;
    }

    public long gK(long j) {
        long j2;
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.mHa != -9223372036854775807L) {
            long gN = gN(this.mHa);
            long j3 = (4294967296L + gN) / IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
            j2 = ((j3 - 1) * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j;
            long j4 = (j3 * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j;
            if (Math.abs(j2 - gN) >= Math.abs(j4 - gN)) {
                j2 = j4;
            }
        } else {
            j2 = j;
        }
        return gL(gM(j2));
    }

    public long gL(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.mHa != -9223372036854775807L) {
            this.mHa = j;
        } else {
            if (this.mlF != Format.OFFSET_SAMPLE_RELATIVE) {
                this.mGZ = this.mlF - j;
            }
            synchronized (this) {
                this.mHa = j;
                notifyAll();
            }
        }
        return this.mGZ + j;
    }

    public synchronized void dyE() throws InterruptedException {
        while (this.mHa == -9223372036854775807L) {
            wait();
        }
    }

    public static long gM(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / SapiWebView.DEFAULT_TIMEOUT_MILLIS;
    }

    public static long gN(long j) {
        return (SapiWebView.DEFAULT_TIMEOUT_MILLIS * j) / TimeUtils.NANOS_PER_MS;
    }
}
