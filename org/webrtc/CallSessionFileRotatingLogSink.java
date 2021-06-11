package org.webrtc;

import org.webrtc.Logging;
/* loaded from: classes8.dex */
public class CallSessionFileRotatingLogSink {
    public long nativeSink;

    public CallSessionFileRotatingLogSink(String str, int i2, Logging.Severity severity) {
        if (str == null) {
            throw new IllegalArgumentException("dirPath may not be null.");
        }
        this.nativeSink = nativeAddSink(str, i2, severity.ordinal());
    }

    public static byte[] getLogData(String str) {
        if (str != null) {
            return nativeGetLogData(str);
        }
        throw new IllegalArgumentException("dirPath may not be null.");
    }

    public static native long nativeAddSink(String str, int i2, int i3);

    public static native void nativeDeleteSink(long j);

    public static native byte[] nativeGetLogData(String str);

    public void dispose() {
        long j = this.nativeSink;
        if (j != 0) {
            nativeDeleteSink(j);
            this.nativeSink = 0L;
        }
    }
}
