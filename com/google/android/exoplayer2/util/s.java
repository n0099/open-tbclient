package com.google.android.exoplayer2.util;

import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes5.dex */
public final class s {
    private long mHe;
    private volatile long mHf = -9223372036854775807L;
    private long mlK;

    public s(long j) {
        gJ(j);
    }

    public synchronized void gJ(long j) {
        a.checkState(this.mHf == -9223372036854775807L);
        this.mlK = j;
    }

    public long dyD() {
        return this.mlK;
    }

    public long dyE() {
        if (this.mHf != -9223372036854775807L) {
            return this.mHf;
        }
        if (this.mlK != Format.OFFSET_SAMPLE_RELATIVE) {
            return this.mlK;
        }
        return -9223372036854775807L;
    }

    public long dyF() {
        if (this.mlK == Format.OFFSET_SAMPLE_RELATIVE) {
            return 0L;
        }
        if (this.mHf != -9223372036854775807L) {
            return this.mHe;
        }
        return -9223372036854775807L;
    }

    public void reset() {
        this.mHf = -9223372036854775807L;
    }

    public long gK(long j) {
        long j2;
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.mHf != -9223372036854775807L) {
            long gN = gN(this.mHf);
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
        if (this.mHf != -9223372036854775807L) {
            this.mHf = j;
        } else {
            if (this.mlK != Format.OFFSET_SAMPLE_RELATIVE) {
                this.mHe = this.mlK - j;
            }
            synchronized (this) {
                this.mHf = j;
                notifyAll();
            }
        }
        return this.mHe + j;
    }

    public synchronized void dyG() throws InterruptedException {
        while (this.mHf == -9223372036854775807L) {
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
