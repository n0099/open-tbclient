package com.google.android.exoplayer2.upstream;
/* loaded from: classes5.dex */
public interface BandwidthMeter {
    public static final long NO_ESTIMATE = -1;

    /* loaded from: classes5.dex */
    public interface EventListener {
        void onBandwidthSample(int i, long j, long j2);
    }

    long getBitrateEstimate();
}
