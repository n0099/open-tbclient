package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes12.dex */
public class b {
    private static final Class<?> lQq = b.class;
    public static final int mdR = dtk();
    private static int mdS = 384;
    private static volatile a mdT;

    private static int dtk() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a dtl() {
        if (mdT == null) {
            synchronized (b.class) {
                if (mdT == null) {
                    mdT = new a(mdS, mdR);
                }
            }
        }
        return mdT;
    }
}
