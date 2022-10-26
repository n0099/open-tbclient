package com.yy.hiidostatis.message;

import java.util.List;
import java.util.Set;
/* loaded from: classes8.dex */
public interface SessionReport {

    /* loaded from: classes8.dex */
    public interface AfterFlush {
        StatisContentAble reset(String str, StatisContentAble statisContentAble);
    }

    /* loaded from: classes8.dex */
    public interface Processor {
        StatisContentAble process(StatisContentAble statisContentAble, String str, Object obj);
    }

    /* loaded from: classes8.dex */
    public interface StatisContentAble {
        List toStatisContent(String str, String str2);
    }

    void beginSession(String str, String str2, Processor processor, AfterFlush afterFlush);

    void closeSession(String str);

    boolean flushSession(String str, String str2);

    boolean flushSessionAll(String str);

    boolean flushSessionAll(String str, Set set);

    boolean pushToSession(String str, String str2, Object obj);
}
