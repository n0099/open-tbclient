package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes8.dex */
public class b {
    private static final Class<?> nju = b.class;
    public static final int nwV = dUH();
    private static int nwW = 384;
    private static volatile a nwX;

    private static int dUH() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a dUI() {
        if (nwX == null) {
            synchronized (b.class) {
                if (nwX == null) {
                    nwX = new a(nwW, nwV);
                }
            }
        }
        return nwX;
    }
}
