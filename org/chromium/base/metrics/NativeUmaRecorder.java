package org.chromium.base.metrics;

import android.os.SystemClock;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;
@JNINamespace("base::android")
@MainDex
/* loaded from: classes2.dex */
public final class NativeUmaRecorder implements UmaRecorder {
    public final Map<String, Long> mNativeHints = Collections.synchronizedMap(new HashMap());

    /* loaded from: classes2.dex */
    public interface Natives {
        long recordBooleanHistogram(String str, long j, boolean z);

        long recordExponentialHistogram(String str, long j, int i, int i2, int i3, int i4);

        long recordLinearHistogram(String str, long j, int i, int i2, int i3, int i4);

        long recordSparseHistogram(String str, long j, int i);

        void recordUserAction(String str, long j);
    }

    private long getNativeHint(String str) {
        Long l = this.mNativeHints.get(str);
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    private void maybeUpdateNativeHint(String str, long j, long j2) {
        if (j != j2) {
            this.mNativeHints.put(str, Long.valueOf(j2));
        }
    }

    @Override // org.chromium.base.metrics.UmaRecorder
    public void recordBooleanHistogram(String str, boolean z) {
        long nativeHint = getNativeHint(str);
        maybeUpdateNativeHint(str, nativeHint, NativeUmaRecorderJni.get().recordBooleanHistogram(str, nativeHint, z));
    }

    @Override // org.chromium.base.metrics.UmaRecorder
    public void recordSparseHistogram(String str, int i) {
        long nativeHint = getNativeHint(str);
        maybeUpdateNativeHint(str, nativeHint, NativeUmaRecorderJni.get().recordSparseHistogram(str, nativeHint, i));
    }

    @Override // org.chromium.base.metrics.UmaRecorder
    public void recordUserAction(String str, long j) {
        NativeUmaRecorderJni.get().recordUserAction(str, SystemClock.elapsedRealtime() - j);
    }

    @Override // org.chromium.base.metrics.UmaRecorder
    public void recordExponentialHistogram(String str, int i, int i2, int i3, int i4) {
        long nativeHint = getNativeHint(str);
        maybeUpdateNativeHint(str, nativeHint, NativeUmaRecorderJni.get().recordExponentialHistogram(str, nativeHint, i, i2, i3, i4));
    }

    @Override // org.chromium.base.metrics.UmaRecorder
    public void recordLinearHistogram(String str, int i, int i2, int i3, int i4) {
        long nativeHint = getNativeHint(str);
        maybeUpdateNativeHint(str, nativeHint, NativeUmaRecorderJni.get().recordLinearHistogram(str, nativeHint, i, i2, i3, i4));
    }
}
