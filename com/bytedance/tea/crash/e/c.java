package com.bytedance.tea.crash.e;

import com.bytedance.tea.crash.e.i;
/* loaded from: classes4.dex */
public class c {
    public static long a(int i) {
        String[] Za = com.bytedance.tea.crash.g.d.Za("/proc/self/task/" + i + "/stat");
        if (Za == null) {
            return -1L;
        }
        return (Long.parseLong(Za[12]) * i.a.a()) + (Long.parseLong(Za[11]) * i.a.a());
    }
}
