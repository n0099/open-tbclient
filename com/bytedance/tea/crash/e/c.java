package com.bytedance.tea.crash.e;

import com.bytedance.tea.crash.e.i;
/* loaded from: classes6.dex */
public class c {
    public static long a(int i) {
        String[] Zn = com.bytedance.tea.crash.g.d.Zn("/proc/self/task/" + i + "/stat");
        if (Zn == null) {
            return -1L;
        }
        return (Long.parseLong(Zn[12]) * i.a.a()) + (Long.parseLong(Zn[11]) * i.a.a());
    }
}
