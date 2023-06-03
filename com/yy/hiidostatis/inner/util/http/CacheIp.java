package com.yy.hiidostatis.inner.util.http;

import com.fun.ad.sdk.channel.CsjForbidStrategy;
/* loaded from: classes10.dex */
public class CacheIp {
    public String lastIP = null;
    public int lastIPTimes = 0;
    public long cacheTime = 0;

    public String getIp() {
        return this.lastIP;
    }

    public void inc() {
        this.lastIPTimes++;
    }

    public boolean isValid() {
        if (this.lastIP == null || this.lastIPTimes >= 1000 || this.cacheTime == 0 || System.currentTimeMillis() - this.cacheTime >= CsjForbidStrategy.FORBID_TIME_ANTI_SPAM) {
            return false;
        }
        return true;
    }

    public void reset(String str) {
        this.lastIPTimes = 0;
        this.lastIP = str;
        this.cacheTime = 0L;
        if (str != null) {
            this.cacheTime = System.currentTimeMillis();
        }
    }
}
