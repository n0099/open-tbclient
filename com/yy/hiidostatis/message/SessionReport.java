package com.yy.hiidostatis.message;

import com.yy.hiidostatis.api.StatisContent;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public interface SessionReport {

    /* loaded from: classes7.dex */
    public interface AfterFlush<K extends StatisContentAble> {
        K reset(String str, K k);
    }

    /* loaded from: classes7.dex */
    public interface Processor<K extends StatisContentAble, T> {
        K process(K k, String str, T t);
    }

    /* loaded from: classes7.dex */
    public interface StatisContentAble {
        List<StatisContent> toStatisContent(String str, String str2);
    }

    void beginSession(String str, String str2, Processor processor, AfterFlush afterFlush);

    void closeSession(String str);

    boolean flushSession(String str, String str2);

    boolean flushSessionAll(String str);

    boolean flushSessionAll(String str, Set<String> set);

    boolean pushToSession(String str, String str2, Object obj);
}
