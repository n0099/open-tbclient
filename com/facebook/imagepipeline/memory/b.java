package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes5.dex */
public class b {
    private static volatile a pDl;
    private static final Class<?> prQ = b.class;
    public static final int pDj = ezw();
    private static int pDk = 384;

    private static int ezw() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a ezx() {
        if (pDl == null) {
            synchronized (b.class) {
                if (pDl == null) {
                    pDl = new a(pDk, pDj);
                }
            }
        }
        return pDl;
    }
}
