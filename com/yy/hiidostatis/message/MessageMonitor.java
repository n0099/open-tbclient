package com.yy.hiidostatis.message;
/* loaded from: classes8.dex */
public interface MessageMonitor {
    void commit();

    long getAutoId(String str);

    int getPackId(String str);

    int getProcessId();

    void init();
}
