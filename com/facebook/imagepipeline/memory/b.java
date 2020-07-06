package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes12.dex */
public class b {
    private static final Class<?> mHr = b.class;
    public static final int mVc = dFv();
    private static int mVd = 384;
    private static volatile a mVe;

    private static int dFv() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a dFw() {
        if (mVe == null) {
            synchronized (b.class) {
                if (mVe == null) {
                    mVe = new a(mVd, mVc);
                }
            }
        }
        return mVe;
    }
}
