package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes10.dex */
public class b {
    private static final Class<?> lGr = b.class;
    public static final int lTC = dpC();
    private static int lTD = 384;
    private static volatile a lTE;

    private static int dpC() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a dpD() {
        if (lTE == null) {
            synchronized (b.class) {
                if (lTE == null) {
                    lTE = new a(lTD, lTC);
                }
            }
        }
        return lTE;
    }
}
