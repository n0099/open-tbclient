package com.kuaishou.aegon.netcheck;

import androidx.annotation.Keep;
/* loaded from: classes6.dex */
public class NetworkQualityEstimator {

    @Keep
    /* loaded from: classes6.dex */
    public static class Metrics {
        public int downstreamThroughputKbps;
        public float gatewayLoss;
        public float gatewayRttMs;
        public float serverRttMs;
        public int signalStrength;

        @Keep
        public Metrics() {
            this(0.0f, -1.0f, -1.0f, -1, -1);
        }

        @Keep
        public Metrics(float f2, float f3, float f4, int i2, int i3) {
            this.gatewayLoss = f2;
            this.gatewayRttMs = f3;
            this.serverRttMs = f4;
            this.downstreamThroughputKbps = i2;
            this.signalStrength = i3;
        }
    }
}
