package com.bytedance.tea.crash.e;

import com.bytedance.tea.crash.e.i;
/* loaded from: classes4.dex */
public class c {
    public static long a(int i) {
        String[] Zb = com.bytedance.tea.crash.g.d.Zb("/proc/self/task/" + i + "/stat");
        if (Zb == null) {
            return -1L;
        }
        return (Long.parseLong(Zb[12]) * i.a.a()) + (Long.parseLong(Zb[11]) * i.a.a());
    }
}
