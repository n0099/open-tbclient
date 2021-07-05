package org.webrtc;
/* loaded from: classes10.dex */
public interface RTCStatsCollectorCallback {
    @CalledByNative
    void onStatsDelivered(RTCStatsReport rTCStatsReport);
}
