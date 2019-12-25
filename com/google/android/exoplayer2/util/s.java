package com.google.android.exoplayer2.util;

import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes4.dex */
public final class s {
    private long mDj;
    private volatile long mDk = -9223372036854775807L;
    private long mhP;

    public s(long j) {
        gE(j);
    }

    public synchronized void gE(long j) {
        a.checkState(this.mDk == -9223372036854775807L);
        this.mhP = j;
    }

    public long dxr() {
        return this.mhP;
    }

    public long dxs() {
        if (this.mDk != -9223372036854775807L) {
            return this.mDk;
        }
        if (this.mhP != Format.OFFSET_SAMPLE_RELATIVE) {
            return this.mhP;
        }
        return -9223372036854775807L;
    }

    public long dxt() {
        if (this.mhP == Format.OFFSET_SAMPLE_RELATIVE) {
            return 0L;
        }
        if (this.mDk != -9223372036854775807L) {
            return this.mDj;
        }
        return -9223372036854775807L;
    }

    public void reset() {
        this.mDk = -9223372036854775807L;
    }

    public long gF(long j) {
        long j2;
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.mDk != -9223372036854775807L) {
            long gI = gI(this.mDk);
            long j3 = (4294967296L + gI) / IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
            j2 = ((j3 - 1) * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j;
            long j4 = (j3 * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j;
            if (Math.abs(j2 - gI) >= Math.abs(j4 - gI)) {
                j2 = j4;
            }
        } else {
            j2 = j;
        }
        return gG(gH(j2));
    }

    public long gG(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.mDk != -9223372036854775807L) {
            this.mDk = j;
        } else {
            if (this.mhP != Format.OFFSET_SAMPLE_RELATIVE) {
                this.mDj = this.mhP - j;
            }
            synchronized (this) {
                this.mDk = j;
                notifyAll();
            }
        }
        return this.mDj + j;
    }

    public synchronized void dxu() throws InterruptedException {
        while (this.mDk == -9223372036854775807L) {
            wait();
        }
    }

    public static long gH(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / SapiWebView.DEFAULT_TIMEOUT_MILLIS;
    }

    public static long gI(long j) {
        return (SapiWebView.DEFAULT_TIMEOUT_MILLIS * j) / TimeUtils.NANOS_PER_MS;
    }
}
