package com.bytedance.tea.crash.e;

import com.bytedance.tea.crash.e.i;
/* loaded from: classes6.dex */
public class c {
    public static long a(int i) {
        String[] Zg = com.bytedance.tea.crash.g.d.Zg("/proc/self/task/" + i + "/stat");
        if (Zg == null) {
            return -1L;
        }
        return (Long.parseLong(Zg[12]) * i.a.a()) + (Long.parseLong(Zg[11]) * i.a.a());
    }
}
