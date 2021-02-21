package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes5.dex */
public class b {
    private static volatile a pLa;
    private static final Class<?> pyc = b.class;
    public static final int pKY = eyI();
    private static int pKZ = 384;

    private static int eyI() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a eyJ() {
        if (pLa == null) {
            synchronized (b.class) {
                if (pLa == null) {
                    pLa = new a(pKZ, pKY);
                }
            }
        }
        return pLa;
    }
}
