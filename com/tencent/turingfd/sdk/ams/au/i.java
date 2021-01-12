package com.tencent.turingfd.sdk.ams.au;

import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Integer, Long> f13529a = new HashMap();

    public static String a() {
        StringBuilder sb = new StringBuilder();
        for (Integer num : f13529a.keySet()) {
            int intValue = num.intValue();
            sb.append(",");
            sb.append(intValue);
            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            sb.append(f13529a.get(Integer.valueOf(intValue)));
        }
        return sb.toString();
    }

    public static void a(int i, long j) {
        f13529a.put(Integer.valueOf(i), Long.valueOf(j));
    }
}
