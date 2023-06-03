package org.chromium.base.metrics;

import android.os.Trace;
/* loaded from: classes2.dex */
public class ScopedSysTraceEvent implements AutoCloseable {
    public ScopedSysTraceEvent(String str) {
        Trace.beginSection(str);
    }

    public static ScopedSysTraceEvent scoped(String str) {
        return new ScopedSysTraceEvent(str);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Trace.endSection();
    }
}
