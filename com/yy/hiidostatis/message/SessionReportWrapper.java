package com.yy.hiidostatis.message;

import com.yy.hiidostatis.message.module.sessionreport.CalAction;
import com.yy.hiidostatis.message.module.sessionreport.EventValue;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public interface SessionReportWrapper {
    void beginSession(String str, String str2, long j2, Map<String, Long> map);

    void closeSession(String str);

    boolean flushSession(String str, String str2);

    boolean flushSessionAll(String str, Set<String> set);

    boolean pushToSession(String str, String str2, CalAction calAction, String str3, Number number, Map<String, String> map, Map<String, String> map2);

    boolean pushToSession(String str, String str2, List<EventValue> list, Map<String, String> map, Map<String, String> map2);
}
