package org.webrtc;

import java.util.Iterator;
import java.util.Map;
/* loaded from: classes12.dex */
public class RTCStatsReport {
    private final Map<String, RTCStats> stats;
    private final long timestampUs;

    public RTCStatsReport(long j, Map<String, RTCStats> map) {
        this.timestampUs = j;
        this.stats = map;
    }

    @CalledByNative
    private static RTCStatsReport create(long j, Map map) {
        return new RTCStatsReport(j, map);
    }

    public Map<String, RTCStats> getStatsMap() {
        return this.stats;
    }

    public double getTimestampUs() {
        return this.timestampUs;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ timestampUs: ");
        sb.append(this.timestampUs);
        sb.append(", stats: [\n");
        Iterator<RTCStats> it = this.stats.values().iterator();
        boolean z = true;
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                sb.append(" ] }");
                return sb.toString();
            }
            RTCStats next = it.next();
            if (!z2) {
                sb.append(",\n");
            }
            sb.append(next);
            z = false;
        }
    }
}
