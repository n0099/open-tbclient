package com.yy.hiidostatis.message;
/* loaded from: classes2.dex */
public interface MessageMonitor {
    void commit();

    long getAutoId(String str);

    int getPackId(String str);

    int getProcessId();

    void init();
}
