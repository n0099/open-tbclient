package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes15.dex */
public class b {
    private static final Class<?> paD = b.class;
    public static final int pnE = evO();
    private static int pnF = 384;
    private static volatile a pnG;

    private static int evO() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a evP() {
        if (pnG == null) {
            synchronized (b.class) {
                if (pnG == null) {
                    pnG = new a(pnF, pnE);
                }
            }
        }
        return pnG;
    }
}
