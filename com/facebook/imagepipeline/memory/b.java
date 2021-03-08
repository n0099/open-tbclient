package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes5.dex */
public class b {
    private static final Class<?> pAh = b.class;
    public static final int pNd = eyR();
    private static int pNe = 384;
    private static volatile a pNf;

    private static int eyR() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a eyS() {
        if (pNf == null) {
            synchronized (b.class) {
                if (pNf == null) {
                    pNf = new a(pNe, pNd);
                }
            }
        }
        return pNf;
    }
}
