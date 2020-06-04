package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes12.dex */
public class b {
    private static final Class<?> mls = b.class;
    public static final int myS = dAP();
    private static int myT = 384;
    private static volatile a myU;

    private static int dAP() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a dAQ() {
        if (myU == null) {
            synchronized (b.class) {
                if (myU == null) {
                    myU = new a(myT, myS);
                }
            }
        }
        return myU;
    }
}
