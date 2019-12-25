package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes9.dex */
public class b {
    private static final Class<?> lCO = b.class;
    public static final int lPL = dor();
    private static int lPM = 384;
    private static volatile a lPN;

    private static int dor() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a dos() {
        if (lPN == null) {
            synchronized (b.class) {
                if (lPN == null) {
                    lPN = new a(lPM, lPL);
                }
            }
        }
        return lPN;
    }
}
