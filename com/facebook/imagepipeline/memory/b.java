package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes12.dex */
public class b {
    private static final Class<?> lGY = b.class;
    public static final int lUj = dqO();
    private static int lUk = 384;
    private static volatile a lUl;

    private static int dqO() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a dqP() {
        if (lUl == null) {
            synchronized (b.class) {
                if (lUl == null) {
                    lUl = new a(lUk, lUj);
                }
            }
        }
        return lUl;
    }
}
