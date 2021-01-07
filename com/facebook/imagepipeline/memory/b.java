package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes3.dex */
public class b {
    private static volatile a pES;
    private static final Class<?> prR = b.class;
    public static final int pEQ = eAa();
    private static int pER = 384;

    private static int eAa() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a eAb() {
        if (pES == null) {
            synchronized (b.class) {
                if (pES == null) {
                    pES = new a(pER, pEQ);
                }
            }
        }
        return pES;
    }
}
