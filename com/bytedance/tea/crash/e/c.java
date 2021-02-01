package com.bytedance.tea.crash.e;

import com.bytedance.tea.crash.e.i;
/* loaded from: classes6.dex */
public class c {
    public static long a(int i) {
        String[] YU = com.bytedance.tea.crash.g.d.YU("/proc/self/task/" + i + "/stat");
        if (YU == null) {
            return -1L;
        }
        return (Long.parseLong(YU[12]) * i.a.a()) + (Long.parseLong(YU[11]) * i.a.a());
    }
}
