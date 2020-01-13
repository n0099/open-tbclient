package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes10.dex */
public class b {
    private static final Class<?> lGm = b.class;
    public static final int lTx = dpA();
    private static int lTy = 384;
    private static volatile a lTz;

    private static int dpA() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a dpB() {
        if (lTz == null) {
            synchronized (b.class) {
                if (lTz == null) {
                    lTz = new a(lTy, lTx);
                }
            }
        }
        return lTz;
    }
}
