package org.webrtc;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class Metrics {
    public static final String TAG = "Metrics";
    public final Map<String, HistogramInfo> map = new HashMap();

    /* loaded from: classes7.dex */
    public static class HistogramInfo {
        public final int bucketCount;
        public final int max;
        public final int min;
        public final Map<Integer, Integer> samples = new HashMap();

        @CalledByNative("HistogramInfo")
        public HistogramInfo(int i2, int i3, int i4) {
            this.min = i2;
            this.max = i3;
            this.bucketCount = i4;
        }

        @CalledByNative("HistogramInfo")
        public void addSample(int i2, int i3) {
            this.samples.put(Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    @CalledByNative
    private void add(String str, HistogramInfo histogramInfo) {
        this.map.put(str, histogramInfo);
    }

    public static void enable() {
        nativeEnable();
    }

    public static Metrics getAndReset() {
        return nativeGetAndReset();
    }

    public static native void nativeEnable();

    public static native Metrics nativeGetAndReset();
}
