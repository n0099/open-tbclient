package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes18.dex */
public class b {
    private static final Class<?> oJR = b.class;
    public static final int oXm = eqo();
    private static int oXn = 384;
    private static volatile a oXo;

    private static int eqo() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a eqp() {
        if (oXo == null) {
            synchronized (b.class) {
                if (oXo == null) {
                    oXo = new a(oXn, oXm);
                }
            }
        }
        return oXo;
    }
}
