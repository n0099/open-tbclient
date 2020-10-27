package com.facebook.imagepipeline.memory;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.facebook.infer.annotation.ThreadSafe;
/* loaded from: classes18.dex */
public class b {
    private static final Class<?> oAy = b.class;
    public static final int oNT = emx();
    private static int oNU = 384;
    private static volatile a oNV;

    private static int emx() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) min) > AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH ? (min / 4) * 3 : min / 2;
    }

    @ThreadSafe
    public static a emy() {
        if (oNV == null) {
            synchronized (b.class) {
                if (oNV == null) {
                    oNV = new a(oNU, oNT);
                }
            }
        }
        return oNV;
    }
}
