package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes12.dex */
public class b {
    private static final Class<?> lQm = b.class;
    public static final int mdN = dtm();
    private static int mdO = 384;
    private static volatile a mdP;

    private static int dtm() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a dtn() {
        if (mdP == null) {
            synchronized (b.class) {
                if (mdP == null) {
                    mdP = new a(mdO, mdN);
                }
            }
        }
        return mdP;
    }
}
