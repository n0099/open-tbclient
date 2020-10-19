package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes18.dex */
public class b {
    private static final Class<?> nJf = b.class;
    public static final int nWB = ecz();
    private static int nWC = 384;
    private static volatile a nWD;

    private static int ecz() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a ecA() {
        if (nWD == null) {
            synchronized (b.class) {
                if (nWD == null) {
                    nWD = new a(nWC, nWB);
                }
            }
        }
        return nWD;
    }
}
