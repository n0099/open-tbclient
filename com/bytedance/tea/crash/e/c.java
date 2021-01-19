package com.bytedance.tea.crash.e;

import com.bytedance.tea.crash.e.i;
/* loaded from: classes4.dex */
public class c {
    public static long a(int i) {
        String[] XT = com.bytedance.tea.crash.g.d.XT("/proc/self/task/" + i + "/stat");
        if (XT == null) {
            return -1L;
        }
        return (Long.parseLong(XT[12]) * i.a.a()) + (Long.parseLong(XT[11]) * i.a.a());
    }
}
