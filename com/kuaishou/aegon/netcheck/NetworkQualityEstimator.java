package com.kuaishou.aegon.netcheck;

import androidx.annotation.Keep;
/* loaded from: classes5.dex */
public class NetworkQualityEstimator {

    @Keep
    /* loaded from: classes5.dex */
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
        public Metrics(float f, float f2, float f3, int i, int i2) {
            this.gatewayLoss = f;
            this.gatewayRttMs = f2;
            this.serverRttMs = f3;
            this.downstreamThroughputKbps = i;
            this.signalStrength = i2;
        }
    }
}
