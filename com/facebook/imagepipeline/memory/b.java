package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes5.dex */
public class b {
    private static volatile a pKA;
    private static final Class<?> pxC = b.class;
    public static final int pKy = eyA();
    private static int pKz = 384;

    private static int eyA() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a eyB() {
        if (pKA == null) {
            synchronized (b.class) {
                if (pKA == null) {
                    pKA = new a(pKz, pKy);
                }
            }
        }
        return pKA;
    }
}
