package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes12.dex */
public class b {
    private static final Class<?> lHa = b.class;
    public static final int lUl = dqQ();
    private static int lUm = 384;
    private static volatile a lUn;

    private static int dqQ() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a dqR() {
        if (lUn == null) {
            synchronized (b.class) {
                if (lUn == null) {
                    lUn = new a(lUm, lUl);
                }
            }
        }
        return lUn;
    }
}
