package com.bytedance.tea.crash.e;

import com.bytedance.tea.crash.e.i;
/* loaded from: classes4.dex */
public class c {
    public static long a(int i) {
        String[] XS = com.bytedance.tea.crash.g.d.XS("/proc/self/task/" + i + "/stat");
        if (XS == null) {
            return -1L;
        }
        return (Long.parseLong(XS[12]) * i.a.a()) + (Long.parseLong(XS[11]) * i.a.a());
    }
}
