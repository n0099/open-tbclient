package com.google.android.exoplayer2.util;

import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes6.dex */
public final class s {
    private long mHL;
    private volatile long mHM = -9223372036854775807L;
    private long mms;

    public s(long j) {
        gH(j);
    }

    public synchronized void gH(long j) {
        a.checkState(this.mHM == -9223372036854775807L);
        this.mms = j;
    }

    public long dzP() {
        return this.mms;
    }

    public long dzQ() {
        if (this.mHM != -9223372036854775807L) {
            return this.mHM;
        }
        if (this.mms != Format.OFFSET_SAMPLE_RELATIVE) {
            return this.mms;
        }
        return -9223372036854775807L;
    }

    public long dzR() {
        if (this.mms == Format.OFFSET_SAMPLE_RELATIVE) {
            return 0L;
        }
        if (this.mHM != -9223372036854775807L) {
            return this.mHL;
        }
        return -9223372036854775807L;
    }

    public void reset() {
        this.mHM = -9223372036854775807L;
    }

    public long gI(long j) {
        long j2;
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.mHM != -9223372036854775807L) {
            long gL = gL(this.mHM);
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
        if (this.mHM != -9223372036854775807L) {
            this.mHM = j;
        } else {
            if (this.mms != Format.OFFSET_SAMPLE_RELATIVE) {
                this.mHL = this.mms - j;
            }
            synchronized (this) {
                this.mHM = j;
                notifyAll();
            }
        }
        return this.mHL + j;
    }

    public synchronized void dzS() throws InterruptedException {
        while (this.mHM == -9223372036854775807L) {
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
