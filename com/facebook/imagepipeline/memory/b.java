package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes15.dex */
public class b {
    private static final Class<?> oLv = b.class;
    public static final int oYP = eqm();
    private static int oYQ = 384;
    private static volatile a oYR;

    private static int eqm() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a eqn() {
        if (oYR == null) {
            synchronized (b.class) {
                if (oYR == null) {
                    oYR = new a(oYQ, oYP);
                }
            }
        }
        return oYR;
    }
}
