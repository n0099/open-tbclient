package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes12.dex */
public class b {
    private static final Class<?> mki = b.class;
    public static final int mxI = dAB();
    private static int mxJ = 384;
    private static volatile a mxK;

    private static int dAB() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a dAC() {
        if (mxK == null) {
            synchronized (b.class) {
                if (mxK == null) {
                    mxK = new a(mxJ, mxI);
                }
            }
        }
        return mxK;
    }
}
