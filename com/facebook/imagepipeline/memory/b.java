package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes12.dex */
public class b {
    private static final Class<?> lIR = b.class;
    public static final int lWc = dro();
    private static int lWd = 384;
    private static volatile a lWe;

    private static int dro() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a drp() {
        if (lWe == null) {
            synchronized (b.class) {
                if (lWe == null) {
                    lWe = new a(lWd, lWc);
                }
            }
        }
        return lWe;
    }
}
