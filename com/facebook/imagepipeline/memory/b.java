package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes4.dex */
public class b {
    private static final Class<?> mPx = b.class;
    public static final int ndd = dIH();
    private static int nde = 384;
    private static volatile a ndf;

    private static int dIH() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a dII() {
        if (ndf == null) {
            synchronized (b.class) {
                if (ndf == null) {
                    ndf = new a(nde, ndd);
                }
            }
        }
        return ndf;
    }
}
