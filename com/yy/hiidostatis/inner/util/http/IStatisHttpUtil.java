package com.yy.hiidostatis.inner.util.http;
/* loaded from: classes2.dex */
public interface IStatisHttpUtil {
    String getHost();

    Throwable getLastError();

    int getLastStatusCode();

    int getLastTryTimes();

    boolean sendSync(String str);

    void setCacheIp(CacheIp cacheIp);

    void setLastTryTimes(int i);

    void setRetryTimeHost(int i);

    void setTestServer(String str);

    void setTryTimeIp(int i);
}
