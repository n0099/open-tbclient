package com.yy.hiidostatis.message;

import com.yy.hiidostatis.message.module.sessionreport.CalAction;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public interface SessionReportWrapper {
    void beginSession(String str, String str2, long j, Map map);

    void closeSession(String str);

    boolean flushSession(String str, String str2);

    boolean flushSessionAll(String str, Set set);

    boolean pushToSession(String str, String str2, CalAction calAction, String str3, Number number, Map map, Map map2);

    boolean pushToSession(String str, String str2, List list, Map map, Map map2);
}
