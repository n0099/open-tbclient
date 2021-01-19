package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes3.dex */
public class b {
    private static volatile a pAs;
    private static final Class<?> pnn = b.class;
    public static final int pAq = ewi();
    private static int pAr = 384;

    private static int ewi() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a ewj() {
        if (pAs == null) {
            synchronized (b.class) {
                if (pAs == null) {
                    pAs = new a(pAr, pAq);
                }
            }
        }
        return pAs;
    }
}
