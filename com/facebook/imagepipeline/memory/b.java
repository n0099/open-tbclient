package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes12.dex */
public class b {
    private static final Class<?> mHo = b.class;
    public static final int mUZ = dFr();
    private static int mVa = 384;
    private static volatile a mVb;

    private static int dFr() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a dFs() {
        if (mVb == null) {
            synchronized (b.class) {
                if (mVb == null) {
                    mVb = new a(mVa, mUZ);
                }
            }
        }
        return mVb;
    }
}
