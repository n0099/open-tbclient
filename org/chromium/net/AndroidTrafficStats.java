package org.chromium.net;

import android.net.TrafficStats;
import android.os.Process;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
@JNINamespace("net::android::traffic_stats")
/* loaded from: classes2.dex */
public class AndroidTrafficStats {
    @CalledByNative
    public static long getCurrentUidRxBytes() {
        long uidRxBytes = TrafficStats.getUidRxBytes(Process.myUid());
        if (uidRxBytes == -1) {
            return 0L;
        }
        return uidRxBytes;
    }

    @CalledByNative
    public static long getCurrentUidTxBytes() {
        long uidTxBytes = TrafficStats.getUidTxBytes(Process.myUid());
        if (uidTxBytes == -1) {
            return 0L;
        }
        return uidTxBytes;
    }

    @CalledByNative
    public static long getTotalRxBytes() {
        long totalRxBytes = TrafficStats.getTotalRxBytes();
        if (totalRxBytes == -1) {
            return 0L;
        }
        return totalRxBytes;
    }

    @CalledByNative
    public static long getTotalTxBytes() {
        long totalTxBytes = TrafficStats.getTotalTxBytes();
        if (totalTxBytes == -1) {
            return 0L;
        }
        return totalTxBytes;
    }
}
