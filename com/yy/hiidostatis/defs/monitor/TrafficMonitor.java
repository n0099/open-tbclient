package com.yy.hiidostatis.defs.monitor;

import android.content.Context;
import com.yy.hiidostatis.inner.util.ArdUtil;
/* loaded from: classes8.dex */
public enum TrafficMonitor {
    instance;
    
    public int appUid;
    public long endAlr;
    public long endAls;
    public long endApr;
    public long endAps;
    public long startAlr;
    public long startAls;
    public long startApr;
    public long startAps;

    public void end() {
        this.endAls = ArdUtil.getTotalTxBytes();
        this.endAlr = ArdUtil.getTotalRxBytes();
        this.endAps = ArdUtil.getUidTxBytes(this.appUid);
        this.endApr = ArdUtil.getUidRxBytes(this.appUid);
    }

    public long getAlr() {
        long j = this.endAlr;
        long j2 = this.startAlr;
        if (j - j2 < 0) {
            return 0L;
        }
        return j - j2;
    }

    public long getAls() {
        long j = this.endAls;
        long j2 = this.startAls;
        if (j - j2 < 0) {
            return 0L;
        }
        return j - j2;
    }

    public long getApr() {
        long j = this.endApr;
        long j2 = this.startApr;
        if (j - j2 < 0) {
            return 0L;
        }
        return j - j2;
    }

    public long getAps() {
        long j = this.endAps;
        long j2 = this.startAps;
        if (j - j2 < 0) {
            return 0L;
        }
        return j - j2;
    }

    public void start() {
        this.startAls = ArdUtil.getTotalTxBytes();
        this.startAlr = ArdUtil.getTotalRxBytes();
        this.startAps = ArdUtil.getUidTxBytes(this.appUid);
        this.startApr = ArdUtil.getUidRxBytes(this.appUid);
        this.endAls = 0L;
        this.endAlr = 0L;
        this.endAps = 0L;
        this.endApr = 0L;
    }

    public void init(Context context) {
        this.appUid = ArdUtil.getCurrAppUid(context);
    }
}
