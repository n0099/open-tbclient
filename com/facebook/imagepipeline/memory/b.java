package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes8.dex */
public class b {
    private static final Class<?> njM = b.class;
    public static final int nxn = dUQ();
    private static int nxo = 384;
    private static volatile a nxp;

    private static int dUQ() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a dUR() {
        if (nxp == null) {
            synchronized (b.class) {
                if (nxp == null) {
                    nxp = new a(nxo, nxn);
                }
            }
        }
        return nxp;
    }
}
