package com.google.android.exoplayer2.util;

import com.baidu.sapi2.SapiWebView;
import com.google.android.exoplayer2.C;
/* loaded from: classes9.dex */
public final class TimestampAdjuster {
    public static final long DO_NOT_OFFSET = Long.MAX_VALUE;
    public static final long MAX_PTS_PLUS_ONE = 8589934592L;
    public long firstSampleTimestampUs;
    public volatile long lastSampleTimestamp = C.TIME_UNSET;
    public long timestampOffsetUs;

    public TimestampAdjuster(long j) {
        setFirstSampleTimestampUs(j);
    }

    public static long ptsToUs(long j) {
        return (j * 1000000) / SapiWebView.DEFAULT_TIMEOUT_MILLIS;
    }

    public static long usToPts(long j) {
        return (j * SapiWebView.DEFAULT_TIMEOUT_MILLIS) / 1000000;
    }

    public long adjustSampleTimestamp(long j) {
        if (j == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.lastSampleTimestamp != C.TIME_UNSET) {
            this.lastSampleTimestamp = j;
        } else {
            long j2 = this.firstSampleTimestampUs;
            if (j2 != Long.MAX_VALUE) {
                this.timestampOffsetUs = j2 - j;
            }
            synchronized (this) {
                this.lastSampleTimestamp = j;
                notifyAll();
            }
        }
        return j + this.timestampOffsetUs;
    }

    public synchronized void setFirstSampleTimestampUs(long j) {
        boolean z;
        if (this.lastSampleTimestamp == C.TIME_UNSET) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.firstSampleTimestampUs = j;
    }

    public long adjustTsTimestamp(long j) {
        if (j == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.lastSampleTimestamp != C.TIME_UNSET) {
            long usToPts = usToPts(this.lastSampleTimestamp);
            long j2 = (4294967296L + usToPts) / 8589934592L;
            long j3 = ((j2 - 1) * 8589934592L) + j;
            j += j2 * 8589934592L;
            if (Math.abs(j3 - usToPts) < Math.abs(j - usToPts)) {
                j = j3;
            }
        }
        return adjustSampleTimestamp(ptsToUs(j));
    }

    public long getFirstSampleTimestampUs() {
        return this.firstSampleTimestampUs;
    }

    public long getLastAdjustedTimestampUs() {
        if (this.lastSampleTimestamp != C.TIME_UNSET) {
            return this.lastSampleTimestamp;
        }
        long j = this.firstSampleTimestampUs;
        if (j == Long.MAX_VALUE) {
            return C.TIME_UNSET;
        }
        return j;
    }

    public long getTimestampOffsetUs() {
        if (this.firstSampleTimestampUs == Long.MAX_VALUE) {
            return 0L;
        }
        if (this.lastSampleTimestamp == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        return this.timestampOffsetUs;
    }

    public void reset() {
        this.lastSampleTimestamp = C.TIME_UNSET;
    }

    public synchronized void waitUntilInitialized() throws InterruptedException {
        while (this.lastSampleTimestamp == C.TIME_UNSET) {
            wait();
        }
    }
}
