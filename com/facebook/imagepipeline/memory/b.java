package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes12.dex */
public class b {
    private static final Class<?> lHl = b.class;
    public static final int lUw = dqR();
    private static int lUx = 384;
    private static volatile a lUy;

    private static int dqR() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a dqS() {
        if (lUy == null) {
            synchronized (b.class) {
                if (lUy == null) {
                    lUy = new a(lUx, lUw);
                }
            }
        }
        return lUy;
    }
}
