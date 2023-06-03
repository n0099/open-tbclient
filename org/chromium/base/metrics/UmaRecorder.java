package org.chromium.base.metrics;
/* loaded from: classes2.dex */
public interface UmaRecorder {
    void recordBooleanHistogram(String str, boolean z);

    void recordExponentialHistogram(String str, int i, int i2, int i3, int i4);

    void recordLinearHistogram(String str, int i, int i2, int i3, int i4);

    void recordSparseHistogram(String str, int i);

    void recordUserAction(String str, long j);
}
