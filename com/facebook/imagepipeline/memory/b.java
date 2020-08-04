package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes4.dex */
public class b {
    private static final Class<?> mPz = b.class;
    public static final int ndf = dII();
    private static int ndg = 384;
    private static volatile a ndh;

    private static int dII() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a dIJ() {
        if (ndh == null) {
            synchronized (b.class) {
                if (ndh == null) {
                    ndh = new a(ndg, ndf);
                }
            }
        }
        return ndh;
    }
}
