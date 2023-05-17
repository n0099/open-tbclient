package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes9.dex */
public final class ConstantBitrateSeeker implements Mp3Extractor.Seeker {
    public static final int BITS_PER_BYTE = 8;
    public final int bitrate;
    public final long durationUs;
    public final long firstFramePosition;

    public ConstantBitrateSeeker(long j, int i, long j2) {
        long timeUs;
        this.firstFramePosition = j;
        this.bitrate = i;
        if (j2 == -1) {
            timeUs = C.TIME_UNSET;
        } else {
            timeUs = getTimeUs(j2);
        }
        this.durationUs = timeUs;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        if (this.durationUs != C.TIME_UNSET) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getPosition(long j) {
        long j2 = this.durationUs;
        if (j2 == C.TIME_UNSET) {
            return 0L;
        }
        return this.firstFramePosition + ((Util.constrainValue(j, 0L, j2) * this.bitrate) / 8000000);
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j) {
        return ((Math.max(0L, j - this.firstFramePosition) * 1000000) * 8) / this.bitrate;
    }
}
