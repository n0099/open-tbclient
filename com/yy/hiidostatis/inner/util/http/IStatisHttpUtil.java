package com.yy.hiidostatis.inner.util.http;
/* loaded from: classes7.dex */
public interface IStatisHttpUtil {
    String getHost();

    Throwable getLastError();

    int getLastStatusCode();

    int getLastTryTimes();

    boolean sendSync(String str);

    void setCacheIp(CacheIp cacheIp);

    void setLastTryTimes(int i2);

    void setRetryTimeHost(int i2);

    void setTestServer(String str);

    void setTryTimeIp(int i2);
}
