package com.pgl.sys.ces.d;

import android.content.Context;
/* loaded from: classes4.dex */
public class c {
    private static b pQd = null;

    public static b b(Context context, String str, int i, a aVar) {
        if (pQd == null) {
            synchronized (c.class) {
                if (pQd == null) {
                    pQd = com.pgl.sys.ces.b.a(context, str, i, aVar);
                }
            }
        }
        return pQd;
    }
}
