package com.google.android.exoplayer2.upstream;
/* loaded from: classes7.dex */
public interface BandwidthMeter {
    public static final long NO_ESTIMATE = -1;

    /* loaded from: classes7.dex */
    public interface EventListener {
        void onBandwidthSample(int i2, long j2, long j3);
    }

    long getBitrateEstimate();
}
