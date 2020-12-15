package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes15.dex */
public class b {
    private static final Class<?> paF = b.class;
    public static final int pnG = evP();
    private static int pnH = 384;
    private static volatile a pnI;

    private static int evP() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a evQ() {
        if (pnI == null) {
            synchronized (b.class) {
                if (pnI == null) {
                    pnI = new a(pnH, pnG);
                }
            }
        }
        return pnI;
    }
}
