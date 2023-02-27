package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.PlaybackParameters;
/* loaded from: classes7.dex */
public final class StandaloneMediaClock implements MediaClock {
    public long baseElapsedMs;
    public long baseUs;
    public PlaybackParameters playbackParameters = PlaybackParameters.DEFAULT;
    public boolean started;

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        long speedAdjustedDurationUs;
        long j = this.baseUs;
        if (this.started) {
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime() - this.baseElapsedMs;
            PlaybackParameters playbackParameters = this.playbackParameters;
            if (playbackParameters.speed == 1.0f) {
                speedAdjustedDurationUs = C.msToUs(elapsedRealtime);
            } else {
                speedAdjustedDurationUs = playbackParameters.getSpeedAdjustedDurationUs(elapsedRealtime);
            }
            return j + speedAdjustedDurationUs;
        }
        return j;
    }

    public void start() {
        if (!this.started) {
            this.baseElapsedMs = android.os.SystemClock.elapsedRealtime();
            this.started = true;
        }
    }

    public void stop() {
        if (this.started) {
            setPositionUs(getPositionUs());
            this.started = false;
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters) {
        if (this.started) {
            setPositionUs(getPositionUs());
        }
        this.playbackParameters = playbackParameters;
        return playbackParameters;
    }

    public void setPositionUs(long j) {
        this.baseUs = j;
        if (this.started) {
            this.baseElapsedMs = android.os.SystemClock.elapsedRealtime();
        }
    }
}
