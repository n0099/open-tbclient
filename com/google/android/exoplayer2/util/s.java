package com.google.android.exoplayer2.util;

import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes6.dex */
public final class s {
    private long mHW;
    private volatile long mHX = -9223372036854775807L;
    private long mmD;

    public s(long j) {
        gH(j);
    }

    public synchronized void gH(long j) {
        a.checkState(this.mHX == -9223372036854775807L);
        this.mmD = j;
    }

    public long dzQ() {
        return this.mmD;
    }

    public long dzR() {
        if (this.mHX != -9223372036854775807L) {
            return this.mHX;
        }
        if (this.mmD != Format.OFFSET_SAMPLE_RELATIVE) {
            return this.mmD;
        }
        return -9223372036854775807L;
    }

    public long dzS() {
        if (this.mmD == Format.OFFSET_SAMPLE_RELATIVE) {
            return 0L;
        }
        if (this.mHX != -9223372036854775807L) {
            return this.mHW;
        }
        return -9223372036854775807L;
    }

    public void reset() {
        this.mHX = -9223372036854775807L;
    }

    public long gI(long j) {
        long j2;
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.mHX != -9223372036854775807L) {
            long gL = gL(this.mHX);
            long j3 = (4294967296L + gL) / IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
            j2 = ((j3 - 1) * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j;
            long j4 = (j3 * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j;
            if (Math.abs(j2 - gL) >= Math.abs(j4 - gL)) {
                j2 = j4;
            }
        } else {
            j2 = j;
        }
        return gJ(gK(j2));
    }

    public long gJ(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.mHX != -9223372036854775807L) {
            this.mHX = j;
        } else {
            if (this.mmD != Format.OFFSET_SAMPLE_RELATIVE) {
                this.mHW = this.mmD - j;
            }
            synchronized (this) {
                this.mHX = j;
                notifyAll();
            }
        }
        return this.mHW + j;
    }

    public synchronized void dzT() throws InterruptedException {
        while (this.mHX == -9223372036854775807L) {
            wait();
        }
    }

    public static long gK(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / SapiWebView.DEFAULT_TIMEOUT_MILLIS;
    }

    public static long gL(long j) {
        return (SapiWebView.DEFAULT_TIMEOUT_MILLIS * j) / TimeUtils.NANOS_PER_MS;
    }
}
