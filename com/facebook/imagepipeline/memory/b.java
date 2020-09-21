package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes25.dex */
public class b {
    private static volatile a nHm;
    private static final Class<?> ntL = b.class;
    public static final int nHk = dYO();
    private static int nHl = 384;

    private static int dYO() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a dYP() {
        if (nHm == null) {
            synchronized (b.class) {
                if (nHm == null) {
                    nHm = new a(nHl, nHk);
                }
            }
        }
        return nHm;
    }
}
